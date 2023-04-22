import org.example.PhoneBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    public void beforeTest() {
        System.out.println("before test");
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void afterTest() {
        System.out.println("after test");
        phoneBook = null;
    }

    public static Stream<Arguments> add() {
        List<Arguments> argumentsList = List.of(
                Arguments.of(1, "Ivan", "+79001111223", "Ivan", "+79003333445"),
                Arguments.of(2, "Liza", "+79002222334", "Petr", "+79004444556"));
        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("add")
    void testAdd(int expected, String name1, String number1, String name2, String number2) {
        System.out.println("test add");
        phoneBook.add(name1, name2);
        Assertions.assertEquals(expected, phoneBook.add(name2, number2));
    }
}
