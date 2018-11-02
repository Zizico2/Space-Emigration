import java.util.*;

public class Main {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, int[]> answers = new HashMap<>(100);
        int nDaysPerYear;
        while (in.hasNext()) {
            nDaysPerYear = in.nextInt();
            if(answers.containsKey(nDaysPerYear))
                System.out.print(nDaysPerYear + " " + answers.get(nDaysPerYear)[0] + " " + answers.get(nDaysPerYear)[1] + " " + answers.get(nDaysPerYear  )[2] + "\n");
            else
                calculateMonths(nDaysPerYear, answers);
        }
        in.close();

    }


    private static void calculateMonths(int nDaysPerYear, Map<Integer, int[]> answers) {

        int nMonthsPerYear = nDaysPerYear / 4;
        while (nMonthsPerYear > 1) {
            if (nDaysPerYear % nMonthsPerYear == 0) {
                int nDaysPerMonth = nDaysPerYear / nMonthsPerYear;
                int nWeeksPerMonth = nDaysPerMonth / 2;
                while (nWeeksPerMonth > 1) {
                    if (nDaysPerMonth % nWeeksPerMonth == 0) {
                        int nDaysPerWeek = nDaysPerMonth / nWeeksPerMonth;
                        if (nDaysPerWeek >= nWeeksPerMonth && nDaysPerWeek <= 2 * nWeeksPerMonth && nMonthsPerYear >= nDaysPerWeek && nMonthsPerYear <= 2* nDaysPerWeek) {
                            int[] aux = {nDaysPerWeek, nWeeksPerMonth, nMonthsPerYear};
                            answers.put(nDaysPerYear, aux);
                            System.out.print(nDaysPerYear + " " + nDaysPerWeek + " " + nWeeksPerMonth + " " + nMonthsPerYear + "\n");
                            return;
                        }
                    }
                        nWeeksPerMonth--;
                }
            }
            nMonthsPerYear--;
        }
    }
}

