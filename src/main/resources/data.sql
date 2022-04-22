--INSERT
--INTO
--  temperature
--  (deviceUUID, columnTwo, unixTimeStamps, dateTime, temperatureInC)
--VALUES
--  ('', '', 0, '', 0);


INSERT
INTO
  person
  (first_name, age)
VALUES
  ('', 0);

--INSERT
--INTO
--  temperature
--  (device_uuid, column_two, unix_time_stamps, date_time, temperature_in_c)
--VALUES
--  ('', '', 0, '', 0);

--CREATE TABLE TEST AS SELECT * FROM CSVREAD('src/test/resources/test.csv');
--CREATE TABLE TEST AS SELECT * FROM CSVREAD('C:/Users/acynt/Desktop/temperature-new.csv');
--CREATE TABLE TEST AS SELECT * FROM CSVREAD('classpath:temperature-new.csv');
--CREATE TABLE temperature AS SELECT * FROM CSVREAD('C:/Users/acynt/Desktop/temperature-v2.csv');

--INSERT INTO
--    temperature
--        (device_uuid, column_two, unix_time_stamps, date_time, temperature_in_c)
--SELECT * FROM
--    CSVREAD('C:/Users/acynt/Desktop/temperature-v2.csv');

INSERT INTO
    temperature
        (device_uuid, column_two, unix_time_stamps, date_time, temperature_in_c)
SELECT * FROM
    CSVREAD('C:/Users/acynt/Desktop/temperature-v5-timestamp-betul.csv');





