package com.crystal.exception;

import com.crystal.Token;

import java.io.IOException;

/**
 * @author stevenschew@apache.org
 */
public class ParseException extends Exception {
    public ParseException(Token s) {
        this("", s);
    }

    public ParseException(String msg, Token token) {
        super("syntex error around " + location(token) + "." + msg);
    }

    private static String location(Token token) {
        if (token == Token.EOF) {
            return "the last line";
        } else {
            return "\"" + token.getText() + "\" at line" + token.getLineNumber();
        }
    }

    public ParseException(IOException e) {
        super(e);
    }

    public ParseException(String msg) {
        super(msg);
    }
}
