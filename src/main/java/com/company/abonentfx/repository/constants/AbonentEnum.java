/**
 * Перечисление AbonentEnum содержит именованные константы
 * с единственным закрытым полем - columnName. Полезен при работе
 * с названиями колонок в таблице Abonent базы данных abonentFXdb.db
 * при формировании SQL- запросов к этой базе данных
 */


package com.company.abonentfx.repository.constants;

public enum AbonentEnum {

    CONTRACT_ID("contract_id"),
    FULL_NAME("full_name"),
    PASSPORT_SERIES("passport_series"),
    PASSPORT_NUMBER("passport_number"),
    ISSUE_DEPARTMENT("issue_department"),
    ISSUE_DATE("issue_date"),
    REGISTRATION("registration"),
    BIRTH_DATE("birth_date");

    private final String columnName;
    AbonentEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
