package lab8;
import lab8.Map61B;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
  private BST root; // root of BST
  private class BST {
    private K key;
    private V value;
    BST left, right;
    private int size; // # of nodes in BST

    public BST(K k, V v, int size) {
      this.key = k;
      this.value = v;
      this.size = size;
    }
  }

  /**
  * Empty BSTMap
  */
  public BSTMap() {
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }

  public Iterator<K> iterator() {
    throw new UnsupportedOperationException("Invalid!");
  }

  public V get(K key) {
    return getHelper(root, key);
  }

  private V getHelper(BST r, K key) {
    if (key == null) {
      return null;
    }
    int cmp = key.compareTo(r.key);
    if (cmp < 0) {
      // Negative if key is less than argument value, which is the BST key
      return getHelper(r.left, key);
    } else if (cmp > 0) {
      // Positive if key is greater than argument value, which is the BST key
      return getHelper(r.right, key);
    } else {
      return r.value;
    }
  }

  public void put(K key, V value) {
    // Error handling -> key null? value null?
    root = putHelper(root, key, value);
  }

  private BST putHelper(BST r, K key, V value) {
    if (r == null) {
      return new BST(key, value, 1);
    }
    int cmp = key.compareTo(r.key); // Return 0 if equal, a value less than 0 means a string is greater than this string, a value greater than 0 means a string is less than this string
    if (cmp < 0) {
      r.left = putHelper(r.left, key, value);
    } else if ( cmp > 0 ) {
      r.right = putHelper(r.right, key, value);
    } else {
      r.value = value;
    }
    r.size = 1 + r.left.size + r.right.size;
    return r;
  }

  public int size() {
    if (root == null) {
      return 0;
    }
    return root.size;
  }

  public void clear() {
    root = null;
  }

  public void printInOrder() {
    printInOrderHelper(root);
  }

  private void printInOrderHelper(BST r) {
      if (root == null) {
        return;
      }
      printInOrderHelper(r.left);
      System.out.print(r.value + " ");
      printInOrderHelper(r.right);
  }

  // Extra -> DELETE FUNCTION! :O
  public V remove(K key) {
    root = removeHelper(root, key);
    return root.value;
  }

  private BST removeHelper(BST r, K key) {
    if (r == null) {
      return null;
    }

    int cmp = key.compareTo(r.key);
    // Negative value if argument is greater than key, if BST key is greater than the key
    // Positive value if key is greater than the BST key
    if (cmp < 0) {
      r.left = removeHelper(r.left, key);
    } else if(cmp > 0) {
      r.right = removeHelper(r.right, key);
    } else {
      if (r.left == null) {
        return r.right;
      } else if (r.right == null) {
        return r.left;
      }

      // Examine this code!
      BST temp = r;
      r = minHelper(temp.right);
      r.right = deleteMin(temp.right);
      r.left = temp.left;
    }
    r.size = r.left.size + r.right.size + 1;
    return r;
  }

  public V remove(K key, V value) {
    throw new UnsupportedOperationException("Invalid operation!");
  }

  public K min() {
    return minHelper(root).key;
  }

  private BST minHelper(BST r) {
    if (r.left == null) return r;
    else                return minHelper(r.left);
  }

  public K max() {
    return maxHelper(root).key;
  }

  private BST maxHelper(BST r) {
    if (r.right == null) return r;
    else                return maxHelper(r.right);
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private BST deleteMin(BST r) {
    if (r.left == null) {
      return r.right;
    }
    r.left = deleteMin(r.left);
    r.size = r.left.size + r.right.size + 1;
    return r;
  }
}
