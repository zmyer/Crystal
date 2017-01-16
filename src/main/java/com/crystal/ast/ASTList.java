package com.crystal.ast;

import java.util.Iterator;
import java.util.List;

/**
 * @author stevenschew@apache.org
 */
public class ASTList extends ASTree {
    protected List<ASTree> children;

    public ASTList(List<ASTree> list) {
        children = list;
    }

    public ASTree child(int i) {
        return children.get(i);
    }

    public int numChildren() {
        return children.size();
    }

    public Iterator<ASTree> children() {
        return children.iterator();
    }

    public String location() {
        for (ASTree t : children) {
            String s = t.location();
            if (s != null)
                return s;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        String sep = "";
        for (ASTree t : children) {
            sb.append(sep);
            sep = " ";
            sb.append(t.toString());
        }
        return sb.append(')').toString();
    }
}
