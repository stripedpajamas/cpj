package cryptopals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;


public class Challenge3 {
  public static byte recoverXorKey(final byte[] input) {
    byte winningKey = 0;
    double highScore = Double.MIN_VALUE;
    for (byte k = Byte.MIN_VALUE; k < Byte.MAX_VALUE; k++) {
      final byte[] key = createKey(k, input.length);
      final byte[] dec = Challenge2.xor(input, key);
      final String str = bytesToStr(dec);
      final double score = score(str);
      if (score > highScore) {
        winningKey = k;
        highScore = score;
      }
    }
    return winningKey;
  }

  static double score(final String input) {
    // determine frequency of all characters
    final Map<Character, Integer> counts = new HashMap<>();
    input.toLowerCase().chars().forEach(n -> {
      counts.compute((char) n, (k, v) -> v == null ? 1 : v + 1);
    });
    // translate frequency relative to length of input
    // and compare to english standard
    final Map<Character, Double> deviations = new HashMap<>();
    counts.entrySet().forEach(entry -> {
      final Double freq = Frequency.ENGLISH.get(entry.getKey());
      deviations.put(
        entry.getKey(),
        freq == null ? 50 : Math.log(Math.abs(freq - (entry.getValue() / input.length())))
      );
    });

    // generate a score
    return deviations.values().stream().reduce(100D, (acc, el) -> acc - el);
  }

  public static byte[] createKey(final byte b, final int len) {
    final ByteBuffer key = ByteBuffer.allocate(len);
    for (int i = 0; i < len; i++) {
      key.put(b);
    }
    return key.array();
  }

  public static String bytesToStr(final byte[] input) {
    final StringBuilder output = new StringBuilder();
    for (byte b : input) {
      output.append((char) b);
    }
    return output.toString();
  }
}