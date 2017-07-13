package hw2.dao.impl;

import hw2.DataSource;
import hw2.Exeptions.DatabaseExcept;
import hw2.dao.CustomersDAO;
import hw2.entityes.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Користувач on 13.07.2017.
 */
public class CustomersDAOImp implements CustomersDAO {

    @Override
    public List<Customers> findAll() {
        List<Customers> result = new ArrayList<Customers>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customers customers = new Customers();
                customers.setCustomersId(rs.getInt(Customers.ID));
                customers.setCustomersName(rs.getString(Customers.NAME));
                result.add(customers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Customers findById(int customersId) {
        Customers customers = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, customersId);
            customers = new Customers();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    customers.setCustomersId(rs.getInt(Customers.ID));
                    customers.setCustomersName(rs.getString(Customers.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customers findByName(String customersName) {
        Customers customers = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, customersName);
            customers = new Customers();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    customers.setCustomersId(rs.getInt(Customers.ID));
                    customers.setCustomersName(rs.getString(Customers.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void insert(Customers customers) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, customers.getCustomersName());
            ps.execute();
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                customers.setCustomersId(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void update(Customers customers) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, customers.getCustomersName());
            statement.setInt(2, customers.getCustomersId());
            statement.execute();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void delete(int customersId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, customersId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }
}
