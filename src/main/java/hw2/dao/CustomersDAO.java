package hw2.dao;

import hw2.entityes.Company;
import hw2.entityes.Customers;

import java.util.List;

/**
 * Created by Користувач on 02.07.2017.
 */
public interface CustomersDAO {

    public static final String SQL_FIND_ALL = "select * from " + Customers.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Customers.ID + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " where " + Customers.NAME + " = ?";
    public static final String SQL_INSERT = "insert into " + Customers.TABLE_NAME + " (" + Customers.NAME + ") values (?)";
    public static final String SQL_UPDATE = "update " + Customers.TABLE_NAME + " set " + Customers.NAME + " = ? where " + Customers.ID + " = ?";
    public static final String SQL_DELETE = "delete from " + Customers.TABLE_NAME + " where " + Customers.ID + " = ?";

    public List<Customers> findAll();
    public Customers findById(int customersId);
    public Customers findByName(String customersName);
    public void insert(Customers customers);
    public void update(Customers customers);
    public void delete(Customers customers);
}
