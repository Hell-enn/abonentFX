module com.company.abonentfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.company.abonentfx to javafx.fxml;
    exports com.company.abonentfx;
    exports com.company.abonentfx.controller;
    opens com.company.abonentfx.controller to javafx.fxml;
    exports com.company.abonentfx.repository.constants;
    opens com.company.abonentfx.repository.constants to javafx.fxml;
    exports com.company.abonentfx.repository;
    opens com.company.abonentfx.repository to javafx.fxml;
}