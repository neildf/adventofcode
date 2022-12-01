package com.neildf.aoc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Day1Pt2 implements Algorithm<Integer> {
    @InputFile(input = "day1.txt")
    public Integer apply(String input) {
        return Arrays.stream(input.split("\n\n"))
                .map(value ->
                        Arrays
                                .stream(value.split("\n"))
                                .collect(Collectors.summingInt(Integer::parseInt))
                )
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.summingInt(Integer::intValue));
    }
}
