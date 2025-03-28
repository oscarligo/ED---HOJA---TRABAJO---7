import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        BinarySearchTree<String, Products> bst = new BinarySearchTree<>();
        String filePath = "inventario.csv"; // Cambia la ruta al archivo CSV según sea necesario

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
            scanner.nextLine(); // Limpiar el buffer

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

    public static void loadCSV(String filePath, BinarySearchTree<String, Products> bst) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar la cabecera
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 4); // Dividir en 4 partes
                if (parts.length < 4) continue; // Validación

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

    private static Map<String, Integer> parseSizes(String sizesStr) {
        Map<String, Integer> sizes = new HashMap<>();
        String[] sizePairs = sizesStr.split("\\|");
        for (String pair : sizePairs) {
            String[] kv = pair.split(":");
            if (kv.length == 2) {
                sizes.put(kv[0], Integer.parseInt(kv[1]));
            }
        }
        return sizes;

    }  
} 
