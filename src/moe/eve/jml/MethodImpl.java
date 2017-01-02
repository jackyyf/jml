package moe.eve.jml;

import java.util.*;

/**
 * Created by Eve on 1/1/2017.
 */
public class MethodImpl {

    public String name;
    public ClassImpl owner;
    public TypeImpl ret;
    public List<VarImpl> arguments;
    public HashMap<String, VarImpl> variables;
    public int line, pos;

    public MethodImpl(ClassImpl owner) {
        this.owner = owner;
        arguments = new ArrayList<>();
        variables = new HashMap<>();
    }

    public MethodImpl(ClassImpl owner, String name) {
        this(owner);
        this.name = name;
    }
}
