package hw2;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import hw2.dao.impl.CompanyDAOImp;
import hw2.dao.impl.PersonsDAOImp;
import hw2.dao.impl.SkillsDAOImp;
import hw2.entityes.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Користувач on 29.06.2017.
 */
public class Main {

    //   private static int count = 2;
    public static void main(String[] args) throws Exception {

        PersonsDAOImp personsDAOImp = new PersonsDAOImp();
//        CompanyDAOImp companyDAOImp = new CompanyDAOImp();
//        SkillsDAOImp skillsDAOImp = new SkillsDAOImp();
//        Company company = getCompanyInstance();
//        companyDAOImp.delete(5);
//        System.out.println(personsDAOImp.findBySalary(2000));

       Persons mark = getPersonsInstance();
   //     personsDAOImp.insert(mark);
        personsDAOImp.addSkillsToPersons(mark, 14);
    }

    static Company getCompanyInstance() {
        return new Company("");
    }

    static Customers getCustomersInstance() {
        return new Customers();
    }

    static Persons getPersonsInstance() {
        List<Integer> skillIdList = Arrays.asList(new Integer[]{1, 2, 5});
        Persons persons = new Persons("Mark", 26, 4,5200);
        persons.setSkillsIDList(skillIdList);
        return persons;
    }

    static Projects getProjectsInstance(){
        return new Projects();
    }

    static Skills getSkillssInstance(){
        return new Skills();
    }


}

