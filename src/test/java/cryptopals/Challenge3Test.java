package cryptopals;

import org.junit.Assert;
import org.junit.Test;

public class Challenge3Test {
  @Test
  public void test_recoverXorKey() {
    final byte[] input = Challenge1.hexToBytes("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736");
    final byte key = 88;

    Assert.assertEquals(key, Challenge3.recoverXorKey(input));
  }

  @Test
  public void test_recoverXorKey_custom() {
    final byte key = 13;
    final String msg = "of all the things to type, hello world is not the best";
    final byte[] input = Challenge2.xor(
      Challenge3.createKey(key, msg.length()),
      msg.getBytes()
    );

    Assert.assertEquals(key, Challenge3.recoverXorKey(input));
  }
}