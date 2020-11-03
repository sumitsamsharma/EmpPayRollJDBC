import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class EmpUpdate implements CRUD
{
    static List<Emp_info> employee_list = new ArrayList<>();

    @Override
    public List<Emp_info> readData(Connection con) throws CustomException {
        try{
            String query = "Select * from emppayroll";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String phone = rs.getString("phone_no");
                String address = rs.getString("Address");
                String department = rs.getString("Department");
                Date start = rs.getDate("start");
                char gender = rs.getString("gender").charAt(0);
                double salary = rs.getDouble("salary");
                Emp_info emp = new Emp_info(id,name,phone,address,department,gender,salary,start);
                employee_list.add(emp);
            }
        }catch(Exception e){
            throw new CustomException("Read Process Unsuccessful");
        }
        return employee_list;
    }

    @Override
    public void insertData() { }

    @Override
    public void updateData(Connection con, String column, String name, String value) throws CustomException {
        try{
            PreparedStatement stmt = con.prepareStatement("Update emppayroll set salary = ? where name = ?");
            stmt.setDouble(1,Double.parseDouble(value));
            stmt.setString(2,name);
            stmt.executeUpdate();
        }catch(Exception e){
            throw new CustomException("Read Process Unsuccessful");
        }
    }

    @Override
    public void deleteData() { }
}