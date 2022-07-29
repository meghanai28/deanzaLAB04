import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/**
 * Lab 04
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the main, where the binary search tree is tested with various operations. This main allows
 * for user interactivity and prints the value to both a file and console. 
 * July 29th 2022
 */

public class Lab04Main {
	
 public static void main(String [] args) throws Exception
 {
	 String fileName = "Lab04FileOutput.txt"; //u can also add ur file path here if needed.
	 try {
	      File lab04 = new File(fileName);
	      lab04.createNewFile();
	    } catch (Exception e) {
	      System.out.println("File not sucesfully created.");
	    }
	 
	System.out.println("Welcome to lab 04! Today we will be exploring Binary Search Trees!\n\n");
	BST tree = new BST();
	Dollar[] firstTwenty = {new Dollar(57.12),new Dollar(23.44), new Dollar(87.43), new Dollar(68.99),
			new Dollar(111.22),new Dollar(44.55),new Dollar(77.77),new Dollar(18.36),new Dollar(543.21),
			new Dollar(20.21),new Dollar(345.67),new Dollar(36.18),new Dollar(48.48),new Dollar(101.00),
			new Dollar(11.00),new Dollar(21.00),new Dollar(51.00),new Dollar(1.00),new Dollar(251.00),
			new Dollar(151.00)};
	for(int i =0; i<firstTwenty.length; i++)
	{
		tree.insert(firstTwenty[i]);
	}
	
	System.out.println("This is the traversals of our first 20 dollar objects inserted into our Binary Search Tree:\n");
	System.out.println("The traversals are in the specific sequence of breadth-first, in-order, pre-order, post-order!\n ");
	String traversals = "\n\n"+ tree.print() + "\n ----";
	writeFile(fileName,traversals,false);
	System.out.println(traversals);
	
	Scanner readInput = new Scanner(System.in);
	
	while(true)
	{
		System.out.println("\n\nHere is a menu of operations you the user can do on our Binary Search Tree: \n"
				+ "i: enter i to insert an dollar object into the Binary Search Tree\n"
				+ "d: enter d to delete an dollar object from the Binary Search Tree\n"
				+ "s: enter s to search if a dollar object is in the Binary Search Tree\n"
				+ "p: enter p to print 4 traversals of the Binary Search Tree\n"
				+ "q: enter q to exit the program.\n");
		System.out.println("Please enter a menu option:\n");
		String val = readInput.nextLine();
		if(!(val.equalsIgnoreCase("i") || val.equalsIgnoreCase("d") || val.equalsIgnoreCase("p") || val.equalsIgnoreCase("s") || val.equalsIgnoreCase("q")))
		{
			System.out.println("INVALID MENU OPTION! Please try again!\n");
			continue;
		}
		
		 char value = val.charAt(0);
		 if(value == 'i') 
		 {
		 	while(true)
		 	{
		 		System.out.println("Please enter a dollar(double) value to insert: (NO DUPLICATES ALLOWED)\n");
	 			String input = readInput.nextLine();
	 			double dollarInput;
	 			try
	 			{
	 				dollarInput = Double.parseDouble(input);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ input + " Is not a Double! Please try again!\n\n";
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
	 				continue;
	 			}
	 			Dollar insert;
	 			try
	 			{
	 				insert = new Dollar(dollarInput);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ dollarInput + ": " + e.getMessage();
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
            		continue;
	 			}
	 			
	 			Boolean found = tree.find(insert);
	 			if(found)
	 			{
	 				String error = "\n\n"+ insert + " already exists in the tree! Please enter a value that is not a duplicate!\n";
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
	 				continue;
	 			}
	 			
	 			System.out.println("Inserting "+ insert + " into our Binary Search Tree.");
	 			tree.insert(insert);
	 			System.out.println(insert + " has been sucessfuly inserted!");
	 			break;
		 			
		 	}
		 	continue;
		 }
		 if(value == 'd') {
		 	while(true)
		 	{
		 		System.out.println("Please enter a dollar(double) value to delete: (MUST BE IN THE BINARY SEARCH TREE)\n");
	 			String input = readInput.nextLine();
	 			double dollarInput;
	 			try
	 			{
	 				dollarInput = Double.parseDouble(input);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ input + " Is not a Double! Please try again!\n";
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
	 				continue;
	 			}
	 			Dollar delete;
	 			try
	 			{
	 				delete = new Dollar(dollarInput);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ dollarInput + ": " + e.getMessage();
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
            		continue;
	 			}
	 			Boolean found = tree.find(delete);
	 			if(!found)
	 			{
	 				String error = "\n\n"+ delete + " does not exist in the tree! Please enter a value to delete that is in the tree!\n";
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
	 				continue;
	 			}
	 			
	 			System.out.println("Deleting "+ delete + " from our Binary Search Tree.");
	 			tree.delete(delete);
	 			System.out.println(delete + " has been sucessfuly removed!");
	 			break;
		 			
		 	}
		 	continue;
		 }
		 if(value == 's') 
		 {
		 	while(true)
		 	{
		 		System.out.println("Please enter a dollar(double) value to search: \n");
	 			String input = readInput.nextLine();
	 			double dollarInput;
	 			try
	 			{
	 				dollarInput = Double.parseDouble(input);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ input + " Is not a Double! Please try again!\n";
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
	 				continue;
	 			}
	 			Dollar search;
	 			try
	 			{
	 				search = new Dollar(dollarInput);
	 			}
	 			catch(Exception e)
	 			{
	 				String error = "\n\n"+ dollarInput + ": " + e.getMessage();
	 				writeFile(fileName,error,true);
	 				System.out.println(error);
            		continue;
	 			}
	 			
	 			Boolean found = tree.find(search);
	 			if(found)
	 			{
	 				System.out.println(search + " exists in the tree! It has been found! \n");
	 			}
	 			else
	 			{
	 				System.out.println(search + " does not exist in this tree! It has NOT been found! \n");
	 			}
	 			break;
		 			
		 	}
		 	continue;
		 }
		 if(value == 'p') 
		 {
			 System.out.println("This is the traversals of our current Binary Search Tree!\n");
		 	 System.out.println("The traversals are in the specific sequence of breadth-first, in-order, pre-order, post-order!\n ");
		 	 String traversal = "\n\n"+ tree.print() + "\n ----";
		 	 writeFile(fileName,traversal,true);
		 	 System.out.println(traversal);
		 	 continue;
		 }
		 if(value == 'q') 
		 {
			 System.out.println("Thanks for using our binary search tree!");
		 	 System.out.println("This is the traversals of our current Binary Search Tree!\n");
		 	 System.out.println("The traversals are in the specific sequence of breadth-first, in-order, pre-order, post-order!\n ");
		 	 String traversal = "\n\n"+ tree.print() + "\n ----";
		 	 writeFile(fileName,traversal,true);
		 	 System.out.println(traversal);
		 	 System.out.println("\n bye!");
		 	 break;
		 }
		
		
	}
	tree = null; // cleanup
	readInput.close(); // cleanup
 }

 /**
  * This method writes into a given file, with a given input, and wether or not to overwrite the file or append.
  * @pre fileName - name of the file.
  * 	 input - input to be written into the file.
  * 	 append - wether input should be appened or overwrite the file.
  * @post has a try catch block to see if there are any exceptions when writing into the file, otherwise the input
  * is written into the file.
  */
 public static void writeFile(String fileName, String input,boolean append)
 {
	 try {
	      FileWriter writer = new FileWriter(fileName,append);
	      writer.write(input);
	      writer.close();
	    } catch (Exception e) {
	      System.out.println("File was not correctly written to");
	    }
 }
 public static void writeFile(String fileName, String input,boolean append)
 {
	 try {
	      FileWriter writer = new FileWriter(fileName,append);
	      writer.write(input);
	      writer.close();
	    } catch (Exception e) {
	      System.out.println("File was not correctly written to");
	    }
 }
 
}
