/**
 * Класс AbonentSortingByPhoneNumber переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * сортировку по номерам телефонов пользователей.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.PhoneNumberEnum;

public class AbonentSortingByPhoneNumber implements SQLOperation {

    private final String column;

    public AbonentSortingByPhoneNumber() {

        column = AbonentfxDBTables.PHONE_NUMBER.getTableName() + "." + PhoneNumberEnum.MOBILE_NUMBER.getColumnName();

    }

    @Override
    public String toClause() {
        return "ORDER BY " + column + " ";
    }

}

