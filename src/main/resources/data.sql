
INSERT INTO
    temperature
        (device_uuid, data_type, unix_time_stamps, date_time, temperature_in_c)
SELECT * FROM
    CSVREAD('./src/main/resources/temperature-v5-timestamp-betul.csv');


