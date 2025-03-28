/** 
 * Clase para un Binary Search Tree (BST) o arbol de busqueda binaria.
 * 
 * Se hicieron modificaciones a la clase original para que sea generica y
 * pueda almacenar cualquier tipo de dato en forma de clave y valor.
 * @author https://www.geeksforgeeks.org/insertion-in-binary-search-tree/
 */

public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    // A utility function to insert a new node
    // with the given key
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> root, K key, V value) {
        // If the tree is empty, return a new node
        if (root == null)
            return new Node<>(key, value);
        // If the key is less than the root's key,
        if (key.compareTo(root.key) < 0)
            root.left = insert(root.left, key, value);
        // If the key is greater than the root's key,
        else if (key.compareTo(root.key) > 0)
            root.right = insert(root.right, key, value);
        // If the key is already present, update the value
        else
            root.value = value;

        // return the unchanged node pointer
        return root;
    }

    
    public V search(K key) {
        return search(root, key);
    }

    private V search(Node<K, V> root, K key) {
        // Base case: root is null (key not found)
        if (root == null)
        return null;

        // Key is found
        if (root.key.equals(key))
            return root.value;

        // Key is greater, search right subtree
        if (key.compareTo(root.key) > 0)
            return search(root.right, key);

        // Key is smaller, search left subtree
        return search(root.left, key);

    }

    // A utility function to do inorder traversal
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<K, V> root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.value.toString() + "\n");
            inorder(root.right);
        }
    }
}
