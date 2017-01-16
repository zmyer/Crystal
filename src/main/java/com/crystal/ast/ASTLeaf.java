package com.crystal.ast;

import com.crystal.Token;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author stevenschew@apache.org
 */
public class ASTLeaf extends ASTree {
    private static ArrayList<ASTree> empty = new ArrayList<ASTree>();
    protected Token token;

    public ASTLeaf(Token token) {
        this.token = token;
    }

    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int numChildren() {
        return 0;
    }

    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    public String location() {
        return "at line " + token.getLineNumber();
    }

    public Token getToken() {
        return token;
    }

    public String toString() {
        return token.getText();
    }
}
