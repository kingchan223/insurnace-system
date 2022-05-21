package repository;

import util.FileCRUD;

import java.io.IOException;

public class EmployeeRepository {
    private static final String employeesFile = "employees.txt";

    String insert(String employeeId) throws IOException {
        return FileCRUD.insertOne(employeesFile, employeeId);
    }

    String findById(String employeeId){
        return FileCRUD.findById(employeeId, employeesFile);
    }

    String update(String employeeId, String employeeStr) throws IOException {
        return FileCRUD.updateOne(employeeId, employeesFile, employeeStr);
    }

    void deleteById(String employeeId) throws IOException {
        FileCRUD.deleteById(employeeId, employeesFile);
    }
}
