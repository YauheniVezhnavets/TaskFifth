package com.epam.task.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {

    private final String EXPRESSION = "[2 5 +]";
    private final int EXPECTED = 7;


    private final ExpressionCalculator expressionCalculator = new ExpressionCalculator();

    @Test
    public void testExpressionCalculatorShouldCalculateExpressionWhenExpressionCorrect() {

        int actual = expressionCalculator.calculate(EXPRESSION);

        Assert.assertEquals(EXPECTED, actual);

    }
}
