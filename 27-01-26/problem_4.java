/*
Problem-4
Create a program that:
Accepts numeric input as strings.
Converts them into appropriate wrapper objects.
Stores them in a List<Number>.
Calculates:
Sum of all integers
Average of floating-point numbers
Logs invalid inputs.
Must Use
✔ Wrapper classes (Integer, Double, etc.)
✔ Autoboxing / Unboxing
✔ ArrayList
✔ NumberFormatException
✔ Iteration techniques (for-each / iterator) */
import java.io.*;
import java.util.*; 
public class problem_4 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine(); 
        List<Number> numbers=new ArrayList<>();
        //autoboxing
        for(int i=0;i<n;i++){
            String input=sc.nextLine();
            try{
                if(input.contains(".")){
                    Double d=Double.parseDouble(input);
                    numbers.add(d);
                }
                else{
                    Integer in=Integer.parseInt(input);
                    numbers.add(in);
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input: "+input);
            }
        }
        int sumInt=0;
        int countFloat=0;
        double sumFloat=0.0;
        //unboxing
        for(Number num:numbers){
            if(num instanceof Integer){
                sumInt+=num.intValue();
            }
            else if(num instanceof Double){
                sumFloat+=num.doubleValue();
                countFloat++;
            }
        }
        System.out.println("Sum of integers: "+sumInt);
        if(countFloat>0){
            System.out.println("Average of floating-point numbers: "+(sumFloat/countFloat));
        }
    }
}
