package cryptopals;

import java.util.Comparator;
import java.util.List;

public class Challenge4 {
  private static class Pair {
    byte[] ciphertext;
    byte[] plaintext;
    Pair(byte[] ct, byte[] pt) {
      this.ciphertext = ct;
      this.plaintext = pt;
    }
    public byte[] getPlaintext() {
      return plaintext;
    }
    public byte[] getCiphertext() {
      return ciphertext;
    }
  }
  public static byte[] detectSingleByteXor(final List<byte[]> input) {
    return input.stream()
      .map(line -> {
        final byte key = Challenge3.recoverXorKey(line);
        final byte[] plaintext = Challenge2.xor(
          line,
          Challenge3.createKey(key, line.length)
        );
        return new Pair(line, plaintext);
      })
      .max(Comparator.comparingDouble(
        pair -> Challenge3.score(Challenge3.bytesToStr(pair.getPlaintext()))
      ))
      .get()
      .getCiphertext();
  }
}