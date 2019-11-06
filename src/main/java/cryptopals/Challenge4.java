package cryptopals;

import java.util.List;
import java.util.stream.Collectors;

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
    List<Pair> pairs = input.stream().map(line -> {
      final byte key = Challenge3.recoverXorKey(line);
      final byte[] plaintext = Challenge2.xor(
        line,
        Challenge3.createKey(key, line.length)
      );
      return new Pair(
        line,
        plaintext
      );
    }).collect(Collectors.toList());

    // see which recovered plaintext is most like english
    Pair winningPair = null;
    double highScore = Double.MIN_VALUE;
    for (Pair pair : pairs) {
      final double score = Challenge3.score(
        Challenge3.bytesToStr(pair.getPlaintext())
      );
      if (score > highScore) {
        winningPair = pair;
        highScore = score;
      }
    }
    return winningPair.getCiphertext();
  }
}