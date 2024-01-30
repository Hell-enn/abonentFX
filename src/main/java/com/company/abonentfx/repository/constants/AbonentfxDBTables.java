/**
 * Перечисление AbonentfxDBTables содержит именованные константы
 * с единственным закрытым полем - tableName. Полезен при работе
 * с названиями таблиц в базе данных abonentFXdb.db
 * при формировании SQL- запросов к этой базе данных.
 */


package com.company.abonentfx.repository.constants;

public enum AbonentfxDBTables {

    ABONENT("Abonent"),
    ADDRESS("Address"),
    PHONE_NUMBER("PhoneNumber"),
    STREETS("Streets");

    private final String tableName;
    AbonentfxDBTables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

}
