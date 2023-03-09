// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#file_}.
	 * @param ctx the parse tree
	 */
	void enterFile_(CalculatorParser.File_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#file_}.
	 * @param ctx the parse tree
	 */
	void exitFile_(CalculatorParser.File_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code plus_or_minus_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus_or_minus_exp(CalculatorParser.Plus_or_minus_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus_or_minus_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus_or_minus_exp(CalculatorParser.Plus_or_minus_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult_or_div_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult_or_div_exp(CalculatorParser.Mult_or_div_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult_or_div_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult_or_div_exp(CalculatorParser.Mult_or_div_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CalculatorParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CalculatorParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pow_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPow_exp(CalculatorParser.Pow_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pow_exp}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPow_exp(CalculatorParser.Pow_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in_params}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIn_params(CalculatorParser.In_paramsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in_params}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIn_params(CalculatorParser.In_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#scientific}.
	 * @param ctx the parse tree
	 */
	void enterScientific(CalculatorParser.ScientificContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#scientific}.
	 * @param ctx the parse tree
	 */
	void exitScientific(CalculatorParser.ScientificContext ctx);
}