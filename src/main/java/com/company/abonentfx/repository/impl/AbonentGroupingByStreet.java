/**
 * Класс AbonentGroupingByStreet переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * группировку по признаку "улица".
 */

package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.AddressEnum;

public class AbonentGroupingByStreet implements SQLOperation {

    private final String column;

    public AbonentGroupingByStreet() {

        column = AbonentfxDBTables.STREETS.getTableName() + "." + AddressEnum.STREET_ID.getColumnName();

    }

    @Override
    public String toClause() {
        return "GROUP BY " + column + " ";
    }

}
