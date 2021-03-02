package com.epam.task.fifth.logic;

import com.epam.task.fifth.logic.expression.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class ExpressionCalculator {


    private final static String SPLITTER = "\\s+";
    private final static String FIRST_SQUARE_BRACKETS= "\\[";
    private final static String SECOND_SQUARE_BRACKETS= "]";
    private final static String EMPTY = "";
    private static final String NUMBER_PATTERN = "^\\d+$";
    private List<AbstractExpression> listExpression = new ArrayList<>();


    public Integer calculate(String expression) {
        ArrayDeque<Integer> stack  = new ArrayDeque<>();
        listExpression = parse(expression);


        for (AbstractExpression terminal : listExpression) {
            terminal.interpret(stack);
        }
        return stack.pop();
    }


    private List<AbstractExpression> parse(String expression) {
        String expressionWithoutBrackets = expression.replaceAll(FIRST_SQUARE_BRACKETS,EMPTY).
                replaceAll(SECOND_SQUARE_BRACKETS,EMPTY);
        for (String lexeme : expressionWithoutBrackets.split(SPLITTER)) {
            if (lexeme.matches(NUMBER_PATTERN)){
                int number = Integer.parseInt(lexeme);
                listExpression.add(new NonTerminalExpression(number));
            }
            switch (lexeme) {
                case "+":
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case "-":
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case "*":
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case "/":
                    listExpression.add(new TerminalExpressionDivide());
                    break;
            }
        }
        return listExpression;
    }
}
