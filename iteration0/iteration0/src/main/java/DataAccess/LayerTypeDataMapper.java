package DataAccess;

import Business.LayerType;
import Business.LoggerSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LayerTypeDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public LayerType selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT layerType.layerId, layerType.layerName FROM layerType WHERE layerType.layerId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                LayerType result = new LayerType(resultSet.getInt("layerId"), resultSet.getString("layerName"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("LayerTypeDataMapper select error");
        }
        return null;
    }


    public void viewLayerTypes() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT layerType.layerId, layerType.layerName FROM layerType");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                LayerType result = new LayerType(resultSet.getInt("layerId"), resultSet.getString("layerName"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("LayerTypeDataMapper view all layers error");
        }
    }


    public synchronized void insert(LayerType layerType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO layerType(layerName) VALUES (?)");
            preparedStatement.setString(1, layerType.getLayerName());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("LayerTypeDataMapper insert error");
        }
    }


    public synchronized void delete(LayerType layerType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM layerType WHERE layerType.layerId = ?");
            preparedStatement.setInt(1, layerType.getLayerId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("LayerTypeDataMapper delete error");
        }
    }


    public synchronized void update(LayerType layerType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE layerType SET layerType.layerName = ? WHERE layerType.layerId = ?");
            preparedStatement.setString(1, layerType.getLayerName());
            preparedStatement.setInt(2, layerType.getLayerId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("LayerTypeDataMapper update error");
        }
    }
}