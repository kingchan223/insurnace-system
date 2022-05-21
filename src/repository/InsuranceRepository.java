package repository;

import util.FileCRUD;

import java.io.IOException;

public class InsuranceRepository {
    private static final String insuranceFile = "insurance.txt";

    String insert(String clientStr) throws IOException {
        return FileCRUD.insertOne(insuranceFile, clientStr);
    }

    public String findById(String clientId){
        return FileCRUD.findById(clientId, insuranceFile);
    }

    String update(String clientId, String clientStr) throws IOException {
        return FileCRUD.updateOne(clientId, insuranceFile, clientStr);
    }

    void deleteById(String clientId) throws IOException {
        FileCRUD.deleteById(clientId, insuranceFile);
    }
}
