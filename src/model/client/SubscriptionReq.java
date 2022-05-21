package model.client;

public class SubscriptionReq {
    private String clientId;
    private ClientHealthInformation clientHealthInformation;

    public ClientHealthInformation getClientHealthInformation() {
        return clientHealthInformation;
    }

    public String getClientId() {
        return clientId;
    }
}
