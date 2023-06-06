import static java.lang.System.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.math.BigInteger;

@SuppressWarnings("CheckReturnValue")
public class SemanticAnalyser extends dimanaBaseVisitor<Boolean> {

   private static int varCount = 0; // variable counter
   private static HashMap<String, ArrayList<String>> varMap = new HashMap<String, ArrayList<String>>();
   // usem este array para guardar as coisas sobre variaveis/dimensoes
   // por exemplo --> {Length : [real, meter, m], ...}

   private static HashMap<String, ArrayList<String>> conversions = new HashMap<>();
   // vai guardar por exemplo --> {inch : ["0.0254", "meter"], ...}

   private static HashMap<String, String> declared_vars = new HashMap<String, String>();

   // guardar as variaveis -----> {l : Length}
   private static HashMap<String, String> declared_lists = new HashMap<String, String>();

   private static HashMap<String, ArrayList<String>> dependent_units = new HashMap<String, ArrayList<String>>();

   // guardar dependencias das unidades dependentes
   // p.ex Volume -> [Length*Length*Length]
   private static int temp_var_counter = 1;

   ArrayList<String> default_types = new ArrayList<String>() {
      {
         add("integer");
         add("real");
         add("string");
      }
   };

   public HashMap<String, ArrayList<String>> getDependent_units() {
      return dependent_units;
   }

   public HashMap<String, String> getDeclared_lists() {
      return declared_lists;
   }

   public HashMap<String, String> getDeclared_vars() {
      return declared_vars;
   }

   public HashMap<String, ArrayList<String>> getConversions() {
      return conversions;
   }

   public HashMap<String, ArrayList<String>> getVarMap() {
      return varMap;
   }

   @Override
   public Boolean visitIndependentUnit(dimanaParser.IndependentUnitContext ctx) {

      Boolean res = visit(ctx.dataType());

      if (res != false) {

         if (isReservedName(ctx.ID(0).getText())) {
            ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cant use a Java reserved name");
            return false;
         }

         if (isReservedName(ctx.ID(1).getText())) {
            ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cannot use a base unit thats a Java reserved name");
            return false;
         }

         if (ctx.ID(2) != null) {

            if (isReservedName(ctx.ID(2).getText())) {
               ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cannot use a suffix thats a Java reserved name");
               return false;
            }

         if (!ctx.dataType().type.equals("integer") && !ctx.dataType().type.equals("real")) {
            ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cannot be of type " + ctx.dataType().type);
            return false;
         }

            // independent units with suffix given
            varMap.put(ctx.ID(0).getText(), new ArrayList<String>() {
               {
                  add(ctx.dataType().type); // datatype -> real, integer
                  add(ctx.ID(1).getText()); // base unit -> meter, second
                  add(ctx.ID(2).getText()); // suffix -> m, s
               }
            });
         } else {
            // independent units without suffix given
            varMap.put(ctx.ID(0).getText(), new ArrayList<String>() {
               {
                  add(ctx.dataType().type); // datatype -> real, integer
                  add(ctx.ID(1).getText()); // base unit -> meter, second
               }
            });
         }
      }

      return res;
   }

   @Override
   public Boolean visitDependantUnit(dimanaParser.DependantUnitContext ctx) {

      Boolean res = visit(ctx.expression()) && visit(ctx.dataType());

      if (varMap.containsKey(ctx.ID(0).getText())) {
         ErrorHandling.printError(ctx, "Unit " + ctx.ID(0).getText() + " already exists");
         return false;
      }

      for (String key : varMap.keySet()) {
         if (varMap.get(key).size() == 3) {
            if (varMap.get(key).get(1).equals(ctx.expression().dimension)) {
               ErrorHandling.printError(ctx,
                     "A unit with the same representation of " + ctx.ID(0).getText() + " already exists");
               return false;
            }
         }
      }

      varMap.put(ctx.ID(0).getText(), new ArrayList<String>() {
         {
            add(ctx.dataType().type);
            add(ctx.expression().dimension);
         }
      });

      return res;
   }

