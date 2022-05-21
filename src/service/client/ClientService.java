package service.client;

public abstract class ClientService {

    ClientResp join(JoinReq joinReq);
    InsuranceState subClientToInsurance(String insuranceId, SubscriptionRequest subscriptionRequest);

    InsuranceDetailResp getInsuranceInfo(String insuranceId);
    List<InsuranceResp> getInsurancesInfo(String clientId);

    ContractResp getContract(String clientId, String contractId);
    List<ContractResp> getContracts(String clientId);

    PaymentResp pay(String contractId);
}
