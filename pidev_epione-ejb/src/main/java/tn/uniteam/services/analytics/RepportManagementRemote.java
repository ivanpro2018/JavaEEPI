package tn.uniteam.services.analytics;

import javax.ejb.Remote;

@Remote
public interface RepportManagementRemote {
	public void sendReport();
}
