package org.game.dto;

public interface Position<T> {
    T getElement() throws IllegalStateException;
}
