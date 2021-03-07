package com.epam.task.fifth.logic;


import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private final TextLogic textLogic = new TextLogic();
    private static final String FIRST_PARAGRAPH_FIRST_WORD = "Chelsea";
    private static final String FIRST_PARAGRAPH_SECOND_WORD = "champion!";
    private static final String SECOND_PARAGRAPH_FIRST_WORD = "He";
    private static final String SECOND_PARAGRAPH_SECOND_WORD = "won";
    private static final String SECOND_PARAGRAPH_THIRD_WORD = "MU.";

    private final Component FIRST_WORD = Leaf.word("Chelsea");
    private final Component FIRST_EXPRESSION = Leaf.expression("[2 1 +]");
    private final Component FIRST_EXPRESSION_CALCULATED = Leaf.word("3");
    private final Component SECOND_EXPRESSION = Leaf.expression("1 2 -");
    private final Component SECOND_EXPRESSION_CALCULATED = Leaf.word("1");
    private final Component SECOND_WORD = Leaf.word("MU");


    private final Component PARAGRAPH_FIRST = new Composite(Collections.singletonList(
            new Composite(Arrays.asList(
                    Leaf.word(FIRST_PARAGRAPH_FIRST_WORD),
                    Leaf.word(FIRST_PARAGRAPH_SECOND_WORD)
            ))
    ));

    private final Component PARAGRAPH_SECOND = new Composite(Collections.singletonList(
            new Composite(Arrays.asList(
                    Leaf.word(SECOND_PARAGRAPH_FIRST_WORD),
                    Leaf.word(SECOND_PARAGRAPH_SECOND_WORD),
                    Leaf.word(SECOND_PARAGRAPH_THIRD_WORD)
            )))
    );

    private final Composite WORDS = new Composite(
            Arrays.asList(
                    FIRST_WORD,
                    FIRST_EXPRESSION,
                    SECOND_EXPRESSION,
                    SECOND_WORD
            )
    );

    private final Composite EXPECTED_WORDS = new Composite(
            Arrays.asList(
                    SECOND_WORD,
                    SECOND_EXPRESSION,
                    FIRST_WORD,
                    FIRST_EXPRESSION
            )
    );

    private final String EXPECTED_TEXT = FIRST_WORD +
            " " + FIRST_EXPRESSION_CALCULATED +
            " " + SECOND_EXPRESSION_CALCULATED +
            " " + SECOND_WORD;

    private final Composite PARAGRAPHS = new Composite(
            Arrays.asList(
                    PARAGRAPH_FIRST,
                    PARAGRAPH_SECOND
            )
    );

    private final Composite EXPECTED_PARAGRAPHS = new Composite(
            Arrays.asList(
                    PARAGRAPH_FIRST,
                    PARAGRAPH_SECOND
            )
    );


    @Test
    public void testParagraphSortShouldSortParagraphs() {

        Component result = textLogic.sortParagraphsByNumberOfSentences(PARAGRAPHS);

        Assert.assertEquals(EXPECTED_PARAGRAPHS, result);
    }

    @Test
    public void testSentenceSortShouldSortWordsInSentences() {

        Component result = textLogic.sortSentencesByLengthOfWords(WORDS);

        Assert.assertEquals(EXPECTED_WORDS, result);
    }

    @Test
    public void testRestoreShouldRestoreTextFromComponent() {

        String result = textLogic.restore(WORDS);

        Assert.assertEquals(EXPECTED_TEXT, result);
    }
}


