// Generated from C:/Users/Eve/IdeaProjects/jml/src\miniJava.g4 by ANTLR 4.6
package moe.eve.jml;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#mainClassDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClassDef(miniJavaParser.MainClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(miniJavaParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(miniJavaParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(miniJavaParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(miniJavaParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(miniJavaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(miniJavaParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(miniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(miniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(miniJavaParser.MethodCallContext ctx);
}