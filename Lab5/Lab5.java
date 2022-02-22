import java.util.LinkedList;
import java.util.Scanner;

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
public class Lab5 {
/**
 * 
 * @param args main method
 */
public static void main(String[]args)
{
Scanner sc = new Scanner(System.in);
String expression = "";
String name=null;
System.out.print("Enter Your Full Name: ");
name = sc.nextLine();
System.out.println(" My name is "+ name + ", Here to present my Lab 5 solution ");


do
{
System.out.print("Enter an expression(or exit to terminate): ");
expression = sc.nextLine().trim();
if(expression.equalsIgnoreCase("Exit"))
{
System.out.println("\nTerminating...\n");
System.exit(0);
}
else
{
if(checkBalanced(expression))
System.out.println("The expression is balanced.");
else
System.out.println("The expression is NOT balanced.");
}
System.out.println();
}while(!expression.equalsIgnoreCase("Exit"));
}

private static boolean isMatchedPair(char c1, char c2)
{
if (c1 == '(' && c2 == ')')
{
return true;
}
else if (c1 == '{' && c2 == '}')
{
return true;
}
else
{
return false;
}
}
/**
 * 
 * @param exp - gets input inputted by user
 * @return whetehr its true or false
 */

public static boolean checkBalanced(String exp)
{
LinkedList<String> braces = new LinkedList<>();

for(int i = 0; i < exp.length(); i++)
{
if(exp.charAt(i) == '(' || exp.charAt(i) == '{')
{
braces.addFirst(exp.charAt(i) + "");
continue;
}

else if(exp.charAt(i) == ')' || exp.charAt(i) == '}')
{
if(braces.isEmpty())
return false;
else if(!isMatchedPair(braces.removeFirst().charAt(0), exp.charAt(i)))
return false;
}
}

if(braces.isEmpty())
return true;
else
return false;
}}
