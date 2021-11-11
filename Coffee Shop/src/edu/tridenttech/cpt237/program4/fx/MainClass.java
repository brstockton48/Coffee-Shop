//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This program allows customers to choose
//and order desired quantity of coffee drinks
//STARTDATE: [11/12/2020]
package edu.tridenttech.cpt237.program4.fx;

import edu.tridenttech.cpt237.program4.fx.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainClass extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("In Start");
		MainWindow mainWindow = new MainWindow(primaryStage);
		mainWindow.show();
		
	}

	public static void main(String[] args) {
		launch();

	}

}
