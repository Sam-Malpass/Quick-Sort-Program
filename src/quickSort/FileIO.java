package quickSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Sam Malpass
 * @version 1.0
 * @since 1.0
 */
public class FileIO {
	/**
	 * Function definition for save()
	 * <p>
	 * Writes a string to a file
	 * <p>
	 * @param s is a string to be written to a file
	 */
	public static void save(String s) {
		/*Creates a JFrame*/
		JFrame frame = new JFrame();
		/*Creates a JFileChooser*/
		JFileChooser saveAs = new JFileChooser();
		/*Sets the JFileChooser title*/
		saveAs.setDialogTitle("Save As");
		/*Create and set option to the users input option*/
		int option = saveAs.showSaveDialog(frame);
		/*If the user confirmed option*/
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			/*Create a file using the specified file path*/
			File file = saveAs.getSelectedFile();
			/*Modify the file's name if file extension is not present*/
			String filePath = file.getPath();
			if(!filePath.toLowerCase().endsWith(".in"))
			{
			    file = new File(filePath + ".in");
			}
			try 
			{	
				/*Create a PrintWriter for the file*/
				PrintWriter output = new PrintWriter(file);
				/*Write the string to the file*/
				output.println(s);
				/*Close the file*/
				output.close();
				/*Return*/
				return;
			} 
			catch (FileNotFoundException exception) 
			{
				exception.printStackTrace();
				return;
			}
		}
		else
		{
			return;
		}
	}
	/**
	 * Function definition for load()
	 * <p>
	 * Opens a file, reads a string from said file and then writes the numbers
	 * to an ArrayList.
	 * <p>
	 * @return an ArrayList of Doubles
	 */
	public static ArrayList<Double> load() {
		/*Create an ArrayList of doubles*/
		ArrayList<Double> inputData = new ArrayList<Double>();
		/*Create a JFrame*/
		JFrame frame = new JFrame();
		/*Create a JFileChooser*/
		JFileChooser loadFrom = new JFileChooser();
		/*Sets the title of the JFileChooser*/
		loadFrom.setDialogTitle("Load From");
		/*Create a variable and set it to the value of the user input*/
		int option = loadFrom.showOpenDialog(frame);
		/*If the option chosen is confirm*/
		if(option == JFileChooser.APPROVE_OPTION)
		{
			/*Open the user specified file*/
			File file = loadFrom.getSelectedFile();
			/*Create a FileReader*/
			try (FileReader fileReader = new FileReader(file))
			{
				/*Create a BufferedReader*/
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				/*Create a string for the raw read*/
				String rawRead = bufferedReader.readLine();
				/*Splits the string at spaces*/
				String[] processedRead = rawRead.split(" ");
				/*For all the values in the string array*/
				for(int i = 0; i < processedRead.length; i++) {
					/*Parse the data in the array to an ArrayList*/
					inputData.add(Double.parseDouble(processedRead[i]));
				}
				/*Close the file*/
	            bufferedReader.close();
			} 
			catch (FileNotFoundException exception) 
			{
				exception.printStackTrace();
			} 
			catch (IOException exception) 
			{
				exception.printStackTrace();
			}
		}
		/*Return the ArrayList*/
		return inputData;
	}
}
