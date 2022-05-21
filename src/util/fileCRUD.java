package util;

import domain.Domain;
import domain.employee.CmEmployee;
import service.employee.CmEmployeeService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class fileCRUD {

    public List<Domain> findAll(String filename, Domain domain){
        List<Domain> retVal = new ArrayList<>();
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(getFilePath(filename)));
            while (objStudentFile.ready()) {
                String strLine = objStudentFile.readLine();
                if (!strLine.equals("")){
                    Domain structure = domain.getStructure(strLine);
                    retVal.add(structure);
                }
            }
            objStudentFile.close();
        //TODO 저장된 내용 없다는 Exception
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Domain findById(String id, String filename, Domain domain){

        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(getFilePath(filename)));
            while (objStudentFile.ready()) {
                String strLine = objStudentFile.readLine();
                if (!strLine.equals("") && strLine.split(" ")[0].equals(id)){
                    return domain.getStructure(strLine);
                }
            }
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertOne(String fileName, Domain domain) throws IOException {
        Files.write(
                Paths.get(getFilePath(fileName)),
                domain.toFileString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND
        );
    }

    public void deleteById(String id, String fileName, Domain domain) throws IOException {
        String allOfFile = "";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            String line = br.readLine();
            String nowId = line.split(" ")[0];
            if(!nowId.equals(id)) allOfFile += line + "/n";
        }
        FileWriter fw = new FileWriter(fileName);
        fw.write(allOfFile);
        fw.close();
        br.close();
    }

    public void updateDomain(String filename, Domain domain) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(getFilePath(filename)));
        String allOfFile = "";
        String id = domain.getId();
        while (br.ready()) {
            String line = br.readLine();
            String[] lineSplit = line.split(" ");
            if(lineSplit[0].equals(id)) allOfFile += domain.toFileString()+ "/n";
            else allOfFile += line + "/n";
        }
        FileWriter fw = new FileWriter(getFilePath(filename));
        fw.write(allOfFile);
        fw.close();
        br.close();
    }

    private String getFilePath(String fileName) {
        if(fileName.equals("client-informaion"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/client/client-informations.txt";
        else if(fileName.equals("contract-datas"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/contract/contract-datas.txt";
        else if(fileName.equals("employees"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/employee/employees.txt";
        else return "";
    }
}
