/**
 * Класс AbonentSortingByStreet переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * сортировку по улицам адресов пользователей.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.StreetsEnum;

public class AbonentSortingByStreet implements SQLOperation {

    private final String column;

    public AbonentSortingByStreet() {

        column = AbonentfxDBTables.STREETS.getTableName() + "." + StreetsEnum.STREET.getColumnName();

    }


    @Override
    public String toClause() {
        return "ORDER BY street " + column + " ";
    }

}
