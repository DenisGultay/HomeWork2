package hw2.entityes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Customers {

    public static final String TABLE_NAME = "customers";
    public static final String ID = "customers_id";
    public static final String NAME = "customers_name";

    private int customersId;
    private String customersName;
    private Set<Projects> projects = new HashSet<Projects>();

    public Customers(String customersName) {
        this.customersName = customersName;
    }

    public Customers() {
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Customers[id= " + this.customersId + ", name= " + this.customersName + "]";
    }
}
