package DataAccess;

import Business.City;
import Business.District;
import Business.LoggerSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public District selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT district.districtId, district.districtName, city.cityId, city.cityName, city.lat, city.lon, district.xStart, district.yStart, district.xEnd, district.yEnd FROM (district INNER JOIN CITY on district.cityId = city.cityId) WHERE district.districtId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                City city = new City(resultSet.getInt("cityId"), resultSet.getString("cityName"), resultSet.getFloat("lat"), resultSet.getFloat("lon"));
                District result = new District(resultSet.getInt("districtId"), city, resultSet.getString("districtName"), resultSet.getInt("xStart"), resultSet.getInt("yStart"), resultSet.getInt("xEnd"), resultSet.getInt("yEnd"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("DistrictDataMapper select error");
        }
        return null;
    }


    public void viewDistricts() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT district.districtId, district.districtName, city.cityId, city.cityName, city.lat, city.lon, district.xStart, district.yStart, district.xEnd, district.yEnd FROM (district INNER JOIN CITY on district.cityId = city.cityId)");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                City city = new City(resultSet.getInt("cityId"), resultSet.getString("cityName"), resultSet.getFloat("lat"), resultSet.getFloat("lon"));
                District result = new District(resultSet.getInt("districtId"), city, resultSet.getString("districtName"), resultSet.getInt("xStart"), resultSet.getInt("yStart"), resultSet.getInt("xEnd"), resultSet.getInt("yEnd"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("DistrictDataMapper view all districts error");
        }
    }


    public synchronized void insert(District district) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO district(districtId, cityId, districtName, xStart, xEnd, yStart, yEnd) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, district.getDistrictId());
            preparedStatement.setInt(2, district.getCity().getCityId());
            preparedStatement.setString(3, district.getDistrictName());
            preparedStatement.setInt(4, district.getxStart());
            preparedStatement.setInt(5, district.getxEnd());
            preparedStatement.setInt(6, district.getyStart());
            preparedStatement.setInt(7, district.getyEnd());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("DistrictDataMapper insert error");
        }
    }


    public synchronized void delete(District district) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM district WHERE district.districtId = ?");
            preparedStatement.setInt(1, district.getDistrictId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("DistrictDataMapper delete error");
        }
    }


    public synchronized void update(District district) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE district SET district.cityId = ?, district.districtName = ?, district.xStart = ?, district.xEnd = ?, district.yStart = ?, district.yEnd = ? WHERE district.districtId = ?");
            preparedStatement.setInt(1, district.getCity().getCityId());
            preparedStatement.setString(2, district.getDistrictName());
            preparedStatement.setInt(3, district.getxStart());
            preparedStatement.setInt(4, district.getxEnd());
            preparedStatement.setInt(5, district.getyStart());
            preparedStatement.setInt(6, district.getyEnd());
            preparedStatement.setInt(7, district.getDistrictId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("DistrictDataMapper update error");
        }
    }
}