   @Override
   public Boolean visitIntSuffix(dimanaParser.IntSuffixContext ctx) {

      boolean res = visit(ctx.expression()); // deve dar visit no ID Expression

      if (isReservedName(ctx.expression().getText())){
         ErrorHandling.printError(ctx, "Suffix " + ctx.expression().getText() + " cant use a Java reserved name");
         return false;
      }

      visit(ctx.expression());
      ctx.dimension = ctx.expression().dimension;

      for (String s : varMap.keySet()){
         if (varMap.get(s).size() == 3){
            if (varMap.get(s).get(2).equals(ctx.expression().dimension)){
               ctx.dimension = s;
            }
         }
      }

     
      return true;
   }

   @Override
   public Boolean visitRealSuffix(dimanaParser.RealSuffixContext ctx) {

      boolean res = visit(ctx.expression()); // deve dar visit no ID Expression

      if (isReservedName(ctx.expression().getText())){
         ErrorHandling.printError(ctx, "Suffix " + ctx.expression().getText() + " cant use a Java reserved name");
         return false;
      }

      visit(ctx.expression());
      ctx.dimension = ctx.expression().dimension;
      String saver = ctx.dimension;

      for (String s : varMap.keySet()){
         if (varMap.get(s).size() == 3){
            if (varMap.get(s).get(2).equals(ctx.expression().dimension)){
               ctx.dimension = s;
            }
         }
      }
      
      if (ctx.dimension.equals(saver)){
         ErrorHandling.printError(ctx, "Suffix " + ctx.expression().getText() + " does not exist or the corresponding dimension has not been declared yet");
         return false;
      }

      return true;
   }

   @Override
   public Boolean visitVariableDeclaration(dimanaParser.VariableDeclarationContext ctx) {

      Boolean res = visit(ctx.dataType()); // check if there are no problems with the datatype

      if (ctx.expression() != null)
         res = res && visit(ctx.expression()); // if there is a expression, check if there are no problems with it also

      if (res != false) {

         String var_dataType = ctx.dataType().type; // this is used both for types and dimensions in the dataType rule

         if (ctx.dataType().type == null) {
            ErrorHandling.printError(ctx,
                  "Attempt at using a undeclared dimension when declaring the variable -> " + ctx.ID().getText());
            return false;
         }

         String varName = ctx.ID().getText();

         if (isReservedName(varName)) {
            ErrorHandling.printError(ctx, "Variable " + varName + " cant use a Java reserved name");
            return false;
         }

         if (declared_vars.containsKey(varName)) {
            ErrorHandling.printError(ctx, "Variable " + varName + " is already declared");
            return false;
         }

         if (ctx.expression() != null) { // se existir uma expressão a ser associada À variavel
            String expr_dataType = ctx.expression().dimension;

            if (var_dataType.equals("String"))
               var_dataType = "string";
            if (expr_dataType.equals("String"))
               expr_dataType = "string";

            if (varMap.get(var_dataType).size() == 1 && varMap.get(expr_dataType).size() == 1) { // when both are type string/integer/real
               if (var_dataType.equals(expr_dataType)) {
                  declared_vars.put(varName, var_dataType);
                  return true;
               } else {
                  ErrorHandling.printError(ctx, "Cant assign expression of dimension -> " +
                        expr_dataType + " to variable "
                        + varName + " of dimension -> " + var_dataType);
                  return false;
               }
            }
            if (varMap.containsKey(expr_dataType) && varMap.containsKey(var_dataType)) {
               if (varMap.get(var_dataType).size() != 1 && varMap.get(expr_dataType).size() == 1 ){
                  ErrorHandling.printError(ctx, "Cant assign expression of dimension -> " +
                        expr_dataType + " to variable "
                        + varName + " of dimension -> " + var_dataType);
                  return false;
               }
            }

            if (var_dataType.equals(expr_dataType) || varMap.get(var_dataType).get(1).equals(expr_dataType)
                  || varMap.get(expr_dataType).get(1).equals(var_dataType)) { // verificar se a dimensão da variável é igual à resultante da expressão
               declared_vars.put(varName, var_dataType);
               return true;
            } else {
               ErrorHandling.printError(ctx, "Cant assign expression of dimension -> " +
                     expr_dataType + " to variable "
                     + varName + " of dimension -> " + var_dataType);
               return false;
            }

         }

         declared_vars.put(varName, var_dataType);
      }

      return res;
   }

