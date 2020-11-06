import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

class EmpUpdate implements CRUD{
    Statement statement=null;
    public static void main(String[] args) {
        JDBCdemo connection = new JDBCdemo();
        Connection con = connection.getConnection();

        try {

            String sql = "SELECT * from employee_payroll;";
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("insert into employee_payroll (id,name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                    "values ('Bill','8123714400','Haryana','Tech','M',150000.0,10000,25000,7000,120000,'2018-03-01'),");
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                double deductions = rs.getInt("deductions");
                double tax_pay = rs.getInt("taxable_pay");
                double income_tax = rs.getInt("income_tax");
                double net_pay = rs.getInt("net_pay");
                String address = rs.getString("address");
                String department = rs.getString("department");
                Date start = rs.getDate("start");
                Character gender = (Character) rs.getObject("gender");
                double basic_pay = rs.getDouble("basic_pay");
                System.out.println(id + "," + name + "," + phone + "," + address + "," + "," +
                        department + "," + basic_pay + "," + deductions + "," + net_pay + "," + start);
            }
            con.commit();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(String s) {

    }

    @Override
    public void update(String s) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void select(String s) {

    }
}
