
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class dimanaMain {
   public static void main(String[] args) {
      try {
         // System.out.println("NOME DO ARGUMENTO -> " + args[0]);
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(args[0]);
         // create a lexer that feeds off of input CharStream:
         dimanaLexer lexer = new dimanaLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         dimanaParser parser = new dimanaParser(tokens);
         // replace error listener:
         // parser.removeErrorListeners(); // remove ConsoleErrorListener
         // parser.addErrorListener(new ErrorHandling());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {

            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));

            // DimanaSemanticChecker checker = new SemanticAnalyser();
            // dadosGuardados dados = new dadosGuardados();

            // Primeiro fazer a analise semantica
            SemanticAnalyser checker = new SemanticAnalyser();

            checker.visit(tree); // run semantic analysis

            if (!ErrorHandling.error()) { // if there are no errors, run code generation
               DimanaCompiler compiler = new DimanaCompiler(checker.getDependent_units(), checker.getVarMap(),
                     checker.getConversions(), checker.getDeclared_vars(), checker.getDeclared_lists());
               ST result = compiler.visit(tree);
               String filename = args[1].replace(".da", "") + "Compiled";
               result.add("name", filename);

               // manda o result para um ficheiro .java
               try {
                  File directory = new File("../../Results");
                  File file = new File(directory, filename + ".java");

                  try (FileWriter writer = new FileWriter(file, false)) {
                     writer.write(result.render());
                     System.out.println("File created/overwritten -> " + file.getName());
                     System.out.println("Execute the bash script to test the code generated -> ./run.sh "
                           + file.getName().replace(".java", ""));
                  } catch (IOException e) {
                     System.out.println("An error occurred while writing to the file.");
                     e.printStackTrace();
                  }

               } catch (Exception e) {
                  System.out.println("An error occurred.");
               }
            } else
               ErrorHandling.reset();
         }

      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      } catch (RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
