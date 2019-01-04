package tn.uniteam.managedBeans.analytics;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.uniteam.managedBeans.users.LoginBean;
import tn.uniteam.persistence.Asset;
import tn.uniteam.services.analytics.AssetsManagementLocal;

@ManagedBean
@ViewScoped
public class OfficeBean {
	
	@EJB
	private AssetsManagementLocal aml;

	
	/********************* **** 		   Bilan  			*****************************/
	
	private double equipment;
	private double buildings = 0;
	private double materals = 0;
	private double transport = 0;
	private double stocks = 0;
	private double debts = 0;
	private double credits = 0;
	private double cash = 0;
	private double capital = 0;
	private double loan = 0;
	private double charges = 0;
	private double trades = 0;
	private double bankloan = 0;
	private double totalactifs = 0;
	private double totalspassifs = 0;	
	
	
	private List<Asset> assets = aml.getAllAssetsOfOffice(LoginBean.loggedUser);
	
	public void init() {
		SetBalance();
	}	
	
	private void SetBalance() {
		// TODO Auto-generated method stub
		for (Asset asset : assets) {
			equipment = 532256446;
		}
	}





	public OfficeBean(){
		
	}


	public double getEquipment() {
		return equipment;
	}
	public void setEquipment(double equipment) {
		this.equipment = equipment;
	}
	public double getBuildings() {
		return buildings;
	}
	public void setBuildings(double buildings) {
		this.buildings = buildings;
	}
	public double getMaterals() {
		return materals;
	}
	public void setMaterals(double materals) {
		this.materals = materals;
	}
	public double getTransport() {
		return transport;
	}
	public void setTransport(double transport) {
		this.transport = transport;
	}
	public double getStocks() {
		return stocks;
	}
	public void setStocks(double stocks) {
		this.stocks = stocks;
	}
	public double getDebts() {
		return debts;
	}
	public void setDebts(double debts) {
		this.debts = debts;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public double getTrades() {
		return trades;
	}
	public void setTrades(double trades) {
		this.trades = trades;
	}
	public double getBankloan() {
		return bankloan;
	}
	public void setBankloan(double bankloan) {
		this.bankloan = bankloan;
	}
	public double getTotalactifs() {
		return totalactifs;
	}
	public void setTotalactifs(double totalactifs) {
		this.totalactifs = totalactifs;
	}
	public double getTotalspassifs() {
		return totalspassifs;
	}
	public void setTotalspassifs(double totalspassifs) {
		this.totalspassifs = totalspassifs;
	}	
	
	
	
	/******************* *** *   </--Bilan  ** * * * ******************************/

}
