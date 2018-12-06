package pkgTest;

import static org.junit.Assert.*;
import pkgCore.Retirement;

import org.junit.Test;

public class Retirement_Test {

	@Test
	public void TestPV() {
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dExpectedPV = -1454485.55;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000;
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsRetired(iYearsRetired);
		
		assertEquals(dExpectedPV,rt.TotalAmountSaved(),0.05);
	}
	@Test
	public void TestPMT() {
		double ExpectedPMT = 554.13;
		int iYearsWork = 40;
		double dAnnualReturnWork = 0.07;
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dExpectedPV = -1454485.55;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000;
		
		Retirement rt = new Retirement();
		rt.setiYearsRetired(iYearsRetired);
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsToWork(iYearsWork);
		rt.setdAnnualReturnWorking(dAnnualReturnWork);
	
		assertEquals(dExpectedPV,rt.TotalAmountSaved(),0.05);
		assertEquals(ExpectedPMT, rt.AmountToSave(),0.05);
	}
}
