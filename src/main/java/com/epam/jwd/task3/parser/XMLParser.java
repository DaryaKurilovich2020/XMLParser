package com.epam.jwd.task3.parser;

import com.epam.jwd.task3.entities.Attribute;
import com.epam.jwd.task3.entities.Node;
import com.epam.jwd.task3.entities.Tree;
import com.epam.jwd.task3.reader.XMLReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class XMLParser implements XMLParsing{
    private List<String> tokens = new ArrayList<>();
    private final String filepath;
    private Tree tree=new Tree();
    private static final String OPENING_BRACKET = "<";
    private static final char CLOSING_TAG_IDENTIFIER = '/';
    private static final char COMMENT_IDENTIFIER = '!';
    private static final char DECLARATION_IDENTIFIER = '?';

    public XMLParser(String filepath) {
        this.filepath = filepath;
    }

    public Tree getTree() {
        return tree;
    }

    public void parse() throws IOException {
        XMLReader reader = new XMLReader(filepath);
        tokens = reader.read();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals(OPENING_BRACKET)) {
                switch (tokens.get(i + 1).charAt(0)) {
                    case CLOSING_TAG_IDENTIFIER:
                        tree.setCurrentFather(tree.getCurrentFather().getFather());
                        i += 2;
                        break;
                    case DECLARATION_IDENTIFIER:
                    case COMMENT_IDENTIFIER:
                        i = skipNonNode(i);
                        break;
                    default:
                        handleElement(i);
                        i+=2;
                        break;
                }
            } else {
                handleContent(token);
            }
        }
    }

    private int skipNonNode(int i) {
        for (int j = i + 1; j < tokens.size(); j++) {
            if (tokens.get(j).equals(">")) {
                i = j;
                break;
            }
        }
        return i;
    }

    private static boolean contentsAttribute(String token) {
        StringTokenizer tokenTokenizer = new StringTokenizer(token, " ");
        return tokenTokenizer.countTokens() > 1;
    }

    private void handleElement(int i) {
        if (contentsAttribute(tokens.get(i+1))) {
            handleAttribute(i+1);
        } else {
            Node newNode = new Node(tokens.get(i + 1));
            tree.insert(newNode);
            tree.setCurrentFather(newNode);
        }
    }

    private void handleContent(String token) {
        tree.getCurrentFather().setContent(token);
    }
    private void handleAttribute(int i){
        StringTokenizer tokenizer = new StringTokenizer(tokens.get(i)," =");
        Node newNode = new Node(tokenizer.nextToken());
        while (tokenizer.hasMoreTokens()) {
            Attribute attribute = new Attribute(tokenizer.nextToken(), tokenizer.nextToken());
            newNode.addAttribute(attribute);
        }
        tree.insert(newNode);
        tree.setCurrentFather(newNode);
    }
}