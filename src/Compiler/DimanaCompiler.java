
import java.util.*;

import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.RuleContext;

@SuppressWarnings("CheckReturnValue")
public class DimanaCompiler extends dimanaBaseVisitor<ST> {

   private STGroup templates = new STGroupFile("dimana.stg"); // stg file to be used
   private int varCount = 0; // variable counter
   HashMap<String, ArrayList<String>> varMap = new HashMap<String, ArrayList<String>>();
   // usem este array para guardar as coisas sobre variaveis/dimensoes
   // por exemplo --> {Length : [real, meter, m], ...}

   HashMap<String, ArrayList<String>> conversions = new HashMap<>();
   // vai guardar por exemplo --> {inch : ["0.0254", "meter"], ...}

   HashMap<String, String> declared_vars = new HashMap<String, String>();
   // guardar as variaveis -----> {l : Length}

   HashMap<String, ArrayList<String>> dependent_units = new HashMap<String, ArrayList<String>>();
   private static HashMap<String, String> declared_lists = new HashMap<String, String>();
   // guardar dependencias das unidades dependentes
   // p.ex Volume -> [Length, Length, Length]
   int temp_var_counter = 1;

   public DimanaCompiler(HashMap<String, ArrayList<String>> dependent_units, HashMap<String, ArrayList<String>> varMap,
         HashMap<String, ArrayList<String>> conversions, HashMap<String, String> declared_vars,
         HashMap<String, String> declared_lists) {
      this.varMap = varMap;
      this.conversions = conversions;
      this.declared_vars = declared_vars;
      this.dependent_units = dependent_units;
      this.declared_lists = declared_lists;
   }

   ArrayList<String> default_types = new ArrayList<String>() {
      {
         add("integer");
         add("real");
         add("string");
      }
   };

   @Override
   public ST visitProgram(dimanaParser.ProgramContext ctx) {
      ST res = templates.getInstanceOf("module");
      res.add("stat", visit(ctx.statList()));
      return res;
   }

   @Override
   public ST visitStatList(dimanaParser.StatListContext ctx) {
      ST res = templates.getInstanceOf("stats");
      for (dimanaParser.StatementContext sc : ctx.statement())
         res.add("stat", visit(sc));
      return res;
   }

   @Override
   public ST visitDependantUnit(dimanaParser.DependantUnitContext ctx) {
      String dimension_name = ctx.ID(0).getText();
      String dataType = ctx.dataType().getText();
      String expression = visit(ctx.expression()).render();

      // dependant units that have suffix provided are already defined in the semantic
      // analysis

      // when there is no suffix provided, we will calculate it ourselves based on the
      // units that the dimension is dependent on
      if (ctx.ID(2) == null) {

         String expressao_variavel = expression;
         String unit_dependency = expressao_variavel.replace(";", "");
         String[] dimParts = unit_dependency.split("(?<=[*|/|+|-])|(?=[*|/|+|-])");

         dependent_units.put(dimension_name, new ArrayList<String>() {
            {
               add(unit_dependency);
            }
         });

         StringBuilder sb = new StringBuilder();

         // calcular a unidade SI da dimensão dependente a partir das unidades SI das dimensões a que está associada
         for (int i = 0; i < dimParts.length; i++) {
            if (dimParts[i].equals("*") || dimParts[i].equals("/") || dimParts[i].equals("+")
                  || dimParts[i].equals("-"))
               sb.append(dimParts[i]);
            else {
               sb.append(varMap.get(dimParts[i]).get(2));
            }
         }

         // add the unit with the suffix created to the hashmap
         varMap.put(dimension_name, new ArrayList<String>() {
            {
               add(dataType);
               add(unit_dependency);
               add(sb.toString());
            }
         });

      }
      return null;
   }

