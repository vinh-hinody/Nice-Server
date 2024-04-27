package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maSP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenSP;
	@ManyToOne
	@JoinColumn(name = "maLSP")
	private LoaiSanPham maLSP;
	@Column
	private LocalDate ngayNhap;
	@Column
	private double giaNhap;
	@Column
	private double giaBan;
	@Column
	private int soLuongTon;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSP, String tenSP, LoaiSanPham maLSP, LocalDate ngayNhap, double giaNhap, double giaBan,
			int soLuongTon, String tinhTrang) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maLSP = maLSP;
		this.ngayNhap = ngayNhap;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", maLSP=" + maLSP + ", ngayNhap=" + ngayNhap
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon + ", tinhTrang="
				+ tinhTrang + "]";
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public LoaiSanPham getMaLSP() {
		return maLSP;
	}
	public void setMaLSP(LoaiSanPham maLSP) {
		this.maLSP = maLSP;
	}
	public LocalDate getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
