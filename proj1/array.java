public class array {
  public static int[] insert(int[] x, int item, int position) {
    int[] newX = new int[x.length + 1];
    position = Math.min(x.length, position);
    for (int i = 0; i < position; i++) {
      newX[i] = x[i];
    }
    // Alternative, if you can remember the syntax for this method:
    // System.arraycopy(x, 0, newX, 0, position);
    newX[position] = item;
    for (int indexInOld = position; indexInOld < x.length; indexInOld++) {
      newX[indexInOld + 1] = x[indexInOld];
    }
    // Alternatively:
    // System.arraycopy(x, position, newX, position + 1, x.length - position)
    return newX;
  }

  public static void reverse(int[] x) {
    for (int i = 0; i < x.length/2; i++) {
      int j = x.length - i - 1;
      //swap function
      int temp = x[i];
      x[i] = x[j];
      x[j] = temp;
    }
  }

  public static void int[] xify(int[] x) {
    int total = 0;
    for (int item : x) {
      total += item;
    }
    int[] newX = new int[total];
    int newIndex = 0;
    for (int item : x) {
      for (int counter = 0; counter < item; counter++) {
        newX[newIndex] = item;
        newIndex++;
      }
    }
    return newX;
  }
}