   public Boolean visitGet_array_idx(dimanaParser.Get_array_idxContext ctx) {

      if (!declared_lists.containsKey(ctx.ID().getText())) {
         ErrorHandling.printError(ctx, "List " + ctx.ID().getText() + " is not declared");
         return false;
      }

      if (ctx.INT().getText().equals("0")){
         ErrorHandling.printError(ctx, "Lists start at index 1, cant access index 0");
         return false;
      }

      ctx.dimension = declared_lists.get(ctx.ID().getText());

      return true;
   }

   @Override
   public Boolean visitAssignment(dimanaParser.AssignmentContext ctx) {

      Boolean res = visit(ctx.expression()); // check if there are no problems with the expression

      String var = declared_vars.get(ctx.ID().getText());

      if (res != false) { // if there are no problems with the expression or the name of the variable
         String var_dim = declared_vars.get(ctx.ID().getText());
         
         if (!(var_dim.equals(ctx.expression().dimension)) && !(varMap.get(var_dim).get(1)
               .equals(ctx.expression().dimension))) {
            // check if the dimension of the variable is equal to the dimension of the expression
            res = false;
            ErrorHandling.printError(ctx,
                  "Cant assign expression of dimension -> " + ctx.expression().dimension +
                        " to variable "
                        + ctx.ID().getText() + " of dimension -> " +
                        declared_vars.get(ctx.ID().getText()));
                        
            return res;
         }
      }

      return res;
   }

   @Override
   public Boolean visitInputStatement(dimanaParser.InputStatementContext ctx) {

      Boolean res = true;

      if (!declared_vars.containsKey(ctx.ID(0).getText())) // verificar se esta variavel já foi declarada
      {
         ErrorHandling.printError(ctx, "Variable " + ctx.ID(0).getText() + " is not declared");
         return false;
      }

      if (ctx.ID(1) != null) // se existir um cast
      {
         // ver se o cast que é feito é para a unidade base da dimensão da variável
         try {
            if (!(varMap.get(declared_vars.get(ctx.ID(0).getText())).get(1).equals(ctx.ID(1).getText()))) {
               ErrorHandling.printError(ctx,
                     "Variable " + ctx.ID(0).getText() + " has base unit of "
                           + varMap.get(declared_vars.get(ctx.ID(0).getText())).get(1) + " and a cast attempt to "
                           + ctx.ID(1).getText() + " was made");
               return false;
            }
         } catch (NullPointerException e) { // null pointer aqui significa que a dimensão da unidade base dada não existe ( ou a variável não está registada ainda, mas isso já é verificado acima)
            ErrorHandling.printError(ctx,
                  "Attempt at casting input (right cast) to a base unit of a dimension that is not declared, base unit -> "
                        + ctx.ID(1).getText() + "!!");
            return false;
         }
      }

      if (ctx.dataType() != null) { // só permitir casts ( na esquerda ) para os tipos de dados base

         if ((ctx.dataType().getText().equals("string")) == false && (ctx.dataType().getText().equals("real")) == false
               &&
               (ctx.dataType().getText().equals("integer")) == false) {
            ErrorHandling.printError(ctx,
                  "Cant cast input given (left cast) to types other than real, string or integer!! An attempt to cast to {"
                        +
                        ctx.dataType().getText() + "} was made");
            return false;
         }
      }

      if (ctx.STRING() != null) { // verificar se a string não é um nome reservado do Java
         if (isReservedName(ctx.STRING().getText())) {
            ErrorHandling.printError(ctx, "Cant use a Java reserved name as a string");
            return false;
         }
      }

      return res;
   }

   @Override
   public Boolean visitOutputStatement(dimanaParser.OutputStatementContext ctx) {
      Boolean res = true;

      // check if problems with output format exist
      Iterator<dimanaParser.OutputFormatContext> it = ctx.outputFormat().iterator();

      while (it.hasNext()) {
         if (visit(it.next()) == false) {
            res = false;
            return res;
         }
      }

      return res;
   }

