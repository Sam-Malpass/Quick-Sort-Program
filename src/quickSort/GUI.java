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
/**
 * @author Sam Malpass
 * @version 1.0
 * @since 1.0
 */
public class GUI extends Application {
	/**
	 * data holds the current data that is being worked on
	 */
	private ArrayList<Double> data;
	/**
	 * Function definition for writeData()
	 * <p>
	 * Creates a string of all the numbers in the data ArrayList
	 * <p>
	 * @return string
	 */
	public String writeData() {
		/*Create a string and put a title at the start*/
		String string = "Data:\n";
		/*For all values in the data set*/
		for(int i = 0; i < data.size(); i++) {
			/*Add the value to the string*/
			string = string + data.get(i) + " ";
		}
		/*Return the string*/
		return string;
	}
	/**
	 * Function definition for sortingWindow()
	 * <p>
	 * Creates a window and outputs the current data as it, with a button
	 * to allow the user to sort the data.
	 */
	public void sortingWindow()
	{
		/*Create a Stage*/
		Stage sortingWindow = new Stage();
		/*Make Stage unable to change size*/
		sortingWindow.setResizable(false);
		/*Set window title*/
		sortingWindow.setTitle("Data");
		/*Create a VBox to output data to*/
		VBox dataOutput = new VBox();
		/*Create the data Label*/
		Label l = new Label(writeData());
		/*Add the Label to the VBox*/
		dataOutput.getChildren().addAll(l);
		/*Create a HBox*/
		HBox buttons = new HBox();
		/*Create the sort Button*/
		Button sort = new Button("Sort");
		/*Set the sort Button's size*/
		sort.setMinSize(300, 50);
		/*Define the sort Button's actions*/
		sort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				/*Sort the data*/
				Algorithm.sort(data);
				/*Get the sorted data*/
				data = Algorithm.getSorted();
				/*Write a new Label*/
				Label l = new Label(writeData());
				/*Clear the current Label*/
				dataOutput.getChildren().clear();
				/*Add Label to VBox*/
				dataOutput.getChildren().addAll(l);
			}
		});
		/*Add buttons to HBox*/
		buttons.getChildren().addAll(sort);
		/*Create a BorderPane*/
		BorderPane borderPane = new BorderPane();
		/*Adds VBox to BorderPane*/
		borderPane.setTop(dataOutput);
		/*Adds HBox to BorderPane*/
		borderPane.setBottom(buttons);
		/*Create a Scene*/
		Scene sortingScene = new Scene(borderPane, 290, 600);
		/*Set the Stage's Scene*/
		sortingWindow.setScene(sortingScene);
		/*Show the window*/
		sortingWindow.showAndWait();
	}
	/**
	 * Function definition for createButtons()
	 * <p>
	 * Creates and defines actions for three buttons
	 * <p>
	 * @return a HBox with buttons in it
	 */
	public HBox createButtons()
	{
		/*Create a HBox*/
		HBox buttons = new HBox();
		/*Create a Button*/
		Button save = new Button("Save");
		/*Define action for new Button*/
		save.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				/*Create an empty string*/
				String w = "";
				/*For all values in the data set*/
				for(int i = 0; i < data.size(); i++) {
					/*Write the value to the string*/
					w = w + data.get(i) + " ";
				}
				/*Save the string*/
				FileIO.save(w);
			}
		});
		/*Create a Button*/
		Button load = new Button("Load");
		/*Define actions for new Button*/
		load.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				/*Load data*/
				data = FileIO.load();
				/*Open Sorting Window*/
				sortingWindow();
			}
		});
		/*Create a Button*/
		Button exit = new Button("Exit");
		/*Define actions for new Button*/
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				/*Exit*/
				System.exit(0);
			}
		});
		/*Set Button sizes*/
		save.setMinSize(100, 100);
		load.setMinSize(100, 100);
		exit.setMinSize(100, 100);
		/*Add Buttons to HBox*/
		buttons.getChildren().addAll(save, load, exit);
		/*Return HBox*/
		return buttons;
	}
	/**
	 * Function definition for start()
	 * <p>
	 * Creates the main Stage and opens the window
	 */
	public void start(Stage stage) throws Exception {
		/*Create the mainStage*/
		Stage mainStage = stage;
		/*Fix the window size*/
		mainStage.setResizable(false);
		/*Set the window title*/
		mainStage.setTitle("QuickSort Program");
		/*Create a HBox*/
		HBox buttonBox = new HBox();
		/*Set HBox to new Buttons*/
		buttonBox = createButtons();
		/*Create a BorderPane*/
		BorderPane borderPane = new BorderPane();
		/*Add the HBox to the BorderPane*/
		borderPane.setBottom(buttonBox);
		/*Create a Scene*/
		Scene mainScene = new Scene(borderPane, 290, 90);
		/*Set Stage's Scene*/
		mainStage.setScene(mainScene);
		/*Show the window*/
		mainStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
