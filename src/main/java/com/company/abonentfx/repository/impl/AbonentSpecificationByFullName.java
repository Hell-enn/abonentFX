/**
 * Класс AbonentSpecificationByFullName переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * выборку пользователей по ФИО.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentEnum;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;

public class AbonentSpecificationByFullName implements SQLOperation {

    private final String fullName;
    private final String column;

    public AbonentSpecificationByFullName(String fullName) {

        this.fullName = fullName;
        column = AbonentfxDBTables.ABONENT.getTableName() + "." + AbonentEnum.FULL_NAME.getColumnName();

    }


    @Override
    public String toClause() {

        return "WHERE " + column + " LIKE '%" + fullName + "%' ";

    }

}