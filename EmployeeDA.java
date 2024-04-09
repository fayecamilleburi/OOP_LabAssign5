import java.io.*;
import java.util.*;

public class EmployeeDA {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDA(String empNo) {
        try {
            Scanner employeeFile = new Scanner(new FileReader("emp.csv"));
            employeeFile.nextLine();

            employee = new Employee();

            while(employeeFile.hasNext()) {
                String employeeLineData = new String();
                employeeLineData = employeeFile.nextLine();

                String[] employeeLineDataSpecific = new String[4];
                employeeLineDataSpecific = employeeLineData.split(",");

                if(empNo.equals(employeeLineDataSpecific[0].trim())) {
                    employee.setEmpNo(employeeLineDataSpecific[0].trim());
                    employee.setLastName(employeeLineDataSpecific[1].trim());
                    employee.setFirstName(employeeLineDataSpecific[2].trim());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}