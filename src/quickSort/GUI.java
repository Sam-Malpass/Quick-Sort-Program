package quickSort;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application {
	private ArrayList<Double> data;
	public void sortingWindow()
	{
		
	}
	public HBox createButtons()
	{
		HBox buttons = new HBox();
		Button save = new Button("Save");
		save.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				String w = "";
				for(int i = 0; i < data.size(); i++) {
					w = w + data.get(i) + " ";
				}
				FileIO.save(w);
			}
		});
		Button load = new Button("Load");
		load.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				data = FileIO.load();
				sortingWindow();
			}
		});
		Button exit = new Button("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		return buttons;
	}
	public void start(Stage stage) throws Exception {
		Stage mainStage = stage;
		mainStage.setTitle("QuickSort Program");
		HBox buttonBox = createButtons(); 
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(buttonBox);
		Scene mainScene = new Scene(borderPane, 300, 100);
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
