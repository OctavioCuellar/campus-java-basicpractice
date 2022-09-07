public class Ejercicio {

    public void ejemplo () {
        ejecutar(this::imprimir);
    }

    public void imprimir (String texto) {
        System.out.println(texto);
    }

    public void ejecutar (IOperacion operacion) {
        operacion.run("Hola mundo");
    }

}

@FunctionalInterface
interface IOperacion {
    void run (String s);
}