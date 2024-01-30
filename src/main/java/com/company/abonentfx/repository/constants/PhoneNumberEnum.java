/**
 * Перечисление PhoneNumberEnum содержит именованные константы
 * с единственным закрытым полем - columnName. Полезен при работе
 * с названиями колонок в таблице PhoneNumber базы данных abonentFXdb.db
 * при формировании SQL- запросов к этой базе данных.
 */


package com.company.abonentfx.repository.constants;

public enum PhoneNumberEnum {

    MOBILE_NUMBER("mobile_number"),
    HOME_NUMBER("home_number"),
    WORKING_NUMBER("working_number");

    private final String columnName;
    PhoneNumberEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}
