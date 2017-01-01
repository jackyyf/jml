package moe.eve.jml;

import java.io.*;
import java.util.*;

/**
 * Created by Eve on 1/1/2017.
 */
public class MethodImpl {

    public class Argument {
        public String name;
        public TypeImpl type;

        public Argument(String name, TypeImpl type) {
            this.name = name;
            this.type = type;
        }
    }

    public String name;
    public ClassImpl owner;
    public TypeImpl ret;
    public List<Argument> arguments;
    public HashMap<String, TypeImpl> variables;

    public MethodImpl(ClassImpl owner) {
        this.owner = owner;
        arguments = new ArrayList<>();
        variables = new HashMap<>();
    }

    public MethodImpl(ClassImpl owner, String name) {
        this(owner);
        this.name = name;
    }

    public void addVariable(TypeImpl t, String name) {
        variables.put(name, t);
    }

    public void addArgument(TypeImpl t, String name) {
        arguments.add(new Argument(name, t));
    }

    public boolean callable(TypeImpl args[]) {
        if (args.length != arguments.size()) {
            return false;
        }

        for (int i = 0; i < args.length; ++ i) {
            if (!args[i].compatible(arguments.get(i).type)) {
                return false;
            }
        }

        return true;
    }

}