   @Override
   public ST visitVariableDeclaration(dimanaParser.VariableDeclarationContext ctx) {
      // NMEC n (dataType ID )
      visit(ctx.dataType());
      String id = ctx.ID().getText();
      String expression = "";
      // so se tem dataType e id garantidos, a expression é opcional

      if (ctx.expression() != null) {
         expression = ctx.expression().getText(); // expressions mal feitas são verificadas na semantica
      }

      ST variable_declaration = null;

      if (ctx.dataType().type.equals("string") || ctx.dataType().type.equals("real")
            || ctx.dataType().type.equals("integer")) {
         if (ctx.expression() != null) {
            variable_declaration = templates.getInstanceOf("decl_value");
            variable_declaration.add("type", ctx.dataType().type);
            variable_declaration.add("var", id);
            if (ctx.expression() instanceof dimanaParser.Get_array_idxContext) {
               visit(ctx.expression());
               variable_declaration.add("assign1", visit(ctx.expression()).render());
               variable_declaration.add("value", ctx.expression().varName);
            } else {
               variable_declaration.add("value", expression);
            }
         } else {
            variable_declaration = templates.getInstanceOf("decl");
            variable_declaration.add("type", ctx.dataType().type);
            variable_declaration.add("var", id);
         }

      } else {

         if (expression.isEmpty()) { // não é dado um valor inicial
            variable_declaration = templates.getInstanceOf("declare_var");
            variable_declaration.add("unit", ctx.dataType().type);
            variable_declaration.add("name", id);

            // avoid the default variables in varMap, string real or integer, that only have size 1
            if (varMap.get(ctx.dataType().type).size() == 3) {
               String suffix = varMap.get(ctx.dataType().type).get(2);
               variable_declaration.add("suffix", suffix);

            }

         } else { // é dado um valor inicial ( expression )
            variable_declaration = templates.getInstanceOf("declare_var_with_value");
            variable_declaration.add("unit", ctx.dataType().type);
            variable_declaration.add("name", id);
            variable_declaration.add("assign1", visit(ctx.expression()).render());
            variable_declaration.add("value", ctx.expression().varName);

            if (ctx.dataType().type.equals("String")) {
               ctx.dataType().type = "string";
            }

            if (varMap.get(ctx.dataType().type).size() == 3) {
               String suffix = varMap.get(ctx.dataType().type).get(2);
               variable_declaration.add("suffix", suffix);
            }
         }
      }
      return variable_declaration;
   }

   @Override
   public ST visitInputStatement(dimanaParser.InputStatementContext ctx) {
      if (ctx.dataType() != null) { // vai ser feito cast
         visit(ctx.dataType());
         String var_dataType = ctx.dataType().type;

         String var_name = ctx.ID(0).getText();
         String unidade_dimensão = ctx.ID(1).getText();
         String dimensão = "";
         for (String s : varMap.keySet()) {
            if (varMap.get(s).contains(unidade_dimensão)) {
               dimensão = s;
               break;
            }
         }

         ST read_and_cast = templates.getInstanceOf("read_and_cast");
         read_and_cast.add("type", var_dataType);
         read_and_cast.add("var", var_name);
         // read_and_cast.add("dimension", dimensão);
         read_and_cast.add("temp", temp_vars());
         return read_and_cast;

      } else { // não vai ser feito um cast diretamente ( é uma string)
         String nome_var = ctx.ID(0).getText();
         ST read = templates.getInstanceOf("read");
         read.add("var", nome_var);
         read.add("temp", temp_vars());
         return read;
      }
   }

   @Override
   public ST visitOutputStatement(dimanaParser.OutputStatementContext ctx) {

      int print_amount = ctx.outputFormat().size();
      ST print = null;
      StringBuilder sb = new StringBuilder();
      String write_expr = ctx.write_expr().getText();
      if (write_expr.equals("writeln"))
         print = templates.getInstanceOf("println");
      else
         print = templates.getInstanceOf("print");

      // iterate all of the expressions to print
      for (int i = 0; i < print_amount; i++) {

         String to_print = visit(ctx.outputFormat(i)).render();

         if (i == print_amount - 1) { // last expression to print
            sb.append(to_print);
         } else {
            sb.append(to_print + " + ");
         }
      }
      print.add("value", sb.toString());
      return print;

   }

