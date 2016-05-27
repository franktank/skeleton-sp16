import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator {
  @Override
  public boolean equalChars(char x, char y) {
    return Math.abs(x - y) == 1;
  }

  @Test
  public void testEqualChars() {
    char x = 'a';
    char y = 'b';
    assertTrue(equalChars(x, y));
    x = 'd';
    y = 'c';
    assertTrue(equalChars(x, y));
    assertTrue(!equalChars('a', 'z'));
    assertTrue(!equalChars('b', 'y'));
  }

  public static void main(String[] args) {
    jh61b.junit.TestRunner.runTests("all", OffByOne.class);
  }
}
