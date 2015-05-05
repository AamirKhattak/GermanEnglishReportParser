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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trade {
	
	// #	Time	Type	Order	Size	Price	S / L	T / P	Profit	Balance
	/*getTradeNumber()
	getTime()
	getType()
	getOrderNumber()
	getSize()
	getPrice()
	getSL()*/

	private int TradeNumber;
	private String time;
	private String type;
	private int order;
	private float size, price, SL, TP, profit, balance;
	
	public int getTradeNumber() {
		return TradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		TradeNumber = tradeNumber;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String token) {
		this.time = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSL() {
		return SL;
	}
	public void setSL(float sL) {
		SL = sL;
	}
	public float getTP() {
		return TP;
	}
	public void setTP(float tP) {
		TP = tP;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public Date getDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy.MM.dd HH:mm");
		try {
			return simpleDateFormat.parse(getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
