package com.skorobahatko.lectures.lecture8.web.dao.impl;

import com.skorobahatko.lectures.lecture8.web.dao.api.Dao;
import com.skorobahatko.lectures.lecture8.web.entity.Entity;
import com.skorobahatko.lectures.lecture8.web.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class CrudDao<T extends Entity<Integer>> implements Dao<Integer, T> {

    private static final String SQL_SELECT_ALL = "SELECT * FROM %s;";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM %s WHERE id = ?;";
    private static final String SQL_DELETE_BY_ID = "DELETE * FROM %s WHERE id = ?;";

    private Class<T> type;
    private DataSource dataSource;

    public CrudDao(Class<T> type) {
        this.type = type;
        dataSource = DataSource.getInstance();

    }

    @Override
    public List<T> getAll() {
        String sql = getFormattedSQL(SQL_SELECT_ALL);

        List<T> result = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            result = readAll(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public T getById(Integer id) {
        String sql = getFormattedSQL(SQL_SELECT_BY_ID);
        List<T> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            result = readAll(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.get(0);
    }

    @Override
    public void save(T entity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = createInsertStatement(conn, entity)) {
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = getFormattedSQL(SQL_DELETE_BY_ID);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = createUpdateStatement(conn, entity)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement createUpdateStatement(Connection conn, T entity);

    protected abstract PreparedStatement createInsertStatement(Connection conn, T entity);

    protected abstract List<T> readAll(ResultSet resultSet);

    private String getFormattedSQL(String sql) {
        return String.format(sql, type.getSimpleName().toLowerCase());
    }
}
