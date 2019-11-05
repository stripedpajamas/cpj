package cryptopals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Challenge3Test {
  private Challenge1 challenge1;
  private Challenge3 challenge3;

  @Before
  public void setup() {
    challenge1 = new Challenge1();
    challenge3 = new Challenge3();
  }

  @Test
  public void test_recoverXorKey() {
    final byte[] input = challenge1.hexToBytes("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736");
    final byte key = 88;

    Assert.assertEquals(key, challenge3.recoverXorKey(input));
  }
}