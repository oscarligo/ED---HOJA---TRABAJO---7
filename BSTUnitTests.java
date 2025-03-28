import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;

public class BSTUnitTests {


    private BinarySearchTree<String, Products> bst;
    private Products product1;
    private Products product2;
    private Products product3;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
        product1 = new Products("100", "Product 1", "Description 1", null);
        product2 = new Products("200", "Product 2", "Description 2", null);
        product3 = new Products("300", "Product 3", "Description 3", null);
        
    }

    @Test

    public void shouldBeAbleToInsertProduct() {
        bst.insert(product1.sku, product1);
        bst.insert(product2.sku, product2);
        bst.insert(product3.sku, product3);

        assertEquals(product1, bst.search(product1.sku));
        assertEquals(product2, bst.search(product2.sku));
        assertEquals(product3, bst.search(product3.sku));
    }

    @Test

    public void shouldBeAbleToSearchProduct() {
        bst.insert(product1.sku, product1);
        bst.insert(product2.sku, product2);
        bst.insert(product3.sku, product3);

        assertEquals(product1, bst.search(product1.sku));
        assertEquals(product2, bst.search(product2.sku));
        assertEquals(product3, bst.search(product3.sku));
    }
    
}