   public String convert_Types(String type) {
      if (type.equals("real"))
         return "double";
      else if (type.equals("string"))
         return "string";
      else
         return "integer";
   }

   @Override
   public ST visitListDeclaration(dimanaParser.ListDeclarationContext ctx) {

      visit(ctx.dataType(0));

      String datatype = ctx.dataType(0).type;
      ST list = null;
      String list_name = ctx.ID().getText();

      if (!default_types.contains(datatype)) {
         // verificar se já existe uma lista com este nome maybe?
         list = templates.getInstanceOf("declare_list_dvar"); // declare list for declared dimensions
         list.add("var", list_name);
         list.add("type", "DimensionVar");
         list.add("unit", datatype);
      }

      else {
         // verificar se já existe uma lista com este nome maybe?
         list = templates.getInstanceOf("declare_list_dtypes"); // declare list for default types, real integer string
         list.add("var", list_name);
         list.add("type", datatype);
      }

      return list;

   }

   @Override
   public ST visitGet_array_idx(dimanaParser.Get_array_idxContext ctx) {

      String array_name = ctx.ID().getText();
      String idx = ctx.INT().getText();
      String array_datatype = varMap.get(declared_lists.get(array_name)).get(0);
      String array_dimension = declared_lists.get(array_name);
      ST res = templates.getInstanceOf("get_array_idx");

      ctx.varName = newVar();
      res.add("type", array_datatype);
      res.add("var", ctx.varName);

      if (array_dimension.equals("String"))
         array_dimension = "string";

      if (array_dimension.equals("real") || array_dimension.equals("integer") || array_dimension.equals("string")) {
         res.add("array", array_name);
         res.add("idx", idx);
      } else {
         res.add("array", array_name);
         res.add("idx", idx);
         res.add("flag", "true");
      }

      return res;
   }

   @Override
   public ST visitAssignment(dimanaParser.AssignmentContext ctx) {

      String nome_var = ctx.ID().getText();
      String var_dimension = declared_vars.get(nome_var);
      String var_type = varMap.get(var_dimension).get(0);
      ST res = null;

      if (var_dimension.equals("real") || var_dimension.equals("integer")) { // integers ou reais
         res = templates.getInstanceOf("assign_2");
         res.add("initial_var", visit(ctx.expression()).render());
         res.add("var", nome_var);
         res.add("varName", ctx.expression().varName);
      } else { // qualquer dimensão
         res = templates.getInstanceOf("assign_1");
         res.add("initial_var", visit(ctx.expression()).render());
         res.add("type", var_type);
         res.add("var", nome_var);
         res.add("varName", ctx.expression().varName);
      }

      return res;
   }

