package cryptopals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Challenge1Test {
  private Challenge1 challenge1;

  @Before
  public void setup() {
    challenge1 = new Challenge1();
  }

  @Test
  public void test_hexToBase64() {
    final String input = "68656c6c6f20776f726c64";
    final String output = "aGVsbG8gd29ybGQ=";
    Assert.assertEquals(output, challenge1.hexToBase64(input));
  }

  @Test
  public void test_base64ToHex() {
    final String input = "aGVsbG8gd29ybGQ=";
    final String output = "68656c6c6f20776f726c64";
    Assert.assertEquals(output, challenge1.base64ToHex(input));
  }
}