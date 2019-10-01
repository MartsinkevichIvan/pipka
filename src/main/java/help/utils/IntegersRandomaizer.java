package help.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class IntegersRandomaizer {
    public static List<Integer> getUniqueIntegers(int maxRange, int countOfIntegers){
        return ThreadLocalRandom.current().ints(0, maxRange).distinct().limit(countOfIntegers).boxed().collect(Collectors.toList());
    }
}
