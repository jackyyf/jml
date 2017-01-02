package moe.eve.jml;

import javax.swing.text.html.MinimalHTMLWriter;
import java.io.*;
import java.util.*;

/**
 * Created by Eve on 1/1/2017.
 */
public class ClassImpl {
	public String name;
	public ClassImpl parent;
	public HashMap<String, VarImpl> field;
	public HashMap<String, MethodImpl> method;
	public int line, pos;

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

	public static ClassImpl get(String name) throws miniJavaException {
		if (!pool.containsKey(name)) {
			throw new miniJavaException("Class " + name + " not defined.");
		}
		return pool.get(name);
	}

	public static ClassImpl create(String name) throws miniJavaException {
		if (!pool.containsKey(name)) {
			pool.put(name, new ClassImpl(name));
			return pool.get(name);
		}
		throw new miniJavaException("Class " + name + " already defined");
	}

	public static boolean contains(String name) {
		return pool.containsKey(name);
	}

	public String toString() {
		return this.name;
	}

	public void addField(String name, VarImpl t) {
		field.put(name, t);
	}

	public void addMethod(String name, MethodImpl m) {
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
