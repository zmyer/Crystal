package com.crystal;

import com.crystal.ast.*;
import com.crystal.exception.ParseException;

import java.util.HashSet;

import static com.crystal.Parser.rule;

/**
 * @author stevenschew@apache.org
 */
public class BasicParser {
    HashSet<String> reserved = new HashSet<String>();
    Parser.Operators operators = new Parser.Operators();
    Parser expr0 = rule();

    Parser primary = rule(PrimaryExpr.class)
            .or(rule().sep("(").ast(expr0).sep(")"),
                    rule().number(NumberLiteral.class),
                    rule().identifier(Name.class, reserved),
                    rule().string(StringLiteral.class));

    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary), primary);
    Parser expr = expr0.expression(BinaryExpr.class, factor, operators);
    Parser statement0 = rule();
    Parser block = rule(BlockStmnt.class)
            .sep("{").option(statement0)
            .repeat(rule().sep(";", Token.EOL).option(statement0))
            .sep("}");
    Parser simple = rule(PrimaryExpr.class).ast(expr);
    Parser statement = statement0.or(rule(IfStmnt.class)
                    .sep("if").ast(expr).ast(block)
                    .option(rule().sep("else").ast(block)),
            rule(WhileStmnt.class).sep("while").ast(expr).ast(block), simple);
    Parser program = rule().or(statement, rule(NullStmnt.class)).sep(";", Token.EOL);

    public BasicParser() {
        reserved.add(";");
        reserved.add("}");
        reserved.add(Token.EOL);

        operators.add("=", 1, Parser.Operators.RIGHT);
        operators.add("==", 2, Parser.Operators.LEFT);
        operators.add(">", 2, Parser.Operators.LEFT);
        operators.add("<", 2, Parser.Operators.LEFT);
        operators.add("+", 2, Parser.Operators.LEFT);
        operators.add("-", 2, Parser.Operators.LEFT);
        operators.add("*", 2, Parser.Operators.LEFT);
        operators.add("/", 2, Parser.Operators.LEFT);
        operators.add("%", 2, Parser.Operators.LEFT);
    }

    public ASTree parse(Lexer lexer) throws ParseException {
        return program.parse(lexer);
    }
}
