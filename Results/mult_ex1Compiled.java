import java.util.*;
//import java.io.*;

public class mult_ex1Compiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      double v2;
      v2 = 3.0;;
      DimensionVar x = new DimensionVar("Length",v2);
      x.setSuffix("m");
      double v3;
      v3 = 5.0;;
      DimensionVar y = new DimensionVar("Length",v3);
      y.setSuffix("m");
      double v4 ;
      v4 = x.getValue_double() * y.getValue_double();;
      DimensionVar a = new DimensionVar("Area",v4);
      a.setSuffix("m*m");
      System.out.print(a.getValue_double() + " " + a.getSuffix());
      sc.close(); /*tem de fechar*/
   }
}