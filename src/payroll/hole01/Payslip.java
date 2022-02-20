package payroll.hole01;

public class Payslip {
    private final double salary;

    public Payslip(final double salary) {
        this.salary = salary;
    }

    public double getNet() {
        final double lowerTaxBracketGross = Math.max(Math.min(salary, 20000.0) - 5000, 0.0);
        final double middleTaxBracketGross = Math.max(Math.min(salary, 40000) - 20000, 0.0);
        final double upperTaxBracketGross = Math.max(salary - 40000, 0.0);
        return salary - (lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4);
    }
}
