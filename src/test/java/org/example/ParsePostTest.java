package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParsePostTest {

    static Stream<Map<String, Integer>> doParse() {
        return Stream.of(
                Map.of("22*", 4),
                Map.of("222*+", 6),
                Map.of("22+2*", 8)
        );
    }

    @ParameterizedTest
    @MethodSource
    void doParse(Map<String, Integer> pairs) {

        pairs.forEach((post, expected) -> {
            ParsePost parsePost = new ParsePost(post);
            int actual = parsePost.doParse();

            assertEquals(expected, actual);
        });
    }
}
