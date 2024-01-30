/**
 * Класс AbonentSortingByFullName переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * сортировку по ФИО пользователя.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentEnum;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;

public class AbonentSortingByFullName implements SQLOperation {

    private final String column;

    public AbonentSortingByFullName() {

        column = AbonentfxDBTables.ABONENT.getTableName() + "." + AbonentEnum.FULL_NAME.getColumnName();

    }

    @Override
    public String toClause() {
        return "ORDER BY " + column + " ";
    }

}
