import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;


public class CompileVisitor extends CalculatorV2BaseVisitor<ST>  {

    private STGroup stGroup;
    public CompileVisitor(STGroup stGroup) {
        super();
        this.stGroup = stGroup;
    }
    @Override
    protected ST defaultResult() {
        return stGroup.getInstanceOf("deflt");
    }

    @Override
    protected ST aggregateResult(ST aggregate, ST nextResult) {
        if(nextResult!=null)
            aggregate.add("elem",nextResult);
        return aggregate;
    }
    @Override
    public ST visitTerminal(TerminalNode node) {
        return new ST("Terminal node:<n>").add("n",node.getText());
    }

    @Override
    public ST visitId(CalculatorV2Parser.IdContext ctx) {
        return super.visitId(ctx);
    }

    @Override
    public ST visitInt(CalculatorV2Parser.IntContext ctx) {
        ST st = stGroup.getInstanceOf("int");
        String debug = ctx.INT().getText();
        return st.add("i",debug );
    }

    @Override
    public ST visitPrintExpr(CalculatorV2Parser.PrintExprContext ctx) {
        ST st = stGroup.getInstanceOf("deflt");
        return st.add("elem", visit(ctx.expr()));
    }

    @Override
    public ST visitAddSub(CalculatorV2Parser.AddSubContext ctx) {
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.ADD -> {
                ST st = stGroup.getInstanceOf("add");
                return st.add("p1", visit(ctx.left)).add("p2", visit(ctx.right));
            }
            case CalculatorV2Lexer.SUB -> {
                ST st = stGroup.getInstanceOf("sub");
                return st.add("p1", visit(ctx.left)).add("p2", visit(ctx.right));
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }
    private int if_count = 0;
    @Override
    public ST visitHandleConditional(CalculatorV2Parser.HandleConditionalContext ctx) {
        return  stGroup.getInstanceOf("cond")
                .add("label_index", Integer.toString(if_count+=1))
                .add("condition", visit(ctx.cond))
                .add("if_true", visit(ctx.then))
                .add("if_false", visit(ctx.else_));
    }

    @Override
    public ST visitMulDiv(CalculatorV2Parser.MulDivContext ctx) {
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.MUL -> {
                ST st = stGroup.getInstanceOf("mul");
                return st.add("p1", visit(ctx.left)).add("p2", visit(ctx.right));
            }
            case CalculatorV2Lexer.DIV -> {
                ST st = stGroup.getInstanceOf("div");
                return st.add("p1", visit(ctx.left)).add("p2", visit(ctx.right));
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public ST visitCompExpr(CalculatorV2Parser.CompExprContext ctx) {
        switch (ctx.op.getType()){
            case CalculatorV2Lexer.ISEQ -> {
                return stGroup.getInstanceOf("comp").add("p1", visit(ctx.left)).add("p2", visit(ctx.right));
            }
            default -> throw  new IllegalArgumentException();
        }
    }

    @Override
    public ST visitAssign(CalculatorV2Parser.AssignContext ctx) {
        ST st = stGroup.getInstanceOf("declare");
        return st.add("n", visit(ctx.expr()));
    }
}
