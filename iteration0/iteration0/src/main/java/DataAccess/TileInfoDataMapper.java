package DataAccess;

import Business.Address;
import Business.Contact;
import Business.LoggerSystem;
import Business.TileInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TileInfoDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public TileInfo selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT info.infoId, info.capacity, info.availability, info.address, info.contact FROM info WHERE info.infoId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                Address address = new AddressDataMapper().selectById(resultSet.getInt("address"));
                Contact contact = new ContactDataMapper().selectById(resultSet.getInt("contact"));
                TileInfo result = new TileInfo(resultSet.getInt("infoId"), resultSet.getInt("capacity"), resultSet.getInt("availability"), address, contact);
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("TileInfoDataMapper select error");
        }
        return null;
    }

    public synchronized void insert(TileInfo tileInfo) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO info(capacity, availability, address, contact) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, tileInfo.getCapacity());
            preparedStatement.setInt(2, tileInfo.getAvailability());
            preparedStatement.setInt(3, tileInfo.getAddress().getAddressId());
            preparedStatement.setInt(4, tileInfo.getContact().getContactId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileInfoDataMapper insert error");
        }
    }


    public synchronized void delete(TileInfo tileInfo) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM info WHERE info.infoId = ?");
            preparedStatement.setInt(1, tileInfo.getTileInfoId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
            new ContactDataMapper().delete(tileInfo.getContact());
            new AddressDataMapper().delete(tileInfo.getAddress());
        } catch (SQLException e) {
            throw new DataMapperException("TileInfoDataMapper delete error");
        }
    }


    public synchronized void update(TileInfo tileInfo) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE info SET info.capacity = ?, info.availability = ?, info.address = ? , info.contact = ? WHERE info.infoId = ?");
            preparedStatement.setInt(1, tileInfo.getCapacity());
            preparedStatement.setInt(2, tileInfo.getAvailability());
            preparedStatement.setInt(3, tileInfo.getAddress().getAddressId());
            preparedStatement.setInt(4, tileInfo.getContact().getContactId());
            preparedStatement.setInt(5, tileInfo.getTileInfoId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileInfoDataMapper update error");
        }
    }
}
