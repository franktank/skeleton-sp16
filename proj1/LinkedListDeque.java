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
  //handle empty list
  public void addFirst(Item toAdd) {
    if (sentinel.next == null) {
      sentinel.next = new Node(toAdd, sentinel, null);
      //Point sentinel.prev to end of list
      Node end = sentinel;
      while (sentinel.next != null) {
        end = sentinel.next;
      }
      sentinel.prev = end;
    } else {
      Node oldFrontNode = sentinel.next;
      Node newNode = new Node(toAdd, sentinel, oldFrontNode);
      sentinel.next = newNode;
      size++;
    }
  }

  //change sentinel.prev to point to new Node
  //find last node and set to OldLast
  //OldLast.next = newNode
  public void addLast(Item toAdd) {
    //If empty list.
    if (sentinel.next == null) {
      sentinel.next = new Node(toAdd, sentinel, null);
      //Point sentinel.prev to end of list
      Node end = sentinel;
      while (sentinel.next != null) {
        end = sentinel.next;
      }
      sentinel.prev = end;
    } else {
      Node oldLastNode = sentinel.prev;
      Node newNode = new Node(toAdd, oldLastNode, sentinel);
      sentinel.prev = newNode;
      size++;
    }

  }

  public boolean isEmpty() {
    if (sentinel.next == null) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    if (sentinel.next == null) {
      System.out.println("Empty List!");
    } else {
      printThis = sentinel;
      while (printThis.next != sentinel) {
        System.out.println("Item: " + printThis.item);
        printThis = printThis.next;
      }
    }
  }

  public Item removeFirst() {

  }

  public Item removeLast() {

  }

  public Item get(int index) {
    while (sentinel.next != sentinel) {

    }
  }
 }
