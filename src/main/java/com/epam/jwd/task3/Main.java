package com.epam.jwd.task3;

import com.epam.jwd.task3.parser.XMLParser;
import com.epam.jwd.task3.printer.XMLPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String file = "input.txt";
        XMLParser xmlParser = new XMLParser(file);
        XMLPrinter printer = new XMLPrinter(xmlParser);
        try {
            printer.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
