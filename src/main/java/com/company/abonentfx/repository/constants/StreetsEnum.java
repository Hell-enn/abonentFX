/**
 * Перечисление StreetsEnum содержит именованные константы
 * с единственным закрытым полем - columnName. Полезен при работе
 * с названиями колонок в таблице StreetsEnum базы данных abonentFXdb.db
 * при формировании SQL- запросов к этой базе данных.
 */


package com.company.abonentfx.repository.constants;

public enum StreetsEnum {

    COUNTRY("country"),
    REGION("region"),
    AREA("area"),
    CITY("city"),
    STREET("street");

    private final String columnName;
    StreetsEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}
