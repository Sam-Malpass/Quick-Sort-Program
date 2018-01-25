package quickSort;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
	private ArrayList<Double> data;
	public String writeData() {
		String string = "Data:\n";
		for(int i = 0; i < data.size(); i++) {
			string = string + data.get(i) + " ";
		}
		return string;
	}
	public void sortingWindow()
	{
		Stage sortingWindow = new Stage();
		sortingWindow.setResizable(false);
		sortingWindow.setTitle("Data");
		VBox dataOutput = new VBox();
		Label l = new Label(writeData());
		dataOutput.getChildren().addAll(l);
		HBox buttons = new HBox();
		Button sort = new Button("Sort");
		sort.setMinSize(300, 50);
		sort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				Algorithm.sort(data);
				data = Algorithm.getSorted();
				Label l = new Label(writeData());
				dataOutput.getChildren().clear();
				dataOutput.getChildren().addAll(l);
			}
		});
		buttons.getChildren().addAll(sort);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(dataOutput);
		borderPane.setBottom(buttons);
		Scene sortingScene = new Scene(borderPane, 290, 600);
		sortingWindow.setScene(sortingScene);
		sortingWindow.showAndWait();
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
		save.setMinSize(100, 100);
		load.setMinSize(100, 100);
		exit.setMinSize(100, 100);
		buttons.getChildren().addAll(save, load, exit);
		return buttons;
	}
	public void start(Stage stage) throws Exception {
		Stage mainStage = stage;
		mainStage.setResizable(false);
		mainStage.setTitle("QuickSort Program");
		HBox buttonBox = new HBox();
		buttonBox = createButtons(); 
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(buttonBox);
		Scene mainScene = new Scene(borderPane, 290, 90);
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
