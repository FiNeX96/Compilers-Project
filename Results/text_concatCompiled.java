import java.util.*;
//import java.io.*;

public class text_concatCompiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      String s = "ola";

      String s2 = " BEM VINDOS AO PINGO DOCE";

      String s3 = " HOW MAY I TAKE YOUR ORDER? ";

      String s4 = s+s2+s3;
      System.out.println(s);
      System.out.println(s2);
      System.out.println(s3);
      System.out.println(s4);
      sc.close(); /*tem de fechar*/
   }
}