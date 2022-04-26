
CREATE TABLE temperature (
  id BIGINT AUTO_INCREMENT NOT NULL,
   device_uuid VARCHAR(255),
   data_type VARCHAR(255),
   unix_time_stamps VARCHAR(255),
   date_time VARCHAR(255),
   temperature_in_c DOUBLE,
   CONSTRAINT pk_temperature PRIMARY KEY (id)
);

CREATE TABLE temperature_predicted (
  id BIGINT AUTO_INCREMENT NOT NULL,
   unix_time_stamps VARCHAR(255),
   date_time VARCHAR(255),
   temperature_in_c DOUBLE,
   CONSTRAINT pk_temperaturepredicted PRIMARY KEY (id)
);