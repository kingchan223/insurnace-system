package service.employee;

public abstract class CmEmployeeService {
    ClientResp getClientInfo(String clientId);
    ContractResp getContractInfo(String contractId);
}
