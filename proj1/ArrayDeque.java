public class ArrayDeque<Item> {
  private Item[] items;
  private int size;

  private static int RFACTOR = 2;

  public ArrayDeque() {
    size = 0;
    items = (Item[]) new Object[8];
  }

  public void addFirst(Item item) {

  }

  public void addLast(Item item) {
    //Resize after basic implementation
    items[size] = item;
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

  }

  public Item removeFirst() {
    
  }

  public Item getBack() {
    int lastItemIndex = size - 1;
    return items[lastItemIndex];
  }

  public Item removeLast() {
    Item itemToReturn = getBack();
    items[size - 1] = null;
    size--;
    return itemToReturn;
  }

  public Item get(int index) {
    return items[index];
  }
}
