import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MCalculatorVisitorV2 extends CalculatorV2BaseVisitor<Integer>{
    /** To jest pamięć dla zmiennych aby móc przechowywać informacje o nich*/
    Map<String, Integer> memory = new HashMap<String, Integer>();
    /** Pamięć na funkcje (Nie chce mi się tego trzymać w jednej mapie) */
    Map<String, List<CalculatorV2Parser.StatContext>> functions = new HashMap<>();
    /** Rozpatrujemy tutaj operację przypisania wartości do zmiennej */
    @Override
    public Integer visitAssign(CalculatorV2Parser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
//        System.out.println("Debug");
//        System.out.println(value);
        return  value;
    }
    /** INT */
    @Override
    public Integer visitInt(CalculatorV2Parser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
    /** operacje * i / */
    @Override
    public Integer visitMulDiv(CalculatorV2Parser.MulDivContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.MUL -> {
                return left * right;
            }
            case CalculatorV2Lexer.DIV -> {
                return left / right;
            }
            default -> {
                return 0;
            }
        }

    }

    @Override
    public Integer visitId(CalculatorV2Parser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) return  memory.get(id);
        System.out.println("Undefined variable");
        return 0;
    }

    /** Operacje + i - */
    @Override
    public Integer visitAddSub(CalculatorV2Parser.AddSubContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.ADD -> {
                return left + right;
            }
            case CalculatorV2Lexer.SUB -> {
                return left - right;
            }
            default -> {
                return 0;
            }
        }
    }
    /** Odwiedzanie nawiasów */
    @Override
    public Integer visitParens(CalculatorV2Parser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }
    /** Operacja printowania  */
    @Override
    public Integer visitPrintExpr(CalculatorV2Parser.PrintExprContext ctx) {
        Integer val = visit(ctx.expr());
        System.out.println(val);
        return 0;
    }

    @Override
    public Integer visitWhile(CalculatorV2Parser.WhileContext ctx) {
        while (!visit(ctx.cond).equals(0) ){
            for ( var expr:  ctx.stat()){
                    visit(expr);
            }
        }
        return 1;
    }

    @Override
    public Integer visitCompExpr(CalculatorV2Parser.CompExprContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.GT -> {
                return left.intValue() > right.intValue() ? 1 : 0;
            }
            case CalculatorV2Lexer.LT -> {
                return left.intValue() < right.intValue() ? 1: 0;
            }
            case CalculatorV2Lexer.ISEQ -> {
                return  left.intValue() == right.intValue()? 1:0;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public Integer visitAndExpr(CalculatorV2Parser.AndExprContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        return left.intValue()>0 && right.intValue()>0 ? 1: 0;
    }

    @Override
    public Integer visitHandleConditional(CalculatorV2Parser.HandleConditionalContext ctx) {
        Integer res = 0;
        if(visit(ctx.cond)!=0){
            for (var expr: ctx.stat()) {
                res = visit(expr);
            }
        }
        else{
            if(ctx.else_ != null){
                for (var expr: ctx.else_in_if().stat()
                     ) {
                    res = visit(expr);
                }
            }
        }
        return res;
    }

    @Override
    public Integer visitOrExpr(CalculatorV2Parser.OrExprContext ctx) {
        Integer left = visit(ctx.left);
        Integer right = visit(ctx.right);
        return left>0 || right>0 ? 1: 0;
    }

    @Override
    public Integer visitFunctionDecl(CalculatorV2Parser.FunctionDeclContext ctx) {
        String functionName = ctx.funcName.getText();
        var body = ctx.stat();
        functions.put(functionName, body);
        return 0;
    }

    @Override
    public Integer visitFunctionCall(CalculatorV2Parser.FunctionCallContext ctx) {
        try {
            List<CalculatorV2Parser.StatContext> body = functions.get(ctx.funcName.getText());
            for (var expr:
                 body) {
                visit(expr);
            }
        } catch (NullPointerException e){
            System.out.println("Function was not defined");
        }
        return 0;
    }
}