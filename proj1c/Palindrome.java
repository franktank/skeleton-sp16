public class Palindrome {
  public static Deque<Character> wordToDeque(String word) {
    LinkedListDequeSolution<Character> charDeque = new LinkedListDequeSolution<>();
    for (int i = 0; i < word.length; i++) {
      charDeque.addLast(word.charAt(i));
    }
    return (Deque)charDeque;
  }

  public static boolean isPalindrome(String word) {
    Deque<Character> charDeque = wordToDeque(word);
    return isPalindrome(charDeque);
  }

  private static boolean isPalindrome(Deque<Character> charDeque) {
    //helper method for recursive call?
    int charDequeSize = charDeque.size();
    if (charDequeSize == 0 || charDequeSize == 1) {
      return true;
    } else {
      Character fLetter = charDeque.removeFirst();
      Character lLetter = charDeque.removeLast();
      return fletter == lLetter && isPalindrome(charDeque);
    }
  }

  private static boolean isPalindrome(Deque<Character>, CharacterComparator cc) {
    int charDequeSize = charDeque.size();
    if (charDequeSize == 0 || charDequeSize == 1) {
      return true;
    } else {
      Character fLetter = charDeque.removeFirst();
      Character lLetter = charDeque.removeLast();
      return cc.equalChars(fLetter, lLetter) && isPalindrome(charDeque, cc);
    }
  }

  public static boolean isPalindrome(String word, CharacterComparator cc) {
    Deque<Character> charDeque = wordToDeque(word);
    return isPalindrome(charDeque, cc);
  }
}
