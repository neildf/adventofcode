package com.neildf.aoc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Algorithm<T> {
    T apply(String input);

    static String loadInputFromFile(String filename) throws IOException {
        try (InputStream inputStream = Algorithm.class.getClassLoader().getResourceAsStream(filename)) {

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }

            return result.toString("UTF-8");
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface InputFile {
    String input();
}
