import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<String> jedis = listOf("Anakin", "Leia", "Luke", "Rey");
        jedis = listOf("Obiwan");

        List<String> filteredJedis = jedis.stream()
                .peek(System.out::println) // Forma funcional de sout
                .filter(s -> !s.equals("Rey")) // Map
                .peek(System.out::println)
                .map(String::toUpperCase) // Map
                .peek(System.out::println)
                .collect(Collectors.toList()); // Reduce, Collectors

        System.out.println("\nfilteredJedis = " + filteredJedis);

//        Float n = 12l;
//        n = 12.5;

        List<Float> listFloat = Arrays.asList(-12f, 120.12f, 7f, 11f, 100f);

        List<Float> filteredFloat1 = listFloat.stream()
                .peek(System.out::println)
                .filter(m -> m < 50)
                .peek(System.out::println)
                .map(m -> (float)Math.pow(m, 2f))
                .collect(Collectors.toList());

        System.out.println("filteredFloat = " + filteredFloat1);

        Stream<Float> filteredFloat = listFloat.stream()
                .filter(m -> m < 50)
                .map(m -> (float)Math.pow(m, 2f));

        filteredFloat.forEach(System.out::println);

        Ejercicio ejercicio = new Ejercicio();
        ejercicio.ejemplo();

        Ejercicio2 ejercicio2 = new Ejercicio2();
        ejercicio2.ejemplo();

    }

    // ... en Java es similar a params en C#
    @SafeVarargs
    public static <T> List<T> listOf(T... elements) {
        List<T> list = new ArrayList<>(Arrays.asList(elements));
        return Collections.unmodifiableList(list);
    }

}