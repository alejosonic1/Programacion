import java.util.Scanner;

public class MATRICULA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una matrícula (en el formato XXXX YYY):");
        String matricula = scanner.nextLine();

        while (!matricula.equals("9999 ZZZ")) {
            String siguienteMatricula = obtenerSiguienteMatricula(matricula);
            System.out.println("La siguiente matrícula es: " + siguienteMatricula);
            System.out.println("Ingrese otra matrícula (o '9999 ZZZ' para salir):");
            matricula = scanner.nextLine();
        }

        System.out.println("Fin del programa.");
        scanner.close();
    }

    private static String obtenerSiguienteMatricula(String matricula) {
        String[] partes = matricula.split(" ");
        int numero = Integer.parseInt(partes[0]);
        String letras = partes[1];

        if (numero < 9999) {
            numero++;
        } else {
            // Cambiamos la última letra si el número alcanza 9999
            char[] chars = letras.toCharArray();
            
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != 'Z') {
                    chars[i]++;
                    break;
                } else {
                    chars[i] = 'A';
                }
            }
            letras = new String(chars);
        }

        return numero + " " + letras;
    }
}

