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
        //todo
        List<String> tokens = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)));
        String line;
        StringTokenizer stringTokenizer;
        while ((line = bufferedReader.readLine()) != null) {
            line.replaceAll("\n","");
            line.replaceAll("\t","");
line.replaceAll(" ","");
            stringTokenizer = new StringTokenizer(line, "<>", true);
            while (stringTokenizer.hasMoreTokens()) {
                tokens.add(stringTokenizer.nextToken());
            }
        }
        bufferedReader.close();
        return tokens;
    }
}
