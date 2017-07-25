package hw2.entityes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Projects {

    public static final String TABLE_NAME = "projects";
    public static final String ID = "projects_id";
    public static final String NAME = "projects_name";
    public static final String COMPANY_ID = "company_id";
    public static final String CUSTOMERS_ID = "customers_id";
    public static final String COSTS = "projects_cost";
    public static final String PERSONS_PROJECTS = "persons_projects";

    private int projectsId;
    private String projectsName;
    private int companyId;
    private int customersId;
    private int projectCost;
    private List<Integer> personsIDList;

    public Projects(String projectsName, int companyId, int customersId, int projectCost) {
        this.projectsName = projectsName;
        this.companyId = companyId;
        this.customersId = customersId;
        this.projectCost = projectCost;
    }

    public Projects() {
    }

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public String getProjectsName() {
        return projectsName;
    }

    public void setProjectsName(String projectsName) {
        this.projectsName = projectsName;
    }

    public int getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public List<Integer> getPersonsIDList() {
        return personsIDList;
    }

    public void setPersonsIDList(List<Integer> personsIDList) {
        this.personsIDList = personsIDList;
    }

    @Override
    public String toString() {
        return "Projects[id= " + this.projectsId + ", name= " + this.projectsName + ", companyId= " + this.companyId +", customersId= " + this.customersId +", projectCosts= " + this.projectCost +"]";
    }
}
