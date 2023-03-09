import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // create a lexer that feeds off of input CharStream
        CalculatorLexer lexer = new CalculatorLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        CalculatorParser parser = new CalculatorParser(tokens);

        // start parsing at the program rule
        ParseTree tree = parser.file_();
        System.out.println(tree.toStringTree());

        // create a visitor to traverse the parse tree
        MCalculatorVisitor visitor = new MCalculatorVisitor();
        Integer solution = visitor.visit(tree);
        System.out.println(solution);
    }
}