module com.nt.quizzapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires lombok;
    requires java.sql;

    opens com.nt.quizzapp to javafx.fxml;
    exports com.nt.quizzapp;
}
