package com.epam.jwd.task3.entities;

public class Tree {
    private Node root;
    private Node currentFather;

    public Node getRoot() {
        return root;
    }

    public Tree() {
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            currentFather = node;
        } else {
            currentFather.getChildNodes().add(node);
            node.setFather(currentFather);
        }
    }

    public Node getCurrentFather() {
        return currentFather;
    }

    public void setCurrentFather(Node currentFather) {
        this.currentFather = currentFather;
    }


    public void print(Node root) {
        for (Node childNode : root.getChildNodes()) {


        }
    }
}