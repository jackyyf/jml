package moe.eve.jml;

import java.io.*;
import java.util.*;

/**
 * Created by Eve on 1/1/2017.
 */
public class ClassImpl {
    public String name;
    public ClassImpl parent;
    public HashMap<String, TypeImpl> field;
    public HashMap<String, MethodImpl> method;

    private static HashMap<String, ClassImpl> pool;

    static {
        pool = new HashMap<>();
    }

    private ClassImpl() {
        field = new HashMap<>();
        method = new HashMap<>();
        parent = null;
    }

    private ClassImpl(String name) {
        this();
        this.name = name;
    }

    public static ClassImpl get(String name) {
        if (!pool.containsKey(name))
            pool.put(name, new ClassImpl(name));
        return pool.get(name);
    }

    public String toString() {
        return this.name;
    }

    public void addField(TypeImpl t, String name) {
        field.put(name, t);
    }

    public void addMethod(MethodImpl m, String name) {
        method.put(name, m);
    }

    public TypeImpl type() {
        return TypeImpl.get(this.name);
    }

    public boolean castable(ClassImpl base) {
        ClassImpl now = this;
        for (;;) {
            if (now == base) {
                return true;
            }
            if (now.parent == null) {
                return false;
            }
            now = now.parent;
        }
    }
}
