package com.epam.task.fifth.logic.expression;

import java.util.ArrayDeque;

public class TerminalExpressionMinus implements AbstractExpression {
    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        int result = stack.pop() - stack.pop();
        stack.push(result);
    }
}
