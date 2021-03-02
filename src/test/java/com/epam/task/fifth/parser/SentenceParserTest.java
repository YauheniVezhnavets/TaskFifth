package com.epam.task.fifth.parser;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;



public class SentenceParserTest {


    private final Parser sentenceParser = new SentenceParser();

    @Test
    public void testParse() {
        //given

        final String text = " Chelsea [6 3 -] [1 0 +] Manchester";
        final String FIRST_LEXEME = "Chelsea";
        final String SECOND_LEXEME = "[6 3 -]";
        final String THIRD_LEXEME = "[1 0 +]";
        final String FOUR_LEXEME = "Manchester";


        Component firstLexeme = Leaf.word(FIRST_LEXEME);
        Component secondLexeme = Leaf.expression(SECOND_LEXEME);
        Component thirdLexeme = Leaf.expression(THIRD_LEXEME);
        Component fourLexeme = Leaf.word(FOUR_LEXEME);

        Component expected = new Composite(Arrays.asList(firstLexeme, secondLexeme,thirdLexeme,fourLexeme));


        //when
        Component actual = sentenceParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);
    }
}
