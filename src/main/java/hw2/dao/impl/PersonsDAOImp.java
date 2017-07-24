package hw2.dao.impl;

import hw2.DataSource;
import hw2.Exeptions.DatabaseExcept;
import hw2.dao.PersonsDAO;
import hw2.entityes.Persons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Користувач on 13.07.2017.
 */
public class PersonsDAOImp implements PersonsDAO {
    @Override
    public List<Persons> findAll() {
        List<Persons> result = new ArrayList<Persons>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persons persons = new Persons();
                persons.setPersonsId(rs.getInt(Persons.ID));
                persons.setPersonsName(rs.getString(Persons.NAME));
                persons.setPersonsAge(rs.getInt(Persons.AGE));
                persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                persons.setSalary(rs.getInt(Persons.SALARY));
                result.add(persons);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Persons findById(int personsId) {
        Persons persons = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, personsId);
            persons = new Persons();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    persons.setPersonsId(rs.getInt(Persons.ID));
                    persons.setPersonsName(rs.getString(Persons.NAME));
                    persons.setPersonsAge(rs.getInt(Persons.AGE));
                    persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                    persons.setSalary(rs.getInt(Persons.SALARY));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Persons findByName(String personsName) {
        Persons persons = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, personsName);
            persons = new Persons();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    persons.setPersonsId(rs.getInt(Persons.ID));
                    persons.setPersonsName(rs.getString(Persons.NAME));
                    persons.setPersonsAge(rs.getInt(Persons.AGE));
                    persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                    persons.setSalary(rs.getInt(Persons.SALARY));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Persons findByAge(int personsAge) {
        Persons persons = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_AGE)) {
            ps.setInt(1, personsAge);
            persons = new Persons();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    persons.setPersonsId(rs.getInt(Persons.ID));
                    persons.setPersonsName(rs.getString(Persons.NAME));
                    persons.setPersonsAge(rs.getInt(Persons.AGE));
                    persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                    persons.setSalary(rs.getInt(Persons.SALARY));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Persons findByCompanyId(int companyId) {
        Persons persons = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_COMPANY_ID)) {
            ps.setInt(1, companyId);
            persons = new Persons();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    persons.setPersonsId(rs.getInt(Persons.ID));
                    persons.setPersonsName(rs.getString(Persons.NAME));
                    persons.setPersonsAge(rs.getInt(Persons.AGE));
                    persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                    persons.setSalary(rs.getInt(Persons.SALARY));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public List<Persons> findBySalary(int salary) {
        List<Persons> result = new ArrayList<Persons>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_SALARY)) {
            ps.setInt(1, salary);
            Persons persons = new Persons();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    persons.setPersonsId(rs.getInt(Persons.ID));
                    persons.setPersonsName(rs.getString(Persons.NAME));
                    persons.setPersonsAge(rs.getInt(Persons.AGE));
                    persons.setCompanyId(rs.getInt(Persons.COMPANY_ID));
                    persons.setSalary(rs.getInt(Persons.SALARY));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Persons persons) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, persons.getPersonsName());
            ps.setInt(2, persons.getPersonsAge());
            ps.setInt(3, persons.getCompanyId());
            ps.setInt(4, persons.getSalary());
            ps.execute();
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                persons.setPersonsId(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void update(Persons persons) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, persons.getPersonsName());
            statement.setInt(2, persons.getPersonsAge());
            statement.setInt(3, persons.getCompanyId());
            statement.setInt(4, persons.getSalary());
            statement.setInt(5, persons.getPersonsId());
            statement.execute();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void delete(int personsId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, personsId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }
}
