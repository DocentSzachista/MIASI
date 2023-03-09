import org.antlr.v4.runtime.tree.ParseTree;

public class MCalculatorVisitor extends CalculatorBaseVisitor<Integer> {
    @Override
    public Integer visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public Integer visitMult_or_div_exp(CalculatorParser.Mult_or_div_expContext ctx) {
        Integer result = 0;
        switch (ctx.op.getType()){
            case CalculatorLexer.TIMES -> {
                result = visit(ctx.left) * visit(ctx.right);
            }
            case CalculatorLexer.DIV -> {
                 result = visit(ctx.left) / visit(ctx.right);
            }
        }
        return result;
    }

    @Override
    public Integer visitPlus_or_minus_exp(CalculatorParser.Plus_or_minus_expContext ctx) {
        Integer result = 0;
        switch (ctx.op.getType()){
            case CalculatorLexer.PLUS -> {
                result = visit(ctx.left) + visit(ctx.right);
                break;
            }
            case CalculatorLexer.MINUS -> {
                result = visit(ctx.left) - visit(ctx.right);
                break;
            }
        }
        System.out.println(result);

        return  result;

    }

    @Override
    public Integer visitFile_(CalculatorParser.File_Context ctx) {
        super.visitFile_(ctx);
        Integer numbOfExpr = ctx.expression().size();
        return numbOfExpr;
    }

    @Override
    public Integer visitVariable(CalculatorParser.VariableContext ctx) {
//        System.out.println(ctx.getText());
        return Integer.valueOf(ctx.getText());
    }
}
