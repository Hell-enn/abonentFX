/**
 * Класс AbonentSpecificationByHouse переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * выборку пользователей по номеру дома.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.AddressEnum;

public class AbonentSpecificationByHouse implements SQLOperation {

    private final String house;
    private final String column;


    public AbonentSpecificationByHouse(String house) {

        this.house = house;
        column = AbonentfxDBTables.ADDRESS.getTableName() + "." + AddressEnum.HOUSE.getColumnName();

    }


    @Override
    public String toClause() {

        return "WHERE " + column + " LIKE '%" + house + "%' ";

    }
}