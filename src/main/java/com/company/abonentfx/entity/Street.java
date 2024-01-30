/**
 * Классы пакета Entity содержат бизнес-сущность приложения
 * и включают в себя необходимые для базы данных свойств.
 */


package com.company.abonentfx.entity;

import java.util.Objects;

public class Street {

    private final int streetId;
    private final String country;
    private final String region;
    private final String area;
    private final String city;
    private final String street;

    public Street(int streetId, String country, String region, String area, String city, String street) {

        this.streetId = streetId;
        this.country = country;
        this.region = region;
        this.area = area;
        this.city = city;
        this.street = street;

    }

    public int getStreetId() {
        return streetId;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street1 = (Street) o;
        return streetId == street1.streetId && Objects.equals(country, street1.country) && Objects.equals(region, street1.region) && Objects.equals(area, street1.area) && Objects.equals(city, street1.city) && Objects.equals(street, street1.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetId, country, region, area, city, street);
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetId=" + streetId +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
