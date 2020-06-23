package DataAccess;

import Business.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TileDataMapper {
    private DBConnection db = new DBConnection();
    private final Connection connection = db.getConnection();
    private LoggerSystem loggerSystem = new LoggerSystem();


    public Tile selectById(int id) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tile.tileId, tile.tileType, tile.tileInfo, tile.xCoord, tile.yCoord FROM tile WHERE tile.tileId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            TileInfo tileInfo = null;
            TileType tileType = null;
            TileTypeDataMapper ttdm = new TileTypeDataMapper();
            TileInfoDataMapper tidm = new TileInfoDataMapper();
            while (resultSet.next()) {
                Tile result = new Tile(resultSet.getInt("tileId"), resultSet.getInt("xCoord"), resultSet.getInt("yCoord"));
                if (resultSet.getInt("tileInfo") > 0) {
                    tileInfo = tidm.selectById(resultSet.getInt("tileInfo"));
                    result.setTileInfo(tileInfo);
                }
                if (resultSet.getInt("tileType") > 0) {
                    tileType = ttdm.selectById(resultSet.getInt("tileType"));
                    result.setTileType(tileType);
                }
                return result;
            }
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper select error");
        }
        return null;
    }


    public void viewTiles() throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tile.tileId, tile.tileType, tile.tileInfo, tile.xCoord, tile.yCoord FROM tile");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            TileInfo tileInfo = null;
            TileType tileType = null;
            TileTypeDataMapper ttdm = new TileTypeDataMapper();
            TileInfoDataMapper tidm = new TileInfoDataMapper();
            while (resultSet.next()) {
                Tile result = new Tile(resultSet.getInt("tileId"), resultSet.getInt("xCoord"), resultSet.getInt("yCoord"));
                if (resultSet.getInt("tileInfo") > 0) {
                    tileInfo = tidm.selectById(resultSet.getInt("tileInfo"));
                    result.setTileInfo(tileInfo);
                }
                if (resultSet.getInt("tileType") > 0) {
                    tileType = ttdm.selectById(resultSet.getInt("tileType"));
                    result.setTileType(tileType);
                }
                System.out.println(result);
            }
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper view all tiles error");
        }
    }

    public Tile[][] getAllTiles(int xMax, int yMax) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT tile.tileId, tile.tileType, tile.tileInfo, tile.xCoord, tile.yCoord FROM tile");
            ResultSet resultSet = preparedStatement.executeQuery();
            loggerSystem.logAction(preparedStatement.toString());
            TileInfo tileInfo = null;
            TileType tileType = null;
            TileTypeDataMapper ttdm = new TileTypeDataMapper();
            TileInfoDataMapper tidm = new TileInfoDataMapper();
            Tile[][] tiles = new Tile[xMax][yMax];
            while (resultSet.next()) {
                tiles[resultSet.getInt("xCoord")][resultSet.getInt("yCoord")] = new Tile(resultSet.getInt("tileId"), resultSet.getInt("xCoord"), resultSet.getInt("yCoord"));
                if (resultSet.getInt("tileInfo") > 0) {
                    tileInfo = tidm.selectById(resultSet.getInt("tileInfo"));
                    tiles[resultSet.getInt("xCoord")][resultSet.getInt("yCoord")].setTileInfo(tileInfo);
                }
                if (resultSet.getInt("tileType") > 0) {
                    tileType = ttdm.selectById(resultSet.getInt("tileType"));
                    tiles[resultSet.getInt("xCoord")][resultSet.getInt("yCoord")].setTileType(tileType);
                }
            }
            return tiles;
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper get all tiles error");
        }
    }


    public synchronized void insert(Tile tile) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO tile(tileType, tileInfo, xCoord, yCoord) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, tile.getTileType().getTileTypeId());
            preparedStatement.setInt(2, tile.getTileInfo().getTileInfoId());
            preparedStatement.setInt(3, tile.getxCoord());
            preparedStatement.setInt(4, tile.getyCoord());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper insert error");
        }
    }


    public synchronized void delete(Tile tile) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM tile WHERE tile.tileId = ?");
            preparedStatement.setInt(1, tile.getTileId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
            new TileInfoDataMapper().delete(tile.getTileInfo());
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper delete error");
        }
    }


    public synchronized void update(Tile tile) throws DataMapperException {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE tile SET tile.tileType = ?, tile.xCoord = ?, tile.yCoord = ? WHERE tile.tileId = ?");
            preparedStatement.setInt(1, tile.getTileType().getTileTypeId());
            preparedStatement.setInt(2, tile.getxCoord());
            preparedStatement.setInt(3, tile.getyCoord());
            preparedStatement.setInt(4, tile.getTileId());
            preparedStatement.executeUpdate();
            loggerSystem.logAction(preparedStatement.toString());
        } catch (SQLException e) {
            throw new DataMapperException("TileDataMapper update error");
        }
    }
}
