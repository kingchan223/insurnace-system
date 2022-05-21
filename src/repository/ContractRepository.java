package repository;

import util.FileCRUD;

import java.io.IOException;

public class ContractRepository {
    private static final String contractFile = "contract-datas.txt";

    public String insert(String contractData){
        return FileCRUD.insertOne(contractFile, contractData);
    }

    String findById(String contractId){
        return FileCRUD.findById(contractId, contractFile);
    }

    String update(String contractId, String contractStr) throws IOException {
        return FileCRUD.updateOne(contractId, contractFile, contractStr);
    }

    void deleteById(String contractId) throws IOException {
        FileCRUD.deleteById(contractId, contractFile);
    }
}
