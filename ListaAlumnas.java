import java.io.*;

public class ListaAlumnas {

    public static void main(String[] args) {

        int cont = 0;
        int totalEdad = 0;
        double totalNota = 0;
        double maxNota = Double.MIN_VALUE;
        double minNota = Double.MAX_VALUE;

        try {
            FileReader fileReader = new FileReader("src/lista_alumnos.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                if (cont == 0) {
                    cont++;
                    continue;
                }

                String[] partes = linea.split(",");
                int edad = Integer.parseInt(partes[3].trim());
                totalEdad += edad;

                double nota = Double.parseDouble(partes[4].trim());
                totalNota += nota;

                if (nota > maxNota) {
                    maxNota = nota;
                }

                if (nota < minNota) {
                    minNota = nota;
                }

                cont++;
            }

            bufferedReader.close();

            FileWriter fileWriter = new FileWriter("informe-clase.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println("Número de estudiantes: " + (cont - 1));
            printWriter.println("Edad media de los estudiantes: " + (double) totalEdad / (cont - 1));
            printWriter.println("Nota media de los estudiantes: " + String.format("%.2f", totalNota / (cont - 1)));

            printWriter.close();

            System.out.println("Informe generado correctamente en el archivo 'informe-clase.txt'.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer/escribir el archivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir la edad o la nota a un número entero o decimal.");
            e.printStackTrace();
        }
    }
}
