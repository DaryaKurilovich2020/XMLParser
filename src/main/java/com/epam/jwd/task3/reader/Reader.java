package com.epam.jwd.task3.reader;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> read() throws IOException;
}
