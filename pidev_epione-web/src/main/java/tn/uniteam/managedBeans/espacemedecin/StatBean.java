package tn.uniteam.managedBeans.espacemedecin;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import tn.uniteam.managedBeans.users.LoginBean;
import tn.uniteam.persistence.Disponibility;
import tn.uniteam.persistence.Reason;
import tn.uniteam.services.espacemedecin.DoctorManagement;


@ManagedBean
@SessionScoped
public class StatBean {

	private PieChartModel pie;
	private BarChartModel bar;
	private LineChartModel model;
	
	public LineChartModel getModel() {
		return model;
	}

	public void setModel(LineChartModel model) {
		this.model = model;
	}

	public BarChartModel getBar() {
		return bar;
	}

	public void setBar(BarChartModel bar) {
		this.bar = bar;
	}

	public StatBean() {
		// TODO Auto-generated constructor stub
	}
	
	public PieChartModel getPie() {
		return pie;
	}
	public void setPie(PieChartModel pie) {
		this.pie = pie;
	}

	@PostConstruct
	public void init() {
		CreatePie();
		CreateBar();
		createAnimatedModel();
	
	}
	
	private void createAnimatedModel() {
		Date dateAjoutrdui=new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateAjoutrdui);		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int monthpre=month;
		int semaineDern=day-7;
		int cetSem=semaineDern+7;
		if (semaineDern<0)
		{semaineDern=(day-7+30);
		monthpre=month-1;}
		if (monthpre==0) {
			monthpre=12;
		}
		model = initLinearModel();
		model.setTitle("Weekly meetings report");
		model.setAnimate(true);
		model.setLegendPosition("se");
		Axis yAxis= model.getAxis(AxisType.Y);
		yAxis.setLabel("Number of meetings");
		yAxis.setMin(0);
		yAxis.setMax(10);
		Axis xAxis= model.getAxis(AxisType.X);
		xAxis.setMin(semaineDern);
		
		xAxis.setLabel("from "+semaineDern+"/"+monthpre+" to "+day+"/"+month+"/"+year);
		
	}
	@EJB
	DoctorManagement dm;
	
	private LineChartModel initLinearModel() {
		LineChartModel chartModel= new LineChartModel();
		Date dateAjoutrdui=new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateAjoutrdui);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int semaineDern=day-7;
		Calendar cal2 = Calendar.getInstance();	
		int i=0;
		
		int daycom=0;
		if (semaineDern<0)
			{semaineDern=(day-7+30);}
		LineChartSeries serie1= new LineChartSeries();
		System.out.println(semaineDern);
		List<Date> listeDate=dm.getNbAppByWeek(LoginBean.loggedUser.getId());
		for(i=semaineDern;i<=(semaineDern+7);i++) {
			int rdv=0;
			if (i>30)	
			{daycom=i-30;}
		else 
			{daycom=i;}
			for(int j=0;j<listeDate.size();j++) {				
				cal2.setTime(listeDate.get(j));				
				int monthrv = cal2.get(Calendar.MONTH)+1;
				int dayrv = cal2.get(Calendar.DAY_OF_MONTH);
				if (dayrv==daycom)
				rdv++;				
			}
			System.out.println("date ajourd: "+daycom+" nb renv: "+rdv);
			serie1.set(daycom, rdv);
		}
		serie1.setLabel("Meetings Number");
		
		
		
		chartModel.addSeries(serie1);
		
		return chartModel;
	}
	/*public int countDispoPArJour(String iddoc,int day,int month) {
		List<Disponibility> liste=dm.getNbDispoByWeek(iddoc);
		int h=0;
		for(int i=1;i<liste.size();i++) {
			Calendar cal2 = Calendar.getInstance();
			Calendar cal3 = Calendar.getInstance();
			cal2.setTime(liste.get(i).getStartDate());
			cal3.setTime(liste.get(i).getEndDate());
			int dayDispo = cal2.get(Calendar.DAY_OF_MONTH);
			int monthDispo = cal2.get(Calendar.MONTH)+1;
			if ((dayDispo==day)) {
				h++;
			}
			
		}
		
		return h;
	}*/

	public void CreateBar() {
		bar = new BarChartModel();
		List<Reason> listeRe=dm.getReasonsByDoctor(LoginBean.loggedUser.getId());
		for(int i=0; i<listeRe.size();i++) {
			ChartSeries newOrder= new ChartSeries(listeRe.get(i).getReasonContent());
			newOrder.set(listeRe.get(i).getReasonContent(), listeRe.get(i).getPrix());
			bar.addSeries(newOrder);
		}
	
		bar.setTitle(" Operation's Price Report");
		bar.setLegendPosition("ne");
		bar.getAxis(AxisType.X).setLabel("Operation");
		bar.getAxis(AxisType.Y).setLabel("Price with DT");
		bar.getAxis(AxisType.Y).setMin(0);
		bar.getAxis(AxisType.Y).setMax(250);
	}

	public void CreatePie() {
		
		int lundi=0;
		int mardi=0;
		int mercredi=0;
		int jeudi=0;
		int vendredi=0;
		int samedi=0;
		List<Date> listeDate=dm.getNbDispoByWeek(LoginBean.loggedUser.getId());
		Calendar cal = Calendar.getInstance();
		
		System.out.println(listeDate);
		
		for(int i=0;i<listeDate.size();i++) {
			cal.setTime(listeDate.get(i));
			int day=cal.get(Calendar.DAY_OF_WEEK);
			if(day==4) {
				mercredi++;
			}else if(day==3) {
				mardi++;
			}else if(day==2) {
				lundi++;
			}else if(day==5) {
				jeudi++;
			}else if(day==6) {
				vendredi++;
			}else if(day==7) {
				samedi++;
			}
		}
		
		pie= new PieChartModel();
		pie.set("Lundi", lundi*10);
		pie.set("Mardi", mardi*10);
		pie.set("Mercredi", mercredi*10);
		pie.set("Jeudi", jeudi*10);
		pie.set("Vendredi", vendredi*10);
		pie.set("Samedi", samedi*10);
		pie.setTitle("Weekly Disponibilities Report %");
		pie.setLegendPosition("w");
	}
}
