package moe.eve.jml;

/**
 * Created by Eve on 1/2/2017.
 */
public class DefPass extends miniJavaBaseListener {
    public String mainClassName;
    public ClassImpl currentClass;
    public MethodImpl currentMethod;
    public String currentDepth;

    public void enterGoal(miniJavaParser.GoalContext ctx) {
        currentClass = null;
        currentMethod = null;
        currentDepth = "global";
    }

    public void enterMainClassDef(miniJavaParser.MainClassDefContext ctx) {
        if (ctx.clsName != null) {
            mainClassName = ctx.clsName.getText();
            currentDepth = "mainClass";
        }
    }

    public void exitMainClassDef(miniJavaParser.MainClassDefContext ctx) {
        currentDepth = "global";
    }

    public void enterClassDef(miniJavaParser.ClassDefContext ctx) {
        try {
            currentClass = ClassImpl.create(ctx.clsName.getText());
            currentClass.line = ctx.getStart().getLine();
            currentClass.pos = ctx.getStart().getCharPositionInLine();
        } catch (miniJavaException e) {
            try {
                ClassImpl cls = ClassImpl.get(ctx.clsName.getText());
                miniJava.error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), e.getMessage());
                miniJava.notice(cls.line, cls.pos, "Class " + ctx.clsName.getText() + " defined here.");
                currentClass = ClassImpl.create(ctx.clsName.getText() + "@" + ctx.getStart().getLine() + "," + ctx.getStart().getCharPositionInLine());
                currentClass.line = -1;
                currentClass.pos = -1;
            } catch (miniJavaException _) {
                // Never reach here.
                throw new RuntimeException(_);
            }
        }
        try {
            if (ctx.parentName != null) {
                currentClass.parent = ClassImpl.get(ctx.parentName.getText());
            }
        } catch (miniJavaException e) {
            miniJava.error(ctx.parentName.getLine(), ctx.parentName.getCharPositionInLine(), "Class " + ctx.parentName.getText() + " not defined.");
        }
        currentDepth = "class";
    }

    public void exitClassDef(miniJavaParser.ClassDefContext ctx) {
        currentClass = null;
        currentDepth = "global";
    }

    public void enterMethod(miniJavaParser.MethodContext ctx) {
        currentMethod = new MethodImpl(currentClass, ctx.name.getText());
        currentMethod.ret = TypeImpl.get(ctx.varType().getText());
        currentMethod.line = ctx.getStart().getLine();
        currentMethod.pos = ctx.getStart().getCharPositionInLine();
        if (currentClass.method.containsKey(ctx.name.getText())) {
            MethodImpl method = currentClass.method.get(ctx.name.getText());
            miniJava.error(currentMethod.line, currentMethod.pos, "Method " + ctx.name.getText() + " already defined.");
            miniJava.notice(method.line, method.pos, "Method " + method.name + " defined here.");
        }
        currentClass.addMethod(ctx.name.getText(), currentMethod);
        currentDepth = "method";
    }

    public void exitMethod(miniJavaParser.MethodContext ctx) {
        currentMethod = null;
        currentDepth = "class";
    }

    public void enterVariable(miniJavaParser.VariableContext ctx) {
        if (currentDepth.equals("method")) {
            if (currentMethod.variables.containsKey(ctx.name.getText())) {
                VarImpl var = currentMethod.variables.get(ctx.name.getText());
                miniJava.error(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Variable " + ctx.name.getText() + " already defined.");
                miniJava.notice(var.line, var.pos, "Variable " + var.name + " defined here.");
            } else {
                VarImpl var = new VarImpl(TypeImpl.get(ctx.varType().getText()), ctx.name.getText());
                var.line = ctx.start.getLine();
                var.pos = ctx.start.getCharPositionInLine();
                currentMethod.variables.put(var.name, var);
            }
        } else if (currentDepth.equals("class")) {
            if (currentClass.field.containsKey(ctx.name.getText())) {
                VarImpl var = currentClass.field.get(ctx.name.getText());
                miniJava.error(ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Field " + ctx.name.getText() + " already defined.");
                miniJava.notice(var.line, var.pos, "Field " + var.name + " defined here.");
            } else {
                VarImpl var = new VarImpl(TypeImpl.get(ctx.varType().getText()), ctx.name.getText());
                var.line = ctx.start.getLine();
                var.pos = ctx.start.getCharPositionInLine();
                currentClass.addField(var.name, var);
            }
        }
    }

    public void enterParameterList(miniJavaParser.ParameterListContext ctx) {
        String name = ctx.parameter().name.getText();
        boolean error = false;
        for (VarImpl var : currentMethod.arguments) {
            if (var.name == name) {
                miniJava.error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "Argument named " + name + " is already defined.");
                miniJava.notice(var.line, var.pos, "Argument " + name + " defined here.");
                error = true;
                break;
            }
        }
        if (!error) {
            VarImpl var = new VarImpl(TypeImpl.get(ctx.parameter().varType().getText()), name);
            var.line = ctx.getStart().getLine();
            var.pos = ctx.getStart().getCharPositionInLine();
            currentMethod.arguments.add(var);
        }
    }
}
