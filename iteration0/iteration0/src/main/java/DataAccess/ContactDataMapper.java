package DataAccess;


import Business.Contact;
import Business.LoggerSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public Contact selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT contact.contactId, contact.telephoneNb, contact.email FROM contact WHERE contact.contactId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                Contact result = new Contact(resultSet.getInt("contactId"), resultSet.getInt("telephoneNb"), resultSet.getString("email"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("ContactDataMapper select error");
        }
        return null;
    }

    public synchronized void insert(Contact contact) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO contact(telephoneNb, email) VALUES (?, ?)");
            preparedStatement.setInt(1, contact.getTelephoneNb());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("ContactDataMapper insert error");
        }
    }


    public synchronized void delete(Contact contact) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM contact WHERE contact.contactId = ?");
            preparedStatement.setInt(1, contact.getContactId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("ContactDataMapper delete error");
        }
    }


    public synchronized void update(Contact contact) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE contact SET contact.telephoneNb = ?, contact.email = ? WHERE contact.contactId = ?");
            preparedStatement.setInt(1, contact.getTelephoneNb());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.setInt(3, contact.getContactId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("ContactDataMapper update error");
        }
    }
}
