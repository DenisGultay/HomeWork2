package hw2.Entityes;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Customers {

    private int customersId;
    private String customersName;

    public Customers(int customersId, String customersName) {
        this.customersId = customersId;
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

    @Override
    public String toString() {
        return "Customers{" +
                "customersId=" + customersId +
                ", customersName='" + customersName + '\'' +
                '}';
    }
}
