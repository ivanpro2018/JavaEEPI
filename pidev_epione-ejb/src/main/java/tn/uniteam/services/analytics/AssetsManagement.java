package tn.uniteam.services.analytics;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Asset;
import tn.uniteam.persistence.Asset.AssetType;

/**
 * Session Bean implementation class AssetsManagement
 */
@Stateless
@LocalBean
public class AssetsManagement implements AssetsManagementRemote, AssetsManagementLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AssetsManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAsset(Asset a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public void updateAsset(Asset a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public void deleteAsset(Asset a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public List<Asset> getAllAssetsOfOffice(AspNetUser a) {
		// TODO Auto-generated method stub
		String req = "select a from Asset a where a.medicalOffice.doctor =:doc";
		Query query = em.createQuery(req).setParameter("doc", a);
		return query.getResultList();
	}

	@Override
	public List<Asset> getAllAssetsByType(AspNetUser a, AssetType at) {
		// TODO Auto-generated method stub
		String req = "select a from Asset a where a.medicalOffice.doctor =:doc and a.assetType =:type";
		Query query = em.createQuery(req).setParameter("type", at);
		return query.getResultList();
	}

}
