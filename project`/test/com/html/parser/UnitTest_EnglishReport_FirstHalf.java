package com.html.parser;

/**
 * Document : Trade Created on : Aug 15, 2013, 6:44:34 PM
 * 
 * This class will set and get attributes of the second half page of report i.e. Trade.
 * 
 * @author Muhammad Aamir Javid
 * @version 2.0 Aug 17, 2013
 * 
 */


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.html.parser.HTML_Parser;

public class UnitTest_EnglishReport_FirstHalf {
	
	private static final double DELTA = 1e-2;

	HTML_Parser sg = new HTML_Parser(
			"input/ReportEnglish.htm");
	
	@Test
	public void testSymbol() {
		assertEquals("AUDJPY", sg.getSymbol());
	}

	@Test
	public void testPeriod() {
		Assert.assertEquals("1 Hour", sg.getPeriod());
	}

	@Test
	public void testModel() {
		Assert.assertEquals("Every tick", sg.getModel());
	}

	@Test
	public void testBarsInTest() {
		Assert.assertEquals( 80301, sg.getBarsInTest());
	}

	@Test
	public void testTicksModelled() {
		Assert.assertEquals( 74883539, sg.getTicksModelled());
	}

	@Test
	public void testModellingQuality() {
		Assert.assertEquals( 90.00, sg.getModellingQuality(), DELTA);
	}

	@Test
	public void testMismatchedChartsErrors() {
		Assert.assertEquals( 0, sg.getMismatchedChartsErrors());
	}

	@Test
	public void testIniDeposit() {
		Assert.assertEquals( 10000.00, sg.getIniDeposit(), DELTA);
	}

	@Test
	public void TestTotalNetProfit() {
		Assert.assertEquals( -9824.62, sg.getTotalNetProfit(), DELTA);
	}

	@Test
	public void testGrossProfit() {
		Assert.assertEquals(13754.93, sg.getGrossProfit(), DELTA);
	}

	@Test
	public void testGrossLoss() {
		Assert.assertEquals( -23579.55, sg.getGrossLoss(), DELTA);
	}
	
	@Test
	public void testProfitFactor() {
		Assert.assertEquals( 0.58, sg.getProfitFactor(), DELTA);
	}
	
	@Test
	public void testExpectedPayOff() {
		Assert.assertEquals( -6.71, sg.getExpectedPayOff(), DELTA);
	}
	
	@Test
	public void testAbsoluteDrawDown() {
		Assert.assertEquals( 9836.87, sg.getAbsoluteDrawDown(), DELTA);
	}
	
	@Test
	public void testMaximalDrawDown() {
		Assert.assertEquals( 9885.25, sg.getMaximalDrawDown(), DELTA);
	}
	
	@Test
	public void testRelativeDrawDown() {
		Assert.assertEquals( 98.38, sg.getRelativeDrawDown(), DELTA);
	}
	
	@Test
	public void testTotalTrades() {
		Assert.assertEquals( 1464, sg.getTotalTrades());
	}
	
	@Test
	public void testShortPositions() {
		Assert.assertEquals( 701, sg.getShortPositions());
	}
	
	@Test
	public void testLongPositions() {
		Assert.assertEquals( 763, sg.getLongPositions());
	}
	
	@Test
	public void testProfitTrades() {
		Assert.assertEquals(351, sg.getProfitTrades());
	}
	
	@Test
	public void testLossTrades() {
		Assert.assertEquals( 1113, sg.getLossTrades());
	}
	
	@Test
	public void testLargestProfitTrade() {
		Assert.assertEquals(247.68, sg.getLargestProfitTrade(), DELTA);
	}
	
	@Test
	public void testLargestLossTrade() {
		Assert.assertEquals(-177.90, sg.getLargestLossTrade(), DELTA);
	}
	
	@Test
	public void testAvgProfitTrade() {
		Assert.assertEquals( 39.19, sg.getAvgProfitTrade(), DELTA);
	}
	
	@Test
	public void testAvgLossTrade() {
		Assert.assertEquals( -21.19, sg.getAvgLossTrade(), DELTA);
	}
	
	@Test
	public void testMxmConsecWins() {
		Assert.assertEquals( 4, sg.getMxmConsecWins());
	}
	
	@Test
	public void testMxmConsecLosses() {
		Assert.assertEquals( 30, sg.getMxmConsecLosses());
	}
	
	@Test
	public void testMaximalConsecWins() {
		Assert.assertEquals( 300.49, sg.getMaximalConsecWins(), DELTA);
	}
	
	@Test
	public void testMaximalConsecLoss() {
		Assert.assertEquals( -611.33, sg.getMaximalConsecLoss(), DELTA);
	}
	
	@Test
	public void testAvgConsecWins() {
		Assert.assertEquals( 1, sg.getAvgConsecWins());
	}
	
	@Test
	public void testAvgConsecLosses() {
		Assert.assertEquals( 4, sg.getAvgConsecLosses());
	}
	/*
	@Test
	public void test() {
		Assert.assertEquals("1 Hour", sg.());
	}
	
	@Test
	public void test() {
		Assert.assertEquals("1 Hour", sg.());
	}
	
	@Test
	public void test() {
		Assert.assertEquals("1 Hour", sg.());
	}
*/
}
