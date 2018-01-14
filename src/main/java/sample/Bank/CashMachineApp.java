package sample.Bank;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.CashMachine;

public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    private Parent createContent() {
        VBox vBox = new VBox(10);
        vBox.setPrefSize(600,600);
        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction( e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);
            areaInfo.setText(cashMachine.toString());
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction( e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.deposit(amount);
            areaInfo.setText(cashMachine.toString());
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction( e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.withdraw(amount);
            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction( e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.exit();
            areaInfo.setText(cashMachine.toString());
        });


        vBox.getChildren().addAll(field, btnSubmit, btnDeposit, btnWithdraw, btnExit, areaInfo);
        return vBox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
