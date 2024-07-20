package org.game.serviceImpl;

import org.game.dto.Position;

import java.util.Iterator;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T>{
    protected static class Node<T> implements Position<T> {
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        private T element;
        public Node(Node<T> parent, Node<T> left, Node<T> right, T element) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.element = element;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }
        public Node<T> getParent() {
            return parent;
        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
        public void setElement(T element) {
            this.element = element;
        }
        @Override
        public T getElement() throws IllegalStateException {
            return element;
        }
    }
    protected Node<T> createNode(Node<T> parent, Node<T> left, Node<T> right, T element) {
        return new Node<>(parent, left, right, element);
    }

    protected Node<T> root = null;
    private int size = 0;
    public LinkedBinaryTree() {}
    protected Node<T> validate(Position<T> position) {
        if (!(position instanceof Node<T> node)) throw new IllegalArgumentException("Not Valid Position Type");
        if (node.parent == node) throw new IllegalArgumentException("position is no longer in the tree");
        return node;
    }
    @Override
    public Position<T> left(Position<T> p) {
        Node<T> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<T> right(Position<T> p) {
        Node<T> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<T>> positions() {
        return null;
    }
}
