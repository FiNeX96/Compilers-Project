import java.util.*;
//import java.io.*;

public class while_loopsCompiled {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); /*para depois usar nos READS*/
      int N = 4;
      int v1 = N;

      int v2 = 6;
      do {
         int v3 ;
         v3 = N + 1;
         N = v3;
         System.out.println(N);

         v1 =  N;
         continue;
      } while (
      v1<v2);
      int v6 = N;

      int v7 = 7;
      while (
      v6<v7) {
         int v8 ;
         v8 = N + 1;
         N = v8;
         System.out.println(N);

         v6 =  N;
      }
      int v11 = N;

      int v12 = 5;
      if (
      v11<v12) {
         int v13 = 300;
         N = v13;

      } else {
      }
      sc.close(); /*tem de fechar*/
   }
}