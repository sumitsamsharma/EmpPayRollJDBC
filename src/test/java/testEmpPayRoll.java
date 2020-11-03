import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testEmpPayRoll {
    EmpUpdate emp;
    EmployeeOperations eo;
    JDBCdemo db;
    Connection con;
    @Before
    public void init(){
        emp = new EmpUpdate();
        eo = new EmployeeOperations();
        db = new JDBCdemo();
        con = db.getConnection();
    }

    @Test
    public void onUpdation_compareEmpPayrollObjectWithDB() throws CustomException, SQLException {
        /* UC3 -- update employee object and in the database and compare */
        eo.updateEmployeeObject("Terissa", "400000");
        emp.readData(con);
        emp.updateData(con, "salary", "Terissa", "1800000");

        Emp_info e = null;
        for(Emp_info ep: EmpUpdate.employee_list){
            if(ep.getName().equals("Terissa"))
                e = ep;
        }
        ResultSet rs = con.createStatement().executeQuery("Select salary from emppayroll where name = 'Terissa'");
        double salary = 0;
        while(rs.next()){
            salary = rs.getDouble("salary");
        }
        Assert.assertEquals(e.getSalary(), salary,0);
    }
}