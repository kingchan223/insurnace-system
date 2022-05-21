package repository;

import domain.client.Client;
import domain.employee.Employee;
import util.FileCRUD;

import java.io.IOException;

public class ClientRepository {

    private static final String clientFile = "client-informations";

    public String insert(String clientStr){
        return FileCRUD.insertOne(clientFile, clientStr);
    }

    String findById(String clientId){
        return FileCRUD.findById(clientId, clientFile);
    }

    String update(String clientId, String clientStr) throws IOException {
        return FileCRUD.updateOne(clientId, clientFile, clientStr);
    }

    void deleteById(String clientId) throws IOException {
        FileCRUD.deleteById(clientId, clientFile);
    }


}
