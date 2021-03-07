package com.epam.task.fifth;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.parser.TextParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class TextCreatorTest {

    private static final String CORRECT_FILE = "src/test/resources/File.txt";
    private static final Component CORRECT_WORD = Leaf.word("Text");


      private TextParser parserMock = Mockito.mock(TextParser.class);
      private TextCreator creator =  new TextCreator(parserMock);



    @Test
    public void testParseTextShouldParseValidText()  {

        when(parserMock.parse(anyString())).thenReturn(new Composite(Collections.singletonList(CORRECT_WORD)));

        Composite expected = new Composite(Collections.singletonList(CORRECT_WORD));

        Component actual = creator.parseText(CORRECT_FILE);

        Assert.assertEquals(actual, expected);
    }
}

