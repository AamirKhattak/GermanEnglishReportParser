package com.html.parser;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Document : AttributeSetterGetter Created on : Aug 15, 2013, 12:44:34 PM
 * 
 * This class will set and get attributes of the first half page of report.
 * 
 * @author Muhammad Aamir Javid
 * @version 2.0 Aug 17, 2013
 * 
 */

public class AttributeSetterGetter {

	private String symbol;
	private String period;
	private String model;
	private String[] raw_parameters;

	Hashtable<String, Float> parameters = new Hashtable<String, Float>();

	private int barsInTest;
	private int ticksModelled;
	private float modellingQuality;
	private int mismatchedChartsErrors;

	private float iniDeposit;
	private float totalNetProfit;
	private float grossProfit;
	private float grossLoss;
	private float profitFactor;
	private float expectedPayOff;

	private float absoluteDrawDown;
	private float maximalDrawDown;
	private float relativeDrawDown;
	// Total Trades
	private int totalTrades;
	private int shortPositions;
	private int longPositions;
	private int profitTrades;
	private int lossTrades;
	private float largestProfitTrade;
	private float largestLossTrade;
	private float avgProfitTrade;
	private float avgLossTrade;
	private int mxmConsecWins;
	private int mxmConsecLosses;
	private float maximalConsecWins;
	private float maximalConsecLoss;
	private int avgConsecWins;
	private int avgConsecLosses;

	protected ArrayList<Trade> tradeList = new ArrayList<Trade>();

	/**
	 * This method will return the tradelist of the report.
	 * 
	 * @return ArrayList<Trade>
	 */
	public ArrayList<Trade> getTradeList() {
		return tradeList;
	}

	/**
	 * 
	 * @return String
	 */

	public String getSymbol() {
		return symbol;
	}

	/**
	 * For-example: Input : AUDJPY (Australian Dollar vs Japanese Yen) will set
	 * the symbol to : AUDJPY
	 * 
	 * @param symbol
	 *            - e.g AUDJPY (Australian Dollar vs Japanese Yen)
	 */
	public void setSymbol(String symbol) {
		int first_Bracket = symbol.indexOf('(');

		this.symbol = symbol.substring(0, first_Bracket-1);
	}

	public String getPeriod() {
		return period;
	}

	/**
	 * For-example: Input : 1 Hour (H1) 2000.01.02 18:00 - 2012.12.31 12:00
	 * (2000.01.01 - 2013.01.01) will set the Period : 1 Hour
	 * 
	 * @param period
	 */
	public void setPeriod(String period) {
		int first_Bracket = period.indexOf('(');
		this.period = period.substring(0, first_Bracket-1);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		int first_Bracket = model.indexOf('(');
		this.model = model.substring(0, first_Bracket-1);
	}

	// ************************** raw_parameters
	public float getParameters(String arg) {

		if (parameters.get(arg) != null) {
			return parameters.get(arg);
		} else {

			// adding space to argument
			arg = " " + arg;
			if (parameters.get(arg) != null) {
				return parameters.get(arg);
			} else {
				return 0;
			}

		}

	}

	public void setParameters(String[] raw_parameters) {

		this.raw_parameters = new String[raw_parameters.length];
		int length = raw_parameters.length;

		for (int i = 0; i < length; i++) {
			this.raw_parameters[i] = raw_parameters[i];
		}

		for (int i = 0; i < length; i++) {
			parameters.put(raw_parameters[i],
					Float.parseFloat(raw_parameters[++i]));

		}
	}

	public int getBarsInTest() {
		return barsInTest;
	}

	public void setBarsInTest(int barsInTest) {
		this.barsInTest = barsInTest;
	}

	public int getTicksModelled() {
		return ticksModelled;
	}

	public void setTicksModelled(int ticksModelled) {
		this.ticksModelled = ticksModelled;
	}

	public float getModellingQuality() {
		return modellingQuality;
	}

	public void setModellingQuality(String modellingQuality) {
		if (modellingQuality.equalsIgnoreCase("n/a")){
			this.modellingQuality=0;
		} else{
		
		int first_Bracket = modellingQuality.indexOf('%');
		this.modellingQuality = Float.parseFloat(modellingQuality.substring(0,
				first_Bracket));
		}
	}

	public int getMismatchedChartsErrors() {
		return mismatchedChartsErrors;
	}

	public void setMismatchedChartsErrors(int mismatchedChartsErrors) {
		this.mismatchedChartsErrors = mismatchedChartsErrors;
	}

	public float getIniDeposit() {
		return iniDeposit;
	}

	public void setIniDeposit(float iniDeposit) {
		this.iniDeposit = iniDeposit;
	}

	public float getTotalNetProfit() {
		return totalNetProfit;
	}

	public void setTotalNetProfit(float totalNetProfit) {
		this.totalNetProfit = totalNetProfit;
	}

	public float getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(float grossProfit) {
		this.grossProfit = grossProfit;
	}

	public float getGrossLoss() {
		return grossLoss;
	}

	public void setGrossLoss(float grossLoss) {
		this.grossLoss = grossLoss;
	}

