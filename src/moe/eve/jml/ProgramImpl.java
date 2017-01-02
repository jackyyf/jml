package moe.eve.jml;

/**
 * Created by Eve on 1/2/2017.
 */
public class ProgramImpl {
    public String main_class;

    public ProgramImpl() {
        main_class = "<UNKNOWN>";
    }

    public VarImpl getVariable(ClassImpl cls, String var) {
        if (cls.field.containsKey(var)) {
            return cls.field.get(var);
        }
        if (cls.parent != null) {
            return getVariable(cls.parent, var);
        }
        return null;
    }

    public MethodImpl getMethod(ClassImpl cls, String name) {
        if (cls.method.containsKey(name)) {
            return cls.method.get(name);
        }
        if (cls.parent != null) {
            return getMethod(cls.parent, name);
        }
        return null;
    }

    public boolean compatible(TypeImpl callee, TypeImpl caller) throws miniJavaException {
        return caller.compatible(callee);
    }

}
