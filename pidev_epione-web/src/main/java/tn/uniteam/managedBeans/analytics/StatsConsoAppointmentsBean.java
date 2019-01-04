package tn.uniteam.managedBeans.analytics;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import tn.uniteam.managedBeans.users.LoginBean;
import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.analytics.ConsommationStatistiquesManagement;

@ManagedBean
@SessionScoped
public class StatsConsoAppointmentsBean {
	
	private PieChartModel pieModel;
	private BarChartModel barModel;
	private List<AspNetUser> listT;
	private List<AspNetUser> listNT;
	
	
	@EJB
	private ConsommationStatistiquesManagement local;
	
	public PieChartModel getPieModel() {
		return pieModel;
	}
	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	public BarChartModel getBarModel() {
		return barModel;
	}
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
	public List<AspNetUser> getListT() {
		return listT;
	}
	public void setListT(List<AspNetUser> listT) {
		this.listT = listT;
	}
	public List<AspNetUser> getListNT() {
		return listNT;
	}
	public void setListNT(List<AspNetUser> listNT) {
		this.listNT = listNT;
	}
	@PostConstruct
	public void init() {
		listNT = new ArrayList<AspNetUser>();
		listT = new ArrayList<AspNetUser>();
		
		listNT  = local.ConsommationGetNotTreatedPatientsOfDoctor(LoginBean.loggedUser.getId());
		listT  = local.ConsommationGetTreatedPatientsOfDoctor(LoginBean.loggedUser.getId());

		//		CreatePie();
		CreateBar();
	
	}
	
	
	private void CreateBar() {
        barModel = initBarModel();
        
        barModel.setTitle("Evolution du nombre de patients traités sur quelques mois");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Patients");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre");
        yAxis.setMin(0);
        yAxis.setMax(200);

		
	}
	
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
//		List<AspNetUser> listT = local.ConsommationGetTreatedPatientsOfDoctor(LoginBean.loggedUser.getId());
//		List<AspNetUser> listNT = local.ConsommationGetNotTreatedPatientsOfDoctor(LoginBean.loggedUser.getId());		
        
        ChartSeries nt = new ChartSeries();
        nt.setLabel("Patients non traités");
        nt.set("Janvier", listNT.size());
        System.out.println("size" + listNT.size());
        nt.set("Février", listNT.size()-2);
        nt.set("Avril", listNT.size()-1);
        nt.set("Mai", listNT.size()-1);
        nt.set("Juin", listNT.size()-3);
 
        ChartSeries tr = new ChartSeries();
        tr.setLabel("Patients traités");
        tr.set("Janvier", listT.size()-3);
        tr.set("Février", listT.size()-2);
        tr.set("Avril", listT.size()-1);
        tr.set("Mai", listT.size());
        tr.set("Juin", listT.size()-1);
 
        model.addSeries(tr);
        model.addSeries(nt);
 
        return model;
	}
	
	
	private void CreatePie() {
		
		List<Appointment> appointments = local.ConsommationGetAppointmentsOfDoctor(LoginBean.loggedUser.getId());
		int nbreInprogress = 0, nbreCompleted = 0, nbreCanceled = 0, nbrePostponed = 0;
		for (Appointment appointment : appointments) {
			switch (appointment.getAppointmentState()) {
			case 0:
				nbreInprogress++;
				break;

			case 1:
				nbreCompleted++;
				break;
				
			case 2:
				nbreCanceled++;
				break;
				
			default:
				nbrePostponed++;
				break;
			}
		}
		
        pieModel = new PieChartModel();
        
        pieModel.set("Canceled", nbreCanceled);
        pieModel.set("Completed", nbreCompleted);
        pieModel.set("Inprogress", nbreInprogress);
        pieModel.set("Postponed", nbrePostponed);
 
        pieModel.setTitle("Your progress appointments' State");
        pieModel.setLegendPosition("w");
        pieModel.setShadow(true);
		
	}
	

	
	
}
