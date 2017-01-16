package com.crystal;

import com.crystal.ast.ASTree;
import com.crystal.exception.ParseException;

/**
 * @author stevenschew@apache.org
 */
public class LexerRunner {

    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        BasicParser bp = new BasicParser();
        while (l.peek(0) != Token.EOF) {
            ASTree ast = bp.parse(l);
            System.out.println("=>" + ast.toString());
        }
    }
}