   @Override
   public Boolean visitOutputFormat(dimanaParser.OutputFormatContext ctx) {
      Boolean res = true;

      // iterator of ID
      if (ctx.ID() != null) { //

         String var_name = ctx.ID().getText();

         if (!declared_vars.containsKey(var_name)) // verificar se esta variavel já foi declarada
         {
            ErrorHandling.printError(ctx,
                  "Attempting to print variable " + var_name + " but it is not declared");
            return false;
         }

         // should never get here because this verification is also done on variabledeclaration beforehand
         if (isReservedName(var_name)) {
            ErrorHandling.printError(ctx,
                  "Attempting to print variable " + var_name + " that has a Java reserved name");
            return false;
         }

      }

      if (ctx.expression() != null) { // prints of array indexes

         if (visit(ctx.expression()) == false) // problems with the expression
            return false;

         String array_name = ctx.expression().varName;

         if (!declared_lists.containsKey(array_name)) // verificar se esta lista já foi declarada
         {
            ErrorHandling.printError(ctx, "Attempting to print list index of list " +
                  array_name + " thats not declared");
            return false;
         }

         // verificar se o valor do indice é o mesmo que tá na for loop, não sei bem como fazer isso
         // por exemplo se é for ( int i = 0 ; ... ; i++) , verificar se tá a ser printed nmecs[i]

      }

      return res;
   }

   @Override
   public Boolean visitLoopStatement(dimanaParser.LoopStatementContext ctx) {
      Boolean res = true;

      for (TerminalNode idNode : ctx.ID()) {
         if (isReservedName(idNode.getText())) {
            ErrorHandling.printError(ctx, "Can't use a Java reserved name as a loop variable");
            return false;
         }

         if (!declared_vars.containsKey(idNode.getText()) && !declared_lists.containsKey(idNode.getText())) {
            ErrorHandling.printError(ctx,
                  "Cant loop over variable or list " + idNode.getText() + " because it is not declared");
            return false;
         }
      }

      if (ctx.INT(0) != null && ctx.INT(1) != null) {

         if (Integer.parseInt(ctx.INT(0).getText()) > Integer.parseInt(ctx.INT(1).getText())) {
            ErrorHandling.printError(ctx,
                  " End value is smaller than start value in loop statement");
            return false;
         }
      }

      for (dimanaParser.StatementContext statement : ctx.statement()) {
         if (statement.variableDeclaration() != null) {
            ErrorHandling.printError(ctx, "Can't declare variables inside a loop statement");
            return false;
         }
         if (statement.prefixUnit() != null) {
            ErrorHandling.printError(ctx, "Can't declare prefixes inside a loop statement");
            return false;
         }
         if (statement.unit() != null) {
            ErrorHandling.printError(ctx, "Can't declare dimensions inside a loop statement");
            return false;
         }
         if (statement.alternativeUnit() != null) {
            ErrorHandling.printError(ctx, "Can't declare alternative units inside a loop statement");
            return false;
         }
      }

      return res;
   }

   @Override
   public Boolean visitPrefixUnit(dimanaParser.PrefixUnitContext ctx) {
      Boolean res = true;
      return res;
   }

   @Override
   public Boolean visitAlternativeUnit(dimanaParser.AlternativeUnitContext ctx) {
      Boolean res = visit(ctx.expression());
      String type = ctx.expression().dimension;

      if (isReservedName(ctx.ID(0).getText())) {
         ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cant use a Java reserved name");
         return false;
      }

      if (isReservedName(ctx.ID(1).getText())) {
         ErrorHandling.printError(ctx, "Unit " + ctx.ID(0) + " cannot use a base unit thats a Java reserved name");
         return false;
      }

      if (!type.equals(ctx.ID(0).getText())) {
         ErrorHandling.printError(ctx, "Trying to define a alternative unit of dimension" + type
               + " for a unit of a different dimension " + ctx.ID(0).getText());
         return false;
      }

      if (!varMap.containsKey(ctx.ID(0).getText())) {
         ErrorHandling.printError(ctx, "Trying to define a alternative unit " + ctx.ID(1).getText()
               + " for a dimension that is not declared -> " + ctx.ID(0).getText());
         return false;
      }

      String unit = ctx.ID(1).getText();
      String[] exprs = ctx.expression().getText().split("[/*]");

      conversions.put(unit, new ArrayList<String>() {
         { // save the conversion with the following format {inch : ["0.0254", "meter", "m"], ...}
            add(exprs[0]);
            add(exprs[1]);
         }
      });

      if (ctx.ID(2) != null) { // add the suffix if it exists
         conversions.get(unit).add(ctx.ID(2).getText());
      }

      return res;
   }

