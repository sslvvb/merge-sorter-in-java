package org.example.strategies;

public interface ReaderStrategy {
    boolean compareValues(ReaderStrategy other);

    String getValue();

    int shiftValue();
}
