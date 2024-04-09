import java.io.*;

public class DepartmentReport {

    public DepartmentReport() throws FileNotFoundException {
        DepartmentDA departmentDA = new DepartmentDA();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new DepartmentReport();
    }
}