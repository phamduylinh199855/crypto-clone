module com.linhpd.project.cryptoclone {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires okhttp3;
    requires com.google.gson;
    requires lombok;

    exports com.linhpd.project.cryptoclone;
    opens com.linhpd.project.cryptoclone to com.google.gson;
}