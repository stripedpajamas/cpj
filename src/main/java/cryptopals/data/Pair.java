package cryptopals.data;

import java.util.List;

public class Pair {
  byte[] ciphertext;
  byte[] plaintext;
  byte[] key;

  public Pair() {}

  public Pair(byte[] ct, byte[] pt) {
    this.ciphertext = ct;
    this.plaintext = pt;
  }

  public Pair(byte[] ct, byte[] pt, byte[] key) {
    this.ciphertext = ct;
    this.plaintext = pt;
    this.key = key;
  }

  public Pair(List<Byte> ct, List<Byte> pt, List<Byte> k) {
    final byte[] ctPrim = new byte[ct.size()];
    final byte[] ptPrim = new byte[pt.size()];
    final byte[] keyPrim = new byte[k.size()];
    for (int i = 0; i < ct.size(); i++) {
      ctPrim[i] = ct.get(i).byteValue();
    }
    for (int i = 0; i < pt.size(); i++) {
      ptPrim[i] = pt.get(i).byteValue();
    }
    for (int i = 0; i < k.size(); i++) {
      keyPrim[i] = k.get(i).byteValue();
    }
    this.ciphertext = ctPrim;
    this.plaintext = ptPrim;
    this.key = keyPrim;
  }

  public byte[] getPlaintext() {
    return plaintext;
  }

  public byte[] getCiphertext() {
    return ciphertext;
  }

  public byte[] getKey() {
    return key;
  }
}