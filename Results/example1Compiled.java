import java.util.*;
//import java.io.*;

public class example1Compiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      DimensionVar n = new DimensionVar("NMEC");
      n.setSuffix("");
      String name ;
      DimensionVar g = new DimensionVar("Grade");
      g.setSuffix("");
      System.out.print("Insert value into variable n (int)  : ");
      int temp1 = sc.nextInt();
      n.setValue_integer(temp1);
      System.out.print("Insert value into variable name (string) : ");
      name = sc.next();
      System.out.print("Insert value into variable g (double)  : ");
      double temp3 = sc.nextDouble();
      g.setValue_double(temp3);
      System.out.print(String.format("%10s","NMEC:"));
      System.out.print(String.format("%30s","Name"));
      System.out.println(String.format("%10s","Grade:"));
      System.out.println(
      String.format("%10s",n.getValue_int()) + String.format("%30s" , name) + 
      String.format("%10s",g.getValue_double()));
      sc.close(); /*tem de fechar*/
   }
}