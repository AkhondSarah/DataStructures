import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Akhond sarah Mesbah
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Due: Sunday 14 of March 2021 at midnight
 *
 * This lab will use linked lists to see if the entered equation is balanced or unbalanced 
 * This class is mainly for user input such as name and the given equation, it does some calculations but will call from the linklist class for more in detailed equations
 */
public class Lab6 {


   public static void main(String[] args) {
       Scanner keyboard = new Scanner(System.in);
       keyboard.useDelimiter(Pattern.compile("[\\n\\r]+"));
       BinaryTree tree = new BinaryTree();

       int choice = 0;
       while(choice != 4)
       {
           displayMenu();
           if(keyboard.hasNext(Pattern.compile("[1-4]")))
           {
               choice = keyboard.nextInt();
               switch(choice)
               {
               case 1: // Add Value to Tree
                   boolean valid = false;
                   while(!valid)
                   {
                       System.out.print("Enter an integer to add to the tree: ");
                       if(keyboard.hasNextInt())
                       {
                           valid = true;
                           int toAdd = keyboard.nextInt();
                           tree.insertInTree(toAdd);
                       }
                       else
                       {
                           System.out.println("Invalid integer");
                           valid = false;
                           keyboard.next();
                       }
                   }
                   break;
               case 2: // Display Tree (In-Order Traversal)
                   System.out.println("Tree Traversal");
                   tree.displayInOrder();
                   System.out.println();
                   break;
               case 3: // display the height of the tree
                    System.out.println("The height of the tree: ");
                    System.out.println( tree.getTreeHeight() );
                    break;
               case 4:
                   System.out.println("Exiting...");
                   break;
               default:
                   break;
               }
           }
           else
           {
               System.out.println("Invalid choice");
               choice = 0;
               keyboard.next();
           }
       }
       keyboard.close();
   }

   /**
   * Displays menu to screen
   */
   public static void displayMenu()
   {
       System.out.println("1: Add Value to Tree");
       System.out.println("2: Display Tree (In-Order Traversal)");
       System.out.println("3: Display height of the Tree");
       System.out.println("4: To Exit");
       System.out.print("> ");
   }

}
