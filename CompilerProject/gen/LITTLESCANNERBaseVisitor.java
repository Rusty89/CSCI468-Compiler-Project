// Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLESCANNER.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link LITTLESCANNERVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class LITTLESCANNERBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements LITTLESCANNERVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitR(LITTLESCANNERParser.RContext ctx) { return visitChildren(ctx); }
}