/**
 * Данный интерфейс формирует слой бизнес-логики, имея ссылки
 * исключительно на бизнес сущность.
 */


package com.company.abonentfx.service;

import com.company.abonentfx.entity.Abonent;

import java.util.List;

public interface AbonentService {

    /**
     * Сохраняет информацию об абоненте abonent.
     */
    void save(Abonent abonent);

    /**
     * Обновляет информацию об абоненте с помощью
     * объекта abonent.
     */
    void update(Abonent abonent);

    /**
     * Возвращает список объектов типа Abonent, имеющих
     * схожий contractId(в отсутствие ошибок в списке
     * должен быть единственный объект).
     */
    List<Abonent> get(int contractId);

    /**
     * Удаляет информацию об абоненте abonent.
     */
    void delete(Abonent abonent);

}

