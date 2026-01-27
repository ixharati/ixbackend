import java.util.*;

public class problem_4 {
    public static class Student{
        private String name;
        private int id;
        private int marks;

        public Student(int id, int marks, String name){
            this.name=name;
            this.marks=marks;
            this.id=id;
        } 

        public static void isPassed(int marks){
            if(marks >= 40){
                System.out.print(" Passed");
            }
            else{
                System.out.print(" Failed");
            }
        }

        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getMarks(){
            return marks;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        int marks=sc.nextInt();
        String name= sc.next();
        Student stu=new Student(id, marks, name );
        System.out.print( name +" is:");
        stu.isPassed(marks);
        

    }
}

