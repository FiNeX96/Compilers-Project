import java.util.*;
//import java.io.*;

public class mult_ex2Compiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      double v3;
      v3 = 3.0 * 0.0254;;
      DimensionVar x = new DimensionVar("Length",v3);
      x.setSuffix("m");
      double v4;
      v4 = 5.0;;
      DimensionVar y = new DimensionVar("Length",v4);
      y.setSuffix("m");
      double v5 ;
      v5 = x.getValue_double() * y.getValue_double();;
      DimensionVar a = new DimensionVar("Area",v5);
      a.setSuffix("m*m");
      System.out.print(a.getValue_double() + " " + a.getSuffix());
      sc.close(); /*tem de fechar*/
   }
}