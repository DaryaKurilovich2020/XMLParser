package com.epam.jwd.task3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private Node father;
    private String name;
    private List<Attribute> attributes = new ArrayList<>();
    private String content;
    private List<Node> childNodes = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getContent() {
        return content;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Node getFather() {
        return father;
    }

    public boolean hasContent() {
        return this.content != null;
    }

    public boolean hasAttributes() {
        return !this.attributes.isEmpty();
    }
}