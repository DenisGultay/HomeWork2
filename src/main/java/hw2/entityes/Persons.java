package hw2.entityes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Користувач on 02.07.2017.
 */
public class Persons {

    public static final String TABLE_NAME = "persons";
    public static final String ID = "persons_id";
    public static final String NAME = "persons_name";
    public static final String AGE = "persons_age";
    public static final String COMPANY_ID = "company_id";
    public static final String SALARY = "salary";
    public static final String PERSONS_SKILLS = "persons_skills";

    private int personsId;
    private String personsName;
    private int personsAge;
    private int companyId;
    private int salary;
    private List<Integer> projectsIDList;
    private List<Integer> skillsIDList;


    public Persons(String personsName, int personsAge, int companyId, int salary) {
        this.personsName = personsName;
        this.personsAge = personsAge;
        this.companyId = companyId;
        this.salary = salary;
    }

    public Persons() {
    }

    public int getPersonsId() {
        return personsId;
    }

    public void setPersonsId(int personsId) {
        this.personsId = personsId;
    }

    public String getPersonsName() {
        return personsName;
    }

    public void setPersonsName(String personsName) {
        this.personsName = personsName;
    }

    public int getPersonsAge() {
        return personsAge;
    }

    public void setPersonsAge(int personsAge) {
        this.personsAge = personsAge;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Integer> getProjectsIDList() {
        return projectsIDList;
    }

    public void setProjectsIDList(List<Integer> projectsIDList) {
        this.projectsIDList = projectsIDList;
    }

    public List<Integer> getSkillsIDList() {
        return skillsIDList;
    }

    public void setSkillsIDList(List<Integer> skillsIDList) {
        this.skillsIDList = skillsIDList;
    }

    @Override
    public String toString() {
        return "Personss[id= " + this.personsId + ", name= " + this.personsName + ", personsAge= " + this.personsAge + ", salary= " + this.salary +", companyId= " + this.companyId +"]";
    }
}
