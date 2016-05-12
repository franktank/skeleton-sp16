public class LinkedListDeque<Item> {
  public class Node {
    public Item item;
    public Node prev;
    public Node next;

    public Node(Item i, Node p, Node n) {
      item = i;
      prev = p;
      next = n;
    }
  }
  private Node sentinel;
  private int size;

  //Empty list
  public LinkedListDeque() {
    size = 0;
    sentinel = new Node(null, null, null);
  }

  public LinkedListDeque(Item toAdd) {
    size = 1;
    sentinel = new Node(null, null, null);
    sentinel.next = new Node(x, sentinel, null);
    //Point sentinel.prev to end of list
    Node end = sentinel;
    while (sentinel.next != null) {
      end = sentinel.next;
    }
    sentinel.prev = end;

  }

  public Item getRecursive(int index) {
    //prob needs a helper function
  }
  public void addFirst(Item toAdd) {

  }

  public void addLast(Item toAdd) {

  }

  public boolean isEmpty() {

  }

  public int size() {

  }

  public void printDeque() {

  }

  public Item removeFirst() {

  }

  public Item removeLast() {

  }

  public Item get(int index) {

  }
 }
