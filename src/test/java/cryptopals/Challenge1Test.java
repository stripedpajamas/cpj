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
    final String input = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
    final String output = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
    Assert.assertEquals(output, challenge1.hexToBase64(input));
  }

  @Test
  public void test_base64ToHex() {
    final String input = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
    final String output = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";;
    Assert.assertEquals(output, challenge1.base64ToHex(input));
  }
}