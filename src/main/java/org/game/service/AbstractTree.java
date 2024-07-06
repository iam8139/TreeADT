package org.game.service;

import org.game.dto.Position;

public abstract class AbstractTree<T> implements Tree<T>{
    public boolean isInternal(Position<T> p) {
        return numChildren(p) > 0;
    }
    public boolean isExternal(Position<T> p) {
        return numChildren(p) == 0;
    }
    public boolean isRoot(Position<T> p) {
        return p == root();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
}
