package org.example.gamemarket.validation;

import org.example.gamemarket.validation.constraint.UUIDFormatCheckerConstraint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.UUID;
import java.util.stream.Stream;

public class UUIDFormatCheckerTest {

    private final UUIDFormatCheckerConstraint uuidFormatCheckerConstraint = new UUIDFormatCheckerConstraint();

    @ParameterizedTest
    @MethodSource("getListOfID")
    public void isValidTest(UUID ID, boolean expected) {
        Assertions.assertEquals(expected, uuidFormatCheckerConstraint.isValid(ID, null));
    }

    private static Stream<Arguments> getListOfID() {
        return Stream.of(
                Arguments.of("cd8edecd-0d27-4228-8fe6-911c1cf7fd7c", true),
                Arguments.of("55035fe9-37e3-466f-ba4a-197f23fc5700", true),
                Arguments.of("fc698b8c-f835-4800-b633-2f7905bfa238", true)
        );
    }


}
