import java.util.Scanner;

public class testUrn
{
  public static void main(String[] args)
  {
    // Creating Urns:
    Urn<Integer> testArray = new Urn<Integer>(10);
    Urn<String> names = new Urn<String>(8);
    Urn<Integer> hours = new Urn<Integer>(5);
    
    // Implementing variables:
    int a, b, c;
    b = 1;
    c = 1;
    
    System.out.println("Adding integers to the array:");
    try
    {
      for (int i = 0; i < 11; i++)
      {
        //Testing if urn is full:
        if (i == testArray.length()) 
          throw new FullUrnException("Cannot add any more integers, urn is full.");
        
        //Calculating integer to add to the array:  
        a = b + c;
        c = b;
        b = a;
        
        //Adding integers to the array:
        testArray.add(a);  
      }
    }
    catch (FullUrnException e)
    {
      System.out.println(e.getMessage());
    }
    System.out.println("Done.");
    
    //Printing the array:
    System.out.println("Printing the array:");
    System.out.println(testArray.toString());
    
    System.out.println("Drawing integers from the array:");
    try
    {
      for (int i = 0; i < 11; i++)
      {
        //Testing if urn is empty:
        if(testArray.isEmpty())
          throw new EmptyUrnException("Cannot draw any more integers, urn is empty.");
        
        //Drawing integers from the array:
        System.out.println(testArray.drawItem());
      }
    }
    catch (EmptyUrnException e)
    {
      System.out.println(e.getMessage());
    }
    System.out.println("Done.");    
    
    //Printing the empty array:
    System.out.println("Printing the empty array:");
    System.out.println(testArray.toString());
    System.out.println("Done.");

    //Adding names of friends:
    System.out.println("Adding names of friends:");
    names.add("Bob");
    names.add("Ruby");
    names.add("Stephanie");
    names.add("Robin");
    names.add("Roger");
    names.add("Alex");
    names.add("Ashley");
    names.add("Lesley");   
    System.out.println("Done.");
      
    //Adding hours:
    System.out.println("Adding hours:");
    for (int i = 1; i <= hours.length(); i++)
    {
      hours.add(i);
    }
      System.out.println("Done.");
    
    //Deciding who to play with and for how long:
    System.out.println("Deciding who to play with and for how long:");
    System.out.println("Tonight you will play with " + names.drawItem() + " and " + names.drawItem() + " for " + hours.drawItem() + " hours.");
  }
}
