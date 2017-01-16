package com.crystal.ast;

import java.util.List;

/**
 * @author stevenschew@apache.org
 */
public class WhileStmnt extends ASTList {
    public WhileStmnt(List<ASTree> list) {
        super(list);
    }

    public ASTree condition() {
        return child(0);
    }

    public ASTree body() {
        return child(1);
    }

    public String toString() {
        return "( while" + condition() + " " + body() + ")";
    }
}
