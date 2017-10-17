import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

public class Groupsize extends Application
{
    @Override
    public void start(Stage Primarystage)
    {   boolean login=false;
        int n=0;
        do {
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Login");
            dialog.setHeaderText("Login");

            ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField username = new TextField();
            username.setPromptText("Username");
            PasswordField password = new PasswordField();
            password.setPromptText("Password");

            grid.add(new Label("Username:"), 0, 0);
            grid.add(username, 1, 0);
            grid.add(new Label("Password:"), 0, 1);
            grid.add(password, 1, 1);

            dialog.getDialogPane().setContent(grid);

            Optional<Pair<String, String>> result = dialog.showAndWait();

            if(username.getText().equals("csc200")&&password.getText().equals("ct0103")){
                TextInputDialog textInputDialog = new TextInputDialog("Number of people");
                textInputDialog.setTitle("Number of people");
                textInputDialog.setHeaderText("Please enter the number of people");
                Optional<String> num = textInputDialog.showAndWait();
                String number = num.get();
                double peoplenumber = Double.parseDouble(number);
                if (peoplenumber > 10) {
                    double groupsize = peoplenumber / 2;
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Groupsize");
                    alert.setHeaderText("Groupsize");
                    alert.setContentText("The number of people is " + peoplenumber + " ." + "Groupsize is " + groupsize + " .");
                    alert.showAndWait();
                } else if (3 <= peoplenumber) {
                    double groupsize = peoplenumber / 3;
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Groupsize");
                    alert.setHeaderText("Groupsize");
                    alert.setContentText("The number of people is " + peoplenumber + " ." + "Groupsize is " + groupsize + " .");
                    alert.showAndWait();
                } else if (peoplenumber < 3) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Groupsize");
                    alert.setHeaderText("Groupsize");
                    alert.setContentText("The number of people has to be at least 3.");
                    alert.showAndWait();
                }
                TextInputDialog teamsizeinputdialog=new TextInputDialog("Number of player");
                teamsizeinputdialog.setTitle("Number of player");
                teamsizeinputdialog.setHeaderText("Please enter the number of player");
                Optional<String> playernum= teamsizeinputdialog.showAndWait();
                String playernumber=playernum.get();
                double numberofplayers=Double.parseDouble(playernumber);
                if (11<=numberofplayers&&numberofplayers<=55){
                    double teamsize = numberofplayers / 11;
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Teamsize");
                    alert.setHeaderText("Teamsize");
                    alert.setContentText("The number of player is " + numberofplayers + " ." + "Teamsize is " + teamsize + " .");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Teamsize");
                    alert.setHeaderText("Teamsize");
                    alert.setContentText("The number of player is " + numberofplayers + " ." + "Teamsize is " + 1 + " .");
                    alert.showAndWait();
                }
                login=true;
                n=0;
            }
            else if(!username.getText().equals("csc200")){
                Alert alert =new Alert (AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Your username or password is wrong.");
                alert.setContentText("Please enter your username and password again.");
                alert.showAndWait();
            }
            else if(username.getText().equals("csc200")&&!password.getText().equals("ct0103")&&n<2){
                Alert alert =new Alert (AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Your username or password is wrong.");
                alert.setContentText("Please enter your username and password again.");
                alert.showAndWait();
                n++;
            }
            else if (username.getText().equals("csc200")&&!password.getText().equals("ct0103")&&n==2){
                Alert alert =new Alert (AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("You have entered wrong password three times.");
                alert.setContentText("Please contact admistrator.");
                alert.showAndWait();
                n++;
            }
        }while(!login&&n<=2);

    }
    public static void main(String [] args) {
        launch(args);
    }
}
