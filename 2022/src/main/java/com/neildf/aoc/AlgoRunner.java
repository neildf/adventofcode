package com.neildf.aoc;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AlgoRunner {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.neildf.aoc", new MethodAnnotationsScanner());

        Set<Method> applyMethods = reflections.getMethodsAnnotatedWith(InputFile.class);

        applyMethods.stream().forEach(m -> {
            try {

                Object instance = m.getDeclaringClass().newInstance();

                String inputFile = m.getAnnotation(InputFile.class).input();
                String inputString = loadInputFromFile(inputFile);

                long startTime = System.nanoTime();
                Object result = m.invoke(instance, inputString);
                long endTime = System.nanoTime();

                System.out.println(instance.getClass().getName() + "(" + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + "ms ): " + result);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Move along, nothing to see here");
            }
        });
    }

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
