package employeewage;

import java.util.ArrayList;

interface EmployeeWageBuilder {

    public void wageComputation( Companyempwage obj );
}


public class EmployeeWage implements EmpWageBuilder{

    final int is_Part_Time = 1;
    final int is_Full_Time = 2;

    public void wageComputation(Companyempwage companyEmployee){

        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkDay = 0;
        int totalEmpWage = 0;

        while (totalWorkDay < companyEmployee.getNumOfWorkingDays() && totalEmpHrs <= companyEmployee.getMaxHrsInMonth()) {

            int employee = (int) ((Math.random() * 10) % 3);

            switch (employee) {
                case is_Part_Time:
                    empHrs = 4;
                    break;
                case is_Full_Time:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalWorkDay++;
            totalEmpHrs = totalEmpHrs + empHrs;
        }
        companyEmployee.setTotalEmpWage( totalEmpHrs * companyEmployee.empRatePerHr );
        System.out.println("Employee Monthly Wage of " + companyEmployee.getCompanyName() + " is " + companyEmployee.getTotalEmpWage());
    }

    public static void main(String arg[]) {

        EmployeeWage emp = new EmployeeWage();

        ArrayList<Companyempwage> company = new ArrayList<Companyempwage>();

        company.add( new Companyempwage( "Asus", 40, 20, 100 ));
        emp.wageComputation(company.get(0));

        company.add( new Companyempwage( "Dell", 30, 22, 120 ));
        emp.wageComputation(company.get(1));

        company.add( new Companyempwage( "HP", 45, 18, 90 ));
        emp.wageComputation(company.get(2));
    }
}

class Companyempwage{

    public String companyName=" ";
    public int empRatePerHr=0;
    public int noOfWorkDay=0;
    public int maxHrsInMonth=0;

    public int totalEmpWage=0;

    public Companyempwage(String companyName, int empRatePerHr, int noOfWorkDay, int maxHrsInMonth){
        this.companyName=companyName;
        this.empRatePerHr=empRatePerHr;
        this.noOfWorkDay=noOfWorkDay;
        this.maxHrsInMonth=maxHrsInMonth;
    }

    public String getCompanyName(){
        return companyName;
    }
    public int getEmpRatePerHour(){
        return empRatePerHr;
    }

    public int getNumOfWorkingDays(){
        return noOfWorkDay;
    }

    public int getMaxHrsInMonth(){
        return maxHrsInMonth;
    }

    public void setTotalEmpWage( int totalEmpWage ){
        this.totalEmpWage = totalEmpWage;
    }

    public int getTotalEmpWage(){
        return totalEmpWage;
    }

}
