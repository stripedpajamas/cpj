package cryptopals;

import java.nio.ByteBuffer;

public class Challenge2 {
  public static byte[] xor(final byte[] a, final byte[] b) {
    if (a.length != b.length) {
      throw new IllegalArgumentException("inputs must be same length");
    }
    final ByteBuffer output = ByteBuffer.allocate(a.length);
    for (int i = 0; i < a.length; i++) {
      output.put((byte) (a[i] ^ b[i]));
    }
    return output.array();
  }
}