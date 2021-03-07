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

public class TextParserTest {

    private final static String TEXT_DATA = "Chelsea champion! \t He won MU. ";


    Parser paragraphParser = Mockito.mock(ParagraphParser.class);
    Parser textParser = new TextParser(paragraphParser);

    @Test
    public void textParserShouldParseTextWhenCorrectData() {
        when(textParser.parse(anyString())).thenAnswer(invocationOnMock -> {
            String paragraph = ((String) invocationOnMock.getArguments()[0]).trim();
            return Leaf.word(paragraph);
        });


        Component actual = textParser.parse(TEXT_DATA);

        Component expected = new Composite(Arrays.asList(Leaf.word("Chelsea champion!"),Leaf.word("He won MU.")));

        Assert.assertEquals(expected,actual);
    }
}

