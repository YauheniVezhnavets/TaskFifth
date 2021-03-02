package com.epam.task.fifth.parser;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TextParser extends AbstractParser {
    private final static String SPLITTER = "\t";

    public TextParser(Parser successor) {

        super(successor);
    }

    public Component parse(String input) {

        String[] paragraphs = input.split(SPLITTER);

        List<Component> paragraphsComponents = Arrays.stream(paragraphs).
                map(getSuccessor()::parse).
                collect(Collectors.toList());

        return new Composite(paragraphsComponents);
    }
}
