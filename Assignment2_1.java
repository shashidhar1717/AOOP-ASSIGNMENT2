package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class Assignment2_1 extends Application {

	String userId = "shashi";
	String pass = "10r";
	TextField name,password;
	Label response,response2;
	Button validate,goback;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage myStage) throws MyException {
		myStage.setTitle("Validating UserId and PassWord");
		
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL,10,20);
		
		FlowPane rootNode2 = new FlowPane(Orientation.VERTICAL,10,20);
		
		rootNode.setAlignment(Pos.CENTER);
		
		rootNode2.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode,450,200);
		
		Scene myScene2 = new Scene(rootNode2,450,200);
		
		myStage.setScene(myScene);
		
		name = new TextField();
		
		name.setPromptText("Enter your name");
		
		password = new TextField();
		
		password.setPromptText("Enter your password");
		
		validate = new Button("Validate");
		
		goback = new Button("Go back");
		
		response = new Label();
		
		response2 = new Label();
		
		Separator separator = new Separator();
		separator.setPrefWidth(100);
		
		Separator separator2 = new Separator();
		separator2.setPrefWidth(180);
		
		validate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					if((name.getText().equals(userId)) && (password.getText().equals(pass))) {
						myStage.setScene(myScene2);		

						response2.setText("WelCome here");
					}
					else
						throw new MyException();
				}
				catch(MyException e) {
					response.setText(e.toString());
				}
			}
		});
		
		goback.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(myScene);
			}
		});
		
		rootNode.getChildren().addAll(name,password,separator,validate,response);
		
		rootNode2.getChildren().addAll(response2,separator2,goback);
		
		myStage.show();
	}
}

class MyException extends Exception {
	public String toString() {
		return "Exception : Invalid userId or passWord";
	}
}
