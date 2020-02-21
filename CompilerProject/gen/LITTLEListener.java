// Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLE.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LITTLEParser}.
 */
public interface LITTLEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LITTLEParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LITTLEParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(LITTLEParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(LITTLEParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(LITTLEParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(LITTLEParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(LITTLEParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(LITTLEParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(LITTLEParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(LITTLEParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(LITTLEParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(LITTLEParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(LITTLEParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(LITTLEParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(LITTLEParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(LITTLEParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(LITTLEParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(LITTLEParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(LITTLEParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(LITTLEParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(LITTLEParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(LITTLEParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(LITTLEParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(LITTLEParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(LITTLEParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(LITTLEParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(LITTLEParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(LITTLEParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(LITTLEParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(LITTLEParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(LITTLEParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(LITTLEParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(LITTLEParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(LITTLEParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(LITTLEParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LITTLEParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LITTLEParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(LITTLEParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(LITTLEParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(LITTLEParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(LITTLEParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(LITTLEParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(LITTLEParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(LITTLEParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(LITTLEParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(LITTLEParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(LITTLEParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(LITTLEParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(LITTLEParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LITTLEParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LITTLEParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prefix(LITTLEParser.Expr_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prefix(LITTLEParser.Expr_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LITTLEParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LITTLEParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFactor_prefix(LITTLEParser.Factor_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFactor_prefix(LITTLEParser.Factor_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(LITTLEParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(LITTLEParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(LITTLEParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(LITTLEParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(LITTLEParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(LITTLEParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(LITTLEParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(LITTLEParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(LITTLEParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(LITTLEParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(LITTLEParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(LITTLEParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(LITTLEParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(LITTLEParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(LITTLEParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(LITTLEParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(LITTLEParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(LITTLEParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(LITTLEParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(LITTLEParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(LITTLEParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(LITTLEParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(LITTLEParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(LITTLEParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LITTLEParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(LITTLEParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LITTLEParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(LITTLEParser.EmptyContext ctx);
}