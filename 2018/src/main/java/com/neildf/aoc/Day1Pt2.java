package com.neildf.aoc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1Pt2 implements Algorithm<Integer> {

    @InputFile(input = "day1.txt")
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
}
