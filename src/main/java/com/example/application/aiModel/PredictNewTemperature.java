package com.example.application.aiModel;

import com.example.application.data.entity.Temperature;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.io.IOException;

public class PredictNewTemperature {

	Long timestamp;
	double temperature;

	public PredictNewTemperature() {


	}

	public double predict(Long timestamp) throws IOException {

		this.timestamp = timestamp;

		// load data to test

		System.out.println("Loading test data...");

		// convert data to indarray

		System.out.println("Converting data to INDArray...");

		INDArray testData = Nd4j.create(1, 1, 1).addi(timestamp);
		System.out.println(testData);

		// normalize data

		System.out.println("Normalizing test data...");

		// load saved model

		System.out.println("Load saved model...");

		File savedModel = new ClassPathResource("trainedTemperatureLSTM-full.zip").getFile();

		// check if model exist

		System.out.println("Checking model existence...");

		if(!savedModel.exists())
		{
			System.out.println("Model not exist. Abort");
		}

		// restore model ModelSerializer.restoreMultiLayerNetwork(modelSave)

		System.out.println("Restoring saved model...");

		MultiLayerNetwork model = ModelSerializer.restoreMultiLayerNetwork(savedModel);

		// model.output

		System.out.println("Making inference...");

		INDArray output = model.output(testData);

		// print out predicted data

		System.out.println("Printing predicted data...");

		System.out.println(output);

		temperature = output.getDouble();

		return temperature;
	}
}
