public class Node <K extends Comparable<K>, V> {

    K key; // Clave del nodo
    V value; // Valor del nodo     
    Node<K, V> left; // Nodo izquierdo
    Node<K, V> right; // Nodo derecho
    

    /**
     * Constructor de la clase Node.
     * @param key Clave del nodo
     * @param value Valor del nodo
     */
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }


    public Node<K, V> getLeft() {
        return left;
    }


    public Node<K, V> getRight() {
        return right;
    }


    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

}
