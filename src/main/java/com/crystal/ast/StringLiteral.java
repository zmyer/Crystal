package com.crystal.ast;

import com.crystal.Token;

/**
 * @author stevenschew@apache.org
 */
public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token token) {
        super(token);
    }

    public String value() {
        return getToken().getText();
    }
}
