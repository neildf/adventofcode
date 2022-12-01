package com.neildf.aoc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day1Pt1 implements Algorithm<Integer> {
    @InputFile(input = "day1.txt")
    public Integer apply(String input) {
        return Arrays.stream(input.split("\n\n"))
                .mapToInt(value ->
                Arrays.stream(value.split("\n"))
                        .collect(Collectors.summingInt(Integer::parseInt))).max().getAsInt();
    }
}
