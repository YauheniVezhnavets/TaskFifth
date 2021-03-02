package com.epam.task.fifth.logic.expression;



import java.util.ArrayDeque;

public class NonTerminalExpression implements AbstractExpression {

    private int number;

    public NonTerminalExpression(int number) {
        this.number = number;
    }


    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        stack.push(number);
    }
}
