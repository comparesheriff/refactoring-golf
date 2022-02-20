package payroll.hole01;

public class Payslip {
    private final double salary;

    public Payslip(final double salary) {
        this.salary = salary;
    }

    public double getNet() {
        final double ltbg = Math.max(Math.min(salary, 20000.0) - 5000, 0.0);
        final double mtbg = Math.max(Math.min(salary, 40000) - 20000, 0.0);
        final double utbg = Math.max(salary - 40000, 0.0);
        return salary - (ltbg * 0.1 + mtbg * 0.2 + utbg * 0.4);
    }
}
