import org.example.PhoneBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expected, phoneBook.add(name2, number2));
    }

    public static Stream<Arguments> findByNumber() {
        List<Arguments> argumentsList = List.of(
                Arguments.of("Ivan", "Ivan", "+79001111223", "Ivan", "+79003333445"),
                Arguments.of("Liza", "Liza", "+79002222334", "Petr", "+79004444556"));
        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("findByNumber")
    void testFindByNumber(String expected, String name1, String number1, String name2, String number2) {
        System.out.println("test findByNumber");
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        assertEquals(expected, phoneBook.findByNumber(number1));
    }

    public static Stream<Arguments> findByName() {
        List<Arguments> argumentsList = List.of(
                Arguments.of(  "+79001111223", "Ivan", "+79001111223", "Ivan", "+79003333445"),
                Arguments.of(  "+79004444556", "Liza", "+79004444556", "Petr", "+79004444556"));
        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("findByName")
    void testFindByName(String expected, String name1, String number1, String name2, String number2) {
        System.out.println("test findByName");
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        assertEquals(expected, phoneBook.findByName(name1));
    }


}
