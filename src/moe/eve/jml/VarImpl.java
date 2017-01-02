package moe.eve.jml;

/**
 * Created by Eve on 1/2/2017.
 */
public class VarImpl {
    public TypeImpl type;
    public String name;
    public int line, pos;

    public VarImpl() {}
    public VarImpl(TypeImpl type, String name) {
        this.type = type;
        this.name = name;
    }
}
