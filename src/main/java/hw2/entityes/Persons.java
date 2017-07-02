package hw2.entityes;

import java.util.HashSet;
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

    private int personsId;
    private String personsName;
    private int personsAge;
    private int companyId;
    private int salary;
    private Set<Projects> projects = new HashSet<Projects>();
    private Set<Skills> skills = new HashSet<Skills>();


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

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Personss[id= " + this.personsId + ", name= " + this.personsName + ", personsAge= " + this.personsAge + ", salary= " + this.salary +", companyId= " + this.companyId +"]";
    }
}
