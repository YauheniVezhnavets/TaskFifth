package com.epam.task.fifth.parser;


import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    private final static String TEXT_DATA = "Chelsea champion! He won MU.";


    Parser sentenceParser = Mockito.mock(SentenceParser.class);
    Parser paragraphParser = new ParagraphParser(sentenceParser);

    @Test
    public void paragraphParserShouldParseParagraphWhenCorrectData() {
        when(paragraphParser.parse(anyString())).thenAnswer(invocationOnMock -> {
            String sentence = ((String) invocationOnMock.getArguments()[0]).trim();
            return Leaf.word(sentence);
        });


        Component actual = paragraphParser.parse(TEXT_DATA);

        Component expected = new Composite(Arrays.asList(Leaf.word("Chelsea champion"),Leaf.word("He won MU")));

        Assert.assertEquals(expected,actual);
    }
}

