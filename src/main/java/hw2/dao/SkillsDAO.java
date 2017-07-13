package hw2.dao;

import hw2.entityes.Skills;

import java.util.List;

/**
 * Created by Користувач on 02.07.2017.
 */
public interface SkillsDAO {

    public static final String SQL_FIND_ALL = "select * from " + Skills.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Skills.ID + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " where " + Skills.NAME + " = ?";
    public static final String SQL_INSERT = "insert into " + Skills.TABLE_NAME + " (" + Skills.NAME + ") values (?)";
    public static final String SQL_UPDATE = "update " + Skills.TABLE_NAME + " set " + Skills.NAME + " = ? where " + Skills.ID + " = ?";
    public static final String SQL_DELETE = "delete from " + Skills.TABLE_NAME + " where " + Skills.ID + " = ?";

    public List<Skills> findAll();
    public Skills findById(int skillsId);
    public Skills findByName(String skillsName);
    public void insert(Skills skills);
    public void update(Skills skills);
    public void delete(int skillsId);
}
