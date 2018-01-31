package by.itiacademy.parser.common;

import by.itiacademy.entity.Owner;
import by.itiacademy.exception.FileParsingException;

public interface Parser {
    Owner parse () throws FileParsingException;
}
