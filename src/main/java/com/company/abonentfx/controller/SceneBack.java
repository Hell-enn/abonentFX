package com.company.abonentfx.controller;

import com.company.abonentfx.repository.Operation;
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

    public SceneBack() {

        abonentService = new AbonentSQLService();


    }


    private List<String> getRequiredList(Operation operation, String ... columns) {

        List<String> requiredList = new ArrayList<>();

        if (abonentService instanceof AbonentSQLService) {

            requiredList = ((AbonentSQLService) abonentService).getAbonentRepository().query(operation, columns);

        }

        return requiredList;

    }


    public List<String> getAll() {

        return getRequiredList(new AbonentSpecificationFull(),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> filterByTelephoneNumber(String telephoneNumber) {

        return getRequiredList(new AbonentSpecificationByPhoneNumber(telephoneNumber),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> filterByFullName(String fullName) {

        return getRequiredList(new AbonentSpecificationByFullName(fullName),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> filterByStreet(String street) {

        return getRequiredList(new AbonentSpecificationByStreet(street),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> filterByHouse(String house) {

        return getRequiredList(new AbonentSpecificationByHouse(house),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> sortByTelephoneNumber() {

        return getRequiredList(new AbonentSortingByPhoneNumber(),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> sortByFullName() {

        return getRequiredList(new AbonentSortingByFullName(),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> sortByStreet() {

        return getRequiredList(new AbonentSortingByStreet(),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }


    public List<String> sortByHouse() {

        return getRequiredList(new AbonentSortingByHouse(),
                "full_name", "street", "house", "mobile_number", "home_number", "working_number");

    }



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


    public List<String> getStreets() {

        return getRequiredList(new AbonentGroupingByStreet(),
                "street_id", "country", "region", "area", "city", "street",
                "COUNT(street)");

    }

}

