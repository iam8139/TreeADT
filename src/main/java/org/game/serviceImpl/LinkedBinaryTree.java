package org.game.serviceImpl;

import org.game.dto.Position;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
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

    public Position<T> addRoot(T p) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not Empty");
        root = createNode(null, null, null, p);
        size = 1;
        return root;
    }

    public Position<T> addLeft(Position<T> p, T e) {
        Node<T> node = validate(p);
        if (node.getLeft() != null) throw new IllegalStateException("Position p already has a left child");
        node.setLeft(createNode(node, null, null, e));
        size++;
        return node.getLeft();
    }

    public Position<T> addRight(Position<T> p, T e) {
        Node<T> node = validate(p);
        if (node.getRight() != null) throw new IllegalStateException("Position p already has a right child");
        node.setRight(createNode(node, null, null, e));
        size++;
        return node.getRight();
    }

    public T set(Position<T> p, T e) {
        Node<T> node = validate(p);
        T temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<T> p, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        Node<T> node = validate(p);
        if (isInternal(node)) throw new IllegalStateException("Node must be a leaf");

        if (!left.isEmpty()) {
            left.root.setParent(node);
            node.setLeft(left.root);
            left.root = null;
            left.size = 0;
        }

        if (!right.isEmpty()) {
            right.root.setParent(node);
            node.setRight(right.root);
            right.root = null;
            right.size = 0;
        }

        size += left.size() + right.size();
    }

    public T remove(Position<T> p) {
        Node<T> node = validate(p);
        if (numChildren(p) == 2) throw new IllegalArgumentException("Node has two children");
        Node<T> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (child != null) child.setParent(node.getParent());
        if (node == root) {
            root = child;
        } else {
            Node<T> parent = node.getParent();
            if (node == parent.getLeft()) parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        T temp = node.getElement();
        node.setRight(null);
        node.setLeft(null);
        node.setElement(null);
        node.setParent(node);

        return temp;
    }
}
