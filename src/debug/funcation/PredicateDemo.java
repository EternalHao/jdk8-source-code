package debug.funcation;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = (str)-> str.length()>5;
        // true
        System.out.println(predicate.test("woaini"));

        //false
        System.out.println(predicate.test("wo"));
    }
}
