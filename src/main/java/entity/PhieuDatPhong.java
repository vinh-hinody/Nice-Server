package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PhieuDatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maPhieuDP;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien maNV;
	@Column
	private LocalDateTime ngayLap;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	
	
	public String getMaPhieuDP() {
		return maPhieuDP;
	}
	public void setMaPhieuDP(String maPhieuDP) {
		this.maPhieuDP = maPhieuDP;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhieuDatPhong(String maPhieuDP, NhanVien maNV, LocalDateTime ngayLap, String tinhTrang) {
		super();
		this.maPhieuDP = maPhieuDP;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDP=" + maPhieuDP + ", maNV=" + maNV + ", ngayLap=" + ngayLap + ", tinhTrang="
				+ tinhTrang + "]";
	}
	

	
}
