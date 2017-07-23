package hw2.dao.impl;

import hw2.DataSource;
import hw2.dao.PersonsDAO;
import hw2.entityes.Persons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Persons findByCompanyId(int companyId) {
        return null;
    }

    @Override
    public Persons findBySalary(int salary) {
        return null;
    }

    @Override
    public void insert(Persons persons) {

    }

    @Override
    public void update(Persons persons) {

    }

    @Override
    public void delete(Persons persons) {

    }
}
