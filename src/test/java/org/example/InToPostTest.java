package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InToPostTest {

    static Stream<Map<String, String>> doTrans() {
        return Stream.of(
                Map.of("2*2", "22*"),
                Map.of("2+2*2", "222*+"),
                Map.of("2+2*2", "222*+")
        );
    }

    @ParameterizedTest
    @MethodSource
    void doTrans(Map<String, String> inPostTest) {

        inPostTest.forEach((input, expected) -> {
            InToPost inToPost = new InToPost(input);
            String actual = inToPost.doTrans();

            assertEquals(expected, actual);
        });
    }
}
