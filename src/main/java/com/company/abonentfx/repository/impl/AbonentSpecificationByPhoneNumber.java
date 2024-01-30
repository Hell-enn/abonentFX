/**
 * Класс AbonentSpecificationByPhoneNumber переопределяет метод
 * суперкласса SQLOperation toClause() и возвращает строку,
 * которая является частью SQL-запроса к базе данных на
 * выборку пользователей по номеру телефона.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.repository.SQLOperation;
import com.company.abonentfx.repository.constants.AbonentfxDBTables;
import com.company.abonentfx.repository.constants.PhoneNumberEnum;

public class AbonentSpecificationByPhoneNumber implements SQLOperation {

    private final String phoneNumber;
    private final String columnMobile;
    private final String columnHome;
    private final String columnWork;



    public AbonentSpecificationByPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
        columnMobile = AbonentfxDBTables.PHONE_NUMBER.getTableName() + "." + PhoneNumberEnum.MOBILE_NUMBER.getColumnName();
        columnHome = AbonentfxDBTables.PHONE_NUMBER.getTableName() + "." + PhoneNumberEnum.HOME_NUMBER.getColumnName();
        columnWork = AbonentfxDBTables.PHONE_NUMBER.getTableName() + "." + PhoneNumberEnum.WORKING_NUMBER.getColumnName();

    }


    @Override
    public String toClause() {

        return "WHERE " + columnMobile + " = '%" + phoneNumber + "%' " +
                "OR " + columnHome + " = '%" + phoneNumber + "%' " +
                "OR " + columnWork + " = '%" + phoneNumber + "%' ";

    }

}