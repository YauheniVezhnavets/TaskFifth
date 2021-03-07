package com.epam.task.fifth;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextCreator {

    private static final Logger LOGGER = LogManager.getLogger(TextCreator.class);

    private final String LINE_SPLITTER = "\n";
    private final String EMPTY = "";

    private final TextParser textParser;


    public TextCreator(TextParser textParser) {
        this.textParser = textParser;
    }

    public Component parseText (String filename){
        String line = EMPTY;
        try {
            line = String.join("\n",Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }
        return  textParser.parse(line);
    }
}
