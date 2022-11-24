module com.se07.btl {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    opens com.se07.vu to javafx.fxml;
    exports com.se07.vu;
    exports com.se07.main;
    requires java.naming;
    opens com.se07.main to javafx.fxml;
}