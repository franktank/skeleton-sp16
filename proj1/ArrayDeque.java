public class ArrayDeque<Item> {
  private Item[] items;
  private int size;

  //pointers of first and last?
  private int nextFirst;
  private int nextLast;
  private int sizeOfArray;

  private static int RFACTOR = 2;

  public ArrayDeque() {
    size = 0;
    sizeOfArray = 8;
    items = (Item[]) new Object[8];
    nextFirst = sizeOfArray / 2;
    nextLast = nextFirst + 1;
  }

  private void resize(int capacity) {

  }
  public void addFirst(Item item) {
    if (size == sizeOfArray ) {
      //resize
    }
    items[nextFirst] = item;
    nextFirst--;
    if (nextFirst < 0) {
      nextFirst = sizeOfArray - 1;
    }
    size++;
  }

  public void addLast(Item item) {
    if (size == sizeOfArray) {
      //resize
    }
    items[nextLast] = item;
    nextLast++;
    if (nextLast == sizeOfArray) {
      nextLast = 0;
    }
    size++;

  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    for (int i = 0; i < items.length; i++) {
      System.out.println("Item: " + [items[i]]);
    }
  }

  public Item removeFirst() {
    Item itemToReturn;
    if (nextFirst == sizeOfArray) {
      itemToReturn = items[0];
      items[0] = null;
      nextFirst = 0;
    } else if (isEmpty()) {
      return null;
    } else {
      itemToReturn = items[nextFirst + 1];
      items[nextFirst + 1] = null;
      nextFirst++;
    }
    size--;
    return itemToReturn;
  }

  public Item getBack() {
    int lastItemIndex = size - 1;
    return items[lastItemIndex];
  }

  public Item removeLast() {
    Item itemToReturn;
    if (nextLast == 0) {
      itemToReturn = items[sizeOfArray - 1];
      items[sizeOfArray - 1] = null;
      nextLast = sizeOfArray - 1;
    } else if (isEmpty()) {
      return null;
    } else {
      itemToReturn = items[nextLast - 1];
      items[nextLast - 1] = null;
      nextLast--;
    }
      size--;
      return itemToReturn;
  }

  public Item get(int index) {
    return items[index];
  }
}
