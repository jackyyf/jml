// Generated from miniJava.g4 by ANTLR 4.6
package moe.eve.jml;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link miniJavaParser}.
 */
public interface miniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#mainClassDef}.
	 * @param ctx the parse tree
	 */
	void enterMainClassDef(miniJavaParser.MainClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#mainClassDef}.
	 * @param ctx the parse tree
	 */
	void exitMainClassDef(miniJavaParser.MainClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(miniJavaParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(miniJavaParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(miniJavaParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(miniJavaParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(miniJavaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(miniJavaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(miniJavaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(miniJavaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(miniJavaParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(miniJavaParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(miniJavaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(miniJavaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(miniJavaParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(miniJavaParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(miniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(miniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(miniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(miniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(miniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(miniJavaParser.MethodCallContext ctx);
}