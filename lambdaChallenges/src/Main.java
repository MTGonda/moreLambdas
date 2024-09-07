import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () ->"I despise lambdas";
        System.out.println(stringSupplier.get());
        System.out.println(everyChar("String"));
        System.out.println("-".repeat(10));





        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String s) {

                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        Consumer<String> printTheParts2 = s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        Consumer<String> printTheParts3 = s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(s1 -> System.out.println(s1));
        };


        printTheParts.accept("This text is to be splitted");
        System.out.println("-".repeat(10));
        printTheParts2.accept("This text is to be splitted");
        System.out.println("-".repeat(10));
        printTheParts3.accept("This text is to be splitted");


        Consumer<String> printTheParts4 = s -> {
            Arrays.asList(s.split(" ")).forEach(s1 -> System.out.println(s1));

        };
        System.out.println("-".repeat(10));
        printTheParts3.accept("This text is to be splitted");



        UnaryOperator<String> everyCharLambda = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everyCharLambda.apply("1234567890"));

        String res = everySecondCharacter(everyCharLambda ,"1234567890");




    }

    public static String everyChar(String s) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(UnaryOperator<String> unaryOperator, String inputString) {

        return unaryOperator.apply(inputString);
    }
}

