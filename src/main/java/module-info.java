module tech.halfwit.itbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens tech.halfwit.itbox to javafx.fxml;
    exports tech.halfwit.itbox;
}