	public float getProfitFactor() {
		return profitFactor;
	}

	public void setProfitFactor(float profitFactor) {
		this.profitFactor = profitFactor;
	}

	public float getExpectedPayOff() {
		return expectedPayOff;
	}

	public void setExpectedPayOff(float expectedPayOff) {
		this.expectedPayOff = expectedPayOff;
	}

	public float getAbsoluteDrawDown() {
		return absoluteDrawDown;
	}

	public void setAbsoluteDrawDown(float absoluteDrawDown) {
		this.absoluteDrawDown = absoluteDrawDown;
	}

	public float getMaximalDrawDown() {
		return maximalDrawDown;
	}

	public void setMaximalDrawDown(String maximalDrawDown) {
		int first_Bracket = maximalDrawDown.indexOf('(');
		this.maximalDrawDown = Float.parseFloat(maximalDrawDown.substring(0,
				first_Bracket));
	}

	public float getRelativeDrawDown() {
		return relativeDrawDown;
	}

	public void setRelativeDrawDown(String relativeDrawDown) {
		int first_Bracket = relativeDrawDown.indexOf('%');
		this.relativeDrawDown = Float.parseFloat(relativeDrawDown.substring(0,
				first_Bracket));
	}

	/*
	 * ***************************************************** TRADES
	 */

	public int getTotalTrades() {
		return totalTrades;
	}

	public void setTotalTrades(int totalTrades) {
		this.totalTrades = totalTrades;
	}

	public int getShortPositions() {
		return shortPositions;
	}

	public void setShortPositions(String shortPositions) {
		int first_Bracket = shortPositions.indexOf('(');
		this.shortPositions = Integer.parseInt(shortPositions.substring(0, first_Bracket-1));
	}

	public int getLongPositions() {
		return longPositions;
	}

	public void setLongPositions(String longPositions) {
		int first_Bracket = longPositions.indexOf('(');
		this.longPositions = Integer.parseInt(longPositions.substring(0,
				first_Bracket - 1));
	}

	public int getProfitTrades() {
		return profitTrades;
	}

	public void setProfitTrades(String profitTrades) {
		int first_Bracket = profitTrades.indexOf('(');
		this.profitTrades = Integer.parseInt(profitTrades.substring(0, first_Bracket-1));
	}

	public int getLossTrades() {
		return lossTrades;
	}

	public void setLossTrades(String lossTrades) {
		int first_Bracket = lossTrades.indexOf('(');
		this.lossTrades = Integer.parseInt( lossTrades.substring(0, first_Bracket-1));
	}

	public float getLargestProfitTrade() {
		return largestProfitTrade;
	}

	public void setLargestProfitTrade(float largestProfitTrade) {
		this.largestProfitTrade = largestProfitTrade;
	}

	public float getLargestLossTrade() {
		return largestLossTrade;
	}

	public void setLargestLossTrade(float largestLossTrade) {
		this.largestLossTrade = largestLossTrade;
	}

	public float getAvgProfitTrade() {
		return avgProfitTrade;
	}

	public void setAvgProfitTrade(float avgProfitTrade) {
		this.avgProfitTrade = avgProfitTrade;
	}

	public float getAvgLossTrade() {
		return avgLossTrade;
	}

	public void setAvgLossTrade(float avgLossTrade) {
		this.avgLossTrade = avgLossTrade;
	}

	public int getMxmConsecWins() {
		return mxmConsecWins;
	}

	public void setMxmConsecWins(String mxmConsecWins) {
		int first_Bracket = mxmConsecWins.indexOf('(');
		this.mxmConsecWins = Integer.parseInt( mxmConsecWins.substring(0, first_Bracket-1));
	}

	public int getMxmConsecLosses() {
		return mxmConsecLosses;
	}

	public void setMxmConsecLosses(String mxmConsecLosses) {
		int first_Bracket = mxmConsecLosses.indexOf('(');
		this.mxmConsecLosses = Integer.parseInt(mxmConsecLosses.substring(0, first_Bracket-1));
	}

	public float getMaximalConsecWins() {
		return maximalConsecWins;
	}

	public void setMaximalConsecWins(String maximalConsecWins) {
		int first_Bracket = maximalConsecWins.indexOf('(');
		this.maximalConsecWins = Float.parseFloat(maximalConsecWins.substring(
				0, first_Bracket - 1));
		;
	}

	public float getMaximalConsecLoss() {
		return maximalConsecLoss;
	}

	public void setMaximalConsecLoss(String maximalConsecLoss) {
		int first_Bracket = maximalConsecLoss.indexOf('(');
		this.maximalConsecLoss = Float.parseFloat(maximalConsecLoss.substring(
				0, first_Bracket - 1));
	}

	public int getAvgConsecWins() {
		return avgConsecWins;
	}

	public void setAvgConsecWins(int avgConsecWins) {
		this.avgConsecWins = avgConsecWins;
	}

	public int getAvgConsecLosses() {
		return avgConsecLosses;
	}

	public void setAvgConsecLosses(int avgConsecLosses) {
		this.avgConsecLosses = avgConsecLosses;
	}
}
