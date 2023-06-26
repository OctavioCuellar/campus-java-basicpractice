public class Ejercicio2 {

    public void ejemplo () {
        Operacion operacion = new Operacion() {
            // Clase anónima, se crea en tiempo de ejecución
            @Override
            public void run(String s) {
                System.out.println(s);
            }
        };
        operacion.run("Hola mundo 2");
    }

}