/**
 * Класс AbonentSpecificationByHouse переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * выборку пользователей по улице проживания.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.AddressEnum;
import com.company.abonentfx.repository.constants.StreetsEnum;

public class AbonentSpecificationByStreet implements SQLOperation {

    private final String street;
    private final String column;


    public AbonentSpecificationByStreet(String street) {

        this.street = street;
        column = AbonentfxDBTables.STREETS.getTableName() + "." + StreetsEnum.STREET.getColumnName();

    }


    @Override
    public String toClause() {

        return "WHERE " + column + " = '" + street + "' ";

    }
}