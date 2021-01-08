package com.epam.jwd.task3.printer;

import com.epam.jwd.task3.entities.Node;
import com.epam.jwd.task3.parser.XMLParser;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class XMLPrinter implements Printer {
    private XMLParser parser;
    private Queue<Node> nodes=new ArrayDeque<>();

    public XMLPrinter(XMLParser parser) {
        this.parser = parser;
    }

    @Override
    public void print() throws IOException {
        parser.parse();
        dfs(parser.getTree().getRoot());
        System.out.println(parser.getTree().getRoot());
        for (Node node : nodes) {
            if (node.hasContent()) {
                System.out.println(node.toString());
            }
        }
    }

    private void dfs(Node node) {
        if (!node.getChildNodes().isEmpty()) {
            nodes.addAll(node.getChildNodes());
        }
        for (Node childNode : node.getChildNodes()) {
            dfs(childNode);
        }
    }
}
