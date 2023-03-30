import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;


public class Main {

    public static void interpreter() throws IOException {
        // create a CharStream that reads from standard input

//        CharStream input = CharStreams.fromFileName("test.docen't");
//        CharStream input = CharStreams.fromFileName("test2.docen't");
        CharStream input = CharStreams.fromFileName("test3.docen't");
//        CharStream input = CharStreams.fromFileName("test4.docen't");
        // przed kolejnymi zajęciami deklaracje i operacje zmiennych dla kompilatora
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
    public static void generateJava() throws Exception {
        // create a CharStream that reads from standard input
        //CharStream input = CharStreams.fromStream(System.in);
        CharStream input = CharStreams.fromFileName("compiled.docen't");

        // create a lexer that feeds off of input CharStream
        CalculatorV2Lexer lexer = new CalculatorV2Lexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        CalculatorV2Parser parser = new CalculatorV2Parser(tokens);

        // start parsing at the program.program rule
        ParseTree tree = parser.prog();

        STGroup stGroup = new STGroupFile("src/reg.stg");
        CompileVisitor visitor = new CompileVisitor(stGroup);
        ST result = visitor.visit(tree);
        System.out.println(result.render());
    }
    public static void main(String[] args) throws Exception {
//        interpreter();
        generateJava();
    }

}