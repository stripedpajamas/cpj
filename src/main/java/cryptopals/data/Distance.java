package cryptopals.data;

public class Distance {
  int distance;
  int keySize;
  public Distance(final int distance, final int keySize) {
    this.distance = distance;
    this.keySize = keySize;
  }
  public double getNormalizedDistance() {
    return (double) distance / (double) keySize;
  }
  public int getKeySize() {
    return keySize;
  }
}