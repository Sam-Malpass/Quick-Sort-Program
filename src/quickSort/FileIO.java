package quickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
}
