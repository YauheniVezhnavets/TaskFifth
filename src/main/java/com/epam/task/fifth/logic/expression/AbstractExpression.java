package com.epam.task.fifth.logic.expression;

import java.util.ArrayDeque;

public interface AbstractExpression {

    void interpret (ArrayDeque<Integer> stack);

}
