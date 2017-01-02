package moe.eve.jml;

import java.io.*;
import java.util.*;

/**
 * Created by Eve on 1/1/2017.
 */
public class TypeImpl {

    public String name;

    private TypeImpl() {}
    private TypeImpl(String name) {
        this.name = name;
    }

    static {
        pool = new HashMap<>();
    }

    private static HashMap<String, TypeImpl> pool;

    public static TypeImpl get(String name) {
        if (!pool.containsKey(name))
            pool.put(name, new TypeImpl(name));
        return pool.get(name);
    }

    public boolean isBasicType() {
        return name.equals("int") || name.equals("boolean") || name.equals("int[]");
    }

    public boolean compatible(TypeImpl type) throws miniJavaException {
        if (this == type) return true;
        if (this.isBasicType() || type.isBasicType()) return false;
        return ClassImpl.get(this.name).castable(ClassImpl.get(type.name));
    }

    public boolean valid() {
        return this.isBasicType() || ClassImpl.contains(this.name);
    }
}
