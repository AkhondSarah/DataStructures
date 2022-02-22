import java.util.Scanner;

public class Lab8
{
        public static void main(String[] args) 
        {
                // creating Scanner object for reading inputs.
                Scanner scan = new Scanner(System.in);
                
                // array of String - 100
                String dataslots[] = new String[100];
                // make every String as ""
                for(int i = 0; i < 100; i++)
                {
                        dataslots[i] = "";
                }
                
                // initialize choice to 1
                int choice = 1;
                
                // while loop - runs till 4 is given as choice
                while(choice != 4)
                {
                        System.out.print("1.Add\n2.Search\n3.Delete\n4.Exit\n>");
                        // reading integer input
                        choice = scan.nextInt();
                        // using switch with choice
                        switch(choice)
                        {
                                case 1:
                                {
                                        String str;
                                        int hash, flag = 0;
                                        
                                        System.out.print("Enter string: ");
                                        // read String from user.
                                        str = scan.next();
                                        // hash holds the index obtained from getHash() method.
                                        hash = getHash(str);
                                        // for loop runs till 99. Starts from index hash.If the String is empty,
                                        // assign the String else move to the next index. Repeat this until an empty String is found or
                                        // index reach 100.
                                        for(int i = hash; i < 100; i++)
                                        {
                                                // if the String is empty
                                                if(dataslots[i].isEmpty())
                                                {
                                                        // assign the String
                                                        dataslots[i] = str;
                                                        // change flag to 1
                                                        flag = 1;
                                                        System.out.println("entered at "+ i);
                                                        // break the loop
                                                        break;
                                                }
                                        }
                                        // if flag == 0 -> String is not added to the dataslots.
                                        if(flag == 0)
                                        {
                                                System.out.println( str + " cannot be added");
                                        }
                                        break;
                                }
                                
                                case 2:
                                {
                                        String str;
                                        int flag = 0;
                                        
                                        System.out.print("Enter string: ");
                                        // read String from user.
                                        str = scan.next();
                                        
                                        // loop through the String objects 
                                        for(int i = 0; i < 100; i++)
                                        {
                                                // if the String is found
                                                if(dataslots[i].equals(str))
                                                {
                                                        // change flag to 1
                                                        flag = 1;
                                                        System.out.println( str + " found at index " + i);
                                                        // break the loop
                                                        break;
                                                }
                                        }
                                        // if flag == 0 -> String not found.
                                        if(flag == 0)
                                        {
                                                System.out.println( str + " not found");
                                        }
                                        break;
                                }
                                
                                case 3:
                                {
                                        String str;
                                        int flag = 0;
                                        
                                        System.out.print("Enter string: ");
                                        // read String from user.
                                        str = scan.next();
                                        
                                        // loop through the String objects 
                                        for(int i = 0; i < 100; i++)
                                        {
                                                // if the String is found
                                                if(dataslots[i].equals(str))
                                                {
                                                        // Make the String empty.
                                                        dataslots[i] = "";
                                                        // change flag to 1
                                                        flag = 1;
                                                        System.out.println( str + " deleted from index " + i);
                                                        // break the loop
                                                        break;
                                                }
                                        }
                                        // if flag == 0 -> String not found.
                                        if(flag == 0)
                                        {
                                                System.out.println( str + " not found");
                                        }
                                        break;
                                }
                                
                                case 4:
                                {
                                        // change the name.
                                        System.out.println("Mariusz Makos has left the program.");
                                        // return from switch
                                        return;
                                }
                                
                                default:
                                {
                                        System.out.println("Invalid Input!");
                                }
                        }
                }
                scan.close();

        }
        
        // getHash() - returns the hash value of the String
        public static int getHash(String str)
        {
                // initialize value to 0.
                int value = 0;
                // loop through the letters
                for(int i = 0; i < str.length(); i++)
                {
                        // add its ASCII value to value.
                        value += str.charAt(i);
                }
                // applying modulus 100 division to get a number between 0 and 99.
                return value % 100;
        }

}
