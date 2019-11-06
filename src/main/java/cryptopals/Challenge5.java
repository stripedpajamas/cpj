package cryptopals;

import java.nio.ByteBuffer;

public class Challenge5 {
  public static byte[] repeatingKeyXor(final byte[] input, final byte[] key) {
    final byte[] repeatingKey = createRepeatingKey(key, input.length);
    return Challenge2.xor(input, repeatingKey);
  }
  public static byte[] createRepeatingKey(final byte[] key, final int len) {
    final ByteBuffer output = ByteBuffer.allocate(len);
    for (int i = 0; i < len; i++) {
      output.put(key[i % key.length]);
    }
    return output.array();
  }
}