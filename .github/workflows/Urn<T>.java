import java.util.Arrays;
import java.util.Random;
import java.lang.reflect.Array;
import java.io.*;

public class Urn<T>
{
    private int Size = 10;
    private int count = 0;  
    private T[] content;
    
    public Urn()
    {
      content = (T[]) (new Object[Size]);
    }
    
    public Urn(int num)
    {
      Size = num;
      content = (T[]) (new Object[num]);
    }
   
    public void add(T element)
    {
        content[count] = element;
        count++;
    }
    
    public int length()
    {
      return Size;
    }
    
    public boolean isEmpty()
    {
      if (count == 0)
        return true;
      else return false;
    }

    public T drawItem()
    {
        if (isEmpty())
          return null;
        
        Random rand = new Random();
        int temp = rand.nextInt(count);
        T element = content[temp];
        for(int i = temp; i < count - 1; i++)
          content[i] = content[i+1];
        count--;
        return element;        
    }      
    
    public String toString()
    { 
        if (isEmpty())
            return "The urn is empty.";
       
          String result = "";
          for (int i = 0; i < count; i++)
            result += content[i] + "    ";
          return result;
    }
}
