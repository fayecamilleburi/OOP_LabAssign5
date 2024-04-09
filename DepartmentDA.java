import java.io.*;
import java.text.*;
import java.util.*;

public class DepartmentDA {
    private HashMap<String, Employee> employeeMap;

    public DepartmentDA() {
        try {
            Scanner departmentFile = new Scanner(new FileReader("dep.csv"));
            departmentFile.nextLine();

            while (departmentFile.hasNext()) {
                employeeMap = new HashMap<>();

                String departmentLineData = new String();
                departmentLineData = departmentFile.nextLine();

                String[] departmentLineDataSpecific = new String[3];
                departmentLineDataSpecific = departmentLineData.split(",");

                Department department = new Department();
                department.setDepCode(departmentLineDataSpecific[0].trim());
                department.setDepName(departmentLineDataSpecific[1].trim());

                readDepEmp(department);
                printDepartment(department);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("Department code: " + department.getDepCode());
        System.out.println("Department name: " + department.getDepName());
        System.out.println("Department total salary: " + df.format(department.getDepTotalSalary()));
        System.out.println("---------------------Details -------------------------");
        System.out.println("EmpNo\t\t\tEmployee Name\tSalary");
        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            Employee employee = entryMap.getValue();
            String fullName = employee.getLastName() + ", " + employee.getFirstName();

            System.out.print(employee.getEmpNo() + "\t\t");
            System.out.print(fullName);
            if (fullName.length() > 13) {
                System.out.print("\t" + df.format(employee.getSalary()));
            } else {
                System.out.print("\t\t" + df.format(employee.getSalary()));
            }
            System.out.println();
        }
        System.out.println();
    }

    private void readDepEmp(Department department) {
        try {
            Scanner deptEmpFile = new Scanner(new FileReader("deptemp.csv"));
            deptEmpFile.nextLine();

            double totalSalary = 0.0;
            Integer key = 0;

            while (deptEmpFile.hasNext()) {
                String deptEmpLineData = new String();
                deptEmpLineData = deptEmpFile.nextLine();
                
                String[] deptEmpLineDataSpecific = new String[3];
                deptEmpLineDataSpecific = deptEmpLineData.split(",");
    
                if (department.getDepCode().equals(deptEmpLineDataSpecific[0].trim())) {
                    String empNo = deptEmpLineDataSpecific[1].trim();

                    EmployeeDA employeeDA = new EmployeeDA(empNo);

                    employeeMap.put(empNo+key, employeeDA.getEmployee());

                    Employee employee = new Employee();
                    employee = employeeDA.getEmployee();

                    employee.setSalary(Double.parseDouble(deptEmpLineDataSpecific[2].trim()));

                    totalSalary += employee.getSalary();
                    key++;
                }
            }
            department.setEmployeeMap(employeeMap);
            department.setDepTotalSalary(totalSalary);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }    
}