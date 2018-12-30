package tn.uniteam.services.analytics;

import javax.ejb.Remote;

import tn.uniteam.persistence.Repport;

@Remote
public interface RepportManagementRemote {
	public void sendReport(Repport r);
}
