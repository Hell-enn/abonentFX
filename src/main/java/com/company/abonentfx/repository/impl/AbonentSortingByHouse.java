/**
 * Класс AbonentSortingByHouse переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * сортировку по домам пользователей.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.AddressEnum;

public class AbonentSortingByHouse implements SQLOperation {

    private final String column;

    public AbonentSortingByHouse() {

        column = AbonentfxDBTables.ADDRESS.getTableName() + "." + AddressEnum.HOUSE.getColumnName();

    }

    @Override
    public String toClause() {
        return "ORDER BY " + column + " ";
    }

}
