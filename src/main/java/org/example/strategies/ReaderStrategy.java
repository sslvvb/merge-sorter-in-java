package org.example.strategies;

/**
 * Общий интерфейс всех стратегий.
 */
public interface ReaderStrategy {
    boolean compareValues(ReaderStrategy other);
    String getValue();
    int shiftValue();
}
