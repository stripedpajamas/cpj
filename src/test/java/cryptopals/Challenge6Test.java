package cryptopals;

import org.junit.Assert;
import org.junit.Test;

public class Challenge6Test {
  @Test
  public void test_getHammingDistance() {
    final String a = "this is a test";
    final String b = "wokka wokka!!!";
    final int distance = 37;
    Assert.assertEquals(distance, Challenge6.getHammingDistance(a, b));
  }

  @Test
  public void test_recoverRepeatingXorKey_custom() {
    final byte[] input = ("To-morrow, and to-morrow, and to-morrow, " + "Creeps in this petty pace from day to day, "
        + "To the last syllable of recorded time; " + "And all our yesterdays have lighted fools "
        + "The way to dusty death. Out, out, brief candle! " + "Life's but a walking shadow, a poor player, "
        + "That struts and frets his hour upon the stage, " + "And then is heard no more. It is a tale "
        + "Told by an idiot, full of sound and fury, " + "Signifying nothing.").getBytes();
    final byte[] key = "drugs".getBytes();
    final byte[] enc = Challenge5.repeatingKeyXor(input, key);
    Assert.assertArrayEquals(key, Challenge6.recoverRepeatingXorKey(enc));
  }
}