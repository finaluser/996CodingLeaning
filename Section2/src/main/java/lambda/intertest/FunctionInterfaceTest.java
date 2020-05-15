package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FunctionInterfaceTest {

    static void pred(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }

    /**
     * 匿名类:判断传入的字符串长度是否大于10
     */
    public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
        @Override
        public boolean test(String t) {
            return t.length() > 10;
        }
    };

    /**
     * OR
     */
    public static void predicate_or() {

        Predicate<String> containsLetterA = p -> p.contains("A");
        String containsA = "And";
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
        System.out.println(outcome);
    }

    /**
     * AND
     */
    public static void predicate_and() {
        Predicate<String> nonNullPredicate = Objects::nonNull;

        String nullString = null;

        boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
        System.out.println(outcome);

        String lengthGTThan10 = "Welcome to the machine";
        boolean outcome2 = nonNullPredicate.and(hasLengthOf10).
                test(lengthGTThan10);
        System.out.println(outcome2);
    }

    /**
     * negate
     */
    public static void predicate_negate() {

        String lengthGTThan10 = "Thunderstruck is a 2012 children's "
                + "film starring Kevin Durant";

        boolean outcome = hasLengthOf10.negate().test(lengthGTThan10);
        System.out.println(outcome);
    }

    public static List<User> process(List<User> users,
                                     Predicate<User> predicat) {
        List<User> result = new ArrayList<User>();
        for (User user : users)
            if (predicat.test(user))
                result.add(user);
        return result;
    }

    /**
     * Predicate测试
     */
    @Test
    public void predicateTest() {
        // Creating predicate
        Predicate<Integer> LESSER_THAN = i -> (i < 18);

        // Calling Predicate method
        System.out.println(LESSER_THAN.test(10));
    }

    /**
     * Predicate And方法测试
     */
    @Test
    public void predicateAndTest() {
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }

    /**
     * Predicate 封装成方法进行调用
     */
    @Test
    public void predicateFunctionTest() {
        pred(10, (i) -> i > 7);
    }

    /**
     * Predicate 封装成方法测试Or
     */
    @Test
    public void predicateOrTest() {
        predicate_or();
    }

    /**
     * Predicate 封装成方法测试And
     */
    @Test
    public void predicateFunctionAndTest() {
        predicate_and();
    }

    /**
     * Predicate 封装成方法测试Negate
     */
    @Test
    public void predicateFunctionNegateTest() {
        predicate_negate();
    }

    /**
     * Predicate 封装成方法测试在集合中的用法
     */
    @Test
    public void predicateCollectionTest() {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
    }

}
