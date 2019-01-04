package tn.uniteam.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Assets")
@NamedQuery(name="Asset.findAll", query="SELECT a FROM Asset a")
public class Asset implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum AssetType {
        capital,
        credit,
        cash,
        loan,
        material,
        room,
        building,
        land,
        salary,
        car,
        other
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AssetId")
	private int assetId;

	@Column(name="AssetName")
	private String assetName;

	@Column(name="AssetType")
	private AssetType assetType;

	@Column(name="PurchaseDate")
	private Date purchaseDate;

	@Column(name="SaleDate")
	private Date saleDate;

	@Column(name="Value")
	private double Value;

	//bi-directional many-to-one association to MedicalOffice
	@ManyToOne
	@JoinColumn(name="Office_Id")
	private MedicalOffice medicalOffice;

	public Asset() {
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public double getValue() {
		return Value;
	}

	public void setValue(double value) {
		Value = value;
	}

	public MedicalOffice getMedicalOffice() {
		return medicalOffice;
	}

	public void setMedicalOffice(MedicalOffice medicalOffice) {
		this.medicalOffice = medicalOffice;
	}


}
