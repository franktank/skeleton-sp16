public class OffByN implements CharacterComparator {
  private int charOffBy;

  @Override
  public boolean equalChars(char x, char y) {
    return Math.abs(x - y) == charOffBy;
  }

  public OffByN(int userNum) {
    charOffBy = userNum;
  }
}
