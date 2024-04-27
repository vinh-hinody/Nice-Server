package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LoaiSanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(255)")
	private String maLSP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLSP;
	@ManyToOne
	@JoinColumn(name = "maLDV")
	private LoaiDichVu maLDV;
	
	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiSanPham(String maLSP, String tenLSP, LoaiDichVu maLDV) {
		super();
		this.maLSP = maLSP;
		this.tenLSP = tenLSP;
		this.maLDV = maLDV;
	}
	@Override
	public String toString() {
		return "LoaiSanPham [maLSP=" + maLSP + ", tenLSP=" + tenLSP + ", maLDV=" + maLDV + "]";
	}
	public String getMaLSP() {
		return maLSP;
	}
	public void setMaLSP(String maLSP) {
		this.maLSP = maLSP;
	}
	public String getTenLSP() {
		return tenLSP;
	}
	public void setTenLSP(String tenLSP) {
		this.tenLSP = tenLSP;
	}
	public LoaiDichVu getMaLDV() {
		return maLDV;
	}
	public void setMaLDV(LoaiDichVu maLDV) {
		this.maLDV = maLDV;
	}
	
	
	
	
}
