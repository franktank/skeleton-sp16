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


  public Item getRecursive(int index) {
    //Need to test, sentinel or sentinel.next
    //Start of index should be 1; (1st item that is not sentinel)
    return getHelper(index, sentinel);
  }

  private Item getHelper (int counter, Node currItem) {
    if (counter == 1 ) {
      return currItem.next.item;
    } else {
      return getHelper(counter - 1, currItem.next);
    }
  }
  //handle empty list
  public void addFirst(Item toAdd) {
    if (sentinel.next == null) {
      sentinel.next = new Node(toAdd, sentinel, sentinel);
      //Point sentinel.prev to end of list
      Node end = sentinel;
      while (end.next.item != null) {
        end = sentinel.next;
      }
      sentinel.prev = end;
      size++;

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
  //special case of size = 1??
  public void addLast(Item toAdd) {
    //If empty list.
    if (sentinel.next == null) {
      sentinel.next = new Node(toAdd, sentinel, sentinel);
      //Point sentinel.prev to end of list
      Node end = sentinel;
      while (end.next.item != null) {
        end = sentinel.next;
      }
      sentinel.prev = end;
      size++;
    } else {
      Node oldLastNode = sentinel.prev;
      Node newNode = new Node(toAdd, oldLastNode, sentinel);
      oldLastNode.next = newNode;
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
      Node printThis = sentinel.next;
      while (printThis != sentinel) {
        System.out.println("Item: " + printThis.item);
        printThis = printThis.next;
      }
    }
  }

  //Removes first node from the list and returns the value
  public Item removeFirst() {
    if (sentinel.next == null) {
      System.out.println("Empty list!");
      return sentinel.item;
    } else if(size == 1) {
      Node frontNode = sentinel.next;
      sentinel.next = null;
      sentinel.prev = null;
      return frontNode.item;
    } else {
      Node firstNode = sentinel.next;
      Node returnNode = sentinel.next;
      sentinel.next = firstNode.next;
      firstNode.next.prev = sentinel;
      firstNode.item = null;
      firstNode = firstNode.next;
      size--;
      return returnNode.item;
    }
  }

  //Removes last node from list and returns the value
  public Item removeLast() {
    if (sentinel.prev == null) {
      System.out.println("Empty list!");
      return sentinel.item;
    } else if (size == 1) {
      Node lastNode = sentinel.prev;
      sentinel.next = null;
      sentinel.prev = null;
      return lastNode.item;
    } else {
      Node lastNode = sentinel.prev;
      Node returnNode = sentinel.prev;
      sentinel.prev = lastNode.prev; //sets previous of sentinel to the node previous to lastNode
      lastNode.item = null;
      lastNode = lastNode.prev;
      lastNode.next = sentinel;
      size--;
      return returnNode.item;
   }
  }

  /**
  Gets ith item in the list, index starts at 1
  0 would get the sentinel
  */
  public Item get(int index) {
    Node tempPtr = sentinel;
    int counter = index;
    while (tempPtr != sentinel || counter > 1) {
      tempPtr.next = tempPtr;
      counter--;
    }
    return tempPtr.item;
  }
 }
