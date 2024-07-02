import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        String palabraDescubrir = "alfabeto";
        int intentosMax = 6;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraDescubrir.length()];

        for(int i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraDescubrir.length() + " letras)");
            
            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraDescubrir.length(); i++) {
                if (palabraDescubrir.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true; 
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos." );
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraDescubrir)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraDescubrir);
            }

        }

        if (!palabraAdivinada) {
            System.out.println("¡Que pena te has quedado sin intentos! - FIN DEL JUEGO -");
        }

        scanner.close();
    }
}
