/**
 * Классы пакета Entity содержат бизнес-сущность приложения
 * и включают в себя необходимые для базы данных свойств.
 */


package com.company.abonentfx.entity;

public class PhoneNumber {

    private final int contractId;
    private String mobileNumber;
    private String homeNumber;
    private String workingNumber;

    public PhoneNumber(int contractId, String mobileNumber, String homeNumber, String workingNumber) {

        this.contractId = contractId;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.workingNumber = workingNumber;

    }

    public int getContractId() {
        return contractId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getWorkingNumber() {
        return workingNumber;
    }

}
