package hw2.dao;

import hw2.entityes.Persons;

import java.util.List;

/**
 * Created by Користувач on 02.07.2017.
 */
public interface PersonsDAO {

    public static final String SQL_FIND_ALL = "select * from " + Persons.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Persons.ID + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " where " + Persons.NAME + " = ?";
    public static final String SQL_FIND_BY_AGE = SQL_FIND_ALL + " where " + Persons.AGE + " = ?";
    public static final String SQL_FIND_BY_COMPANY_ID = SQL_FIND_ALL + " where " + Persons.COMPANY_ID + " = ?";
    public static final String SQL_FIND_BY_SALARY = SQL_FIND_ALL + " where " + Persons.SALARY + " = ?";
    public static final String SQL_INSERT = "insert into " + Persons.TABLE_NAME + " (" + Persons.NAME + ", " + Persons.AGE + ", " + Persons.COMPANY_ID + ", " + Persons.SALARY + ") values (?,?,?,?)";
    public static final String SQL_UPDATE = "update " + Persons.TABLE_NAME + " set " + Persons.NAME + " = ?, " + Persons.AGE + " = ?, " + Persons.COMPANY_ID + " = ?, " + Persons.SALARY + " = ? where " + Persons.ID + " = ?";
    public static final String SQL_DELETE = "delete from " + Persons.TABLE_NAME + " where " + Persons.ID + " = ?";

    public List<Persons> findAll();
    public Persons findById(int personsId);
    public Persons findByName(String personsName);
    public Persons findByAge(int personsAge);
    public Persons findByCompanyId(int companyId);
    public List<Persons> findBySalary(int salary);
    public void insert(Persons persons);
    public void update(Persons persons);
    public void delete(Persons persons);
}
