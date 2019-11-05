package cryptopals;

import java.nio.ByteBuffer;
import java.util.Base64;

public class Challenge1 {
  static String hexToBase64(final String input) {
    return bytesToBase64(hexToBytes(input));
  }

  static String base64ToHex(final String input) {
    return bytesToHex(base64ToBytes(input));
  }

  static byte[] base64ToBytes(final String input) {
    return Base64.getDecoder().decode(input);
  }

  static byte[] hexToBytes(final String input) {
    final ByteBuffer output = ByteBuffer.allocate(input.length() / 2);
    for (int i = 1; i < input.length(); i += 2) {
      final String substr = input.substring(i - 1, i + 1);
      final int b = Integer.parseInt(substr, 16);
      output.put((byte) b);
    }
    return output.array();
  }

  static String bytesToBase64(final byte[] input) {
    return Base64.getEncoder().encodeToString(input);
  }

  static String bytesToHex(final byte[] input) {
    final StringBuilder output = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      String hex = Integer.toHexString((int) input[i]);
      if (hex.length() < 2) {
        hex = '0' + hex;
      }
      output.append(hex);
    }
    return output.toString();
  }
}