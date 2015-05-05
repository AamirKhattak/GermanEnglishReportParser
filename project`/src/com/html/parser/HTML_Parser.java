package com.html.parser;

// Main/Driver Class of the Program

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTML_Parser extends AttributeSetterGetter {

	private String filePath;

	public HTML_Parser(String pfilePath) {

		this.filePath = pfilePath;
		// System.out.println("Hello");

		HTML_FirstHalf();
		HTML_SecondHalf();
	}

	public void HTML_SecondHalf() {

		try {
			File input = new File(filePath);
			Document doc = Jsoup.parse(input, "UTF-8");

			int i = 0;

			Elements contents1 = doc.getElementsByTag("table");
			Element contents2 = contents1.last();
			Elements contents = contents2.getElementsByTag("tr");
			// # Time Type Order Size Price S / L T / P Profit Balance
			// 2 2000.01.03 18:02 close 1 0.20 66.953 0.000 0.000 -4.69 9995.31
			// System.out
			// .println("# \t Time \t Type \t Order \t Size \t Price \t SL \t TP \t Profit \t Balance");
			for (Element content : contents) {
				Trade myTrade = new Trade();
				// System.out.print( content.text()+"\t");
				// System.out.println();

				if (content.text().contains("at")){
					break;
				}
				
				String[] token = content.text().split("[ ]");

				if (i > 0) {

					myTrade.setTradeNumber(Integer.parseInt(token[0]));
					myTrade.setTime(token[1] + " " + token[2]);
					myTrade.setType(token[3]);
					myTrade.setOrder(Integer.parseInt(token[4]));
					myTrade.setSize(Float.parseFloat(token[5]));
					myTrade.setPrice(Float.parseFloat(token[6]));
					myTrade.setSL(Float.parseFloat(token[7]));
					myTrade.setTP(Float.parseFloat(token[8]));

					// if the last two fields of the table are not empty
					if (token.length == 11) {

						
						myTrade.setProfit(Float.parseFloat(token[9]));

						myTrade.setBalance(Float.parseFloat(token[10]));
					}

					tradeList.add(myTrade);
				}// end-if

				// System.out.println("\n*****: "+i+" :*********\n");
				i++;
			}// end-loop

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void HTML_FirstHalf() {
		try {
			// ********* FILE NAME
			File input = new File(filePath);
			Document doc = Jsoup.parse(input, "UTF-8");

			Elements contents = doc.getElementsByTag("td");

			int i = 0;
			for (Element content : contents) {

				String tdData = content.text();

				if (tdData.contains("Modellierungsqualit")) {
					tdData = "Modelling quality";
				} else if (tdData.contains("Urspr")) {
					tdData = "Initial deposit";

				} else if (tdData.contains("sster")) {
					tdData = "Largest";

				} /*else if (tdData.contains("sster")) {
					tdData = "Largest";

				} else if (tdData.contains("sster")) {
					tdData = "Largest";

				}*/
				// Symbol -> Mismatched charts errors

				switch (tdData) {

				case "Symbol":
					setSymbol(content.nextElementSibling().text());
					break;

				case "Period":
				case "Periode":
					setPeriod(content.nextElementSibling().text());
					break;

				case "Model":
				case "Modell":
					setModel(content.nextElementSibling().text().toString());
					break;

				case "Parameters":
				case "Parameter":
					String delims = "[;/=]";
					String[] tokens = content.nextElementSibling().text()
							.split(delims);

					setParameters(tokens);
					break;

				case "Bars in test":
				case "Balken im Test":
					setBarsInTest(Integer.parseInt(content.nextElementSibling()
							.text()));
					break;

				case "Ticks modelled":
				case "Ticks modelliert":
					setTicksModelled(Integer.parseInt(content
							.nextElementSibling().text()));
					break;

				case "Modelling quality":
					setModellingQuality(content.nextElementSibling().text());
					break;

				case "Mismatched charts errors":
				case "Fehler in Charts-Anpassung":
					setMismatchedChartsErrors(Integer.parseInt(content
							.nextElementSibling().text()));
					break;

				// ======== BREAK Point ====================

				case "Initial deposit":
					setIniDeposit(Float.parseFloat(content.nextElementSibling()
							.text()));
					break;

				case "Total net profit":
				case "Gesamt netto Profit":
					setTotalNetProfit(Float.parseFloat(content
							.nextElementSibling().text()));
					break;

				case "Gross profit":
				case "Brutto Profit":
					setGrossProfit(Float.parseFloat(content
							.nextElementSibling().text()));
					break;

				case "Gross loss":
				case "Brutto Loss":
					setGrossLoss(Float.parseFloat(content.nextElementSibling()
							.text()));
					break;

				case "Profit factor":
				case "Profit Faktor":
					setProfitFactor(Float.parseFloat(content
							.nextElementSibling().text()));
					break;

				case "Expected payoff":
				case "Erwartetes Ergebnis":
					setExpectedPayOff(Float.parseFloat(content
							.nextElementSibling().text()));
					break;

				case "Absolute drawdown":
				case "Drawdown absolut":
					setAbsoluteDrawDown(Float.parseFloat(content
							.nextElementSibling().text()));
					break;

				case "Maximal drawdown":
				case "Maximaler Drawdown":
					setMaximalDrawDown(content.nextElementSibling().text());
					break;

				case "Relative drawdown":
				case "Relative Drawdown":
					setRelativeDrawDown(content.nextElementSibling().text());
					break;

				// ======== BREAK Point ====================

				case "Total trades":
				case "Trades gesamt":
					setTotalTrades(Integer.parseInt(content
							.nextElementSibling().text()));
					break;

				case "Short positions (won %)":
				case "Short Positionen (gewonnen %)":
					setShortPositions(content.nextElementSibling().text());
					break;

				case "Long positions (won %)":
				case "Long Positionen (gewonnen %)":
					setLongPositions(content.nextElementSibling().text());
					break;

				case "Profit trades (% of total)":
				case "Profit Trades (% gesamt)":
					setProfitTrades(content.nextElementSibling().text());
					break;

				case "Loss trades (% of total)":
				case "Loss Trades (% gesamtl)":
					setLossTrades(content.nextElementSibling().text());
					break;

				case "Largest": {
					Element L_profitTrade = content.nextElementSibling()
							.nextElementSibling();
					setLargestProfitTrade(Float
							.parseFloat(L_profitTrade.text()));

					Element L_lossTrade = L_profitTrade.nextElementSibling()
							.nextElementSibling();
					setLargestLossTrade(Float.parseFloat(L_lossTrade.text()));

					break;
				}

				case "Average":
				case "Durchschnitt": {
					// System.out.print(content.nextElementSibling().text());

					if (content.nextElementSibling().text().toLowerCase()
							.equals("profit trade")) {

						Element avg_profitTrade = content.nextElementSibling()
								.nextElementSibling();

						// System.out.println("avg_PT: " +
						// avg_profitTrade.text());
						setAvgProfitTrade(Float.parseFloat(avg_profitTrade
								.text()));

						Element avg_lossTrade = avg_profitTrade
								.nextElementSibling().nextElementSibling();
						// System.out.println("avg_LT: " +
						// avg_lossTrade.text());
						setAvgLossTrade(Float.parseFloat(avg_lossTrade.text()));
					} else {

						Element avg_consecWins = content.nextElementSibling()
								.nextElementSibling();
						// System.out.println(avg_consecWins.text());
						setAvgConsecWins(Integer
								.parseInt(avg_consecWins.text()));

						Element avg_consecLosses = avg_consecWins
								.nextElementSibling().nextElementSibling();
						// System.out.println(avg_consecLosses.text());
						setAvgConsecLosses(Integer.parseInt(avg_consecLosses
								.text()));
					}

					break;
				}

				case "Maximum": {
					Element mxm_consecWins = content.nextElementSibling()
							.nextElementSibling();
					// System.out.println("mxmWin: " + mxm_consecWins.text());
					setMxmConsecWins(mxm_consecWins.text());

					Element mxm_consecLosses = mxm_consecWins
							.nextElementSibling().nextElementSibling();
					setMxmConsecLosses(mxm_consecLosses.text());

					break;

				}
				case "Maximal": {

					Element maximal_consecProfit = content.nextElementSibling()
							.nextElementSibling();

					setMaximalConsecWins(maximal_consecProfit.text());

					Element maximal_consecLosses = maximal_consecProfit
							.nextElementSibling().nextElementSibling();
					setMaximalConsecLoss(maximal_consecLosses.text());

					// storing avg consective wins and losse
					break;

				}

				}// end-switch

				// System.out.println(tdData + "\n");

				i++;
				if (i == 95)
					break;

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause() + "");
			System.out.println(filePath);
		}

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



}

/*
 * int j = 0; String[] token = content.text().split("[ ]");
 * 
 * if (i > 0) {
 * 
 * // System.out.println(token[j]); // System.out.println("j : " + j);
 * myTrade.setTradeNumber(Integer.parseInt(token[0]));
 * 
 * j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setTime(token[1] + " " + token[2]);
 * 
 * j++; j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setType(token[j]);
 * 
 * j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setOrder(Integer.parseInt(token[4]));
 * 
 * j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setSize(Float.parseFloat(token[5]));
 * 
 * j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setPrice(Float.parseFloat(token[6]));
 * 
 * j++; // System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setSL(Float.parseFloat(token[7]));
 * 
 * j++; // //System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setTP(Float.parseFloat(token[8]));
 * 
 * for( String tok:token){ System.out.println( tok); }
 * 
 * System.out.println(
 * "#: "+token[0]+" -i :"+i+" -token_length: "+token.length); if (i % 2 == 0) {
 * j++; System.out.println(
 * "#: "+token[0]+" -i :"+i+" -token_length: "+token.length+" -j : " + j); //
 * System.out.println(token[j]); myTrade.setProfit(Float.parseFloat(token[9]));
 * 
 * j++; // //System.out.println("j : " + j); // System.out.println(token[j]);
 * myTrade.setBalance(Float.parseFloat(token[10])); }
 * 
 * tradeList.add(myTrade); }// end-if
 */