package com.epam.jwd.task3.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class XMLReader implements Reader {
    private String filepath;

    public XMLReader(String filepath) {
        this.filepath = filepath;
    }

    public List<String> read() throws IOException {
        List<String> tokens = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String line;
        StringTokenizer stringTokenizer;
        while ((line = bufferedReader.readLine()) != null) {
            stringTokenizer = new StringTokenizer(line, "<>", true);
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                if (!token.isBlank()) {
                    token.trim();
                    tokens.add(token);
                }
            }
        }
        bufferedReader.close();
        return tokens;
    }
}