import java.util.Map;

/**
 * Clase para poder almacenar los productos que se lean de un archivo
 * y que se puedan almacenar en un arbol de busqueda binaria.
 */
public class Products {

    String sku;
    String name;
    String description;
    Map<String, Integer> sizes;

    public Products(String sku, String name, String description, Map<String, Integer> sizes) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.sizes = sizes;
    }


    @Override
    public String toString() {
        return "SKU: " + sku + " - Producto: " + name + " - Tallas: " + sizes;
    }
    public String completeDescription() {
        return "SKU: " + sku + "\nPRODUCTO: " + name + "\nDESCRIPCIÓN: " + description + "\n\nTALLAS DISPONIBLES:\n" + sizes;
    }
}




    

