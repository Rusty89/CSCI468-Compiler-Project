// Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLE.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LITTLEParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LITTLEVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LITTLEParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LITTLEParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#pgm_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPgm_body(LITTLEParser.Pgm_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(LITTLEParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#string_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_decl(LITTLEParser.String_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#str}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(LITTLEParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(LITTLEParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(LITTLEParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#any_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_type(LITTLEParser.Any_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(LITTLEParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#id_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_tail(LITTLEParser.Id_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#param_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_decl_list(LITTLEParser.Param_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#param_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_decl(LITTLEParser.Param_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#param_decl_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_decl_tail(LITTLEParser.Param_decl_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#func_declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_declarations(LITTLEParser.Func_declarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_decl(LITTLEParser.Func_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#func_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body(LITTLEParser.Func_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(LITTLEParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LITTLEParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#base_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_stmt(LITTLEParser.Base_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(LITTLEParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#assign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(LITTLEParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#read_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stmt(LITTLEParser.Read_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#write_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_stmt(LITTLEParser.Write_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(LITTLEParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LITTLEParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#expr_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prefix(LITTLEParser.Expr_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LITTLEParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#factor_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor_prefix(LITTLEParser.Factor_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#postfix_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expr(LITTLEParser.Postfix_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_expr(LITTLEParser.Call_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(LITTLEParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#expr_list_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list_tail(LITTLEParser.Expr_list_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(LITTLEParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(LITTLEParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(LITTLEParser.MulopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(LITTLEParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#else_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_part(LITTLEParser.Else_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(LITTLEParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#compop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompop(LITTLEParser.CompopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(LITTLEParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LITTLEParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(LITTLEParser.EmptyContext ctx);
}