package hw2.dao.impl;

import hw2.DataSource;
import hw2.Exeptions.DatabaseExcept;
import hw2.dao.CompanyDAO;
import hw2.entityes.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Користувач on 03.07.2017.
 */
public class CompanyDAOImp implements CompanyDAO {

    public List<Company> findAll() {

        List<Company> result = new ArrayList<Company>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyId(rs.getInt(Company.ID));
                company.setCompanyName(rs.getString(Company.NAME));
                result.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Company findById(int companyId) {
        Company company = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, companyId);
            company = new Company();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    company.setCompanyId(rs.getInt(Company.ID));
                    company.setCompanyName(rs.getString(Company.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public Company findByName(String companyName) {
        Company company = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, companyName);
            company = new Company();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    company.setCompanyId(rs.getInt(Company.ID));
                    company.setCompanyName(rs.getString(Company.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void insert(Company company) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, company.getCompanyName());
            ps.execute();
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                company.setCompanyId(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    public void update(Company company) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, company.getCompanyName());
            statement.setInt(2, company.getCompanyId());
            statement.execute();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    public void delete(Company company) {

    }
}
