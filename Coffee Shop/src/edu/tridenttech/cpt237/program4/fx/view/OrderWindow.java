//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This class displays the order window
//for customer to select quantity
//STARTDATE: [11/12/2020]
package edu.tridenttech.cpt237.program4.fx.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OrderWindow {
	private Stage stage = new Stage();
	private static final String[] BEV_NAMES = {"Latte", "Mocha Chilla", "Jamba Juice" };
	private static final String[] BEV_PRICES = {"  4.29", "  4.99", "  5.49"};

	private TextField bevOneCost = new TextField();		
	private TextField bevTwoCost = new TextField();	
	private TextField bevThreeCost = new TextField();	
	private TextField totalCost = new TextField();	
	private TextField bevOneQty = new TextField();		
	private TextField bevTwoQty = new TextField();	
	private TextField bevThreeQty = new TextField();	
	private OrderConfirmWindow ocw = null;
	private String d1Amt = BEV_PRICES[0];
	private String d2Amt = BEV_PRICES[1];
	private String d3Amt = BEV_PRICES[2];
	private String d1Name = BEV_NAMES[0];
	private String d2Name = BEV_NAMES[1];
	private String d3Name = BEV_NAMES[2];



	private class recalcHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			bevOneCost.setAlignment(Pos.CENTER_RIGHT);
			bevTwoCost.setAlignment(Pos.CENTER_RIGHT);
			bevThreeCost.setAlignment(Pos.CENTER_RIGHT);
			totalCost.setAlignment(Pos.CENTER_RIGHT);
			double d1Price = Double.parseDouble(d1Amt);
			double d2Price = Double.parseDouble(d2Amt);
			double d3Price = Double.parseDouble(d3Amt);
			String d1Num = bevOneQty.getText();
			String d2Num = bevTwoQty.getText();
			String d3Num = bevThreeQty.getText();
				
			if(d1Num.isEmpty()||d2Num.isEmpty()||d3Num.isEmpty()){
				String message = "Cannot leave any fields blank";
				Alert alertBox = new Alert(AlertType.ERROR, message);
				alertBox.show();
			}else if((Double.parseDouble(d1Num)<0)||(Double.parseDouble(d2Num)<0)||(Double.parseDouble(d3Num)<0)) {
				String message = "Must enter a non-negative integer in each field";
				Alert alertBox = new Alert(AlertType.ERROR, message);
				alertBox.show();
			}else {				
				double d1Qty = Double.parseDouble(d1Num);
				double d2Qty = Double.parseDouble(d2Num);
				double d3Qty = Double.parseDouble(d3Num);
				double d1Cost = d1Price*d1Qty;
				double d2Cost = d2Price*d2Qty;
				double d3Cost = d3Price*d3Qty;
				double totCost=d1Cost+d2Cost+d3Cost;
				String drinkOneCost=String.format("%.2f",d1Cost);
				String drinkTwoCost=String.format("%.2f",d2Cost);
				String drinkThreeCost=String.format("%.2f",d3Cost);
				String finalCost=String.format("%.2f",totCost);
				bevOneCost.setText(drinkOneCost);
				bevTwoCost.setText(drinkTwoCost);
				bevThreeCost.setText(drinkThreeCost);
				totalCost.setText(finalCost);
				stage.show();
			}	
		}
	}

private class purchaseHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		if(bevOneQty.getText().isEmpty()||bevTwoQty.getText().isEmpty()||bevThreeQty.getText().isEmpty()){
			String message = "Please select quantity of items to purchase";
			Alert alertBox = new Alert(AlertType.ERROR, message);
			alertBox.show();
		}else {
			if (ocw == null) {
		ocw = new OrderConfirmWindow();
			}ocw.show(d1Name, d1Amt, bevOneQty, bevOneCost, 
			     d2Name, d2Amt, bevTwoQty, bevTwoCost,
                 d3Name, d3Amt, bevThreeQty, bevThreeCost, totalCost);
		}
	}
}
public OrderWindow() {
	GridPane pane = new GridPane();
	Scene scene = new Scene(pane,350,200); 
	pane.setHgap(3);
	stage.setScene(scene);            
	stage.setTitle("Joe's Java and Koffee Kafe");   //

	//Grid Column 0
	Node bevOneName = new Label(BEV_NAMES[0]);		
	Node bevTwoName = new Label(BEV_NAMES[1]);
	Node bevThreeName = new Label(BEV_NAMES[2]);	
	Node total = new Label("Total");
	Button purchaseButton = new Button("Purchase");
	pane.add(bevOneName,0,0);
	pane.add(bevTwoName,0,1);
	pane.add(bevThreeName,0,2);
	pane.add(total,0,3);
	pane.add(purchaseButton,0,4);

	//GridColumn 1 
	Node bevOnePrice = new Label(BEV_PRICES[0]);		
	Node bevTwoPrice = new Label(BEV_PRICES[1]);
	Node bevThreePrice = new Label(BEV_PRICES[2]);
	Button closeButton = new Button("Close");
	pane.add(bevOnePrice,1,0);
	pane.add(bevTwoPrice,1,1);
	pane.add(bevThreePrice,1,2);
	pane.add(closeButton,1,4,2,1);

	//GridColumn 2
	pane.add(bevOneQty,2,0);
	pane.add(bevTwoQty,2,1);
	pane.add(bevThreeQty,2,2);
	bevOneQty.setMaxWidth(30);
	bevTwoQty.setMaxWidth(30);
	bevThreeQty.setMaxWidth(30);

	//GridColumn 3
	Button recalcButton = new Button("Recalculate");
	pane.add(bevOneCost,3,0);
	pane.add(bevTwoCost,3,1);
	pane.add(bevThreeCost,3,2);
	bevOneCost.setMaxWidth(140);
	bevTwoCost.setMaxWidth(140);
	bevThreeCost.setMaxWidth(140);
	pane.add(totalCost,3,3);
	totalCost.setMaxWidth(140);
	pane.add(recalcButton,3,4);	
	purchaseButton.setOnAction(new purchaseHandler());
	recalcButton.setOnAction(new recalcHandler());
	closeButton.setOnAction(e -> stage.hide());

}

public void show() {
	stage.show();
}
}

