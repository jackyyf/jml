package moe.eve.jml;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.*;

import java.io.*;
import java.util.*;


/**
 * Created by Eve on 1/1/2017.
 */
public class miniJava {

    public static boolean hasError = false;

    public static void error(int line, int pos, String msg) {
        hasError = true;
        System.err.printf("line %d:%d error: %s%n", line, pos, msg);
    }

    public static void notice(int line, int pos, String msg) {
        System.err.printf("line %d:%d notice: %s%n", line, pos, msg);
    }

    public static void main(String[] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);
        ErrorListener errorListener = new ErrorListener();
        miniJavaLexer lexer = new miniJavaLexer(inputStream);
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        miniJavaParser parser = new miniJavaParser(tokens);
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.goal();
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPass def = new DefPass();
        walker.walk(def, tree);
        CheckPass check = new CheckPass();
        walker.walk(check, tree);

        if (!hasError) {
            System.out.println(tree.toStringTree(parser));
            if (args.length == 0 || !args[0].equals("-nogui")) {
                Trees.inspect(tree, parser);
            }
        }

    }
}
