package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_ALLOWED_AGE = 35;

    static boolean hasSufficientResidency(String periodsInUkr) {
        if (periodsInUkr == null || !periodsInUkr.contains("-")) {
            return false;
        }

        String[] years = periodsInUkr.split("-");
        try {
            int startYear = Integer.parseInt(years[0].trim());
            int endYear = Integer.parseInt(years[1].trim());
            return (endYear - startYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasSufficientResidency(candidate.getPeriodsInUkr());
    }
    //write your code here
}
