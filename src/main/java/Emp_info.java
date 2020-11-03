import java.util.Date;

public class Emp_info
{
    private int id;
    private String name, address, department;
    private char gender;
    private double salary;
    private Date date;
    private String phone;

    public Emp_info(int id, String name, String phone, String address, String department, char gender, double salary, Date date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.department = department;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public char getGender() { return gender; }

    public void setGender(char gender) { this.gender = gender; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department;}

    @Override
    public String toString() {
        return "Id: " + this.id + " | Name: " + this.name + " | Gender: " + this.gender + " | Salary: " + this.salary
                + " | Date: " + this.date + " | Phone: " + this.phone + " | Address: " + this.address
                + " | Department: " + this.department;
    }
}


