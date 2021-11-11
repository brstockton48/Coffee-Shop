//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This class displays the Main Window
//where customer chooses whether or not to order
//STARTDATE: [11/12/2020]
package edu.tridenttech.cpt237.program4.fx.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow {
	private Stage stage;
	private OrderWindow ow = null;

	//Creates and displays order window if none exists
	private class newOrdHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (ow == null) {
			ow = new OrderWindow();
			}
			ow.show();
		}
	}
		public MainWindow(Stage stage) {
			this.stage = stage;                
			VBox pane = new VBox();            
			Scene scene = new Scene(pane,230,100);    
			stage.setScene(scene);            
			stage.setTitle("Main Menu");  
			Button newOrderButton = new Button("New Order");
			Button quitButton = new Button("Quit");
			pane.getChildren().add(newOrderButton);
			pane.getChildren().add(quitButton);
			newOrderButton.setOnAction(new newOrdHandler());
			quitButton.setOnAction(e -> stage.hide());
		}
		public void show() {
			stage.show();
		}

	}
