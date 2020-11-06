import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class testEmpPayRoll {

    @Test
    public void givenConnection_whenInserted_shouldInsertInSQL() throws SQLException {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("insert into EmpPayRoll (name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                "values ('Bill','8145671323','Delhi','Sales','M',14000.0,1000,1000,2000,10000,'2018-03-01');");
        Assert.assertEquals(1,i);
    }

    @Test
    public void givenConnection_whenInserted_shouldCommit() throws SQLException {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("insert into EmpPayRoll (name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                "values ('Mahima','8124152611','Noida','Tech','M',100000.0,3000,12000,2000,85000,'2019-03-01');");
        con.commit();
        Assert.assertEquals(1,i);

    }

    @Test
    public void givenPreparedStatement_shouldExecute() throws SQLException {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();
        PreparedStatement stmt=con.prepareStatement("insert into EmpPayRoll(name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)");
        stmt.setString(2,"9723978901");
        stmt.setInt(6,25000);
        stmt.setInt(7,1500);
        stmt.setInt(8,3500);
        stmt.setInt(9,3500);
        stmt.setInt(10,19500);
        stmt.setDate(11, new Date(8000000));
        stmt.setString(1,"Gaurangi");
        stmt.setString(3,"Kolkatta");
        stmt.setString(4,"Sales");
        stmt.setString(5,"F");

        int i = stmt.executeUpdate();

        Assert.assertEquals(1,i);
    }


    @Test
    public void givenDates_shouldReturnEmployees() throws SQLException {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "Select name from EmpPayRoll where start> 2018-01-01 & start<2019-01-01";
        ResultSet rs = stmt.executeQuery(sql);
        int empCount=0;
        while (rs.next()){
            System.out.print(rs.getString("name"));
            empCount++;
        }
        Assert.assertEquals(7,empCount);
    }

    @Test
    public void givenTable_shouldReturnSumOfSalary() throws SQLException {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select sum(basic_pay) as total from EmpPayRoll where gender='F' group by gender";
        ResultSet rs = stmt.executeQuery(sql);

        int count = 0;
        while (rs.next()){
            count++;
        }
        System.out.println(rs.getString("total"));
        Assert.assertEquals(1,count);
    }
}