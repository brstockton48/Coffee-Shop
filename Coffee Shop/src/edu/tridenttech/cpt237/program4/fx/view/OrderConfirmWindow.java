//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This class displays the final receipt
//and order confirmation
//STARTDATE: [11/12/2020]
package edu.tridenttech.cpt237.program4.fx.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OrderConfirmWindow {
	private Stage stage = new Stage();
	private TextArea area = new TextArea();
	
	//Constructor
	public OrderConfirmWindow() {
		
		
		area.setFont(new Font("Consolas", 12));
		area.setPrefColumnCount(15);
		area.setPrefHeight(200);	
		area.setPrefWidth(350);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(area);
		Scene scene = new Scene(vbox, 350, 175);
		
		stage.setTitle("");
		stage.setScene(scene);
		Button dismissButton = new Button("Dismiss");
		
		vbox.getChildren().add(dismissButton);
		dismissButton.setAlignment(Pos.BOTTOM_LEFT);
		dismissButton.setOnAction(e -> stage.hide());
		
	}


	public void show(String d1Name, String d1Amt, TextField d1Num, TextField bevOneCost, 
			  String d2Name, String d2Amt, TextField d2Num, TextField bevTwoCost, 
			  String d3Name, String d3Amt, TextField d3Num, TextField bevThreeCost, TextField finalCost) {
		
		String rOne=String.format("%s%n%-20s%-10s%-3s%7s%n%-20s%-10s%-3s%7s%n%-20s%-10s%-3s%7s%n%-35s%s","Receipt",//Row1
				d1Name,d1Amt,d1Num.getText(),bevOneCost.getText(),//Row2
				d2Name,d2Amt,d2Num.getText(),bevTwoCost.getText(),//Row3
				d3Name,d3Amt,d3Num.getText(),bevThreeCost.getText(),//Row4
				"Total:",finalCost.getText());//Row5
		area.setText(rOne);
		stage.show();
	}
}
