package com.epam.task.fifth.logic.expression;

import java.util.ArrayDeque;

public class TerminalExpressionPlus implements AbstractExpression {

    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(first + second);
    }
}
