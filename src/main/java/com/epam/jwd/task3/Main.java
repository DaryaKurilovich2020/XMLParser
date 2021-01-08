package com.epam.jwd.task3;

import com.epam.jwd.task3.parser.XMLParser;
import com.epam.jwd.task3.printer.XMLPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        XMLParser xmlParser=new XMLParser("input.txt");
        XMLPrinter printer=new XMLPrinter(xmlParser);
        printer.print();
    }
}
