package edu.nyu.cs9053.homework2;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:48 AM
 */
public class CompoundInterestCalculatorTest {

    @Test
    public void compoundAnnually() {
        CompoundInterestCalculator calculator = new CompoundInterestCalculator();
        BigDecimal expected = new BigDecimal("438.8368221341036315119868759615438447390638938086647345973196039067038515540052407615743135238517425023019313812255859375000");
        assertEquals(expected, calculator.compoundAnnually(1500d, 0.043d, 4, 6));
    }

    @Test
    public void continuousCompound() {
        CompoundInterestCalculator calculator = new CompoundInterestCalculator();
        BigDecimal expected = new BigDecimal("228.0604605273118800");
        assertEquals(expected, calculator.continuousCompound(2340d, 0.031d, 3));
    }

}
