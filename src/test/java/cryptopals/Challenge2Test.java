package cryptopals;

import org.junit.Assert;
import org.junit.Test;

public class Challenge2Test {
  @Test
  public void test_xor() {
    final byte[] a = Challenge1.hexToBytes("1c0111001f010100061a024b53535009181c");
    final byte[] b = Challenge1.hexToBytes("686974207468652062756c6c277320657965");
    final byte[] c = Challenge1.hexToBytes("746865206b696420646f6e277420706c6179");

    Assert.assertArrayEquals(c, Challenge2.xor(a, b));
  }

  @Test
  public void test_xor_length_mismatch() {
    try {
      Challenge2.xor(new byte[]{1, 2, 3}, new byte[]{1, 2});
    } catch (Exception e) {
      Assert.assertTrue(e instanceof IllegalArgumentException);
    }
  }
}
