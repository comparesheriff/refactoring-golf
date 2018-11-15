package payroll;

public class TaxCalculator {
    private final TaxBand lowerTaxBand = new TaxBand.ChainedTaxBand(0.1, 5000, 1500, TaxBand.NIL_TAX_BAND);
    private final TaxBand middleTaxBand = new TaxBand.ChainedTaxBand(0.2, 20000, 4000, lowerTaxBand);
    private final TaxBand upperTaxBand = new TaxBand.ChainedTaxBand(0.4, 40000, 0, middleTaxBand);

    public long taxFor(long grossSalary) {
        return taxBandFor(grossSalary).taxFor(grossSalary);
    }

    private TaxBand taxBandFor(long grossSalary) {
        if (upperTaxBand.appliesTo(grossSalary)) return upperTaxBand;
        if (middleTaxBand.appliesTo(grossSalary)) return middleTaxBand;
        if (lowerTaxBand.appliesTo(grossSalary)) return  lowerTaxBand;
        return TaxBand.NIL_TAX_BAND;
    }
}