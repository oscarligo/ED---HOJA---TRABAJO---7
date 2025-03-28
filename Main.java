import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        BinarySearchTree<String, Products> bst = new BinarySearchTree<>();

        // Cargar el archivo CSV
        // Se cambia la ruta del archivo según sea necesario
        // Se asume que el archivo CSV se encuentra en la misma carpeta que el proyecto
        
        String filePath = "inventario.csv"; 

        loadCSV(filePath, bst);

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n1. Buscar producto por SKU");
            System.out.println("2. Mostrar productos en orden (Recorrido in-orden)");
            System.out.println("3. Ingresar nuevo producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("SKU del producto a buscar: ");
                    String sku = scanner.nextLine();
                    Products product = bst.search(sku);
                    if (product != null) {
                        System.out.println("\nPRODUCTO ENCONTRADO:");
                        System.out.println("\n"+ product.completeDescription());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;
                case 2:
                    System.out.println("Productos en orden:");
                    bst.inorder();
                    break;

                case 3:

                    System.out.print("Ingrese SKU: ");
                    String newSku = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String newName = scanner.nextLine();
                    System.out.print("Ingrese descripción: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Ingrese tamaños (formato: tamaño1:cantidad1|tamaño2:cantidad2): ");
                    String newSizesStr = scanner.nextLine();
                    Map<String, Integer> newSizes = parseSizes(newSizesStr);
                    Products newProduct = new Products(newSku, newName, newDescription, newSizes);
                    bst.insert(newSku, newProduct);

                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();

    }

    /**
     * Carga un archivo CSV y lo inserta en el árbol de búsqueda binaria.
     * Antes de insertar, se divide la line en partes que conforman un objeto de tipo Productos.
     *
     * @param filePath Ruta del archivo CSV
     * @param bst Árbol de búsqueda binaria donde se insertarán los productos
     */

    public static void loadCSV(String filePath, BinarySearchTree<String, Products> bst) {
        // Se utiliza BufferedReader para leer el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Se salta la primera línea (encabezados)
            // Se lee cada línea del archivo CSV
            // Se divide la línea en partes y se crea un objeto de tipo Productos
            // Se inserta el objeto en el árbol de búsqueda binaria
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 4);
                if (parts.length < 4) continue;

                String sku = parts[0];
                String name = parts[1];
                String description = parts[2];

                Map<String, Integer> sizes = parseSizes(parts[3]);

                Products product = new Products(sku, name, description, sizes);
                bst.insert(sku, product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para convertir las tallas de un String a un Map.
     * 
     * @param sizesStr String con las tallas y cantidades
     * @return Map con las tallas y cantidades
     */

    private static Map<String, Integer> parseSizes(String sizesStr) {
        Map<String, Integer> sizes = new HashMap<>();
        // Se divide el String en pares de talla y cantidad
        // Formato "talla:cantidad|talla:cantidad"
        String[] sizePairs = sizesStr.split("\\|");
        for (String pair : sizePairs) {
            // Se divide cada par en talla y cantidad
            // Formato  "talla:cantidad"
            String[] kv = pair.split(":");
            if (kv.length == 2) {
                sizes.put(kv[0], Integer.parseInt(kv[1]));
            }
        }
        return sizes;

    }  
} 
