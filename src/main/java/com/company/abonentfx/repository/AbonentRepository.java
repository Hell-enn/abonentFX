/**
 * С помощью интерфейса AbonentRepository реализуется паттерн
 * Репозиторий. Данный интерфейс не имеет привязки к конкретному
 * хранилищу, поэтому любой расширяющий его класс может реализовывать
 * декларированные тут методы уникальным образом (связывая их с массивом,
 * связным списком, представлением, реляционной или нереляционной
 * базой данных).
 */


package com.company.abonentfx.repository;

import com.company.abonentfx.entity.Abonent;

import java.util.List;

public interface AbonentRepository {

    /**
     * Сохраняет объект типа Abonent в структуру данных.
     */
    void save(Abonent abonent);

    /**
     * Обновляет объект типа Abonent в структуре данных.
     */
    void update(Abonent abonent);

    /**
     * Возвращает список объектов типа Abonent, имеющих
     * одинаковый id, из структуры данных.
     */
    List<Abonent> get(int contract_id);

    /**
     * Удаляет объект типа Abonent из структуры данных.
     */
    void delete(Abonent abonent);

    /**
     * Возвращает список строк, сформированный из элементов
     * elements структуры данных с помощью операции operation.
     */
    List<String> query(Operation operation,String ... elements);

}
