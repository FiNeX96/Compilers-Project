
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

@SuppressWarnings("CheckReturnValue")
public class Precompiler extends dimanaPrecompilerBaseVisitor<Object> {

   String filePath = "../../examples/temp.da";

   @Override public Object visitProgram(dimanaPrecompilerParser.ProgramContext ctx) {
      Object res = null;
      try {
         File outputFile = new File(filePath);
         boolean isPut = outputFile.createNewFile();
         if (!isPut) {
         System.err.println("Please remove 'temp.da' before preprocessing");
         System.exit(0);
         }
      } catch (IOException e) {
         System.err.println("Please remove 'temp.da' before preprocessing");
      }
      return visitChildren(ctx);
   }


   @Override public Object visitPreprocessorDirective(dimanaPrecompilerParser.PreprocessorDirectiveContext ctx) {
      String res = visit(ctx.filename()).toString().replace("\"", "");
      // System.out.println(res);
      // System.out.print("use " + res);
      try {
         File file = new File("../../examples/" + res);
         Scanner sc = new Scanner(file);
         PrintWriter writer = new PrintWriter(new FileWriter(filePath, true));
         while(sc.hasNextLine()) {
            writer.println(sc.nextLine());
         }
         writer.close();
         sc.close();
      } catch (IOException e) {
         System.out.println("# File was not found");
      }
      return res;
   }

   @Override public Object visitCode(dimanaPrecompilerParser.CodeContext ctx) {
      try {
         PrintWriter writer = new PrintWriter(new FileWriter(filePath, true));

         Object res = ctx.LETTER();
         Object res2 = ctx.SYMBOLS();
         Object res3 = ctx.SPACE();
         Object res4 = ctx.STRING();
         Object res5 = ctx.NEWLINE();
         Object res6 = ctx.LINE_COMMENT();
         if(res != null)
            writer.print(res.toString());
         else if (res2 != null)
            writer.print(res2.toString());
         else if (res3 != null)
            writer.print(res3.toString());
         else if (res4 != null)
            writer.print(res4.toString());
         else if (res5 != null)
            writer.print(res5.toString());
         else if (res6 != null)
            writer.print(res6.toString());

         try{
            writer.print(ctx.semicolon.getText());
         } catch (NullPointerException e) {
         }
   

         writer.close();
      } catch (IOException e) {
         System.out.println("# File was not found");
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitFilename(dimanaPrecompilerParser.FilenameContext ctx) {
      String res = ctx.STRING().toString();
      return res;
   }
}
