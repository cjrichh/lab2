package lab;
import java.util.Scanner;
public class TomsTrucking {

	//store integers inside of variables that were initialized
private static int numTrucks;
private static int[] maxCapOfEachTruck;
private static double [] loadOfEachTruck;

public static void setNumOfTrucksForTheDay() {
       Scanner scan = new Scanner(System.in);   						//use scanner to scan for user input and store the input inside loop for range purposes
       boolean done = false;
       while(done==false) {
           System.out.println("Please enter the number of trucks you have today");
           int num = scan.nextInt();
           if(num >= 2) {
               numTrucks = num;
               loadOfEachTruck = new double[numTrucks];
               done = true;
           }else {
               System.out.println("The number must be two or greater than two. Please try again.");   //used if integer is not in the range given
           }
       }
}
       
   

public static void setTheMaxCapacityOfEachTruck() {
    maxCapOfEachTruck = new int[numTrucks];
    Scanner scan = new Scanner(System.in);                			// Use scanner for user input and store the input inside if statement to determine if small else large
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        System.out.println("Please enter the size of truck "+(index+1)+". Size is small or large");
        String size = scan.next();
        if(size.equalsIgnoreCase("small")) {
            maxCapOfEachTruck[index]=10;
        }else if(size.equalsIgnoreCase("large")) {
            maxCapOfEachTruck[index]=100;
        }
    }
}
public static void setTheLoadOfEachTruck() {
Scanner scan = new Scanner(System.in);
for(int index = 0; index < numTrucks; index++) {
System.out.println("Please enter the actual load of each truck "+(index+1)+".");
double size = scan.nextDouble();
loadOfEachTruck[index] = size;
}
}

//use this next section where you call the methods of code that were just written
public static double[] calcPercentageOfLoad() {
    double[] percOfLoad = new double[numTrucks];
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        percOfLoad[index] = loadOfEachTruck[index]  / (maxCapOfEachTruck[index]* 1.0);
    }
    return percOfLoad;
}

public static String displayTruckInfo(double[] percOfLoad) {
    String out = "";
    for(int index = 0; index < maxCapOfEachTruck.length; index++) {
        out+="Truck "+(index+1)+"- Max capacity: "+maxCapOfEachTruck[index]+", Actual load: "+loadOfEachTruck[index]+", %: "+percOfLoad[index];
        out+="\n";
    }
    return out;
}

//where you print the final answers which are needed
public static void main(String[] args) {
TomsTrucking.setNumOfTrucksForTheDay();
TomsTrucking.setTheMaxCapacityOfEachTruck();
TomsTrucking.setTheLoadOfEachTruck();
double[] pol = TomsTrucking.calcPercentageOfLoad();
System.out.println(TomsTrucking.displayTruckInfo(pol));
}
}