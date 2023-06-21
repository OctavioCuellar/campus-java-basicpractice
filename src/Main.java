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

        // Problema 1: Dado un array de enteros, identificar los numeros que se repiten en el array y la cantidad de veces que se repite.
        int[] myArray = {1, 2, 3, 4, 5, 6, 1, 2,2, 4, 6, 7, 9, 9, 10, 11, 13, 15, 11, 11,15,20};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : myArray) {
            if (map.containsKey(i)) {
                int add = map.get(i);
                map.put(i, add + 1);
            }
            else
                map.put(i, 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            int key = i.getKey();
            int value = i.getValue();
            if (value > 1)
                System.out.println(key + " se repite " + value + " veces.");
        }

        // Problema 2: Dado un string "Hello World" crear un algoritmo para invertir el texto. Salida esperada: "droW olleH" Nota: No utilizar metodos de clases ya desarrollados para la resolucion del ejercicio.
        String input = "Hello World";
        char [] myCharArray = input.toCharArray();

        int left = 0;
        int right = myCharArray.length - 1;

        while (left < right){
            char temp = myCharArray[left];
            myCharArray[left] = myCharArray[right];
            myCharArray[right] = temp;
            right--;
            left++;
        }

        String output = new String(myCharArray);
        System.out.println("Hello World al reves es: " + output);

        // Segunda solucion al problema 2
        String value = "Hello World";
        String reversedValue = "";

        for(int i = value.length() - 1; i >= 0; i--){
            reversedValue += value.charAt(i);
        }

        System.out.println(value);
        System.out.println(reversedValue);

    }

    // ... en Java es similar a params en C#
    @SafeVarargs
    public static <T> List<T> listOf(T... elements) {
        List<T> list = new ArrayList<>(Arrays.asList(elements));
        return Collections.unmodifiableList(list);
    }

}