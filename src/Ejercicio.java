public class Ejercicio {

    public void ejemplo () {
        ejecutar(this::imprimir);
    }

    public void imprimir (String texto) {
        System.out.println(texto);
    }

    public void ejecutar (Operacion operacion) {
        operacion.run("Hola mundo");
    }

}

@FunctionalInterface
interface Operacion {
    void run (String s);
}