DROP DATABASE IF EXISTS city_building;
CREATE DATABASE IF NOT EXISTS city_building;
USE city_building;


CREATE TABLE IF NOT EXISTS city(
	cityId INT NOT NULL AUTO_INCREMENT,
    cityName VARCHAR(150) NOT NULL,
    lat FLOAT(10,6) NOT NULL,
	lon FLOAT(10,6) NOT NULL,
    PRIMARY KEY(cityId)
);

CREATE TABLE IF NOT EXISTS district(
	districtId INT NOT NULL AUTO_INCREMENT,
    cityId INT NOT NULL,
    districtName VARCHAR(150) NOT NULL,
	xStart INT NOT NULL,
    xEnd INT NOT NULL,
    yStart INT NOT NULL,
    yEnd INT NOT NULL,
    PRIMARY KEY(districtId),
    FOREIGN KEY (cityId) REFERENCES city(cityId)
);


CREATE TABLE IF NOT EXISTS layerType(
	layerId INT NOT NULL AUTO_INCREMENT,
    layerName VARCHAR(30) NOT NULL,
    PRIMARY KEY(layerId)
);

CREATE TABLE IF NOT EXISTS tileType(
	tileTypeId INT NOT NULL AUTO_INCREMENT,
    layerId INT NOT NULL,
    tileName VARCHAR(30) NOT NULL,
    rating INT NOT NULL,
	iconPath VARCHAR(100) NOT NULL,
    PRIMARY KEY(tileTypeId),
    FOREIGN KEY (layerId) REFERENCES layerType(layerId)
);

CREATE TABLE IF NOT EXISTS contact(
	contactId INT NOT NULL AUTO_INCREMENT,
    telephoneNb INT NOT NULL,
    email VARCHAR(30) NOT NULL,
    PRIMARY KEY(contactId)
);

CREATE TABLE IF NOT EXISTS address(
	addressId INT NOT NULL AUTO_INCREMENT,
    district INT NOT NULL,
    street VARCHAR(100) NOT NULL,
	PRIMARY KEY(addressId),
    FOREIGN KEY (district) REFERENCES district(districtId)
);

CREATE TABLE IF NOT EXISTS info(
	infoId INT NOT NULL AUTO_INCREMENT,
    capacity INT NOT NULL,
    availability INT NOT NULL,
    address INT NOT NULL,
    contact INT NOT NULL,
    PRIMARY KEY(infoId),
    FOREIGN KEY (contact) REFERENCES contact(contactId),
    FOREIGN KEY (address) REFERENCES address(addressId)
);

CREATE TABLE IF NOT EXISTS tile(
	tileId INT NOT NULL AUTO_INCREMENT,
    tileType INT NOT NULL,
    tileInfo INT NULL,
    xCoord INT NOT NULL,
    yCoord INT NOT NULL,
    PRIMARY KEY(tileId),
    FOREIGN KEY (tileType) REFERENCES tileType(tileTypeId),
    FOREIGN KEY (tileInfo) REFERENCES info(infoId)
);

INSERT INTO layerType(layerName) VALUES ('land layer');
INSERT INTO layerType(layerName) VALUES ('hydro layer');
INSERT INTO layerType(layerName) VALUES ('places layer');
INSERT INTO tileType(layerId, tileName, rating, iconPath) VALUES (1, 'grass', 5, 'img/grass.png');
INSERT INTO tileType(layerId, tileName, rating, iconPath) VALUES (2, 'river', 6, 'img/river.png');
INSERT INTO tileType(layerId, tileName, rating, iconPath) VALUES (2, 'sea', 3, 'img/sea.png');
INSERT INTO tileType(layerId, tileName, rating, iconPath) VALUES (3, 'house', 3, 'img/house1.png');
INSERT INTO city(cityName, lat, lon) VALUES ('city1', 17.3, 9.3);
INSERT INTO city(cityName, lat, lon) VALUES ('city2', 3.2, -73.5);
INSERT INTO district(cityId, districtName, xStart, xEnd, yStart, yEnd) VALUES (1, 'district1', 2, 8, 3, 8);
INSERT INTO district(cityId, districtName, xStart, xEnd, yStart, yEnd) VALUES (2, 'district2', 13, 18, 12, 19);
INSERT INTO address(district, street) VALUES (1, 'street1 nb100');
INSERT INTO address(district, street) VALUES (2, 'street2 nb203');
INSERT INTO contact(telephoneNb, email) VALUES (03495, 'example1@email.com');
INSERT INTO contact(telephoneNb, email) VALUES (06445, 'example2@email.com');
INSERT INTO info(capacity, availability, address, contact) VALUES (5, 9, 1, 1);
INSERT INTO info(capacity, availability, address, contact) VALUES (5, 9, 2, 2);

INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (2, 0, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 1, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 2, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 3, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 4, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 5);
INSERT INTO tile(tileType, tileInfo, xCoord, yCoord) VALUES (4, 1, 5, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 5, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 6, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 7, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 8, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 9, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 10, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 11, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 12, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 13, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 14, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 15, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 14);
INSERT INTO tile(tileType, tileInfo, xCoord, yCoord) VALUES (4, 2, 16, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 16, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 17, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (1, 18, 19);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 0);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 1);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 2);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 3);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 4);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 5);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 6);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 7);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 8);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 9);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 10);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 11);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 12);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 13);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 14);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 15);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 16);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 17);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 18);
INSERT INTO tile(tileType, xCoord, yCoord) VALUES (3, 19, 19);