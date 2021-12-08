package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    private LocalDate terminationInclusive;
    private long numberOfOccurrences;

    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        this.terminationInclusive = terminationInclusive;
        long between = ChronoUnit.DAYS.between(start, terminationInclusive);
        if (frequency.equals(ChronoUnit.DAYS)) {
            numberOfOccurrences = between;
        }
        if (frequency.equals(ChronoUnit.WEEKS)) {
            numberOfOccurrences = between / 7;
        }
        if (frequency.equals(ChronoUnit.MONTHS)) {
            numberOfOccurrences = between / 30;
        }

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive
     * event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;
        long between = 0;
        if (frequency.equals(ChronoUnit.DAYS)) {
            between = numberOfOccurrences;
        }
        if (frequency.equals(ChronoUnit.WEEKS)) {
            between = numberOfOccurrences * 7;
        }
        if (frequency.equals(ChronoUnit.MONTHS)) {
            between = numberOfOccurrences * 30;
        }
        LocalDate nStart = start.toLocalDate();
        terminationInclusive = nStart.plusDays(between);
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        return this.terminationInclusive;
    }

    public long getNumberOfOccurrences() {
        return this.numberOfOccurrences;
    }

}
