package com.epam.jwd.task3.printer;

import com.epam.jwd.task3.entities.Node;
import com.epam.jwd.task3.parser.XMLParser;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class XMLPrinter implements Printer {
    private XMLParser parser;
    Queue<Node> nodes = new ArrayDeque<>();

    public XMLPrinter(XMLParser parser) {
        this.parser = parser;
    }

    @Override
    public void print() throws IOException {
        parser.parse();
        treeTraversal(parser.getTree().getRoot());
        System.out.println(parser.getTree().getRoot().print());
        for (Node node : nodes) {
            if (node.hasContent() || node.hasAttributes()) {
                System.out.println(node.print());
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
}