package edu.nyu.cs9053.homework2;

import java.math.BigDecimal;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:22 AM
 *
 * Calculates interest annually and continuously.
 */
public class CompoundInterestCalculator {


	public BigDecimal compoundAnnually(double principal,double rate,int periods,int years){
		BigDecimal bigPrincipal = new BigDecimal(Double.toString(principal));
		BigDecimal bigRate = new BigDecimal(Double.toString(rate));
		BigDecimal base = BigDecimal.ONE.add(bigRate.divide(new BigDecimal(periods)));
		BigDecimal interest = bigPrincipal.multiply(base.pow(years*periods)).subtract(bigPrincipal);
		return interest;
	}

    public BigDecimal continuousCompound(double principal, double rate, int years){
		BigDecimal bigPrincipal = new BigDecimal(Double.toString(principal));
		BigDecimal interest = bigPrincipal.multiply(BigDecimal.valueOf(Math.exp(rate*years))).subtract(bigPrincipal);
		return interest;
	}
  