package hw2.entityes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Company {

    public static final String TABLE_NAME = "company";
    public static final String ID = "company_id";
    public static final String NAME = "company_name";

    private int companyId;
    private String companyName;
    private Set<Projects> projects = new HashSet<Projects>();
    private Set<Persons> persons = new HashSet<Persons>();

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }

    public Set<Persons> getPersons() {
        return persons;
    }

    public void setPersons(Set<Persons> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Company[id= " + this.companyId + ", name= " + this.companyName + "]";
    }
}
