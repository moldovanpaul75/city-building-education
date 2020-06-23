package DataAccess;

import Business.LayerType;
import Business.LoggerSystem;
import Business.TileType;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TileTypeDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public TileType selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tileType.tileTypeId, tileType.tileName, tileType.rating, tileType.iconPath, layerType.layerId, layerType.layerName FROM (tileType INNER JOIN layerType ON tileType.layerId = layerType.layerId) WHERE tileType.tileTypeId = ?");
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                TileType result = new TileType(resultSet.getInt("tileTypeId"), new LayerType(resultSet.getInt("layerId"), resultSet.getString("layerName")), resultSet.getString("tileName"), resultSet.getInt("rating"), resultSet.getString("iconPath"));
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper select error");
        }
        return null;
    }


    public ArrayList<TileType> getAllTileTypes() throws DataMapperException {
        try {
            ArrayList<TileType> tileTypeArrayList = new ArrayList<TileType>();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tileType.tileTypeId, tileType.tileName, tileType.rating, tileType.iconPath, layerType.layerId, layerType.layerName FROM (tileType INNER JOIN layerType ON tileType.layerId = layerType.layerId)");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                TileType result = new TileType(resultSet.getInt("tileTypeId"), new LayerType(resultSet.getInt("layerId"), resultSet.getString("layerName")), resultSet.getString("tileName"), resultSet.getInt("rating"), resultSet.getString("iconPath"));
                tileTypeArrayList.add(result);
            }
            return tileTypeArrayList;
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper get all tile types error");
        }
    }

    public void viewTileTypes() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tileType.tileTypeId, tileType.tileName, tileType.rating, tileType.iconPath, layerType.layerId, layerType.layerName FROM (tileType INNER JOIN layerType ON tileType.layerId = layerType.layerId)");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            while (resultSet.next()) {
                TileType result = new TileType(resultSet.getInt("tileTypeId"), new LayerType(resultSet.getInt("layerId"), resultSet.getString("layerName")), resultSet.getString("tileName"), resultSet.getInt("rating"), resultSet.getString("iconPath"));
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper view all tile types error");
        }
    }


    public synchronized void insert(TileType tileType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO tileType(layerId, tileName, rating, iconPath) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, tileType.getLayerType().getLayerId());
            preparedStatement.setString(2, tileType.getTileName());
            preparedStatement.setInt(3, tileType.getRating());
            preparedStatement.setString(4, tileType.getIconPath());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper insert error");
        }
    }


    public synchronized void delete(TileType tileType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM tileType WHERE tileType.tileTypeId = ?");
            preparedStatement.setString(1, String.valueOf(tileType.getTileTypeId()));
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper delete error");
        }
    }


    public synchronized void update(TileType tileType) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE tileType SET tileType.layerId = ?, tileType.tileName = ?, tileType.rating = ?, tileType.iconPath = ? WHERE tileType.tileTypeId = ?");
            preparedStatement.setInt(1, tileType.getLayerType().getLayerId());
            preparedStatement.setString(2, tileType.getTileName());
            preparedStatement.setInt(3, tileType.getRating());
            preparedStatement.setString(4, tileType.getIconPath());
            preparedStatement.setInt(5, tileType.getTileTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataMapperException("TileTypeDataMapper update error");
        }
    }
}
