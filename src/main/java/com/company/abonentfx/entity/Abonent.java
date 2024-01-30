/**
 * Классы пакета Entity содержат бизнес-сущность приложения
 * и включают в себя необходимые для базы данных свойств.
 */


package com.company.abonentfx.entity;

import java.util.Objects;

public class Abonent {

    private final int contractId;
    private String fullName;
    private final String birthDate;
    private String passportSeries;
    private String passportNumber;
    private String issueDate;
    private String issueDepartment;
    private String registration;
    private int postalIndex;
    private int streetId;
    private String house;
    private int flat;
    private String mobileNumber;
    private String houseNumber;
    private String workingNumber;



    public Abonent(int contractId, String fullName, String birthDate, String passportSeries, String passportNumber,
                   String issueDate, String issueDepartment, String registration, int postalIndex,
                   int streetId, String house, int flat, String mobileNumber, String houseNumber,
                   String workingNumber) {

        this.contractId = contractId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.issueDate = issueDate;
        this.issueDepartment = issueDepartment;
        this.registration = registration;
        this.postalIndex = postalIndex;
        this.streetId = streetId;
        this.house = house;
        this.flat = flat;
        this.mobileNumber = mobileNumber;
        this.houseNumber = houseNumber;
        this.workingNumber = workingNumber;

    }

    public int getContractId() {
        return contractId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public String getRegistration() {
        return registration;
    }

    public int getPostalIndex() {
        return postalIndex;
    }

    public int getStreetId() {
        return streetId;
    }

    public String getHouse() {
        return house;
    }

    public int getFlat() {
        return flat;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getWorkingNumber() {
        return workingNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return contractId == abonent.contractId && postalIndex == abonent.postalIndex && streetId == abonent.streetId
                && flat == abonent.flat && Objects.equals(fullName, abonent.fullName)
                && Objects.equals(birthDate, abonent.birthDate) && Objects.equals(passportSeries, abonent.passportSeries)
                && Objects.equals(passportNumber, abonent.passportNumber) && Objects.equals(issueDate, abonent.issueDate)
                && Objects.equals(issueDepartment, abonent.issueDepartment)
                && Objects.equals(registration, abonent.registration) && Objects.equals(house, abonent.house)
                && Objects.equals(mobileNumber, abonent.mobileNumber) && Objects.equals(houseNumber, abonent.houseNumber)
                && Objects.equals(workingNumber, abonent.workingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, birthDate);
    }


    @Override
    public String toString() {
        return "Abonent{" +
                "contractId=" + contractId +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", issueDepartment='" + issueDepartment + '\'' +
                ", registration='" + registration + '\'' +
                ", postalIndex=" + postalIndex +
                ", streetId=" + streetId +
                ", house='" + house + '\'' +
                ", flat=" + flat +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", workingNumber='" + workingNumber + '\'' +
                '}';
    }
}