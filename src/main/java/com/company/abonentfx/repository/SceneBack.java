/**
 * Класс SceneBack содержит методы, возвращающие
 * списки, сформированные из информации, содержащейся в
 * базе данных, и подвергнутые сортировке/фильтрации/группировке
 * на основе определённого криятерия.
 */


package com.company.abonentfx.repository;

import com.company.abonentfx.repository.impl.*;
import com.company.abonentfx.service.AbonentService;
import com.company.abonentfx.service.impl.AbonentSQLService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SceneBack {

    private final AbonentService abonentService;
    private final String[] columns;

    public SceneBack() {

        abonentService = new AbonentSQLService();
        columns = new String[]
                {"full_name", "street", "house", "mobile_number", "home_number", "working_number"};


    }


    /**
     *Закрытый метод формирует список строковых объектов с определённой
     * в columns информацией о пользователях на основе критерия operation.
     * Метод используется открытыми методами класса SceneBack во избежание
     * дублирования кода и формирования понятного API.
     */
    private List<String> getRequiredList(Operation operation, String ... columns) {

        List<String> requiredList = new ArrayList<>();

        if (abonentService instanceof AbonentSQLService) {

            requiredList = ((AbonentSQLService) abonentService).getAbonentRepository().query(operation, columns);

        }

        return requiredList;

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях.
     */
    public List<String> getAll() {

        return getRequiredList(new AbonentSpecificationFull(), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, имеющих общие вхождения
     * telephoneNumber в элементах базы данных, содержащих номера телефонов.
     */
    public List<String> filterByTelephoneNumber(String telephoneNumber) {

        return getRequiredList(new AbonentSpecificationByPhoneNumber(telephoneNumber), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, имеющих общие вхождения
     * fullName в элементе таблицы Abonent базы данных, содержащем ФИО.
     */
    public List<String> filterByFullName(String fullName) {

        return getRequiredList(new AbonentSpecificationByFullName(fullName), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, имеющих общие вхождения
     * street в элементе таблицы Streets базы данных, содержащем улицу
     * проживания абонента.
     */
    public List<String> filterByStreet(String street) {

        return getRequiredList(new AbonentSpecificationByStreet(street), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, имеющих общие вхождения
     * house в элементе таблицы Address базы данных, содержащем номер
     * дома проживания абонента.
     */
    public List<String> filterByHouse(String house) {

        return getRequiredList(new AbonentSpecificationByHouse(house), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, отсортированной по их
     * номерам телефонов.
     */
    public List<String> sortByTelephoneNumber() {

        return getRequiredList(new AbonentSortingByPhoneNumber(), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, отсортированной по их ФИО.
     */
    public List<String> sortByFullName() {

        return getRequiredList(new AbonentSortingByFullName(), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, отсортированной по
     * улице их проживания.
     */
    public List<String> sortByStreet() {

        return getRequiredList(new AbonentSortingByStreet(), columns);

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации обо всех пользователях, отсортированной по номеру
     * их домов.
     */
    public List<String> sortByHouse() {

        return getRequiredList(new AbonentSortingByHouse(), columns);

    }


    /**
     * Сохраняет файл с информацией, сформированной из списка,
     * переданного в метод в качестве аргумента, формата .csv
     * в рабочую директорию в пакет "com.company.abonentfx.CSVs".
     */
    public void getCurrentCSV(List<String> currentInfo) {

        String currentTime = LocalDateTime.now().toString();
        String filePath = String.format("src\\CSVs\\report_%s_%s-%s-%s.csv",
                currentTime.substring(0, 10), currentTime.substring(11, 13),
                currentTime.substring(14, 16), currentTime.substring(17, 19));

        File csv = new File(filePath);

        boolean created;

        try {

            created = csv.createNewFile();

        } catch (IOException exception) {

            System.out.println("Невозможно создать файл!");
            exception.printStackTrace();
            return;

        }

        if (!created) {

            System.out.println("Файл с таким именем уже существует!");

        }

        try (Writer writer = new FileWriter(filePath)) {

            for (String line: currentInfo) {

                writer.write(line + "\n");

            }

            writer.write("\n");

        } catch (IOException exception) {

            System.out.println("Ошибка при сохранении в файл!");
            exception.printStackTrace();

        } catch (Exception exception) {

            System.out.println("Произошла ошибка: " + exception.getMessage());

        }

    }


    /**
     * Возвращает список строковых объектов формата CSV (в т.ч. для
     * их последующего сохранения в файл формата .csv), состоящих
     * из информации об улицах, обслуживаемых телефонной компанией,
     * содержащейся в базе данных.
     */
    public List<String> getStreets() {

        return getRequiredList(new AbonentGroupingByStreet(),
                "street_id", "country", "region", "area", "city", "street",
                "COUNT(street)");

    }

}

