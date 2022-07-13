
package employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private final String companyName;
    private final int EMP_RATE_PER_HOUR;
    private final int NUM_WORKING_DAYS;
    private final int MAX_WORKING_HRS_IN_MONTH;
    private int totalEmpWage;

    public EmployeeWageComputation(String companyName, int EMP_RATE_PER_HOUR, int NUM_WORKING_DAYS, int MAX_WORKING_HRS_IN_MONTH) {
        this.companyName = companyName;
        this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
        this.NUM_WORKING_DAYS = NUM_WORKING_DAYS;
        this.MAX_WORKING_HRS_IN_MONTH = MAX_WORKING_HRS_IN_MONTH;
    }
    public void computeEmpWage() {
        Random random = new Random();
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        System.out.println("----------------------------------");
        System.out.println("Name of the company :- " + companyName);
        System.out.println("Employee rate per hour "+EMP_RATE_PER_HOUR);

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

         totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "Total employee wage :-- " + totalEmpWage;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the employee wage computation program");
        EmployeeWageComputation amazon = new EmployeeWageComputation("Amazon", 20,
                4,50);
        EmployeeWageComputation tcs = new EmployeeWageComputation("TCS", 10,
                4, 40);
        EmployeeWageComputation tesla = new EmployeeWageComputation("TESLA", 40,
                 5, 25);
        amazon.computeEmpWage();
        System.out.println(amazon);
        tcs.computeEmpWage();
        System.out.println(tcs);
        tesla.computeEmpWage();
        System.out.println(tesla);
    }

}
