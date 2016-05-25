public class Palindrome {
  public static Deque<Character> wordToDeque(String word) {
    Deque<Character> wordDeque = new LinkedListDeque<Character>;
    for (int i = 0; i < word.length; i++) {
      wordDeque.addLast(word[i]);
    }
    return wordDeque;
  }

  public static boolean isPalindrome(String word) {
    boolean isPal = true;

    Deque<Character> returnDeque = wordToDeque(word);

    Node prev = returnDeque.sentinel.prev;
    Node next = returnDeque.sentinel.next;

    for (int i = 0; i < returnDeque.size()/2; i++) {
        if (prev == next) {
          isPal = true;
          prev = prev.prev;
          next = next.next;
        } else {
          isPal = false;
        }
    }
    return isPal;
  }

  private static boolean isPalindrome(String firstLetter, String secondLetter) {
    //helper method for recursive call?
  }
}
