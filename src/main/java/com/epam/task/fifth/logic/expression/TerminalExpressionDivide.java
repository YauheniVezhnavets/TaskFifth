package com.epam.task.fifth.logic.expression;

import java.util.ArrayDeque;

public class TerminalExpressionDivide implements AbstractExpression {

    @Override
    public void interpret(ArrayDeque<Integer> stack) {

        //for good practice result need type double
        int result = stack.pop() / stack.pop();
        stack.push(result);
    }
}
