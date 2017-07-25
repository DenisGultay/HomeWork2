package hw2.dao.impl;

import hw2.DataSource;
import hw2.Exeptions.DatabaseExcept;
import hw2.dao.ProjectsDAO;
import hw2.entityes.Projects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Користувач on 13.07.2017.
 */
public class ProjectsDAOImp implements ProjectsDAO {

    @Override
    public List<Projects> findAll() {
        List<Projects> result = new ArrayList<Projects>();

        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Projects projects = new Projects();
                projects.setProjectsId(rs.getInt(Projects.ID));
                projects.setProjectsName(rs.getString(Projects.NAME));
                projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                projects.setProjectCost(rs.getInt(Projects.COSTS));
                result.add(projects);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Projects findById(int projectsId) {
        Projects projects = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, projectsId);
            projects = new Projects();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    projects.setProjectsId(rs.getInt(Projects.ID));
                    projects.setProjectsName(rs.getString(Projects.NAME));
                    projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                    projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                    projects.setProjectCost(rs.getInt(Projects.COSTS));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Projects findByName(String projectsName) {
        Projects projects = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, projectsName);
            projects = new Projects();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    projects.setProjectsId(rs.getInt(Projects.ID));
                    projects.setProjectsName(rs.getString(Projects.NAME));
                    projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                    projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                    projects.setProjectCost(rs.getInt(Projects.COSTS));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Projects findByCustomersId(int customersId) {
        Projects projects = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_CUSTOMERS_ID)) {
            ps.setInt(1, customersId);
            projects = new Projects();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    projects.setProjectsId(rs.getInt(Projects.ID));
                    projects.setProjectsName(rs.getString(Projects.NAME));
                    projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                    projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                    projects.setProjectCost(rs.getInt(Projects.COSTS));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public List<Projects> findByCompanyId(int companyId) {
        List<Projects> result = new ArrayList<Projects>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_COMPANY_ID)) {
            ps.setInt(1, companyId);
           Projects projects = new Projects();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    projects.setProjectsId(rs.getInt(Projects.ID));
                    projects.setProjectsName(rs.getString(Projects.NAME));
                    projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                    projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                    projects.setProjectCost(rs.getInt(Projects.COSTS));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Projects> findByCosts(int projectCost) {
        List<Projects> result = new ArrayList<Projects>();
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_COSTS)) {
            ps.setInt(1, projectCost);
            Projects projects = new Projects();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    projects.setProjectsId(rs.getInt(Projects.ID));
                    projects.setProjectsName(rs.getString(Projects.NAME));
                    projects.setCompanyId(rs.getInt(Projects.COMPANY_ID));
                    projects.setCustomersId(rs.getInt(Projects.CUSTOMERS_ID));
                    projects.setProjectCost(rs.getInt(Projects.COSTS));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Projects projects) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, projects.getProjectsName());
            ps.setInt(2, projects.getCompanyId());
            ps.setInt(3, projects.getCustomersId());
            ps.setInt(4, projects.getProjectCost());
            ps.execute();
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                projects.setProjectsId(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void addPersonsToProject(Projects project, int projectId) throws Exception {
        List<Integer> personsId = project.getPersonsIDList();
        if (personsId != null) {
            for (Integer personId : personsId) {
                try (Connection connection = DataSource.getConnection();
                     PreparedStatement ps = connection.prepareStatement(SQL_ADD_PERSONS_TO_PROJECT)) {
                    ps.setInt(1, personId);
                    ps.setInt(2, projectId);
                    ps.executeUpdate();
                }
            }
        }
    }

    @Override
    public void update(Projects projects) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, projects.getProjectsName());
            statement.setInt(2, projects.getCompanyId());
            statement.setInt(3, projects.getCustomersId());
            statement.setInt(4, projects.getProjectCost());
            statement.setInt(5, projects.getProjectsId());
            statement.execute();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }

    @Override
    public void delete(int projectsId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, projectsId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseExcept(e);
        }
    }
}
