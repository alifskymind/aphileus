package com.example.application.aiModel;

import com.google.gson.Gson;
import org.datavec.api.records.reader.SequenceRecordReader;
import org.datavec.api.records.reader.impl.csv.CSVSequenceRecordReader;
import org.datavec.api.split.NumberedFileInputSplit;
import org.deeplearning4j.datasets.datavec.SequenceRecordReaderDataSetIterator;
import org.deeplearning4j.eval.RegressionEvaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.BackpropType;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.LSTM;
import org.deeplearning4j.nn.conf.layers.RnnOutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.PerformanceListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerMinMaxScaler;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.RmsProp;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.Arrays;

public class TrainLSTM {

	public static void main(String[] args) throws Exception {

		LocalTime startTime = LocalTime.now();
		System.out.println("*****************************************************************************************");
		System.out.println("Start time:");
		System.out.println(startTime);
		System.out.println("*****************************************************************************************");

		File baseDir = new ClassPathResource("temperatureMultiple").getFile();

		//int miniBatchSize = 32;
		int miniBatchSize = 1000000;

		System.out.println("Loading data...");

		// ----- Load the training data -----
		SequenceRecordReader trainReader = new CSVSequenceRecordReader(0, ",");
		trainReader.initialize(new NumberedFileInputSplit(baseDir.getAbsolutePath() + "/temperature_%d.csv", 0, 335219));

		//For regression, numPossibleLabels is not used. Setting it to -1 here
		DataSetIterator trainIter = new SequenceRecordReaderDataSetIterator(trainReader, miniBatchSize, -1, 1, true);

		SequenceRecordReader testReader = new CSVSequenceRecordReader(0, ",");
		testReader.initialize(new NumberedFileInputSplit(baseDir.getAbsolutePath() + "/temperature_%d.csv", 0, 335219));
		DataSetIterator testIter = new SequenceRecordReaderDataSetIterator(testReader, miniBatchSize, -1, 1, true);

		//Create data set from iterator here since we only have a single data set
		DataSet trainData = trainIter.next();
		DataSet testData = testIter.next();

		trainIter.reset();
		testIter.reset();

		System.out.println("Printing data information...");

		System.out.println("\nShape of training batch vector:");
		System.out.println(Arrays.toString(trainIter.next().getFeatures().shape()));
		System.out.println("\nShape of test batch vector:");
		System.out.println(Arrays.toString(testIter.next().getFeatures().shape()));
		//System.out.println("\ntraining vector: ");
		//System.out.println(trainIter.next().getFeatures());
		//System.out.println("\ntest vector: ");
		//System.out.println(testIter.next().getFeatures());

		trainIter.reset();
		testIter.reset();

		System.out.println("Normalize the data...");

		//Normalize data, including labels (fitLabel=true)
		NormalizerMinMaxScaler normalizer = new NormalizerMinMaxScaler(0, 1);

		normalizer.fitLabel(true);
		normalizer.fit(trainData);              //Collect training data statistics

		normalizer.transform(trainData);
		normalizer.transform(testData);

		//DataNormalization normalizer = new NormalizerStandardize();
		//normalizer.fitLabel(true);
		//normalizer.fit(trainData);
		//normalizer.transform(trainData);
		//normalizer.transform(testData);

		//----- Configure the network -----
		MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
				.seed(140)
				.optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
				.weightInit(WeightInit.XAVIER)
				//.updater(new Adam(0.001))
				.updater(new RmsProp(0.1))
				.l2(0.001)
				.list()

				.layer(new LSTM.Builder()
						.activation(Activation.TANH)
						.nIn(1)
						.nOut(100)
						.build())

				.layer(new LSTM.Builder()
						.activation(Activation.TANH)
						.nOut(50)
						.build())

				.layer(new LSTM.Builder()
						.activation(Activation.TANH)
						.nOut(25)
						.build())

				.layer(new RnnOutputLayer.Builder(LossFunctions.LossFunction.MSE)
						.activation(Activation.IDENTITY)
						.nOut(1)
						.build())

				.backpropType(BackpropType.TruncatedBPTT)
				.tBPTTLength(50)
				.build();

		//MultiLayerConfiguration conf =  new NeuralNetConfiguration.Builder()
		//        .seed(140)
		//        .updater(new Adam(5e-3))
		//        .l2(1e-5)
		//        .weightInit(WeightInit.XAVIER)
		//        .gradientNormalization(GradientNormalization.ClipElementWiseAbsoluteValue)
		//        .gradientNormalizationThreshold(1.0)
		//        .list()
		//        .layer(new LSTM.Builder()
		//                .nIn(1)
		//                .activation(Activation.TANH)
		//                .nOut(256)
		//                .build())
		//        .layer(new LSTM.Builder()
		//                .nIn(256)
		//                .activation(Activation.TANH)
		//                .nOut(384)
		//                .build())
		//        .layer(new LSTM.Builder()
		//                .nIn(384)
		//                .activation(Activation.TANH)
		//                .nOut(128)
		//                .build())
		//        .layer(new RnnOutputLayer.Builder()
		//                .nIn(128)
		//                .nOut(1)
		//                .lossFunction(LossFunctions.LossFunction.MSE)
		//                .activation(Activation.IDENTITY)
		//                .build())
		//        .build();

		MultiLayerNetwork net = new MultiLayerNetwork(conf);
		net.init();

		net.setListeners(new ScoreIterationListener(1), new PerformanceListener(1));

		System.out.println("Training model...");

		// ----- Train the network, evaluating the test set performance at each epoch -----
		int nEpochs = 10;

		for (int i = 0; i < nEpochs; i++) {
			net.fit(trainData);
			System.out.println("Epoch " + i + " complete. Time series evaluation:");

			//Run regression evaluation on our single column input
			RegressionEvaluation evaluation = new RegressionEvaluation(1);
			INDArray features = testData.getFeatures();

			INDArray labels = testData.getLabels();
			INDArray predicted = net.output(features, false);

			evaluation.evalTimeSeries(labels, predicted);

			//Just do sout here since the logger will shift the shift the columns of the stats
			System.out.println(evaluation.stats());

			System.out.println("Printing test data...");

			System.out.println(labels);

			System.out.println("Printing predicted data...");

			System.out.println(predicted);

		}

		System.out.println("Predict with test data...");

		//Init rrnTimeStemp with train data and predict test data
		net.rnnTimeStep(trainData.getFeatures());
		INDArray predicted = net.rnnTimeStep(testData.getFeatures());

		System.out.println("Un-normalize the data...");

		//Revert data back to original values for plotting
		normalizer.revert(trainData);
		normalizer.revert(testData);
		normalizer.revertLabels(predicted);

		System.out.println("Printing training data...");

		System.out.println(trainData.getLabels().shapeInfo());
		System.out.println(trainData.getLabels());
		System.out.println(trainData);

		System.out.println("Printing test data...");

		System.out.println(testData.getLabels().shapeInfo());
		System.out.println(testData.getLabels());
		System.out.println(testData);

		System.out.println("Printing predicted data...");

		System.out.println(predicted.shapeInfo());
		System.out.println(predicted);

		System.out.println("Saving model...");
		File locationToSave = new File("src/main/resources/trainedTemperatureLSTM.zip");

		//save updater
		boolean saveUpdater = true;

		//ModelSerializer needs modelname, location, booleanSaveUpdater
		ModelSerializer.writeModel(net, locationToSave, saveUpdater);

		System.out.println("Trained network saved at " + locationToSave);

		LocalTime endTime = LocalTime.now();
		System.out.println("*****************************************************************************************");
		System.out.println("End time:");
		System.out.println(endTime);
		System.out.println("*****************************************************************************************");

		System.out.println("*****************************************************************************************");
		System.out.println("Compare predicted with ground truth.");
		System.out.println("*****************************************************************************************");


		//System.out.println("Predicted" + "\t" + "Ground Truth");
		//for (int i = 0; i < predicted.length(); i++) {
		//    System.out.println(predicted.getRow(i) + "\t" + testData.getLabels().getRow(i));
		//}

		System.out.println("Testing getting information about predicted...");
		System.out.println(Arrays.toString(predicted.shape()));
		System.out.println(predicted.length());
		System.out.println(predicted.rank());
		System.out.println(predicted);
		INDArray flattened = Nd4j.toFlattened(predicted);
		System.out.println(flattened);


		//System.out.println("Predicted flattened...");
		//for (int i = 0; i < flattened.length(); i++) {
		//    System.out.println(flattened.getRow(i));
		//}

		//System.out.println("Printing predicted data only...");
		//
		//int nRows = (int) predicted.shape()[2];
		//for (int i = 0; i < nRows; i++) {
		//    System.out.println(i + predicted.getDouble(i));
		//    System.out.println(predicted.getDouble(i));
		//    System.out.println(i);
		//}

		System.out.println("Saving INDArray to json...");

		DataBuffer flattenedDataBuffer = flattened.data();
		double[] flattenedArray = flattenedDataBuffer.asDouble();
		System.out.println(Arrays.toString(flattenedArray));
		Gson gson = new Gson();
		gson.toJson(flattenedArray, new FileWriter("C:\\Users\\acynt\\Desktop\\predicted.json"));

		System.out.println("Saving INDArray to file...");

		FileWriter writer = new FileWriter("C:\\Users\\acynt\\Desktop\\predicted.txt");
		int len = flattenedArray.length;
		for (int i = 0; i < len; i++) {
			writer.write(flattenedArray[i] + "\n"+ "");
		}
		writer.close();

		//System.out.println("Create plot with data...");

		//Create plot with out data
		//XYSeriesCollection c = new XYSeriesCollection();
		//createSeries(c, trainData.getFeatures(), 0, "Train data");
		//createSeries(c, testData.getFeatures(), 99, "Actual test data");
		//createSeries(c, predicted, 100, "Predicted test data");
		//
		//plotDataset(c);

		System.out.println("----- Example Complete -----");

		LocalTime endTime2 = LocalTime.now();
		System.out.println("*****************************************************************************************");
		System.out.println("End time 2:");
		System.out.println(endTime2);
		System.out.println("*****************************************************************************************");


		//LocalTime endTime = LocalTime.now();
		//System.out.println("*****************************************************************************************");
		//System.out.println("End time:");
		//System.out.println(endTime);
		//System.out.println("*****************************************************************************************");


	}

}
