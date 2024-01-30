/**
 * Классы пакета Entity содержат бизнес-сущность приложения
 * и включают в себя необходимые для базы данных свойств.
 */


package com.company.abonentfx.entity;

public class Address {

    private final int contractId;
    private final int postalCode;
    private final int streetId;
    private final String house;
    private final int flat;

    public Address(int contractId, int postalCode, int streetId, String house, int flat) {

        this.contractId = contractId;
        this.postalCode = postalCode;
        this.streetId = streetId;
        this.house = house;
        this.flat = flat;

    }

    public int getContractId() {
        return contractId;
    }

    public int getPostalCode() {
        return postalCode;
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

}
