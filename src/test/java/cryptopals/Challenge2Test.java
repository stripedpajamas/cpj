package cryptopals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Challenge2Test {
  private Challenge1 challenge1;
  private Challenge2 challenge2;

  @Before
  public void setup() {
    challenge1 = new Challenge1();
    challenge2 = new Challenge2();
  }

  @Test
  public void test_xor() {
    final byte[] a = challenge1.hexToBytes("1c0111001f010100061a024b53535009181c");
    final byte[] b = challenge1.hexToBytes("686974207468652062756c6c277320657965");
    final byte[] c = challenge1.hexToBytes("746865206b696420646f6e277420706c6179");

    Assert.assertArrayEquals(c, challenge2.xor(a, b));
  }

  @Test
  public void test_xor_length_mismatch() {
    try {
      challenge2.xor(new byte[]{1, 2, 3}, new byte[]{1, 2});
    } catch (Exception e) {
      Assert.assertTrue(e instanceof IllegalArgumentException);
    }
  }
}
