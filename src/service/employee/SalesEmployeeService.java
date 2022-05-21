package service.employee;

import domain.insurance.Insurance;
import model.client.SubscriptionReq;
import repository.InsuranceRepository;

public class SalesEmployeeService {

    private final SaEmployeeService saEmployeeService;
    private final InsuranceRepository insuranceRepository;
    private final ContractService contractService;

    public SalesEmployeeService() {
        this.saEmployeeService = new SaEmployeeService();
        this.insuranceRepository = new InsuranceRepository();
        this.contractService = new ContractService();
    }

//    List<InsuranceResp> recommandInsurance(String clientId);

    public boolean saleInsurance(String insuranceId, SubscriptionReq subscriptionReq) {
        String insuranceStr = insuranceRepository.findById(insuranceId);
        Insurance insurance = Insurance.makeObject(insuranceStr);//client 가 가입하고 싶은 insurance
        if(saEmployeeService.AuditSubscription(subscriptionReq.getClientHealthInformation(), insurance))
            return makeContract(subscriptionReq.getClientId(), insuranceId);
        else return false;
    }

    private boolean makeContract(String clientId, String insuranceId){
        //뭐 또 필요한 로직....
        this.contractService.makeContract(clientId, insuranceId);
        return true;
    }
}
