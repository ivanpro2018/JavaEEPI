package tn.uniteam.services.analytics;

import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Asset;
import tn.uniteam.persistence.Asset.AssetType;

@Local
public interface AssetsManagementLocal {
	public void addAsset(Asset a);
	public void updateAsset(Asset a);
	public void deleteAsset(Asset a);
	public List<Asset> getAllAssetsOfOffice(AspNetUser a);
	public List<Asset> getAllAssetsByType(AspNetUser a, AssetType at);
	
}
