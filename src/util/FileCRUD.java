package util;

import domain.Domain;
import domain.employee.Employee;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileCRUD {

    public static List<String> findAll(String filename){
        List<String> retVal = new ArrayList<>();
        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(getFilePath(filename)));
            while (objStudentFile.ready()) {
                String strLine = objStudentFile.readLine();
                if (!strLine.equals("")){
                    retVal.add(strLine);
                }
            }
            objStudentFile.close();
        //TODO 저장된 내용 없다는 Exception
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public static String findById(String id, String filename){

        try {
            BufferedReader objStudentFile = new BufferedReader(new FileReader(getFilePath(filename)));
            while (objStudentFile.ready()) {
                String strLine = objStudentFile.readLine();
                if (!strLine.equals("") && strLine.split(" ")[0].equals(id)){
                    return strLine;
                }
            }
            objStudentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String insertOne(String fileName, String data){
        try{
            Files.write(
                    Paths.get(getFilePath(fileName)),
                    data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND
            );
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static void deleteById(String id, String fileName) throws IOException {
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

    public static String updateOne(String id, String filename, String data) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(getFilePath(filename)));
        String allOfFile = "";
        while (br.ready()) {
            String line = br.readLine();
            String[] lineSplit = line.split(" ");
            if(lineSplit[0].equals(id)) allOfFile += data + "/n";
            else allOfFile += line + "/n";
        }
        FileWriter fw = new FileWriter(getFilePath(filename));
        fw.write(allOfFile);
        fw.close();
        br.close();
        return data;
    }

    private static String getFilePath(String fileName) {
        if(fileName.equals("client-informaion"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/client/client-informations.txt";
        else if(fileName.equals("contract-datas"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/contract/contract-datas.txt";
        else if(fileName.equals("employees"))
            return "/Users/leechanyoung/Downloads/명지/분산/insurance-system/src/files/employee/employees.txt";
        else return "";
    }
}
