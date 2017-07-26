package hw2;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import hw2.dao.impl.*;
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
        CompanyDAOImp companyDAOImp = new CompanyDAOImp();
        SkillsDAOImp skillsDAOImp = new SkillsDAOImp();
        ProjectsDAOImp projectsDAOImp = new ProjectsDAOImp();
        CustomersDAOImp customersDAOImp = new CustomersDAOImp();

//      ---------------- Company -------------------

        Company company = getCompanyInstance();
        companyDAOImp.insert(company);

//      ---------------- Customers -----------------

        System.out.println(customersDAOImp.findById(5));

//      ----------------- Skills -------------------

        Skills skill = getSkillssInstance();
        skillsDAOImp.update(skill);

//      -------------- Persons --------------------

        Persons mark = getPersonsInstance();
//               personsDAOImp.insert(mark);
        personsDAOImp.addSkillsToPersons(mark, 14);

//      -------------- Projects -------------------

        Projects lastProject = getProjectsInstance();
//        projectsDAOImp.insert(lastProject);
        projectsDAOImp.addPersonsToProject(lastProject, 18);
    }

    static Company getCompanyInstance() {
        return new Company("Oracle");
    }

    static Customers getCustomersInstance() {
        return new Customers();
    }

    static Persons getPersonsInstance() {
        List<Integer> skillIdList = Arrays.asList(new Integer[]{1, 2, 5});
        Persons persons = new Persons("Mark", 26, 4, 5200);
        persons.setSkillsIDList(skillIdList);
        return persons;
    }

    static Projects getProjectsInstance() {
        List<Integer> personIdList = Arrays.asList(new Integer[]{7, 14});
        Projects projects = new Projects("LastProject", 4, 3, 250000);
        projects.setPersonsIDList(personIdList);
        return projects;
    }

    static Skills getSkillssInstance() {
        return new Skills("C#");
    }


}

