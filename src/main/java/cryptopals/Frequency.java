package cryptopals;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Frequency {
  public static final Map<Character, Double> ENGLISH = Stream.of(new AbstractMap.SimpleImmutableEntry[] {
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('a'), 8.167),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('b'), 1.492),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('c'), 2.782),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('d'), 4.253),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('e'), 12.702),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('f'), 2.228),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('g'), 2.015),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('h'), 6.094),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('i'), 6.966),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('j'), 0.153),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('k'), 0.772),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('l'), 4.025),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('m'), 2.406),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('n'), 6.749),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('o'), 7.507),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('p'), 1.929),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('q'), 0.095),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('r'), 5.987),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('s'), 6.327),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('t'), 9.056),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('u'), 2.758),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('v'), 0.978),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('w'), 2.360),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('x'), 0.150),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('y'), 1.974),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf('z'), 0.074),
    new AbstractMap.SimpleImmutableEntry<>(Character.valueOf(' '), 12.800)
  }).collect(Collectors.toMap(entry -> (Character) entry.getKey(), entry -> (Double) entry.getValue()));
}