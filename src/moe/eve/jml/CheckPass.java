package moe.eve.jml;

/**
 * Created by Eve on 1/2/2017.
 */
public class CheckPass extends miniJavaBaseListener {

	public ClassImpl currentClass;

	public void enterClassDef(miniJavaParser.ClassDefContext ctx) {
		try {
			currentClass = ClassImpl.get(ctx.clsName.getText());
		} catch (miniJavaException e) {
			throw new RuntimeException(e);
		}
	}

	public void enterMethod(miniJavaParser.MethodContext ctx) {
		MethodImpl method = currentClass.method.get(ctx.name.getText());
		if (!method.ret.valid()) {
			miniJava.error(ctx.varType().getStart().getLine(), ctx.varType().getStart().getCharPositionInLine(), "Class " + method.ret.name + " is not defined!");
		}
	}

	public void enterVariable(miniJavaParser.VariableContext ctx) {
		TypeImpl type = TypeImpl.get(ctx.varType().getText());
		if (!type.valid()) {
			miniJava.error(ctx.varType().getStart().getLine(), ctx.varType().getStart().getCharPositionInLine(), "Class " + type.name + " is not defined!");
		}
	}
}
