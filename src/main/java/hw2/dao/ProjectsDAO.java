package hw2.dao;

import hw2.entityes.Projects;

import java.util.List;

/**
 * Created by Користувач on 02.07.2017.
 */
public interface ProjectsDAO {

    public static final String SQL_FIND_ALL = "select * from " + Projects.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Projects.ID + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " where " + Projects.NAME + " = ?";
    public static final String SQL_FIND_BY_CUSTOMERS_ID = SQL_FIND_ALL + " where " + Projects.CUSTOMERS_ID + " = ?";
    public static final String SQL_FIND_BY_COMPANY_ID = SQL_FIND_ALL + " where " + Projects.COMPANY_ID + " = ?";
    public static final String SQL_FIND_BY_COSTS = SQL_FIND_ALL + " where " + Projects.COSTS + " = ?";
    public static final String SQL_INSERT = "insert into " + Projects.TABLE_NAME + " (" + Projects.NAME + ", " + Projects.COMPANY_ID + ", " + Projects.CUSTOMERS_ID + ", " + Projects.COSTS + ") values (?,?,?,?)";
    public static final String SQL_ADD_PERSONS_TO_PROJECT = "insert into " + Projects.PERSONS_PROJECTS + " (persons_id, projects_id) values (? ,?)";
    public static final String SQL_UPDATE = "update " + Projects.TABLE_NAME + " set " + Projects.NAME + " = ?, " + Projects.COMPANY_ID + " = ?, " + Projects.CUSTOMERS_ID + " = ?, " + Projects.COSTS + " = ? where " + Projects.ID + " = ?";
    public static final String SQL_DELETE = "delete from " + Projects.TABLE_NAME + " where " + Projects.ID + " = ?";

    public List<Projects> findAll();
    public Projects findById(int projectsId);
    public Projects findByName(String projectsName);
    public Projects findByCustomersId(int customersId);
    public List<Projects> findByCompanyId(int companyId);
    public List<Projects> findByCosts(int projectCost);
    public void insert(Projects projects);
    public void addPersonsToProject(Projects project, int projectId) throws Exception;
    public void update(Projects projects);
    public void delete(int projectsId);
}
