module com.example.tashklistfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tasklistjfx to javafx.fxml;
    exports com.example.tasklistjfx;
}