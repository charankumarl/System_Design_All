package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Character_ReUse;

import java.util.*;

public class StyleFactory {

    static Map<String, CharacterStyle> cache = new HashMap<>();

    static CharacterStyle getStyle(String font, int size, boolean bold) {

        String key = font + size + bold;

        return cache.computeIfAbsent(key, k -> new CharacterStyle(font, size, bold));

        /**
         * computeIfAbsent(key, mappingFunction):
         *
         * 1. Checks if key already exists in cache.
         * 2. If present → returns the existing value as-is. Lambda (k -> new CharacterStyle(...)) is not called.
         * 3. If absent → calls the lambda with k = key, creates new CharacterStyle(...), automatically puts (key, newValue) into the map, then returns that new value.
         *
         * So it's doing this manually, in one line:
         * // equivalent manual version
         *
         * CharacterStyle getStyle(String font, int size, boolean bold) {
         *     String key = font + size + bold;
         *     if (cache.containsKey(key)) {
         *         return cache.get(key); // already present, reuse
         *     }
         *     CharacterStyle newStyle = new CharacterStyle(font, size, bold);
         *     cache.put(key, newStyle); // auto-inserted
         *     return newStyle;
         * }
         */
    }
}
