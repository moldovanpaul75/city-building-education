package DataAccess;

import Business.City;
import Business.LoggerSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public City selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT city.cityId, city.cityName, city.lat, city.lon FROM city WHERE city.cityId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                City result = new City(resultSet.getInt("cityId"), resultSet.getString("cityName"), resultSet.getFloat("lat"), resultSet.getFloat("lon"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("CityDataMapper select error");
        }
        return null;
    }


    public void viewCities() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT city.cityId, city.cityName, city.lat, city.lon FROM city");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                City result = new City(resultSet.getInt("cityId"), resultSet.getString("cityName"), resultSet.getFloat("lat"), resultSet.getFloat("lon"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("CityDataMapper view all cities error");
        }
    }


    public synchronized void insert(City city) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO city(cityName, lat, lon) VALUES (?, ?, ?);");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setFloat(2, city.getCityLat());
            preparedStatement.setFloat(3, city.getCityLon());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("CityDataMapper insert error");
        }
    }


    public synchronized void delete(City city) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM city WHERE city.cityId = ?");
            preparedStatement.setInt(1, city.getCityId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("CityDataMapper delete error");
        }
    }


    public synchronized void update(City city) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE city SET city.cityName = ?, city.lat = ?, city.lon = ? WHERE city.cityId = ?");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setFloat(2, city.getCityLat());
            preparedStatement.setFloat(3, city.getCityLon());
            preparedStatement.setInt(4, city.getCityId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("CityDataMapper update error");
        }
    }
}
