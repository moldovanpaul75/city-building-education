package DataAccess;

import Business.Address;
import Business.District;
import Business.LoggerSystem;

import java.sql.*;

public class AddressDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public Address selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT address.addressId, address.street, address.district FROM address WHERE address.addressId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                District district = new DistrictDataMapper().selectById(resultSet.getInt("district"));
                Address result = new Address(resultSet.getInt("addressId"), district, resultSet.getString("street"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("AddressDataMapper select error");
        }
        return null;
    }


    public void viewAddresses() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT address.addressId, address.street, address.district FROM address");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                District district = new DistrictDataMapper().selectById(resultSet.getInt("district"));
                Address result = new Address(resultSet.getInt("addressId"), district, resultSet.getString("street"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("AddressDataMapper view all addresses error");
        }
    }


    public synchronized void insert(Address address) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO address(district, street) VALUES (?, ?)");
            preparedStatement.setInt(1, address.getDistrict().getDistrictId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("AddressDataMapper insert error");
        }
    }


    public synchronized void delete(Address address) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM address WHERE address.addressId = ?");
            preparedStatement.setInt(1, address.getAddressId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("AddressDataMapper delete error");
        }
    }


    public synchronized void update(Address address) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE address SET address.district = ?, address.street = ? WHERE address.addressId = ?");
            preparedStatement.setInt(1, address.getDistrict().getDistrictId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getAddressId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("AddressDataMapper update error");
        }
    }
}
