package com.epam.task.fifth.parser;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ParagraphParser extends AbstractParser {

    private final static String SPLITTER = "[.?!]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }


    @Override
    public Component parse(String input) {

        String[] sentences = input.split(SPLITTER);


        List<Component> sentenceComponents = Arrays.stream(sentences).
                map(getSuccessor()::parse).
                collect(Collectors.toList());

        return new Composite(sentenceComponents);
    }
}
