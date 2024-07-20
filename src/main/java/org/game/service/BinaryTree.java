package org.game.service;

import org.game.dto.Position;

public interface BinaryTree<T> extends Tree<T> {
    Position<T> left(Position<T> p);
    Position<T> right(Position<T> p);
    Position<T> sibling(Position<T> p);
}