   @Override
   public Boolean visitListDeclaration(dimanaParser.ListDeclarationContext ctx) {
      Boolean res = visit(ctx.dataType(0)) && visit(ctx.dataType(1));

      String list_type = ctx.dataType(0).type;

      if (!varMap.containsKey(list_type)) {
         ErrorHandling.printError(ctx, "Trying to declare a list {" + ctx.ID().getText()
               + "} with an invalid ( not declared ) dimension " + list_type + " is not a valid dimension type");
         return false;
      }

      if (!list_type.equals(ctx.dataType(1).type)) {
         ErrorHandling.printError(ctx, "Trying to declare a List {" + ctx.ID().getText() + "} with type {" + list_type
               + "} that is not the same as the type of the list elements -> " + ctx.dataType(1).type);
         return false;
      }

      if (isReservedName(ctx.ID().getText())) {
         ErrorHandling.printError(ctx, "Can't use a Java reserved name as a list name");
         return false;
      }

      declared_lists.put(ctx.ID().getText(), ctx.dataType(0).type);

      return res;
   }

   @Override
   public Boolean visitIndexExpression(dimanaParser.IndexExpressionContext ctx) {
      if (isReservedName(ctx.ID(0).getText()) || isReservedName(ctx.ID(1).getText())) {
         ErrorHandling.printError(ctx, "Can't use a Java reserved name as a list name or index name");
         return false;
      }

      ctx.varName = ctx.ID(0).getText();

      return true;
   }

   @Override
   public Boolean visitAddSubExpression(dimanaParser.AddSubExpressionContext ctx) {
      Boolean res = visit(ctx.expression(0)) && visit(ctx.expression(1));
      
      if ((ctx.expression(0).dimension.equals("real") && ctx.expression(1).dimension.equals("integer")) 
      || (ctx.expression(0).dimension.equals("integer") && ctx.expression(1).dimension.equals("real"))){
         ctx.dimension = "real";
         return res;
      }
      
      
      if (!(ctx.expression(0).dimension.equals(ctx.expression(1).dimension))) {
         ErrorHandling.printError(ctx, "Trying to add/subtract variables of different dimensions {" + ctx.expression(0).dimension + "} and {" + ctx.expression(1).dimension +"}");
         return false;
      }
      ctx.dimension = ctx.expression(0).dimension; // qualquer um deles dá, tem de ser iguais ja compilou direito

      return res;
   }

   @Override
   public Boolean visitRealLiteral(dimanaParser.RealLiteralContext ctx) {
      ctx.dimension = "real";
      Boolean res = true;
      return res;
   }

   @Override
   public Boolean visitTypeConversion(dimanaParser.TypeConversionContext ctx) {
      Boolean res = visit(ctx.expression()) && visit(ctx.dataType());
      String convert_type = ctx.dataType().type;
      if (convert_type.equals("real")) {
         try {
            Double.parseDouble(ctx.expression().getText());
            ctx.dimension = "real";
         } catch (NumberFormatException e) {

            if (ctx.expression().dimension.equals("integer") || ctx.expression().dimension.equals("real")) {
               ctx.dimension = "real";
               return true;
            }

            else {
            ErrorHandling.printError(ctx, "Trying to convert a non-numeric value to real");
            return false;
         }
         }
      } else if (convert_type.equals("string")) {
         ctx.dimension = "string";
         return true; // any value can be converted to a string
      } else {
         try {
            Integer.parseInt(ctx.expression().getText());
            ctx.dimension = "integer";
         } catch (NumberFormatException e) {
            if (ctx.expression().dimension.equals("integer") || ctx.expression().dimension.equals("real")) {
               ctx.dimension = "real";
               return true;
            } else {
               ErrorHandling.printError(ctx, "Trying to convert a non-numeric value to integer");
               return false;
            }
         }
      }

      return res;
   }

