// Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLESCANNER.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LITTLESCANNERParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LITTLESCANNERVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LITTLESCANNERParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(LITTLESCANNERParser.RContext ctx);
}