package com.neildf.aoc;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1Pt2 implements Algorithm<Integer> {
    @Override
    public Integer apply(String input) {
        Set<Integer> seen = new HashSet<Integer>() {{
            add(0);
        }};

        Integer frequency = 0;

        // No bounds validation
        while (true) {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextInt()) {
                frequency += scanner.nextInt();

                if (seen.contains(frequency)) {
                    return frequency;
                }

                seen.add(frequency);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String input = Algorithm.loadInputFromFile("day1.txt");

            Day1Pt2 algo = new Day1Pt2();

            System.out.println(algo.apply(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
