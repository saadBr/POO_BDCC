import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chat extends Application {
    private VBox messageBox;
    private ScrollPane scrollPane;
    private TextField inputField;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;
    @Override
    public void start(Stage primaryStage){
        messageBox = new VBox(5);
        messageBox.setPadding(new Insets(10));
        scrollPane = new ScrollPane(messageBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        inputField = new TextField();
        inputField.setPromptText("Type your message here...");
        HBox.setHgrow(inputField, Priority.ALWAYS);
        Button sendButton = new Button("Send");
        sendButton.setMinWidth(70);
        sendButton.setOnAction(e->sendMessage());
        inputField.setOnAction(e->sendMessage());
        HBox inputBox = new HBox(10, inputField, sendButton);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane(scrollPane, null, null, inputBox, null);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setTitle("Chat");
        primaryStage.show();
        new Thread(this::setupConnection).start();
    }
    private void setupConnection(){
        try {
            Socket socket = new Socket("localhost", 9092);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            clientName = in.readLine();
            addMessage(clientName, false);
            String message;
            while ((message = in.readLine())!= null){
                if (!message.startsWith(clientName + ":")) {
                    addMessage(message, false);
                }
            }
        }catch(IOException e)
        {
            addMessage("Connection failed: " + e.getMessage(), false);
        }

    }
    private void sendMessage(){
        String message = inputField.getText();
        if(!message.trim().isEmpty()){
            out.println(message);
            inputField.clear();
            addMessage(clientName + ": " + message, true);
        }
    }
    private void addMessage(String message, boolean isOwnMessage) {
        Label label = new Label(message);
        label.setWrapText(true);
        label.setPadding(new Insets(10));
        label.setStyle(isOwnMessage
                ? "-fx-background-color: #dcf8c6; -fx-background-radius: 16px;"
                : "-fx-background-color: #ffffff; -fx-background-radius: 16px; -fx-border-color: #ccc;"
        );

        HBox wrapper = new HBox(label);
        wrapper.setPadding(new Insets(5, 10, 5, 10));
        wrapper.setAlignment(isOwnMessage ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);

        Platform.runLater(() -> {
            messageBox.getChildren().add(wrapper);
            scrollPane.layout();
            scrollPane.setVvalue(1.0); // always scroll to bottom
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
