package cryptopals;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cryptopals.data.Distance;
import cryptopals.data.Pair;

public class Challenge6 {
  public static byte[] recoverRepeatingXorKey(final byte[] input) {
    return getLikelyKeySizes(input).stream().map(ks -> {
      final List<Pair> transposed = transpose(input, ks).stream().map(chunk -> {
        final byte[] key = Challenge3.createKey(Challenge3.recoverXorKey(chunk), chunk.length);
        final byte[] plaintext = Challenge2.xor(chunk, key);
        return new Pair(chunk, plaintext, key);
      }).collect(Collectors.toList());
      // merge pairs into a single pair
      final List<Byte> mergedCt = new ArrayList<>();
      final List<Byte> mergedPt = new ArrayList<>();
      final List<Byte> mergedKey = new ArrayList<>();
      for (Pair pair : transposed) {
        for (byte b : pair.getCiphertext()) {
          mergedCt.add(b);
        }
        for (byte b : pair.getPlaintext()) {
          mergedPt.add(b);
        }
        mergedKey.add(pair.getKey()[0]);
      }
      // this pair represents the full decryption of the CT using recovered key bytes
      // based on this specific likely key size
      return new Pair(mergedCt, mergedPt, mergedKey);
    }).max(Comparator.comparingDouble(pair -> Challenge3.score(Challenge3.bytesToStr(pair.getPlaintext())))).get()
        .getKey();
  }

  // sometimes i need to see it
  private static void printBytes(List<Byte> input) {
    StringBuilder s = new StringBuilder();
    for (Byte b : input) {
      s.append((char) b.byteValue());
    }
    System.out.println(s.toString());
  }

  public static List<Integer> getLikelyKeySizes(final byte[] input) {
    // arbitrarily checking sizes between 2 and 40
    return IntStream.range(2, 40).boxed().map(ks -> chunkify(input, ks)).map(chunks -> {
      final int keySize = chunks.get(0).length;
      // get distance for 1st and 2nd block
      final int first = getHammingDistance(chunks.get(0), chunks.get(1));
      if (chunks.size() < 4) {
        return new Distance(first, keySize);
      }
      // get some additional data
      final int second = getHammingDistance(chunks.get(2), chunks.get(3));
      return new Distance((first + second) / 2, keySize);
    }).sorted(Comparator.comparingDouble(Distance::getNormalizedDistance).reversed()).map(Distance::getKeySize)
        .sorted(Comparator.naturalOrder()).limit(5).collect(Collectors.toList());
  }

  public static int getHammingDistance(final String a, final String b) {
    return getHammingDistance(a.getBytes(), b.getBytes());
  }

  public static int getHammingDistance(final byte[] a, final byte[] b) {
    if (a.length != b.length) {
      throw new IllegalArgumentException("inputs must be equal length");
    }
    int totalDistance = 0;
    for (int i = 0; i < a.length; i++) {
      totalDistance += Integer.bitCount(a[i] ^ b[i]);
    }
    return totalDistance;
  }

  private static List<byte[]> chunkify(final byte[] input, final int size) {
    final List<byte[]> chunks = new ArrayList<>();
    for (int i = 0; i < input.length; i += size) {
      final ByteBuffer chunk = ByteBuffer.allocate(size);
      for (int j = i; j < size; j++) {
        chunk.put(input[j]);
      }
      chunks.add(chunk.array());
    }
    return chunks;
  }

  private static List<byte[]> transpose(final byte[] input, final int size) {
    final List<byte[]> chunks = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      final ByteBuffer chunk = ByteBuffer.allocate((input.length / size) + 1);
      for (int j = i; j < input.length; j += size) {
        chunk.put(input[j]);
      }
      chunks.add(chunk.array());
    }
    return chunks;
  }
}