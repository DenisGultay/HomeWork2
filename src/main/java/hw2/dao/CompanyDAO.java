package hw2.dao;

import hw2.entityes.Company;

import java.util.List;

/**
 * Created by Користувач on 02.07.2017.
 */
public interface CompanyDAO {

    public static final String SQL_FIND_ALL = "select * from " + Company.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Company.ID + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " where " + Company.NAME + " = ?";
    public static final String SQL_INSERT = "insert into " + Company.TABLE_NAME + " (" + Company.NAME + ") values (?)";
    public static final String SQL_UPDATE = "update " + Company.TABLE_NAME + " set " + Company.NAME + " = ? where " + Company.ID + " = ?";
    public static final String SQL_DELETE = "delete from " + Company.TABLE_NAME + " where " + Company.ID + " = ?";

    public List<Company> findAll();
    public Company findById(int companyId);
    public Company findByName(String companyName);
    public void insert(Company company);
    public void update(Company company);
    public void delete(int companyId);
}
