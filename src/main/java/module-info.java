module com.cpllabs.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.cpllabs.APK_Builder to javafx.fxml;
    exports com.cpllabs.APK_Builder;
}