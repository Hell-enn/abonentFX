/**
 * Класс AbonentSQLRepository реализует интерфейс AbonentRepository
 * для сохранения, изменения, получения и удаления информации о пользователе
 * из SQL базы данных.
 */


package com.company.abonentfx.repository.impl;

import com.company.abonentfx.entity.Abonent;
import com.company.abonentfx.repository.AbonentRepository;
import com.company.abonentfx.repository.Operation;
import com.company.abonentfx.repository.SQLOperation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonentSQLRepository implements AbonentRepository {


    /**
     * Метод формирует запрос на сохранение в SQL базу данных
     * информации о пользователе, содержащейся в объекте abonent.
     */
    @Override
    public void save(Abonent abonent) {

        String abonentSQL = String.format("INSERT INTO Abonent " +
                        "(contract_id, full_name, passport_series, passport_number, issue_date, issue_department, registration, birth_date) " +
                        "VALUES(%d, '%s','%s','%s','%s','%s','%s','%s'); ", abonent.getContractId(), abonent.getFullName(), abonent.getPassportSeries(),
                abonent.getPassportNumber(), abonent.getIssueDate(), abonent.getIssueDepartment(),
                abonent.getRegistration(), abonent.getBirthDate());

        String addressSQL = String.format("INSERT INTO Address " +
                        "(contract_id, postal_index, street_id, house, flat) " +
                        "VALUES(%d, %d, %d, '%s', %d);", abonent.getContractId(), abonent.getPostalIndex(), abonent.getStreetId(), abonent.getHouse(),
                abonent.getFlat());

        String phoneNumberSQL = String.format("INSERT INTO PhoneNumber " +
                        "(contract_id, mobile_number, home_number, working_number)" +
                        "VALUES(%d, '%s', '%s', '%s');", abonent.getContractId(), abonent.getMobileNumber(), abonent.getHouseNumber(),
                abonent.getWorkingNumber());

        String fullSave = abonentSQL + addressSQL + phoneNumberSQL;

        try {

            Connection connection =DriverManager.getConnection("jdbc:sqlite:abonentsFXdb.db");
            Statement saveStatement = connection.createStatement();
            saveStatement.executeUpdate(fullSave);

            connection.close();
            saveStatement.close();

        } catch (SQLException exception) {

            System.out.println("Ошибка при добавлении данных в SQL таблицу!");

        }

    }



    /**
     * Метод формирует запрос на обновление в SQL базе данных
     * информации о пользователе, информацией, содержащейся
     * в объекте abonent.
     */
    @Override
    public void update(Abonent abonent) {


        try {

            Connection connection =DriverManager.getConnection("jdbc:sqlite:abonentsFXdb.db");
            Statement updateStatement = connection.createStatement();

            String query = "SELECT * FROM Abonent JOIN Address JOIN PhoneNumber WHERE Abonent.contract_id = " + abonent.getContractId();
            ResultSet resultSet = updateStatement.executeQuery(query);

            if (resultSet == null) {
                return;
            }


            int contractId;
            String fullName;
            String birthDate;
            String passportSeries;
            String passportNumber;
            String issueDate;
            String issueDepartment;
            String registration;
            int postalIndex;
            int streetId;
            String house;
            int flat;
            String mobileNumber;
            String houseNumber;
            String workingNumber;

            Abonent sqlAbonent;

            while (resultSet.next()) {

                contractId = resultSet.getInt("contract_id");
                fullName = resultSet.getString("full_name");
                birthDate = resultSet.getString("birth_date");
                passportSeries = resultSet.getString("passport_series");
                passportNumber = resultSet.getString("passport_number");
                issueDate = resultSet.getString("issue_date");
                issueDepartment = resultSet.getString("issue_department");
                registration = resultSet.getString("registration");
                postalIndex = resultSet.getInt("postal_index");
                streetId = resultSet.getInt("street_id");
                house = resultSet.getString("house");
                flat = resultSet.getInt("flat");
                mobileNumber = resultSet.getString("mobile_number");
                houseNumber = resultSet.getString("home_number");
                workingNumber = resultSet.getString("working_number");

                sqlAbonent = new Abonent(contractId, fullName, birthDate, passportSeries, passportNumber, issueDate,
                        issueDepartment, registration, postalIndex, streetId, house, flat, mobileNumber, houseNumber,
                        workingNumber);

                if (!abonent.equals(sqlAbonent)) {

                    StringBuilder updateQuery = new StringBuilder("UPDATE Abonent SET ");

                    if (!abonent.getFullName().equalsIgnoreCase(sqlAbonent.getFullName())) {

                        updateQuery.append("full_name = '").append(abonent.getFullName()).append("', ");

                    }

                    if (!abonent.getPassportSeries().equalsIgnoreCase(sqlAbonent.getPassportSeries())) {

                        updateQuery.append("passport_series = '").append(abonent.getPassportSeries())
                                .append("', ");

                    }

                    if (!abonent.getPassportNumber().equalsIgnoreCase(sqlAbonent.getPassportNumber())) {

                        updateQuery.append("passport_number = '").append(abonent.getPassportNumber())
                                .append("', ");

                    }

                    if (!abonent.getIssueDate().equalsIgnoreCase(sqlAbonent.getIssueDate())) {

                        updateQuery.append("issue_date = '").append(abonent.getIssueDate())
                                .append("', ");

                    }

                    if (!abonent.getIssueDepartment().equalsIgnoreCase(sqlAbonent.getIssueDepartment())) {

                        updateQuery.append("issue_department = '").append(abonent.getIssueDepartment())
                                .append("', ");

                    }

                    if (!abonent.getRegistration().equalsIgnoreCase(sqlAbonent.getRegistration())) {

                        updateQuery.append("registration = '").append(abonent.getRegistration())
                                .append("', ");

                    }


                    if (updateQuery.toString().equalsIgnoreCase("UPDATE Abonent SET ")) {

                        updateQuery.replace(0, updateQuery.length(), "UPDATE Address SET ");

                    } else {

                        updateQuery.replace(updateQuery.length() - 2, updateQuery.length(), " WHERE contract_id = " +
                                abonent.getContractId() + ";\n UPDATE Address SET ");

                    }


                    if (abonent.getPostalIndex() != sqlAbonent.getPostalIndex()) {

                        updateQuery.append("postal_index = ").append(abonent.getPostalIndex())
                                .append(", ");

                    }

                    if (abonent.getStreetId() != sqlAbonent.getStreetId()) {

                        updateQuery.append("street_id = ").append(abonent.getStreetId())
                                .append(", ");

                    }

                    if (!abonent.getHouse().equalsIgnoreCase(sqlAbonent.getHouse())) {

                        updateQuery.append("house = '").append(abonent.getHouse())
                                .append("', ");

                    }

                    if (abonent.getFlat() != sqlAbonent.getFlat()) {

                        updateQuery.append("flat = ").append(abonent.getFlat())
                                .append(", ");

                    }


                    if (updateQuery.toString().equalsIgnoreCase("UPDATE Address SET ")) {

                        updateQuery.replace(0, updateQuery.length(), "UPDATE PhoneNumber SET ");

                    }  else {

                        updateQuery.replace(updateQuery.length() - 2, updateQuery.length(), " WHERE contract_id = " +
                                abonent.getContractId() + ";\n UPDATE PhoneNumber SET ");

                    }


                    if (!abonent.getMobileNumber().equalsIgnoreCase(sqlAbonent.getMobileNumber())) {

                        updateQuery.append("mobile_number = '").append(abonent.getMobileNumber())
                                .append("', ");

                    }

                    if (!abonent.getHouseNumber().equalsIgnoreCase(sqlAbonent.getHouseNumber())) {

                        updateQuery.append("home_number = '").append(abonent.getHouseNumber())
                                .append("', ");

                    }

                    if (!abonent.getWorkingNumber().equalsIgnoreCase(sqlAbonent.getWorkingNumber())) {

                        updateQuery.append("working_number = '").append(abonent.getWorkingNumber())
                                .append("', ");

                    }

                    if (updateQuery.toString().equalsIgnoreCase("UPDATE PhoneNumber SET ")) {

                        return;

                    } else {

                        updateQuery.replace(updateQuery.length() - 2, updateQuery.length(), " WHERE contract_id = " +
                                abonent.getContractId() + ";");

                    }

                    updateStatement.executeUpdate(updateQuery.toString());

                }

            }

            connection.close();
            updateStatement.close();

        } catch (SQLException exception) {

            System.out.println("Ошибка запроса к базе данных!");

        }

    }



    /**
     * Метод формирует запрос на получение из SQL базы данных
     * списка объектов типа Abonent, содержащих информацию о
     * каждом пользователе, имеющем схожий contractId(в отсутствие
     * ошибок в списке должен быть единственный объект).
     */
    @Override
    public List<Abonent> get(int contractId) {

        List<Abonent> abonents = new ArrayList<>();

        String query = "SELECT * FROM Abonent, Address, PhoneNumber WHERE Abonent.contract_id = " + contractId + ";";

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:abonentsFXdb.db");
            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery(query);

            int contract;
            String fullName;
            String birthDate;
            String passportSeries;
            String passportNumber;
            String issueDate;
            String issueDepartment;
            String registration;
            int postalIndex;
            int streetId;
            String house;
            int flat;
            String mobileNumber;
            String houseNumber;
            String workingNumber;

            Abonent sqlAbonent;

            while (resultSet.next()) {

                contract = resultSet.getInt("contract_id");
                fullName = resultSet.getString("full_name");
                birthDate = resultSet.getString("birth_date");
                passportSeries = resultSet.getString("passport_series");
                passportNumber = resultSet.getString("passport_number");
                issueDate = resultSet.getString("issue_date");
                issueDepartment = resultSet.getString("issue_department");
                registration = resultSet.getString("registration");
                postalIndex = resultSet.getInt("postal_index");
                streetId = resultSet.getInt("street_id");
                house = resultSet.getString("house");
                flat = resultSet.getInt("flat");
                mobileNumber = resultSet.getString("mobile_number");
                houseNumber = resultSet.getString("home_number");
                workingNumber = resultSet.getString("working_number");

                sqlAbonent = new Abonent(contract, fullName, birthDate, passportSeries, passportNumber, issueDate,
                        issueDepartment, registration, postalIndex, streetId, house, flat, mobileNumber, houseNumber,
                        workingNumber);

                abonents.add(sqlAbonent);

            }

            connection.close();
            getStatement.close();

        } catch (SQLException exception) {

            System.out.println("Ошибка при полусении экземпляра из базы данных!");

        }

        return abonents;
    }



    /**
     * Метод формирует запрос на удаление из SQL базы данных
     * информации о пользователе, содержащейся в объекте abonent.
     */
    @Override
    public void delete(Abonent abonent) {

        String query = "DELETE FROM Abonent WHERE contract_id = " + abonent.getContractId() + ";\n" +
                "DELETE FROM Address WHERE contract_id = " + abonent.getContractId() + ";\n" +
                "DELETE FROM PhoneNumber WHERE contract_id = " + abonent.getContractId() + ";";

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:abonentsFXdb.db");
            Statement deleteStatement = connection.createStatement();
            deleteStatement.executeUpdate(query);

            connection.close();
            deleteStatement.close();

        } catch (SQLException exception) {

            System.out.println("Ошибка при удалении!");

        }

    }


    /**
     * Метод формирует запрос на выборку/сортировку/группировку информации
     * о пользователях на основе определённого критерия - operation. Возвращает
     * список строк формата CSV для их последующего сохранения в файл .csv.
     * Каждая строка включает информацию исключительно из колонок, содержащихся
     * в columns.
     */
    @Override
    public List<String> query(Operation operation, String ... columns) {

        List<String> results = new ArrayList<>();

        String requiredOperation;

        if (operation instanceof SQLOperation) {

            requiredOperation = ((SQLOperation)operation).toClause();

        } else {

            return results;

        }

        StringBuilder clause = new StringBuilder("SELECT ");
        StringBuilder namesOfColumns = new StringBuilder();

        for (String column: columns) {

            if (column.equalsIgnoreCase("contract_id")
                    || column.equalsIgnoreCase("full_name")
                    || column.equalsIgnoreCase("passport_series")
                    || column.equalsIgnoreCase("passport_number")
                    || column.equalsIgnoreCase("issue_department")
                    || column.equalsIgnoreCase("issue_date")
                    || column.equalsIgnoreCase("registration")
                    || column.equalsIgnoreCase("birth_date")) {

                clause.append("Abonent.").append(column).append(",");

            } else if (column.equalsIgnoreCase("postal_index")
                    || column.equalsIgnoreCase("house")
                    || column.equalsIgnoreCase("flat")) {

                clause.append("Address.").append(column).append(",");

            } else if (column.equalsIgnoreCase("mobile_number")
                    || column.equalsIgnoreCase("home_number")
                    || column.equalsIgnoreCase("working_number")) {

                clause.append("PhoneNumber.").append(column).append(",");

            } else if (column.equalsIgnoreCase("country")
                    || column.equalsIgnoreCase("region")
                    || column.equalsIgnoreCase("area")
                    || column.equalsIgnoreCase("city")
                    || column.equalsIgnoreCase("street")
                    || column.equalsIgnoreCase("street_id")) {

                clause.append("Streets.").append(column).append(",");

            } else {

                clause.append(column).append(",");

            }

            namesOfColumns.append(column).append(",");

        }

        results.add(namesOfColumns.replace(namesOfColumns.length() - 1, namesOfColumns.length(), "").toString());

        clause.replace(clause.length()-1, clause.length(), "")
                .append(" \nFROM \nAbonent JOIN Address ON Abonent.contract_id = Address.contract_id \n" +
                        "JOIN PhoneNumber ON Abonent.contract_id = PhoneNumber.contract_id \n" +
                        "JOIN Streets ON Streets.street_id = Address.street_id \n")
                .append(requiredOperation).append(";");

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:abonentsFXdb.db");
            Statement queryStatement = connection.createStatement();
            System.out.println(clause + "\n\n");
            ResultSet resultSet = queryStatement.executeQuery(clause.toString());

            String[] columnsArray = namesOfColumns.toString().split(",");

            StringBuilder resultLine = new StringBuilder();

            while (resultSet.next()) {

                for (String val: columnsArray) {

                    if (resultSet.getObject(val) instanceof Integer) {

                        Integer column = (Integer) resultSet.getObject(val);
                        resultLine.append(column).append(",");

                    } else if (resultSet.getObject(val) instanceof String) {

                        String column = resultSet.getString(val);
                        resultLine.append(column).append(",");

                    }

                }

                results.add(resultLine.delete(resultLine.length() - 1, resultLine.length()).toString());
                resultLine.delete(0, resultLine.length());

            }

            connection.close();
            queryStatement.close();

            return results;

        } catch (SQLException exception) {

            System.out.println("Ошибка при работе с базой данных!");

        }

        return new ArrayList<>();

    }

}