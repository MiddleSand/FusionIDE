module dev.middlesand.starbie {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens dev.middlesand.starbie to javafx.fxml;
    exports dev.middlesand.starbie;
    exports dev.middlesand.starbie.views;
    opens dev.middlesand.starbie.views to javafx.fxml;
}