import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Main{

	  private Scanner sc;
	  private parkinglot lot; 
	  
	// Interactive Mode   
	   public void interactive_mode()
	   {
		   sc = new Scanner(System.in);
		   return;   
	   }
	   
	// File mode   
	   public void filemode()
	   {
		   try {
		   File file = new File("file_input.txt"); 
		   
		   sc = new Scanner(file);
		   //return ;
		   
		   }
		   catch(IOException e)
		   {
			   System.out.println("Wrong I/O");
		   }
	   }
	   
	 // Crated parking lot
       public boolean create_parkinglot(int capacity)
	   {
		   lot = new parkinglot(capacity);
		   System.out.println("Created a parking lot with "+ capacity + " slots");
		   return true;
	   }

  public void Go(){
      String input;	
	  while(sc.hasNextLine()){ 
	   input = sc.nextLine();
	   
	   String[] sepinput = input.split(" ");
	   
	   String comm = sepinput[0];
	   if(comm.equals("exit"))
	   {
		   System.out.println("Exiting program");
		   break;
	   }
	 else if(comm.equals("create_parking_lot"))
	   {
		   int total_lot = Integer.valueOf(sepinput[1]);
		   create_parkinglot(total_lot);
		  // System.out.println("parking lot is created....");
	   }
	   else if(comm.equals("park")){
	   String regNum = sepinput[1];
	   String colour = sepinput[2];
	   lot.parkcar(regNum, colour);
	   }
	   else if(comm.equals("leave"))
	   {
		   Integer slotnum = Integer.valueOf(sepinput[1]);
		   lot.leaveCar(slotnum);
	   }
	   else if(comm.equals("registration_numbers_for_cars_with_colour"))
	   {
		   lot.printRegNumsWithColor(sepinput[1]);
	   }
	   else if(comm.equals("slot_numbers_for_cars_with_colour"))
	   {
		   lot.printSlotNumsWithColor(sepinput[1]);
	   }
	   else if(comm.equals("slot_number_for_registration_number")){
		   
		   lot.printSlotNumWithRegNum(sepinput[1]);
	   }
	   else if(comm.equals("status"))
	   {
		   lot.printStatus();
	   }
	   else {
		   
		   System.out.println("Invalid Command");
		   System.out.println("Please Enter valid command");
	   }
	   
	   
	  }
	  
	  
   }
	
}