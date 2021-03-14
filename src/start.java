
import java.util.*;

public class start{

  public static void main(String[] args)
  {
  
  Main obj = new Main();
  
    Scanner sc = new Scanner(System.in);
	
    System.out.println("Choose the mode of input - Enter Interactive OR File");
	while(sc.hasNextLine()){
	String input = sc.nextLine();
   
     if(input.equals("Interactive"))
	 {
		 obj.interactive_mode();
		System.out.println("Enter your Command"); 
		  obj.Go();
		 System.out.println("Enter other Command OR exit"); 
	 }
     else if(input.equals("File"))
     {        
	  obj.filemode();
	  System.out.println("Enter your Command");
	  obj.Go();
	  System.out.println("Enter other Command ( e.g :- Interactive, File or exit) "); 
     }
	 else if(input.equals("exit"))
	 {
		 System.out.println("Exit program");
		 break;
	 }
	 else {
		 System.out.println("Invalid Command - Try again OR Enter exit");
	 }
  }
  }
} 