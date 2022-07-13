package employeewage;
import java.util.Random;
public class EmployeeWageBuilder {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
//    public static final int EMP_RATE_PER_HOUR = 20;
//    private static final int NUM_WORKING_DAYS = 20;
//    private static final int MAX_WORKING_HRS_IN_MONTH = 100;

    public static int computeEmpWage(String companyName, int EMP_RATE_PER_HOUR, int NUM_WORKING_DAYS, int MAX_WORKING_HRS_IN_MONTH) {
        Random random = new Random();
        int empHrs;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        System.out.println(" --------------------------------");
        System.out.println("Name of the company :- "+companyName);

        while (totalEmpHrs <= MAX_WORKING_HRS_IN_MONTH && totalWorkingDays < NUM_WORKING_DAYS) {
            totalWorkingDays++;
            int employeeCheck = random.nextInt(3);
            switch (employeeCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day " + totalWorkingDays + " Employee working hours : " + empHrs);
        }
        int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
        System.out.println("Total employee wage : " + totalEmpWage);
        return totalEmpWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the employee wage computation program");
        computeEmpWage("Amazon",100, 20, 100);
        computeEmpWage("TCS",80, 15,100 );
        computeEmpWage("BridgeLabz", 50, 20, 80);
        computeEmpWage("ITC", 40, 10, 60);

    }

}
