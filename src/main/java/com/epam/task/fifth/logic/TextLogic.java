package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;


import java.util.ArrayList;
import java.util.List;

public class TextLogic {


    public Component sortParagraphsByNumberOfSentences(Composite text) {
        List<Component> paragraphs = text.getComponents();
        List<Component> sortedText = new ArrayList<>(paragraphs);

        sortedText.sort((first, second) -> {
            List<Component> firstParagraph = ((Composite) first).getComponents();
            List<Component> secondParagraph = ((Composite) second).getComponents();

            return firstParagraph.size() - secondParagraph.size();
        });
        return new Composite(sortedText);
    }

    public Component sortSentencesByLengthOfWords(Composite sentences) {
        List<Component> words = sentences.getComponents();
        List<Component> sortedSentences = new ArrayList<>(words);

        sortedSentences.sort((first, second) -> {
            String firstWord = ((Leaf) first).getLexeme();
            String secondWord = ((Leaf) second).getLexeme();

            return firstWord.length() - secondWord.length();
        });
        return new Composite(sortedSentences);
    }

    public Component calculate(Component component) {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();

        String lexeme = ((Leaf) component).getLexeme();
        Integer result = expressionCalculator.calculate(lexeme);

        return Leaf.word(result.toString());
    }

    public String restore(Composite composite) {
        List<Component> lexemes = composite.getComponents();
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        StringBuilder stringBuilders = new StringBuilder();


        for (Component lexeme : lexemes) {
            String word ;
            if (((Leaf) lexeme).getLeafType() == LeafType.EXPRESSION) {
                word = calculate(lexeme).toString();
            }
            word = lexeme.toString();
            stringBuilders.append(word).append(" ");
        }

        return stringBuilders.toString();
    }
}
