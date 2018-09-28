-- Queries executed on database train (/Users/sameenislam/Documents/Repositories/Train/dat/train.db)
-- Date and time of execution: 2018-09-20 23:15:25
CREATE TABLE train_driver_details (train_id VARCHAR (10) NOT NULL, from_station VARCHAR (10), to_station VARCHAR (10), driver_name VARCHAR (10), journey_status VARCHAR (10));

-- Queries executed on database train (/Users/sameenislam/Documents/Repositories/Train/dat/train.db)
-- Date and time of execution: 2018-09-20 23:26:05
CREATE TABLE train_delay_details (train_id VARCHAR (10) NOT NULL, station VARCHAR (10), departure_time_at_station VARCHAR (10), departure_lateness_in_seconds VARCHAR (10));