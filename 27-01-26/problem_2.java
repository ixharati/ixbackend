/*Problem-2
Given an array of employee names (with duplicates):
Convert array → ArrayList
Remove duplicates using HashSet
Create a HashMap<String, Integer> for frequency count
Display data using multiple iteration techniques
Must Use
✔ Arrays
✔ ArrayList
✔ HashSet
✔ HashMap
✔ Iterators and enhanced for-loop
✔ equals() internally (HashSet behavior)
 */
import java.util.*;

public class problem_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of places: ");
    int n = sc.nextInt();
    String[] places = new String[n];
    System.out.println("Enter places: ");
    for(int i = 0 ; i < n ; i++){
        places[i] = sc.next();
    }
    System.out.println("Converting Array to ArrayList: ");
    List<String> li = Arrays.asList(places);
    // to convert - can also use for-loop
    System.out.println(li);

    Set<String> set = new HashSet<>();
    for(String s : places){
        while(!set.contains(s)){
            set.add(s);
        }
    }
    System.out.println();
    System.out.println("After removing duplicates: ");
    System.out.println(set);
    System.out.println("Total places : "+ set.size());
    System.out.println();

    Map<String, Integer> map = new HashMap<>();
    for(String s : places){
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    System.out.println("Frequency count for each place: ");
    for(Map.Entry<String, Integer> er : map.entrySet()){
        System.out.println("Place: "+er.getKey() +"\t Count: "+ er.getValue());
    }
    System.out.println("Total places: "+map.size()+"\n");

    //iteration methods---
    System.out.println("Using for-loop: ");
    for(int i = 0; i<n ; i++){
        System.err.print(places[i]+" ");
    }
    System.out.println("\n");

    System.out.println("Using for-each loop: ");
    for(String s : places){
        System.out.print(s+" ");
    }
    System.out.println("\n");

    System.out.println("Using Iterator: ");
    Iterator<String> it =li.iterator();
    while(it.hasNext()){
        System.out.print(it.next()+" ");
    }
  }  
}
