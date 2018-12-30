package tn.uniteam.services.analytics;

import javax.ejb.Local;

import tn.uniteam.persistence.Repport;

@Local
public interface RepportManagementLocal {
	public void sendReport(Repport r);
}
