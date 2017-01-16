package com.crystal.ast;

import java.util.List;

/**
 * @author stevenschew@apache.org
 */
public class NegativeExpr extends ASTList {
    public NegativeExpr(List<ASTree> list) {
        super(list);
    }

    public ASTree operand() {
        return child(0);
    }

    public String toString() {
        return "-" + operand();
    }
}
