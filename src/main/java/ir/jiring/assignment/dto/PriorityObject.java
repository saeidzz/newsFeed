package ir.jiring.assignment.dto;

public class PriorityObject {
    private Short priority;
    private Short probability;

    public PriorityObject() {
    }

    public PriorityObject(short priority, short probability) {
        this.priority = priority;
        this.probability = probability;
    }

    public static PriorityObject of(Short priority, Short probability) {
        return new PriorityObject(priority, probability);
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Short getProbability() {
        return probability;
    }

    public void setProbability(Short probability) {
        this.probability = probability;
    }
}
