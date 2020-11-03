import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testEmpPayRoll {

    EmployeeOperations eo;
    JDBCdemo db;
    Connection con;
    EmpUpdate empDBO;
    @Before
    public void init(){
        empDBO = EmpUpdate.getInstance();
        eo = new EmployeeOperations();
        db = new JDBCdemo();
    }

    @Test
    public void onUpdation_compareEmpPayrollObjectWithDB() throws CustomException, SQLException {
        /* UC3 -- update employee object and in the database and compare */
        eo.updateEmployeeObject("Terissa", "400000");
        empDBO.readData();
        empDBO.updateData("salary", "Terissa", "400000");

        Emp_info e = eo.getEmployeeDataFromObject("Terissa");
        ResultSet rs = empDBO.getEmployeeDataFromDB("Select salary from employee where name = 'Terissa'");
        double salary = 0;
        while(rs.next()){
            salary = rs.getDouble("salary");
        }
        Assert.assertEquals(e.getSalary(), salary,0);
    }
    }

