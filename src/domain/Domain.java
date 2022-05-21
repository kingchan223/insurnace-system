package domain;


public interface Domain {
    Domain getStructure(String strLine);
    String toFileString();
    String getId();
}
