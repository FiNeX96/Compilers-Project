
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class dimanaMain {
   public static void main(String[] args) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(System.in);
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

            SemanticAnalyser checker = new SemanticAnalyser();

            checker.visit(tree); // run semantic analysis

            if (!ErrorHandling.error()) { // if there are no errors, run code generation
               DimanaCompiler compiler = new DimanaCompiler();
               ST result = compiler.visit(tree);
               System.out.println(result.render()); // dislays generated code
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
