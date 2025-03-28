import java.util.Map;

/**
 * Clase para poder almacenar los productos que se lean de un archivo
 * y que se puedan almacenar en un arbol de busqueda binaria.
 */
public class Products {

    String sku; // SKU del producto
    String name; // Nombre del producto
    String description; // Descripción del producto
    Map<String, Integer> sizes; // Tallas y cantidades disponibles

    /**
     * Constructor de la clase Products.
     * @param sku SKU del producto
     * @param name Nombre del producto
     * @param description Descripción del producto
     * @param sizes Tallas y cantidades disponibles
     */

    public Products(String sku, String name, String description, Map<String, Integer> sizes) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.sizes = sizes;
    }

    /** 
     * Metodo para obtener la información del producto.
     * en un formato más simple.
     * @return String con la información del producto
     */
    @Override
    public String toString() {
        return "SKU: " + sku + " - Producto: " + name + " - Tallas: " + sizes;
    }

    /**
     * Metodo para obtener la información del producto
     * en un formato más completo.
     * @return String con la información del producto  
     */
    public String completeDescription() {
        return "SKU: " + sku + "\nPRODUCTO: " + name + "\nDESCRIPCIÓN: " + description + "\n\nTALLAS DISPONIBLES:\n" + sizes;
    }
}




    

