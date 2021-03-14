import java.util.*;


class parkinglot {

    int capacity;
     Map<String, Car> CarWithRegNum;
     Map<Integer, Car> CarWithSlotNum;
     Map<String, Set<Car> > CarsToColor;
	 Map<String, String > carWithColor;
	 Map<Integer, String> colorWithSlotnum;
     TreeSet<Integer> AvailableSlots;

    public  parkinglot(int cap) {
        this.capacity = cap;
        CarWithRegNum = new HashMap<String, Car>();
        CarWithSlotNum = new HashMap<Integer, Car>();
        CarsToColor = new HashMap<String, Set<Car>>();
		carWithColor = new HashMap< String, String>();
		colorWithSlotnum = new HashMap<Integer, String>();
        AvailableSlots = new TreeSet<Integer>();
        for (int i = 1; i <= capacity; i++) {
            AvailableSlots.add(i);
        }
    }

  public int parkcar(String regnum, String colour)
  {
	  
	  if (CarWithRegNum.containsKey(regnum)) {
            System.out.println("Car with same RegNum already parked!");
            return -1;
        } else if (AvailableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return -1;
        }
		
		carWithColor.put(regnum, colour);
		
	  Car newCar = new Car(regnum, colour);
	  if(CarsToColor.containsKey(colour))
	  {
		 CarsToColor.get(colour).add(newCar); 
	  }
	  else{
	  CarsToColor.put(colour, new HashSet<Car>());
	  }
	  //CarsToColor.get(colour).add(newCar);
	  CarWithRegNum.put(regnum, newCar);
	  
	  int slotallocate = AvailableSlots.pollFirst();
	  newCar.setSlotNumber(slotallocate);
	  CarWithSlotNum.put(slotallocate, newCar);
	  
	  colorWithSlotnum.put(slotallocate, colour);
	  System.out.println("Allocated slot number: " + slotallocate);
	  
	 
        return slotallocate;
	  //return 1;
  }  

   public Car leaveCar(int slotNum) {
        if (!CarWithSlotNum.containsKey(slotNum)) {
            System.out.println("Slot number " + slotNum + " is invalid, leave car aborted");
            return null;
        }
        Car evictCar = CarWithSlotNum.get(slotNum);
        CarWithRegNum.remove(evictCar.getRegNum());
        CarWithSlotNum.remove(slotNum);
		carWithColor.remove(evictCar.getRegNum());
		colorWithSlotnum.remove(slotNum);
        CarsToColor.get(evictCar.getColor()).remove(evictCar);
        AvailableSlots.add(slotNum);
        System.out.println("Slot number " + slotNum + " is free");
        return evictCar;
    }
  
  public void printStatus() {
	  
	  //System.out.println(CarsToColor);
	  
	  
	  
        System.out.println("Slot No.    Registration No    Colour");
        for (int i = 1; i <= 6; i++) {
            Car car = CarWithSlotNum.get(i);
            if (car != null) {
                System.out.println(String.format("%-12s%-19s%s", i, car.getRegNum(), car.getColor()));
            }
        }
    }
	
	
	
	public boolean printRegNumsWithColor(String color) {
        Set<String> matchingCars =  new HashSet<String>();
        
		  for(Map.Entry<String, String > entry : carWithColor.entrySet())
		  {
			  if(entry.getValue().equals(color))
			  {
				  matchingCars.add(entry.getKey());
			  }
		  }


		if (matchingCars.isEmpty()) {
            System.out.println("No cars with such color");
            return false;
        }
		else {
			TreeSet<String> Result = new TreeSet<String>(matchingCars);
			System.out.println(Result);
		}
        System.out.println();
        return true;
    }
	
	public boolean printSlotNumsWithColor(String color) {
        Set<Integer> matchingCars =  new HashSet<Integer>();
		 for(Map.Entry<Integer, String> entry : colorWithSlotnum.entrySet())
		  {
			  
			  if(entry.getValue().equals(color))
			  {
				  
				  matchingCars.add(entry.getKey());
			  }
			 
		  }
		  
        if (matchingCars.isEmpty()) {
            System.out.println("No cars with such color");
            return false;
        }
		else {
			TreeSet<Integer> Result = new TreeSet<Integer>(matchingCars);
			System.out.println(Result);
		}
		
        System.out.println();
        return true;
    }

	
	 public boolean printSlotNumWithRegNum(String regNum) {
        Car matchingCar = CarWithRegNum.get(regNum);
        if (matchingCar == null) {
            System.out.println("Not found");
            return false;
        } else {
            System.out.println(matchingCar.getAllocatedSlotNumber());
            return true;
        }
    }
	
  

}