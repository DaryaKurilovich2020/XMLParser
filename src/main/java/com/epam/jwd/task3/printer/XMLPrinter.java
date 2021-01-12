package com.epam.jwd.task3.printer;

import com.epam.jwd.task3.entities.Attribute;
import com.epam.jwd.task3.entities.Node;
import com.epam.jwd.task3.parser.XMLParser;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class XMLPrinter implements Printer {
    private final XMLParser parser;
    Queue<Node> nodes = new ArrayDeque<>();

    public XMLPrinter(XMLParser parser) {
        this.parser = parser;
    }

    @Override
    public void print() throws IOException {
        parser.parse();
        treeTraversal(parser.getTree().getRoot());
        System.out.println(printNode(parser.getTree().getRoot()));
        for (Node node : nodes) {
            if (node.hasContent() || node.hasAttributes()) {
                System.out.println(printNode(node));
            }
        }
    }

    private void treeTraversal(Node node) {
        if (!node.getChildNodes().isEmpty()) {
            for (Node childNode : node.getChildNodes()) {
                nodes.add(childNode);
                treeTraversal(childNode);
            }
        }
    }

    private String printNode(Node node) {
        StringBuilder attributesToString = new StringBuilder();
        for (Attribute attribute : node.getAttributes()) {
            attributesToString.append(attribute.toString()).append(" ");
        }
        if (node.hasContent()) {
            return node.getName() + " " + node.getContent() + " " + attributesToString.toString();
        } else {
            return node.getName() + " " + attributesToString.toString();
        }
    }
}