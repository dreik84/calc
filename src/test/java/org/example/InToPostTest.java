package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InToPostTest {

    private static final Map<String, String> IN_POST_PAIRS = new HashMap<>();

    @BeforeAll
    static void init() {
        IN_POST_PAIRS.put("2*2", "22*");
        IN_POST_PAIRS.put("2+2*2", "222*+");
        IN_POST_PAIRS.put("2*(2+2)", "222+*");
    }

    @Test
    void doTrans() {

        IN_POST_PAIRS.forEach((input, expected) -> {
            InToPost inToPost = new InToPost(input);
            String actual = inToPost.doTrans();

            assertEquals(expected, actual);
        });
    }
}
