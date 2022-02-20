package payroll.hole04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        assertTaxBasedOnGivenGross(5000, 5000);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        assertTaxBasedOnGivenGross(10000, 9500);

        assertTaxBasedOnGivenGross(20000, 18500);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        assertTaxBasedOnGivenGross(25000, 22500);

        assertTaxBasedOnGivenGross(40000, 34500);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        assertTaxBasedOnGivenGross(50000, 40500);

        assertTaxBasedOnGivenGross(60000, 46500);
    }

    private void assertTaxBasedOnGivenGross(int grossSalary, int expected) {
        final Payslip payslip = new Payslip(grossSalary, new TaxCalculator());
        assertEquals(expected, payslip.getNet(), 1e-6);
    }
}
