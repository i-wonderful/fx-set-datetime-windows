module org.byby {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sun.jna;
    requires com.sun.jna.platform;

    opens org.byby to javafx.fxml;
    exports org.byby;
}