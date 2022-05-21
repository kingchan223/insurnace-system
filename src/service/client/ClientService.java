package service.client;

import model.client.ClientJoinReq;
import model.client.SubscriptionReq;
import repository.ClientRepository;
import service.employee.SalesEmployeeService;

import java.io.IOException;

public class ClientService {

    private final ClientRepository clientRepository;
    private final SalesEmployeeService salesEmployeeService;

    public ClientService() {
        this.clientRepository = new ClientRepository();
        this.salesEmployeeService = new SalesEmployeeService();
    }

    String join(ClientJoinReq joinReq){
        return clientRepository.insert(joinReq.toString());
    }

    String subClientToInsurance(String insuranceId, SubscriptionReq subscriptionReq){
        salesEmployeeService.saleInsurance(insuranceId, subscriptionReq);
        return "보험 가입에 성공하셨습니다.";
    }

//    String getInsuranceInfo(String insuranceId){
//
//    }
//
//    List<InsuranceResp> getInsurancesInfo(String clientId){
//
//    }
//
//    String getContract(String clientId, String contractId){
//
//    }
//    String getContracts(String clientId){
//
//    }
//
//    String pay(String contractId){
//
//    }
}
