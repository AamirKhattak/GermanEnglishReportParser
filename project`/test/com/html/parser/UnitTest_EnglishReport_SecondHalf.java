package com.html.parser;



/**
 * Test case for the second half of the report.
 * @author Muhammad Aamir Javid
 * @date Aug 23, 2013
 * 
 */
/*
 * This test case is for second half.
 * 
 * The selected record from table is: record no 2
 * 
 * 									i-e "2	2000.01.03 18:02	close	1	0.20	66.953	0.000	0.000	-4.69	9995.31"
 * 
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.html.parser.HTML_Parser;
import com.html.parser.Trade;

public class UnitTest_EnglishReport_SecondHalf {

	private static final double DELTA = 1e-2;

	HTML_Parser sg = new HTML_Parser("input/ReportEnglish.htm");
	Trade trade = new Trade();

	@Before
	public void mySetup() {
		
		//setting trade
		trade = sg.getTradeList().get(1);
	}

	@Test
	public void getTradeNumber() {
		Assert.assertEquals( 2, trade.getTradeNumber());
	}

	@Test
	public void getTime() {
		Assert.assertEquals("2000.01.03 18:02", trade.getTime());
	}

	@Test
	public void getType() {
		Assert.assertEquals( "close", trade.getType());
	}

	@Test
	public void getOrder() {
		Assert.assertEquals(1, trade.getOrder());
	}

	@Test
	public void getSize() {
		Assert.assertEquals( 0.20, trade.getSize(), DELTA);
	}

	@Test
	public void getPrice() {
		Assert.assertEquals( 66.953, trade.getPrice(), 1e-3);
	}

	@Test
	public void getSL() {
		Assert.assertEquals( 0.000, trade.getSL(), 1e-3);
	}

	@Test
	public void getTP() {
		Assert.assertEquals( 0.000, trade.getTP(), 1e-3);
	}

	@Test
	public void getProfit() {
		Assert.assertEquals( -4.69, trade.getProfit(), DELTA);
	}

	@Test
	public void getBalance() {
		Assert.assertEquals( 	9995.31, trade.getBalance(), DELTA);
	}
}