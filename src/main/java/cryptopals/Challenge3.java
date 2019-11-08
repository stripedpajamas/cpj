package cryptopals;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.stream.Collectors;

import cryptopals.data.Frequency;

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
    final Map<Object, Long> counts = input.toLowerCase().chars().boxed()
        .collect(Collectors.groupingBy(c -> Character.valueOf((char) c.intValue()), Collectors.counting()));
    // translate frequency relative to length of input
    // and compare to english standard
    return 100D - counts.entrySet().stream().filter(entry -> !Frequency.ENGLISH_PUNCTUATION.contains(entry.getKey()))
        .collect(Collectors.summingDouble(entry -> {
          final Double freq = Frequency.ENGLISH.get(entry.getKey());
          return freq == null ? 50 : Math.log(Math.abs(freq - (entry.getValue() / input.length())));
        }));
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