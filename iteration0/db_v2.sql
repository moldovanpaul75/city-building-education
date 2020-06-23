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
    districtName VARCHAR(150) NOT NULL,
	xStart INT NOT NULL,
    xEnd INT NOT NULL,
    yStart INT NOT NULL,
    yEnd INT NOT NULL,
    PRIMARY KEY(districtId)
);

CREATE TABLE IF NOT EXISTS city_district(
	cityId INT NOT NULL,
	districtId INT NOT NULL,
	FOREIGN KEY (cityId) REFERENCES city(cityId),
    FOREIGN KEY (districtId) REFERENCES district(districtId)
);

CREATE TABLE IF NOT EXISTS address(
	addressId INT NOT NULL AUTO_INCREMENT,
    district INT NOT NULL,
    street VARCHAR(100) NOT NULL,
	PRIMARY KEY(addressId),
    FOREIGN KEY (district) REFERENCES district(districtId)
);

CREATE TABLE IF NOT EXISTS layer(
	layerId INT NOT NULL AUTO_INCREMENT,
    layerName VARCHAR(30) NOT NULL,
    PRIMARY KEY(layerId)
);

CREATE TABLE IF NOT EXISTS tileType(
	tileTypeId INT NOT NULL AUTO_INCREMENT,
    tileName VARCHAR(30) NOT NULL,
    rating INT NOT NULL,
	iconPath VARCHAR(100) NOT NULL,
    PRIMARY KEY(tileTypeId)
);

CREATE TABLE IF NOT EXISTS layer_tileType(
	layerId INT NOT NULL,
    tileTypeId INT NOT NULL,
    FOREIGN KEY (tileTypeId) REFERENCES tileType(tileTypeId),
    FOREIGN KEY (layerId) REFERENCES layerType(layerId)
);




CREATE TABLE IF NOT EXISTS contact(
	contactId INT NOT NULL AUTO_INCREMENT,
    telephoneNb INT NOT NULL,
    email VARCHAR(30) NOT NULL,
    PRIMARY KEY(contactId)
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
    tileInfo INT NULL,
    xCoord INT NOT NULL UNIQUE,
    yCoord INT NOT NULL UNIQUE,
    PRIMARY KEY(tileId),
    FOREIGN KEY (tileInfo) REFERENCES info(infoId)
);


CREATE TABLE IF NOT EXISTS tile_type(
	tileId INT NOT NULL,
    tileType INT NOT NULL,
	FOREIGN KEY (tileType) REFERENCES tileType(tileTypeId),
    FOREIGN KEY (tileId) REFERENCES tile(tileId)
);
