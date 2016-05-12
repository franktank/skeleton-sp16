public class SList {
  private class SNode {
    public int Item;
    public SNode next;
    public SNode(int item, SNode next) {
      this.item = item;
      this.next = next;
    }
  }

  private SNode front;

  public void insertFront (int x) {
    front = new SNode (x, front);
  }

  //recursion?
  //base case,
  public void insert(int item, int position) {
    if (front == null || position == 0) {
      insertFront(item);
      return;
    }

    SNode currentNode = front;
    while(position > 1 && currentNode.next != null) {
      position--;
      currentNode = currentNode.next;
    }
    SNode newNode = new SNode(item, currentNode.next);
    currentNode.next = newNode;
  }

  public void reverse() {
    // Traverse through SNodes, and for each SNodes insert it at the front of a new list.
    // Maintain two pointers, one to current front of newly reversed list (frontOfReversed)
    // and one to next node in our un-reversed old list (nextNodeToAdd)

    SNode frontOfReversed = null;
    SNode nextNodeToAdd = front;
    while (nextNodeToAdd != null) {
      SNode remainderOfOriginal = nextNodeToAdd.next;
      // Put nextNodeToAdd on the front of the reversed list.
      nextNodeToAdd.next = frontOfReversed;
      // Update to the pointers.
      frontOfReversed = nextNodeToAdd;
      nextNodeToAdd = remainderOfOriginal;
    }
    front = frontOfReversed;
  }

  //reverse recursively

  private SNode reverseRecursiveHelper (SNode front) {
    //base case
    if (front == null || front.next == null) {
      return front;
    } else {
    //Reverse everything except front
    SNode reversed = reverseRecursiveHelper(front.next);

    // Put the front onto the back of the new reversed list
    // Since everything after front got reversed, front.next is
    // the LAST thing in reversed. Change this last thing's next pointer to point
    // to front, so front is now at the back of reversed.
    front.next.next = front;
    // Since front is now last element, its next pointer should be null.
    front.next = null;
    return reversed;
    }
  }

  public void recReverse() {
    front = reverseRecursiveHelper(front);
  }
}
