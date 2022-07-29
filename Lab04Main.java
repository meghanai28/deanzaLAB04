import java.util.Scanner;
public class Lab04Main {
 
	
 public static void main(String [] args) throws Exception
 {
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
	String traversals = tree.print();
	System.out.println(traversals);
	
	Scanner readInput = new Scanner(System.in);
	
	while(true)
	{
		System.out.println("\n\nHere is a menu of operations you the user can do on our Binary Search Tree: \n"
				+ "i: enter i to insert an dollar object into the Binary Search Tree\n"
				+ "d: enter d to delete an dollar object from the Binary Search Tree\n"
				+ "p: enter p to print 4 traversals of the Binary Search Tree\n"
				+ "q: enter q to exit the program.\n");
		System.out.println("Please enter a menu option:\n");
		String val = readInput.nextLine();
		if(!(val.equalsIgnoreCase("i") || val.equalsIgnoreCase("d") || val.equalsIgnoreCase("p") || val.equalsIgnoreCase("q")))
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
	 				System.out.println("Not A Double! Please try again!\n");
	 				continue;
	 			}
	 			Dollar insert;
	 			try
	 			{
	 				insert = new Dollar(dollarInput);
	 			}
	 			catch(Exception e)
	 			{
	 				System.out.println(e.getMessage());
            		continue;
	 			}
	 			
	 			Boolean found = tree.find(insert);
	 			if(found)
	 			{
	 				System.out.println(insert + " already exists in the tree! Please enter a value that is not a duplicate!\n");
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
	 				System.out.println("Not A Double! Please try again!\n");
	 				continue;
	 			}
	 			Dollar delete;
	 			try
	 			{
	 				delete = new Dollar(dollarInput);
	 			}
	 			catch(Exception e)
	 			{
	 				System.out.println(e.getMessage());
            		continue;
	 			}
	 			Boolean found = tree.find(delete);
	 			if(!found)
	 			{
	 				System.out.println(delete + " does not exist in the tree! Please enter a value to delete that is in the tree!\n");
	 				continue;
	 			}
	 			
	 			System.out.println("Deleting "+ delete + " from our Binary Search Tree.");
	 			tree.delete(delete);
	 			System.out.println(delete + " has been sucessfuly removed!");
	 			break;
		 			
		 	}
		 	continue;
		 }
		 if(value == 'p') 
		 {
			 System.out.println("This is the traversals of our current Binary Search Tree!\n");
		 	 System.out.println("The traversals are in the specific sequence of breadth-first, in-order, pre-order, post-order!\n ");
		 	 String traversal = tree.print();
		 	 System.out.println(traversal);
		 	 continue;
		 }
		 if(value == 'q') 
		 {
			 System.out.println("Thanks for using our binary search tree!");
		 	 System.out.println("This is the traversals of our current Binary Search Tree!\n");
		 	 System.out.println("The traversals are in the specific sequence of breadth-first, in-order, pre-order, post-order!\n ");
		 	 String traversal = tree.print();
		 	 System.out.println(traversal);
		 	 System.out.println("\n bye!");
		 	 break;
		 }
		
		
	}
	
	
 }

 
 
}
