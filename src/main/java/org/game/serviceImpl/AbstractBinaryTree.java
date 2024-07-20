package org.game.serviceImpl;

import org.game.dto.Position;
import org.game.service.AbstractTree;
import org.game.service.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
    @Override
    public Position<T> sibling(Position<T> p) {
        return null;
    }

    public int numChildren(Position<T> p) {
        int count = 0;
        if (left(p) != null) count++;
        if (right(p) != null) count++;

        return count;
    }

    public Iterable<Position<T>> children(Position<T> p) {
        List<Position<T>> snapshot = new ArrayList<>(2);
        if (left(p) != null) snapshot.add(left(p));
        if (right(p) != null) snapshot.add(right(p));

        return snapshot;
    }
}