   @Override
   public Boolean visitStringLiteral(dimanaParser.StringLiteralContext ctx) {
      ctx.dimension = "string";
      Boolean res = true;
      return res;
   }

   @Override
   public Boolean visitIdExpression(dimanaParser.IdExpressionContext ctx) {
      Boolean res = true;

      if (isReservedName(ctx.ID().getText())) {
         ErrorHandling.printError(ctx,
               "Can't use a Java reserved name as a variable name");
         return false;
      }

      if (declared_vars.containsKey(ctx.ID().getText())) {
         try {
            ctx.dimension = declared_vars.get(ctx.ID().getText()); // its a variable
         } catch (Exception e) {
            ctx.dimension = declared_lists.get(ctx.ID().getText()); // its a list
         }
         return res;
      }

      ctx.dimension = ctx.ID().getText();
   
      if (varMap.containsKey(ctx.dimension)) {
         if (varMap.get(ctx.dimension).get(1).contains("*") || varMap.get(ctx.dimension).get(1).contains("/")) {
            ctx.dimension = "(" + varMap.get(ctx.dimension).get(1) + ")";
         }

      }

      return res;
   }

   @Override
   public Boolean visitParenExpression(dimanaParser.ParenExpressionContext ctx) {
      Boolean res = visit(ctx.expression());
      ctx.dimension = ctx.expression().type;
      return res;
   }

   @Override
   public Boolean visitConditionalExpression(dimanaParser.ConditionalExpressionContext ctx) {

      Boolean res = visit(ctx.e1) && visit(ctx.e2);
      String dim_1 = ctx.e1.dimension;
      String dim_2 = ctx.e2.dimension;

      if (dim_1.equals("string") || dim_2.equals("string")) {
         if (!ctx.op.getText().equals("==") && !ctx.op.getText().equals("!=")) {
            ErrorHandling.printError(ctx, "Trying to compare strings with a non-equality operator ( > or < )");
            return false;
         }
      }

      if (!dim_1.equals(dim_2)) {
         if ((dim_1.equals("real") && dim_2.equals("integer")) || (dim_1.equals("integer") && dim_2.equals("real"))) {
            // comparação entre inteiros e reais
            return true;
         } else { // comparação entre expressões de dimensões diferentes
            ErrorHandling.printError(ctx, "Trying to compare two variables of diferent dimensions");
            return false;
         }
      }

      return res;
   }

/*    @Override
   public Boolean visitIfBlock(dimanaParser.IfBlockContext ctx) {
      
      return visitChildren(ctx);
   }

   @Override
   public Boolean visitElseBlock(dimanaParser.ElseBlockContext ctx) {
      
      return visitChildren(ctx);
   } */

   @Override
   public Boolean visitConditional(dimanaParser.ConditionalContext ctx) {
      dimanaParser.IfBlockContext ifblock = ctx.ifBlock();

      if (!(ifblock.expression() instanceof dimanaParser.ConditionalExpressionContext)) {
         ErrorHandling.printError(ctx, "Conditional expression in if loop must be a boolean expression");
         return false;
      }

      return true;
   }

   @Override
   public Boolean visitAndOrExpression(dimanaParser.AndOrExpressionContext ctx) {
      for (dimanaParser.ExpressionContext expr_context : ctx.expression()) {
         if (!(expr_context instanceof dimanaParser.ConditionalExpressionContext)) {
            ErrorHandling.printError(ctx, "Conditional expression must be a boolean expression");
            return false;
         }
      }

      return true;
   }

