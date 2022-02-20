package payroll.hole03;

public class Payslip {
    private final double grossSalary;
    private final TaxCalculator taxCalculator;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
        taxCalculator = new TaxCalculator();
    }

    public double getNet() {
        return grossSalary - taxCalculator.calculatedTax(grossSalary);
    }

}
