package com.crystal.ast;

import com.crystal.Token;

/**
 * @author stevenschew@apache.org
 */
public class Name extends ASTLeaf {
    public Name(Token token) {
        super(token);
    }

    public String getName() {
        return getToken().getText();
    }
}
