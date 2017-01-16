package com.crystal.ast;

import java.util.List;

/**
 * @author stevenschew@apache.org
 */
public class BinaryExpr extends ASTList {
    public BinaryExpr(List<ASTree> list) {
        super(list);
    }

    public ASTree left() {
        return child(0);
    }

    public String operator() {
        return ((ASTLeaf) child(1)).getToken().getText();
    }

    public ASTree right() {
        return child(2);
    }
}
