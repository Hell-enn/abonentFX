/**
 * Перечисление AddressEnum содержит именованные константы
 * с единственным закрытым полем - columnName. Полезен при работе
 * с названиями колонок в таблице Address базы данных abonentFXdb.db
 * при формировании SQL- запросов к этой базе данных.
 */


package com.company.abonentfx.repository.constants;

public enum AddressEnum {

    POSTAL_INDEX("postal_index"),
    STREET_ID("street_id"),
    HOUSE("house"),
    FLAT("flat");

    private final String columnName;
    AddressEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}