   @Override
   public Boolean visitWhileStatement(dimanaParser.WhileStatementContext ctx) {
      if (!(ctx.expression() instanceof dimanaParser.ConditionalExpressionContext)) {
         ErrorHandling.printError(ctx, "Conditional expression in while loop must be a boolean expression");
         return false;
      }

      return true;
   }

   @Override
   public Boolean visitDoWhileStatement(dimanaParser.DoWhileStatementContext ctx) {
      if (!(ctx.expression() instanceof dimanaParser.ConditionalExpressionContext)) {
         ErrorHandling.printError(ctx, "Conditional expression in do while loop must be a boolean expression");
         return false;
      }

      return true;
   }

   @Override
   public Boolean visitIntLiteral(dimanaParser.IntLiteralContext ctx) {
      ctx.dimension = "integer";
      Boolean res = true;
      return res;
   }

   @Override
   public Boolean visitMulDivExpression(dimanaParser.MulDivExpressionContext ctx) {

      Boolean res = visit(ctx.expression(0)) && visit(ctx.expression(1));

      String dimension_1 = ctx.expression(0).dimension;
      String dimension_2 = ctx.expression(1).dimension;
      String operator = ctx.op.getText();

      if (dimension_1.equals("invalid") || dimension_2.equals("invalid")) {
         ErrorHandling.printError(ctx, "Trying to multiply/divide an invalid expression");
         return false;
      }

      if (dimension_1.equals("integer") && dimension_2.equals("integer")) {
         ctx.dimension = "integer";
         return res;
      }

      if (dimension_1.equals("real") && dimension_2.equals("real")) {
         ctx.dimension = "real";
         return res;
      }

      if (dimension_1.equals("integer") || dimension_1.equals("real")) {
         // operation between a number and a unit , will return to visitAssignment or visitAlternativeUnit such as 2 * meter , or for the alternative units , 0.2345 * meter

         for (String s : varMap.keySet()) {
            if (varMap.get(s).size() == 3) { // size() of "dimensions" string,real,integer is always 1, need to avoid those
               if (varMap.get(s).get(1).equals(dimension_2)) // normal units
               {
                  ctx.dimension = s;
               }
            }
         }

         if (ctx.dimension == null) {
            for (String s : varMap.keySet()) {
               // find the dimension of the 2nd expression , for example, find dimension Length for unit meter
               if (varMap.get(s).size() == 3) { // size() of "dimensions" string,real,integer is always 1, need to avoid those
                  if (varMap.get(s).get(1).equals(conversions.get(dimension_2).get(1))) { // normal units
                     ctx.dimension = s;
                  }
               }
            }
         }
      } else if (declared_vars.containsKey(dimension_1) || declared_vars.containsKey(dimension_2)) {
         // operation that involves a variable and a unit, will return to visitAssignment in this case the dimension variables may be the naem of the variables being used
         dimension_1 = declared_vars.get(dimension_1);
         dimension_2 = declared_vars.get(dimension_2);
         String resulting_dimension = null;

         for (String dim : varMap.keySet()) {
            if (varMap.get(dim).size() != 1) { // skip real integer string default types, they have size 1
               if (varMap.get(dim).get(1).equals(dimension_1 + operator + dimension_2)) {
                  resulting_dimension = dim;
               }
            }
         }

         if (!dimension_1.equals(dimension_2)) {

            if (resulting_dimension == null) {
               // multiplications/divisions between variables of different dimensions will only be allowed if the resulting dimension is already defined
               ErrorHandling.printError(ctx,
                     "Trying to multiply/divide variables of different dimensions " + "{" + dimension_1 + "}" + " and "
                           + "{" + dimension_2 + "}\nThe resulting dimension would be " + "{" + dimension_1 + operator
                           + dimension_2 + "}" + " but it is not defined");
            } else {
               ctx.dimension = resulting_dimension;
            }
         }

      } else { // assign of a new dependant unit, will return to visitDependantUnit

         String full_dim = dimension_1 + operator + dimension_2;
         full_dim = full_dim.replaceAll("[()]", "");

         String[] split_dim = full_dim.split("[/*]");

         for (String dim : split_dim) {

            if (!varMap.containsKey(dim)) {
               ErrorHandling.printError(ctx,
                     "Dimension {" + dim + "} is trying to be used but does not exist ( not declared )");
            }
         }

         ctx.dimension = dimension_1 + operator + dimension_2;

         String default_type = varMap.get(split_dim[0]).get(0); // default datatype for when expression will cancel out and result in a

         ctx.dimension = dimensionDivision(ctx.dimension, default_type).toString(); // reduce the fraction of dimensions
      }
      return res;
   }

