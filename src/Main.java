
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;



public class Main {
    public static void main(String[] args) {

        String archivo = "C:\\Users\\CM\\Downloads\\divina_comedia_sp.txt";
        BufferedReader fr = null;

        int caracteresLeidos = 0;
        String palabraActual = "";
        int palabrasValidas = 0;

        int[] histograma = new int[11];

        try {
            fr = new BufferedReader (new FileReader(archivo));
            int caracter = fr.read();
            while (caracter != -1) {
                caracteresLeidos++;

                if (Character.isLetter(caracter)) {
                    palabraActual += (char) caracter;
                } else if (!palabraActual.isEmpty() && palabraActual.length() >= 2 && palabraActual.length() <= 10) {
                    palabrasValidas++;
                    histograma[palabraActual.length()]++;
                    palabraActual = "";
                } else {
                    palabraActual = "";
                }

                caracter = fr.read();

            }

                System.out.println("Número de caracteres leídos "+ caracteresLeidos);

            for (int i = 2; i <= 10; i++) {
                System.out.println("Palabras de longitud: " + i + ": " + histograma[i]);
            }


        } catch (FileNotFoundException e){
            System.out.println("Error: Archivo no encontrado");
            System.out.println(e.getMessage());

        } catch (Exception e){
            System.out.println("Error de lectura del archivo");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
                System.out.println(e.getMessage());
            }
            }
         }
      }


