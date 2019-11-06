package cryptopals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class Challenge4Test {
  @Rule
  public ResourceFile inputFile = new ResourceFile("/4.txt");

  @Test
  public void test_detectSingleByteXor() throws IOException {
    List<byte[]> input = Arrays.stream(inputFile.getContent().split("\n"))
      .map(Challenge1::hexToBytes)
      .collect(Collectors.toList());
    Assert.assertEquals(
      "7b5a4215415d544115415d5015455447414c155c46155f4058455c5b523f",
      Challenge1.bytesToHex(Challenge4.detectSingleByteXor(input))
    );
  }
}