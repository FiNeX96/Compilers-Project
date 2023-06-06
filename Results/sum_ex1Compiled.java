import java.util.*;
//import java.io.*;

public class sum_ex1Compiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      double v3;
      v3 = 3.0;;
      DimensionVar x = new DimensionVar("Length",v3);
      x.setSuffix("m");
      double v4;
      v4 = 5.0;;
      DimensionVar y = new DimensionVar("Length",v4);
      y.setSuffix("m");
      double v5 ;
      v5 = x.getValue_double() + y.getValue_double();;
      DimensionVar z = new DimensionVar("Length",v5);
      z.setSuffix("m");
      System.out.println(" z ( should be 8.0 m ) ->  " + z.getValue_double() + " " + z.getSuffix());
      sc.close(); /*tem de fechar*/
   }
}