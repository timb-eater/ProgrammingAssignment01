package org.example;
public abstract class Ticket {
    private final int id;
    private final String requester;
    private final int priority; // 1 (low) .. 5 (high)
    private final int daysOpen;

    public Ticket(int id, String requester, int priority, int daysOpen) {
        if (priority < 1 || priority > 5) throw new IllegalArgumentException("priority must be 1..5");
        if (daysOpen < 0) throw new IllegalArgumentException("daysOpen must be >= 0");
        this.id = id;
        this.requester = requester;
        this.priority = priority;
        this.daysOpen = daysOpen;
    }

    public int getId() { return id; }
    public String getRequester() { return requester; }
    public int getPriority() { return priority; }
    public int getDaysOpen() { return daysOpen; }

    /** Higher means more urgent */
    public abstract int urgencyScore();

    // -------------------------------
    // xTODO #1 (Method Overloading)
    // Implement ALL three overloads.
    // - Base estimate depends on priority and daysOpen.
    // - Add complexityFactor if provided (>=1).
    // - Add afterHoursPenalty if provided (>=0).
    // Suggested formula (you can follow exactly):
    //   base = (6 - priority) * 2 + daysOpen
    //   return max(1, base * complexityFactor + afterHoursPenalty)
    // -------------------------------

    public int estimateResolutionHours() {
        // xTODO #1a
        int base = (6 - getPriority()) * 2  + getDaysOpen();
        return Math.max(1, base);
    }

    public int estimateResolutionHours(int complexityFactor) {
        // xTODO #1b
        int base = (6 - getPriority()) * 2  + getDaysOpen();
        return Math.max(1, base * complexityFactor);
    }

    public int estimateResolutionHours(int complexityFactor, int afterHoursPenalty) {
        // xTODO #1c
        int base = (6 - getPriority()) * 2  + getDaysOpen();
        return Math.max(1, base * complexityFactor + afterHoursPenalty);
    }

    @Override
    public String toString() {
        return String.format("#%d (%s) pr=%d open=%dd score=%d est=%dh",
                id, requester, priority, daysOpen, urgencyScore(), estimateResolutionHours());
    }
}