   @Override
   public ST visitOutputFormat(dimanaParser.OutputFormatContext ctx) {
      ST res = null;

      if (ctx.getChildCount() == 1) {
         // Option: ID

         if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            String var_dimension = declared_vars.get(id); // get the dimension of this variable

            if (var_dimension.equals("String"))
               var_dimension = "string";

            if (var_dimension.equals("real")
                  || var_dimension.equals("integer")
                  || var_dimension.equals("string")) { // print de uma variavel integer/real

               res = templates.getInstanceOf("stats");
               res.add("stat", id);
               return res;
            } else { // print de uma variavel de qualquer dimensão

               res = templates.getInstanceOf("var_get_nostring");
               String var_datatype = varMap.get(declared_vars.get(id)).get(0);
               res.add("var", id);
               res.add("type", var_datatype);
               return res;
            }
         } else { // write just a normal string
            res = templates.getInstanceOf("stats");
            res.add("stat", ctx.STRING().getText());
            return res;

         }

      } else if (ctx.getChildCount() == 3) {
         // Option: STRING ',' ID

         String str = ctx.STRING().getText();
         String id = ctx.ID().getText();
         String var_dimension = declared_vars.get(id); // get the dimension of this variable

         if (var_dimension.equals("String"))
            var_dimension = "string";

         if (var_dimension.equals("real") || var_dimension.equals("integer") || var_dimension.equals("string")) {
            res = templates.getInstanceOf("stats");
            res.add("stat", id);
            return res;
         }

         else { // print de uma string + variavel de qualquer dimensão

            res = templates.getInstanceOf("var_get");
            String var_datatype = varMap.get(declared_vars.get(id)).get(0);
            res.add("str", str);
            res.add("var", id);
            res.add("type", var_datatype);
            return res;
         }

      } else if (ctx.getChildCount() == 6) {
         // Option: 'string' '(' (ID | STRING | expression) ',' INT ')'

         if (ctx.ID() != null) { // print de variável right-aligned
            String id = ctx.ID().getText();
            res = templates.getInstanceOf("var_get_RA");
            String var_datatype = varMap.get(declared_vars.get(id)).get(0);
            String var_dimension = declared_vars.get(id); // get the dimension of this variable

            if (var_dimension.equals("String"))
               var_dimension = "string";

            if (var_dimension.equals("real") || var_dimension.equals("integer") || var_dimension.equals("string")) {
               res = templates.getInstanceOf("stats");
               res.add("stat", "String.format(\"%" + ctx.INT().getText() + "s\" , " + id + ")");
               return res;
            }

            res.add("var", id);
            res.add("type", var_datatype);
            res.add("length", ctx.INT().getText());

            return res;
         }
         if (ctx.STRING() != null) { // print de string right-aligned
            String str = ctx.STRING().getText();
            res = templates.getInstanceOf("string_RA");
            res.add("string", str);
            res.add("length", ctx.INT().getText());

            return res;
         }
         if (ctx.expression() != null) {

            if (ctx.expression() instanceof dimanaParser.IndexExpressionContext) {
               dimanaParser.IndexExpressionContext array = (dimanaParser.IndexExpressionContext) ctx.expression();
               String type = varMap.get(declared_lists.get(array.ID(0).getText())).get(0);
               String dimension = declared_lists.get(array.ID(0).getText());

               if (dimension.equals("String"))
                  dimension = "string";
               if (type.equals("String"))
                  type = "string";

               if (dimension.equals("string") || dimension.equals("real") || dimension.equals("integer")) {
                  res = templates.getInstanceOf("arrayidx_getRA_nonvar");
                  res.add("var", array.ID(0).getText());
                  res.add("idx", array.ID(1).getText());
                  res.add("length", ctx.INT().getText());
               } else {
                  res = templates.getInstanceOf("arrayidx_getRA_var");
                  res.add("var", array.ID(0).getText());
                  res.add("idx", array.ID(1).getText());
                  res.add("length", ctx.INT().getText());
                  res.add("type", type);
               }

               return res;

            } else { // print de uma expressão qualquer
               res = templates.getInstanceOf("expr_getRA");
               res.add("expr", visit(ctx.expression()).render());
               res.add("length", ctx.INT().getText());

               return res;
            }
         }

      }
      return res;
   }

   /* @Override
   public ST visitWrite_expr(dimanaParser.Write_exprContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   } */

   public String temp_vars() {
      return "temp" + temp_var_counter++;
   }

   @Override
   public ST visitStatement(dimanaParser.StatementContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   }

   /* @Override
   public ST visitHeaderFile(dimanaParser.HeaderFileContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   }

   @Override
   public ST visitPrefixUnit(dimanaParser.PrefixUnitContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   }

   @Override
   public ST visitAlternativeUnit(dimanaParser.AlternativeUnitContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   }

   @Override
   public ST visitIndexExpression(dimanaParser.IndexExpressionContext ctx) {
      ST res = null;
      return visitChildren(ctx);
   } */

   @Override
   public ST visitAddSubExpression(dimanaParser.AddSubExpressionContext ctx) {
      ST res = null;

      ctx.varName = newVar();

      String op = ctx.op.getText();
      visit(ctx.expression(0));
      visit(ctx.expression(1));
      String operando1 = ctx.expression(0).getText();
      String operando2 = ctx.expression(1).getText();

      String var_type = varMap.get(declared_vars.get(operando1.split("[+-]")[0])).get(0);

      res = templates.getInstanceOf("assign_dvar");
      res.add("var_name", ctx.varName);

      if (ctx.expression(0).dimension.equals("string") || ctx.expression(0).dimension.equals("real")
            || ctx.expression(0).dimension.equals("integer")) {
         res.add("operando1", operando1);
      } else {
         res.add("operando1", operando1);
         res.add("flag1", "true");
      }
      if (ctx.expression(1).dimension.equals("string") || ctx.expression(1).dimension.equals("real")
            || ctx.expression(1).dimension.equals("integer")) {
         res.add("operando2", operando2);
      } else {
         res.add("operando2", operando2);
         res.add("flag2", "true");
      }
      res.add("dataType", var_type);
      res.add("operacao", op);

      return res;
   }

   @Override
   public ST visitReadToArray(dimanaParser.ReadToArrayContext ctx) {
      ST input = templates.getInstanceOf("read_toArray"); // its a string
      if (ctx.castTypes() != null) {
         input = templates.getInstanceOf("read_and_cast_toArray");
         input.add("type", ctx.castTypes().getText());
         if (ctx.ID(0) != null && ctx.ID(1) != null) { // cast to dimension default value
            input.add("var", ctx.ID(1).getText());
            String dimension = "";
            for (String s : varMap.keySet()) {
               if (varMap.get(s).contains(ctx.ID(0).getText())) {
                  dimension = s;
                  break;
               }
            }
            input.add("dimension", dimension);
         } else
            input.add("var", ctx.ID(0).getText());
         input.add("temp", temp_vars());
         input.add("temp2", temp_vars());
      } else {
         if (ctx.ID(0) != null && ctx.ID(1) != null)
            input.add("var", ctx.ID(1).getText());
         else
            input.add("var", ctx.ID(0).getText());
         input.add("temp", temp_vars());
         input.add("temp2", temp_vars());
      }
      return input;
   }

   @Override
   public ST visitTypeConversion(dimanaParser.TypeConversionContext ctx) {
      ST res = null;

      String varName = ctx.expression().getText();
      String value = visit(ctx.expression()).render();

      // deal with sums and other operations in the name of the variable
      if (varName.split("[/*+-]").length > 1) {
         varName = value.split(";")[1];
         varName = varName.split("=")[0];
         varName = varName.replace("\n", "");
      }

      String type = ctx.dataType().type;

      switch (type) {
         case "integer":
            res = templates.getInstanceOf("conversionToInt");
            break;
         case "real":
            res = templates.getInstanceOf("conversionToDouble");
            break;
         case "string":
            res = templates.getInstanceOf("conversionToString");
            break;
      }
      res.add("assign1", value.split("\n")[0]);
      res.add("assign2", value.split("\n")[1]);
      ctx.varName = newVar();
      res.add("name", ctx.varName);
      res.add("value", varName);

      return res;
   }

   /* @Override
   public ST visitParenExpression(dimanaParser.ParenExpressionContext ctx) {
      ST res = null;

      return visitChildren(ctx);
   } */

   @Override
   public ST visitIdExpression(dimanaParser.IdExpressionContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.varName = newVar();

      try {
         String dimension = declared_vars.get(ctx.ID().getText());
         String datatype = varMap.get(dimension).get(0);
         datatype = typeConvert(datatype);
         res.add("stat", datatype + " " + ctx.varName + " = " + ctx.ID().getText() + ";");
         // retorna String var = value; e define o ctx.varName (var) pra usar acima
         ctx.dimension = dimension;
      } catch (NullPointerException e){ // sufixos
      }
      return res;
   }

   public ST visitIntSuffix(dimanaParser.IntSuffixContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.varName = newVar();
      res.add("stat", "int " + ctx.varName + " = " + ctx.INT().getText() + ";");
      // retorna int var = value; e define o ctx.varName (var) pra usar acima
      ctx.dimension = "integer";
      return res;
   }

   public ST visitRealSuffix(dimanaParser.RealSuffixContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.varName = newVar();
      res.add("stat", "double " + ctx.varName + " = " + ctx.REAL().getText() + ";");
      // retorna int var = value; e define o ctx.varName (var) pra usar acima
      ctx.dimension = "real";
      return res;
   }

   public static String typeConvert(String type) {
      switch (type) {
         case "integer":
            return "int";
         case "real":
            return "double";
         case "string":
            return "String";
         default:
            return "void";
      }
   }

   @Override
   public ST visitIntLiteral(dimanaParser.IntLiteralContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.varName = newVar();
      res.add("stat", "int " + ctx.varName + " = " + ctx.INT().getText() + ";");
      // retorna int var = value; e define o ctx.varName (var) pra usar acima
      ctx.dimension = "integer";
      return res;
   }

   @Override
   public ST visitStringLiteral(dimanaParser.StringLiteralContext ctx) {
      ST res = null;
      ctx.varName = newVar();
      res.add("stat", "String " + ctx.varName + " = " + ctx.STRING().getText() + ";");
      ctx.dimension = "string";
      return res;
   }

   @Override
   public ST visitRealLiteral(dimanaParser.RealLiteralContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.varName = newVar();
      res.add("stat", "double " + ctx.varName + " = " + ctx.REAL().getText() + ";");
      ctx.dimension = "real";
      return res;
   }

   @Override
   public ST visitConditionalExpression(dimanaParser.ConditionalExpressionContext ctx) {
      ST res = templates.getInstanceOf("stats");

      String expr1 = visit(ctx.expression(0)).render(); // assign , pra por logo no inicio do stg
      String expr2 = visit(ctx.expression(1)).render(); // assign , pra por logo no inicio do stg
      String var1 = ctx.expression(0).varName; // agora a condição vai ser uma comparação entre duas variaveis que tem o
                                               // valor assigned acima
      String var2 = ctx.expression(1).varName; // agora a condição vai ser uma comparação entre duas variaveis que tem o
                                               // valor assigned acima
      String op = ctx.op.getText();

      res.add("stat", expr1); // assign da primeira expressão
      res.add("stat", expr2); // assign da segunda expressão
      res.add("stat", var1 + op + var2); // isto vai ser do tipo x > y , agora é so dar wrap em if (x > y) { ... }

      // o retorno desta função é do tipo
      // int v = 3
      // int y = 4
      // y > v
      return res;
   }

   /* @Override
   public ST visitIfBlock(dimanaParser.IfBlockContext ctx) {

      return visitChildren(ctx);
   }

   @Override
   public ST visitElseBlock(dimanaParser.ElseBlockContext ctx) {

      return visitChildren(ctx);
   } */

   @Override
   public ST visitConditional(dimanaParser.ConditionalContext ctx) {

      ST res = templates.getInstanceOf("ifcondicion");

      dimanaParser.IfBlockContext ifblock = ctx.ifBlock(); // list of all if's
      dimanaParser.ElseBlockContext elseblock = ctx.elseBlock(); // else block

      String condition = visit(ifblock.expression()).render();
      int ifblock_amount = ifblock.statement().size();
      String if_statements = "";
      String else_statements = "";

      for (int i = 0; i < ifblock_amount; i++) {
         if_statements += visit(ifblock.statement(i)).render() + "\n";
      }

      if (elseblock != null) {
         int elseblock_amount = elseblock.statement().size();

         for (int i = 0; i < elseblock_amount; i++) {
            else_statements += visit(elseblock.statement(i)).render() + "\n";
         }
      }

      String[] split_conds = condition.split(";");

      res.add("assign1", split_conds[0] + ";");
      res.add("assign2", split_conds[1] + ";");
      res.add("cond", split_conds[2]);
      res.add("statementsTrue", if_statements);
      res.add("statementsFalse", else_statements);

      return res;
   }

   /* @Override
   public ST visitAndOrExpression(dimanaParser.AndOrExpressionContext ctx) {
      ST res = templates.getInstanceOf("");

      return visitChildren(ctx);
   } */

   @Override
   public ST visitLoopStatement(dimanaParser.LoopStatementContext ctx) {

      int expression_amount = ctx.statement().size(); // amount of expressions/statements inside the for loop
      ST loop_statement = templates.getInstanceOf("for_loop");
      boolean is_length;
      String for_loop_statements = "";
      String final_value = "";
      String initial_value;

      if (ctx.INT(1) != null) // final value of for loop is a INT
         final_value = ctx.INT(1).getText();

      if (ctx.ID(1) != null && ctx.ID(2) != null)
         final_value = ctx.ID(2).getText();

      if (ctx.INT(0) != null)
         final_value = ctx.ID(1).getText();

      if (ctx.length() != null)
         final_value = final_value + ".size()-1";

      for (int i = 0; i < expression_amount; i++) {
         for_loop_statements += visit(ctx.statement(i)).render() + "\n";
      }

      if (ctx.ID(1) != null && ctx.INT(0) == null && ctx.INT(1) == null) // initial value is a variable
         initial_value = ctx.ID(1).getText();
      else // initial value is a number
         initial_value = ctx.INT(0).getText();

      loop_statement.add("initial_value", initial_value);
      loop_statement.add("end_value", final_value);
      loop_statement.add("statements", for_loop_statements);

      // visit the expression
      return loop_statement;
   }

   @Override
   public ST visitBreakStatement(dimanaParser.BreakStatementContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", ctx.getText());
      return res;
   }

   @Override
   public ST visitContinueStatement(dimanaParser.ContinueStatementContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", ctx.getText());
      return res;
   }

   @Override
   public ST visitWhileStatement(dimanaParser.WhileStatementContext ctx) {
      ST while_loop = templates.getInstanceOf("while_loop");

      int breaks = 0;
      int continues = 0;

      int expression_amount = ctx.statement().size();
      String while_loop_statements = "";
      String condition = visit(ctx.expression()).render();

      for (int i = 0; i < expression_amount; i++) {
         String statement = visit(ctx.statement(i)).render();

         if (statement.equals("stop")) {
            breaks += 1;
         } else if (statement.equals("procede")) {
            continues += 1;
         } else {
            while_loop_statements += statement + "\n";
         }
      }

      String[] split_conds = condition.split(";");

      String var_to_regen = split_conds[2].split("[<>=!]+|==|!=")[0].replace("\n", "") + " = "
            + split_conds[0].split("=")[1].replace("[\n]", "") + ";";

      while_loop.add("assign1", split_conds[0]);
      while_loop.add("assign2", split_conds[1]);

      while_loop.add("cond", split_conds[2]);
      while_loop.add("regen_val", var_to_regen);
      while_loop.add("statements", while_loop_statements);

      return while_loop;
   }

   @Override
   public ST visitDoWhileStatement(dimanaParser.DoWhileStatementContext ctx) {
      ST do_while_loop = templates.getInstanceOf("do_while_loop");

      int breaks = 0;
      int continues = 0;

      int expression_amount = ctx.statement().size();
      String do_while_loop_statements = "";
      String condition = visit(ctx.expression()).render();

      for (int i = 0; i < expression_amount; i++) {
         String statement = visit(ctx.statement(i)).render();

         if (statement.equals("stop")) {
            breaks += 1;

         } else if (statement.equals("procede")) {
            continues += 1;
         } else {
            do_while_loop_statements += statement + "\n";
         }
      }

      String[] split_conds = condition.split(";");

      String var_to_regen = split_conds[2].split("[<>=!]+|==|!=")[0].replace("\n", "") + " = "
            + split_conds[0].split("=")[1].replace("[\n]", "") + ";";

      do_while_loop.add("assign1", split_conds[0]);
      do_while_loop.add("assign2", split_conds[1]);
      do_while_loop.add("regen_val", var_to_regen);
      do_while_loop.add("cond", split_conds[2]);
      do_while_loop.add("statements", do_while_loop_statements);
      if (breaks > 0)
         do_while_loop.add("break", "break;");
      if (continues > 0)
         do_while_loop.add("continue", "continue;");

      return do_while_loop;
   }

   @Override
   public ST visitMulDivExpression(dimanaParser.MulDivExpressionContext ctx) {

      ctx.varName = newVar();

      String temp = ctx.expression(0).getText() + ctx.op.getText() + ctx.expression(1).getText();

      String operando1 = ctx.expression(0).getText();
      String operando2 = ctx.expression(1).getText();

      if (declared_vars.containsKey(operando1) && declared_vars.containsKey(operando2)) { // operação entre variaveis
         String var_type = varMap.get(declared_vars.get(operando1)).get(0);
         ST assign_dvar = templates.getInstanceOf("assign_dvar");
         assign_dvar.add("var_name", ctx.varName);
         assign_dvar.add("operando1", operando1);
         assign_dvar.add("operando2", operando2);
         assign_dvar.add("dataType", var_type);
         assign_dvar.add("operacao", ctx.op.getText());

         // flags are used to see when its a dimension_var ( that needs method getValue<type> ) or a normal datatype ( real/integer ), which doesnt need this method.
         if (!(declared_vars.get(operando1).equals("integer") && declared_vars.get(operando1).equals("real")))
            assign_dvar.add("flag1", "true");

         if (!(declared_vars.get(operando2).equals("integer") && declared_vars.get(operando2).equals("real")))
            assign_dvar.add("flag2", "true");

         declared_vars.put(ctx.varName, temp);

         return assign_dvar;
      }

      if (bothAreStrings(operando1)) { // operação entre dimensões
         ST Return = templates.getInstanceOf("return");
         Return.add("value", temp);
         return Return;

      } else { // assign de uma variável a um escalar * dimensão OU definição de unidade alternativa

         // if the parent of this is the node from function visitAlternativeUnit

         if (ctx.getParent() instanceof dimanaParser.AlternativeUnitContext) { // definição de unidades alternativas já sao feitas na analise semantica, estão definidas no array associativo conversions
            return null;
         }

         ST var_setValue = templates.getInstanceOf("var_setValue");
         var_setValue.add("var", ctx.varName);
         String var_type = "";
         for (String s : varMap.keySet()) { // SI unit
            if (varMap.get(s).size() == 3) {
               if (varMap.get(s).get(1).equals(operando2))
                  var_type = varMap.get(s).get(0);
            }
         }

         if (var_type.equals("")) { // didnt get defined because its not the base unit
            String base_unit = conversions.get(operando2).get(1);
            String multiplier = conversions.get(operando2).get(0);
            for (String s : varMap.keySet()) {
               if (varMap.get(s).size() == 3) {
                  if (varMap.get(s).get(1).equals(base_unit))
                     var_type = varMap.get(s).get(0);
               }
            }
            String final_value = Double.parseDouble(operando1) + " * " + Double.parseDouble(multiplier);
            var_setValue.add("value", final_value);
         } else {
            var_setValue.add("value", operando1); // tou a assumir que é tipo sempre 3*meter e nunca meter*3
         }

         var_setValue.add("type", var_type);
         return var_setValue;
      }
   }

   public boolean bothAreStrings(String operand1) {
      // in this case, in a multiplication if the first operand is a String, they are  gonna be both Strings because there is only 1 case where this kind of multiplication happens and it is when defining a dependant dimension
      try {
         if ((Double) Double.parseDouble(operand1) instanceof Double) // parseDouble can parse integers aswell
            return false;
      } catch (NumberFormatException e) {
         return true;
      }
      return false;
   }

   @Override
   public ST visitDataType(dimanaParser.DataTypeContext ctx) {
      ctx.type = ctx.getText();
      return visitChildren(ctx);
   }

   private String newVar() {
      numVars++;
      return "v" + numVars;
   }

   private int numVars = 0;
}
