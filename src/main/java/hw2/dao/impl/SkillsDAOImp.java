package hw2.dao.impl;

import hw2.DataSource;
import hw2.Exeptions.DatabaseExcept;
import hw2.dao.SkillsDAO;
import hw2.entityes.Skills;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Користувач on 13.07.2017.
 */
public class SkillsDAOImp implements SkillsDAO {

    @Override
    public List<Skills> findAll() {
        List<Skills> result = new ArrayList<Skills>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Skills skills = new Skills();
                skills.setSkillsId(rs.getInt(Skills.ID));
                skills.setSkillsName(rs.getString(Skills.NAME));
                result.add(skills);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Skills findById(int skillsId) {
        Skills skills = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, skillsId);
            skills = new Skills();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    skills.setSkillsId(rs.getInt(Skills.ID));
                    skills.setSkillsName(rs.getString(Skills.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public Skills findByName(String skillsName) {
        Skills skills = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, skillsName);
            skills = new Skills();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    skills.setSkillsId(rs.getInt(Skills.ID));
                    skills.setSkillsName(rs.getString(Skills.NAME));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public void insert(Skills skills) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, skills.getSkillsName());
            ps.execute();
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                skills.setSkillsId(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void update(Skills skills) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, skills.getSkillsName());
            statement.setInt(2, skills.getSkillsId());
            statement.execute();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void delete(int skillsId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, skillsId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }
}
