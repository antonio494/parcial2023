import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Object> libro1 = ingresarLibro(sc);
        Map<String, Object> libro2 = ingresarLibro(sc);
        Map<String, Object> libro3 = ingresarLibro(sc);
        Map<String, Object> libro4 = ingresarLibro(sc);
        System.out.println(Biblioteca(libro1, libro2, libro3, libro4));
    }

    public static Map<String, Object> ingresarLibro(Scanner sc) {
        Map<String, Object> libro = new HashMap<>();
        System.out.print("Ingrese el nombre del libro: ");
        libro.put("nombre", sc.nextLine());
        System.out.print("Ingrese el nombre del autor: ");
        libro.put("autor", sc.nextLine());
        System.out.print("Ingrese el código del libro: ");
        libro.put("codigo", sc.nextLine());
        System.out.print("Ingrese el año de publicación: ");
        libro.put("año_publicacion", sc.nextLine());
        System.out.print("Ingrese el precio del libro: ");
        libro.put("precio", Double.parseDouble(sc.nextLine()));
        System.out.print("Ingrese el costo del libro: ");
        libro.put("costo", Double.parseDouble(sc.nextLine()));
        System.out.print("Ingrese la demanda del libro: ");
        libro.put("demanda", Integer.parseInt(sc.nextLine()));
        return libro;
    }
    public static String Biblioteca(Map<String, Object> libro1, Map<String, Object> libro2, Map<String, Object> libro3, Map<String, Object> libro4) {
        List<Map<String, Object>> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);

        Map<String, Object> mejorLibro = null;
        double gananciaMaxima = 0;
        for (Map<String, Object> libro : libros) {
            int demanda = (int) libro.get("demanda");
            double precio = (double) libro.get("precio");
            double costo = (double) libro.get("costo");
            double ganancia = (precio - costo) * demanda;
            if (ganancia > gananciaMaxima && demanda >= 100 && (demanda <= 800 || precio * 1.1 - costo >= 14000)) {
                gananciaMaxima = ganancia;
                mejorLibro = libro;
            }
        }

        if (mejorLibro != null) {
            String nombre = (String) mejorLibro.get("nombre");
            String autor = (String) mejorLibro.get("autor");
            String codigo = (String) mejorLibro.get("codigo");
            String año = (String) mejorLibro.get("año_publicacion");
            double precio = (double) mejorLibro.get("precio");
            return "El libro " + nombre + " escrito por " + autor + " en el año " + año + " con el código " + codigo + " y precio de " + precio + " es la mejor opción a vender.";
        } else {
            return "Ninguno de los libros es la mejor opción para ser vendido.";
        }
    }
}
