import java.util.*;
//import java.io.*;

public class example2Compiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      int N = 4;
      ArrayList<DimensionVar> nmecs = new ArrayList<DimensionVar>(); // List of NMEC ;
      nmecs.add(null); // fill index 0 so it starts at 1
      ArrayList<String> names = new ArrayList<String>(); // List of string ;
      names.add(null); // fill index 0 so it starts at 1
      ArrayList<DimensionVar> grades = new ArrayList<DimensionVar>(); // List of Grade ;
      grades.add(null); // fill index 0 so it starts at 1
      int i ;
      for (i = 1; i <= N; i++) {
         System.out.print("Insert value into array nmecs (int)  : ");
         int temp1 = sc.nextInt();
         DimensionVar temp2 = new DimensionVar("NMEC",temp1);
         nmecs.add(temp2);
         System.out.print("Insert value into array names (string) : ");
         String temp3 = sc.next();
         names.add(temp3);
         System.out.print("Insert value into array grades (double)  : ");
         double temp5 = sc.nextDouble();
         DimensionVar temp6 = new DimensionVar("Grade",temp5);
         grades.add(temp6);

      }
      System.out.println(String.format("%10s","NMEC:") + String.format("%30s","Name") + String.format("%10s","Grade:"));
      for (i = 1; i <= nmecs.size()-1; i++) {
         System.out.println(String.format("%10s",nmecs.get(i).getValue_int()) + String.format("%30s",names.get(i)) + String.format("%10s",grades.get(i).getValue_double()));

      }
      sc.close(); /*tem de fechar*/
   }
}