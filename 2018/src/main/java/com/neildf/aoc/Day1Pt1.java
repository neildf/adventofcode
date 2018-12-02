package com.neildf.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@InputFile(input = "day1.txt")
public class Day1Pt1 implements Algorithm<Integer> {

    @Override
    public Integer apply(String input) {
        // No input validation
        return Arrays.stream(input.split("\n")).collect(Collectors.summingInt(Integer::parseInt));
    }

    public static void main(String[] args) {
        try {
            String input = Algorithm.loadInputFromFile("day1.txt");
            Day1Pt1 algo = new Day1Pt1();

            System.out.println(algo.apply(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
