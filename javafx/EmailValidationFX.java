import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailValidationFX extends Application {

    @Override
    public void start(Stage stage) {

        // Label
        Label title = new Label("Email Validation");

        // TextField for email input
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email address");

        // Button
        Button validateButton = new Button("Validate");

        // Label to show result
        Label resultLabel = new Label();

        // Button action
        validateButton.setOnAction(e -> {
            String email = emailField.getText();

            if (email.contains("@") && email.contains(".com")) {
                resultLabel.setText("✅ Valid Email Address");
                resultLabel.setStyle("-fx-text-fill: green;");
            } else {
                resultLabel.setText("❌ Invalid Email Address");
                resultLabel.setStyle("-fx-text-fill: red;");
            }
        });

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(title, emailField, validateButton, resultLabel);

        // Scene
        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Email Validator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
