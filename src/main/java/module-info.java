module com.schfr.catchingbutterflies {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.schfr.catchingbutterflies to javafx.fxml;
    exports com.schfr.catchingbutterflies;
}