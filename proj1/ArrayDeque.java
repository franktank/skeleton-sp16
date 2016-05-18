public class ArrayDeque<Item> {
  private Item[] items;
  private int size;

  //pointers of first and last?
  private int nextFirst;
  private int nextLast;

  private static int RFACTOR = 2;

  public ArrayDeque() {
    size = 8;
    items = (Item[]) new Object[8];
  }

  public void addFirst(Item item) {
    items[] = item;
    nextFirst--;
    size++;
  }

  public void addLast(Item item) {
    //Resize after basic implementation
    items[size] = item;
    nextLast++;
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

  }

  public Item getBack() {
    int lastItemIndex = size - 1;
    return items[lastItemIndex];
  }

  public Item removeLast() {
    if (isEmpty()) {
      return null;
    } else {
      Item itemToReturn = getBack();
      items[size - 1] = null;
      size--;
      return itemToReturn;
    }
  }

  public Item get(int index) {
    return items[index];
  }
}
