package Lab7;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Akhond Sarah Mesbah 
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 2
 * Due: Sunday March 28 2021 at midnight
 *
 */
public class Lab7 {


	static Scanner sc = new Scanner(System.in);

	//Beginning of displayMainMenu method
	public static void displayMainMenu() {
		System.out.println("\nPlease Select One Of The Following: \n");
		System.out.println("1: Create A Tree Map Of Data From Txt File\n2: Display The Tree Map\n3: Search For a Given Key Or Value In Tree Map\n4: Create And Display Keys TreeSet And Values TreeSet From Tree Map\n5: Sort And Display Values TreeSet In Descending Order."
				+ "\n6: Add New Key-Value Data To The TreeMap.\n7: Exit");
		System.out.println("\n> ");

	}//End of displayMainMenu method



	public static void main(String[] args) throws FileNotFoundException{
		
		Map tree_map = new TreeMap<Integer, String>();

		

			//While loop
			while (true) {
				
				displayMainMenu();
				int choice = sc.nextInt();
				 Scanner myReader = null;
				//Choice 1
				if (choice == 1) {
                    //File myObj = new File("productowners.txt");
                   
					try {
						myReader = new Scanner(Paths.get("src\\productowners.txt"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    myReader.useDelimiter(",");
                    while (myReader.hasNextLine()) {
                            String name = myReader.nextLine();
                            String s[] = name.split("\\t");
                            if (s.length == 2) {
                                    tree_map.put(Integer.parseInt(s[1].trim()), s[0].trim());
                                    
                            } else if (s.length == 3) {
                                    tree_map.put(Integer.parseInt(s[2].trim()), s[0].trim() + " " + s[1].trim());
                            }//End of else if
                    }//End of while2

                    System.out.println("...TreeMap created...");
                    myReader.close();
            
				//Choice 2	
				}else if (choice == 2) {
					System.out.println("TreeMap: " + tree_map);
					
				//Choice 3	
				}else if (choice == 3) {
					System.out.print("Enter Key To Search: ");
					int searchKey = sc.nextInt();
					
					if (tree_map.containsKey(searchKey)) {
						System.out.println("... Key " + searchKey + " Found...");
					} else {
						System.out.println("... Key " + searchKey + " Not Found...");
					}//End if else

					//Choice 4
				}else if (choice == 4) {
					
				
					TreeSet<Integer> keys = new TreeSet();
					TreeSet<String> values = new TreeSet();
					Set set = tree_map.entrySet();

					Iterator it = set.iterator();

				
					while (it.hasNext()) {
						Map.Entry me = (Map.Entry) it.next();
						keys.add((Integer) me.getKey());
						values.add((String) me.getValue());
					}//End while
					
					System.out.println("Key TreeSet Is " + keys);
					System.out.println("Names TreeSet Is " + values);

					//Choice 5
				}else if (choice == 5) {
					TreeSet<String> values = new TreeSet((a, b) -> b.toString().compareTo(a.toString()));


					Set set = tree_map.entrySet();
					Iterator it = set.iterator();

					while (it.hasNext()) {
						Map.Entry me = (Map.Entry) it.next();
						values.add((String) me.getValue());
					}

					System.out.println("...Names TreeSet Has Been Sorted...\n" + values);

					//Choice 6
				}else if (choice == 6) {
					
					while (true) {
						System.out.println("Please Enter New Key: ");
						String input = sc.nextLine();
						
						String s[] = input.split(",");
						
						if (s.length == 2) {
							tree_map.put(Integer.parseInt(s[1].trim()), s[0].trim());
							System.out.println("Updated treeMap is: \n" + tree_map);
						
							
						}else {
							System.out.println("Please Enter Key Value In Correct Format.");
						}//End else
					}//End while

					//Choice 7
				} else if (choice == 7) {
					System.out.println("...Exiting...");
					break;
				} else {
					System.out.println("Please Enter Option: ");
				}//Else
			}//End big while
		}//End main
	}//End class