   private static String dimensionDivision(String equation, String default_type) {
      List<String> numerador = new ArrayList<String>();
      List<String> denominador = new ArrayList<String>();
      List<String> dimensions = new ArrayList<String>();
      List<String> operations = new ArrayList<String>();

      dimensions.addAll(Arrays.asList(equation.split("[/*()]")));
      dimensions.removeAll(Arrays.asList("", null));
      operations.addAll(Arrays.asList(equation.split("[0-9a-zA-Z]+")));
      operations.removeAll(Arrays.asList("", null));
      boolean inverted = false;

      numerador.add(dimensions.get(0));
      int dim_index = 1;
      for (String op : operations) {
         if (op.matches("[)]{0,}[/]")) {
            if (!inverted) {
               denominador.add(dimensions.get(dim_index));
            } else {
               numerador.add(dimensions.get(dim_index));
            }
            dim_index++;
         } else if (op.matches("[)]{0,}[*][(]{0,}")) {
            if (!inverted) {
               numerador.add(dimensions.get(dim_index));
            } else {
               denominador.add(dimensions.get(dim_index));
            }
            dim_index++;
         } else if (op.matches("[/][(]{0,}")) {
            if (inverted) {
               inverted = false;
            } else {
               inverted = true;
            }
            if (!inverted) {
               numerador.add(dimensions.get(dim_index));
            } else {
               denominador.add(dimensions.get(dim_index));
            }
            dim_index++;
         }
      }

      List<String> temp = new ArrayList<String>(denominador);
      for (String dim : temp) {
         if (numerador.contains(dim)) {
            numerador.remove(dim);
            denominador.remove(dim);
         }
      }

      StringBuilder final_str = new StringBuilder();
      for (String dim : numerador) {
         final_str.append(dim);
         final_str.append("*");
      }

      if (final_str.length() == 0) {
         return default_type;
      }

      final_str.deleteCharAt(final_str.length() - 1);
      if (denominador.size() > 0) {
         final_str.append("/");
         if (denominador.size() > 1) {
            final_str.append("(");
         }
         for (String dim : denominador) {
            final_str.append(dim);
            final_str.append("*");
         }
         final_str.deleteCharAt(final_str.length() - 1);
         if (denominador.size() > 1) {
            final_str.append(")");
         }
      }
      // clear all arrays
      numerador.clear();
      denominador.clear();
      dimensions.clear();
      operations.clear();

      return final_str.toString();
   }

   @Override
   public Boolean visitDataType(dimanaParser.DataTypeContext ctx) {
      ctx.type = ctx.getText();
      return true;
   }

   @Override
   public Boolean visitCastTypes(dimanaParser.CastTypesContext ctx) {
      Boolean res = true;
      return res;
   }

   @Override
   public Boolean visitProgram(dimanaParser.ProgramContext ctx) {
      // add the default types/dimensions for verification purposes

      varMap.put("string", new ArrayList<String>() {
         {
            add("string");
         }
      });
      varMap.put("real", new ArrayList<String>() {
         {
            add("real");
         }
      });
      varMap.put("integer", new ArrayList<String>() {
         {
            add("integer");
         }

      });

      return visitChildren(ctx);
   }

   // nothing to be checked here
   @Override
   public Boolean visitLength(dimanaParser.LengthContext ctx) {
      Boolean res = true;
      return res;
   }

   // nothing to be checked here
   @Override
   public Boolean visitWrite_expr(dimanaParser.Write_exprContext ctx) {
      Boolean res = true;
      return res;
   }

   private static Boolean isReservedName(String variableName) {
      Set<String> reservedKeywords = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto",
            "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"));

      return reservedKeywords.contains(variableName);
   }
}
