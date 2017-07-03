package hw2;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import hw2.dao.impl.CompanyDAOImp;
import hw2.entityes.Company;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Користувач on 29.06.2017.
 */
public class Main {

    private static int count = 2;
    public static void main(String[] args) {

        CompanyDAOImp companyDAOImp = new CompanyDAOImp();
        Company company = getCompanyInstance();
        companyDAOImp.insert(company);
    }

    static Company getCompanyInstance(){
        return new Company("Oracle" + count);
    }
}
