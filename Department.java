import java.util.*;

public class Department {
    private String depCode;
    private String depName;
    private double depTotalSalary;
    private HashMap<String, Employee> employeeMap;

    //Setter methods
    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDepTotalSalary(double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }

    public void setEmployeeMap(HashMap<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    //Getter methods
    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public double getDepTotalSalary() {
        return depTotalSalary;
    }

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}