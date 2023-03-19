import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input

        CharStream input = CharStreams.fromFileName("test.docen't");
//        CharStream input = CharStreams.fromFileName("test2.docen't");
//        CharStream input = CharStreams.fromFileName("test3.docen't");
//        CharStream input = CharStreams.fromFileName("test4.docen't");

        // create a lexer that feeds off of input CharStream
        CalculatorV2Lexer lexer = new CalculatorV2Lexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        CalculatorV2Parser parser = new CalculatorV2Parser(tokens);

        // start parsing at the prog rule
        ParseTree tree = parser.prog();
//         System.out.println(tree.toStringTree());
        
        // create a visitor to traverse the parse tree
        MCalculatorVisitorV2 visitor = new MCalculatorVisitorV2();
        visitor.visit(tree);
//        visitor.memory.forEach((key, value) -> {
//            System.out.print(key + ":" + value + " ");
//        });
    }
}