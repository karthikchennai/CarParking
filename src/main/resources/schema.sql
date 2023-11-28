DROP TABLE IF EXISTS cars_parked;
DROP TABLE IF EXISTS parking_spaces;

CREATE TABLE cars_parked (
    id INT AUTO_INCREMENT PRIMARY KEY,
    arrival_time DATETIME,
    departure_time DATETIME
);

CREATE TABLE parking_spaces (
    id INT AUTO_INCREMENT PRIMARY KEY,
    available BOOLEAN
);