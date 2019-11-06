package cryptopals;

import org.junit.Assert;
import org.junit.Test;

public class Challenge5Test {
  @Test
  public void test_repeatingKeyXor() {
    final byte[] input = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal".getBytes();
    final byte[] key = "ICE".getBytes();
    final byte[] expected = Challenge1.hexToBytes(
      "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"
    );
    Assert.assertArrayEquals(expected, Challenge5.repeatingKeyXor(input, key));
  }
}