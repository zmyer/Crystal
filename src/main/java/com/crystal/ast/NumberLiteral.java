package com.crystal.ast;

import com.crystal.Token;

/**
 * @author stevenschew@apache.org
 */
public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token token) {
        super(token);
    }

    public int val() {
        return getToken().getNumber();
    }
}
