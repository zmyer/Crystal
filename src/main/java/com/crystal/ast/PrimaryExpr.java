package com.crystal.ast;

import java.util.List;

/**
 * @author stevenschew@apache.org
 */
public class PrimaryExpr extends ASTList {
    public PrimaryExpr(List<ASTree> c) {
        super(c);
    }
    public static ASTree create(List<ASTree> c) {
        return c.size() == 1? c.get(0) : new PrimaryExpr(c);
    }
}
