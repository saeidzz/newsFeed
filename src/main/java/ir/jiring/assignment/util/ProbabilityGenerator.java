package ir.jiring.assignment.util;

import ir.jiring.assignment.dto.PriorityObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProbabilityGenerator {

    private static final List<Short> PRIORITY_NUMBERS = new ArrayList<>();

    static {
        PriorityObject[] priorities = new PriorityObject[]{PriorityObject.of((short) 0, (short) 1),
                PriorityObject.of((short) 1, (short) 2), PriorityObject.of((short) 2, (short) 3),
                PriorityObject.of((short) 3, (short) 4), PriorityObject.of((short) 4, (short) 4),
                PriorityObject.of((short) 5, (short) 5), PriorityObject.of((short) 6, (short) 5),
                PriorityObject.of((short) 7, (short) 10), PriorityObject.of((short) 8, (short) 23),
                PriorityObject.of((short) 9, (short) 43)};
        Arrays.stream(priorities).forEach(p -> {
            for (int i = 1; i <= p.getProbability(); i++) {
                PRIORITY_NUMBERS.add(p.getPriority());
            }
        });

    }

    private ProbabilityGenerator() {

    }

    public static short getPriority() {
        return PRIORITY_NUMBERS.get(Util.nextInt(0, 100));
    }
}
