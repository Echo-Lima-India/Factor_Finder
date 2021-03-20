package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TenByTen extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ten By Ten");
		stage.setResizable(false);
		int[][] labelAns = new int[10][10];
		Label[][] factorMult = new Label[10][10];
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				labelAns[i][j] = (i + 1) * (j + 1);	
			}
		}
		
		// convert setters to css in style.css
		
		BorderPane bPain = new BorderPane();
		BorderPane bPain2 = new BorderPane();
		HBox horizon = new HBox();
		HBox buttHold = new HBox();
		VBox vertical = new VBox();
		GridPane griddy = new GridPane();
		griddy.getStyleClass().add("griddy");
		Button butt = new Button("Submit Here");
		butt.getStyleClass().add("submit");
		Button clear = new Button("Clear Colors");
		Text gh2 = new Text("Enter Answer: ");
		gh2.getStyleClass().add("txtTop");
		TextField text = new TextField();
		buttHold.getChildren().addAll(butt,clear);
		
		butt.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				int answer = Integer.parseInt(text.getText().trim());
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						if(labelAns[i][j] == answer) {
							factorMult[i][j].setBackground(new Background(new BackgroundFill(Color.GREY,CornerRadii.EMPTY,Insets.EMPTY)));
						}
					}
				}
			}
		});

		clear.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				int answer = Integer.parseInt(text.getText().trim());
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						if(labelAns[i][j] == answer) {
							factorMult[i][j].setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
						}
					}
				}	
			}
		});

		
		bPain2.setCenter(text);
		bPain2.setBottom(horizon);
		bPain2.setRight(buttHold);
		bPain2.setLeft(gh2);
		
		bPain.setTop(bPain2);
		bPain.setLeft(vertical);
		bPain.setCenter(griddy);
		Scene scene = new Scene(bPain);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		for(int i = 0; i <= 10; i++) {
			Label row = new Label(Integer.toString(i));
			row.getStyleClass().add("row");
			horizon.getChildren().add(row);
		}
		for(int j = 0; j < 10; j++) {
			Label col = new Label(Integer.toString(j + 1));
			col.getStyleClass().add("col");
			vertical.getChildren().add(col);
		}
		
		for(int rowCount = 1; rowCount <= 10; rowCount++) {
			for(int colCount = 1; colCount <= 10; colCount++) {
				Label label1 = new Label(rowCount + " x " + colCount);
				label1.getStyleClass().add("label1");
				griddy.add(label1,rowCount,colCount);
				factorMult[rowCount - 1][colCount - 1] = label1;
			}
		}
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
