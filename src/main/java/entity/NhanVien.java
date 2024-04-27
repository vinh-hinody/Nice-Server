package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@AllArgsConstructor
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer maNV;
	@Column(columnDefinition = "nvarchar(255)")
	private String hoTenNV;
	@ManyToOne
	@JoinColumn(name = "maCV")
	private ChucVu maCV;
	@Column
	private String sdt;
	@Column
	private String cccd;
	@Column
	private LocalDate ngaySinh;
	@Column(columnDefinition = "nvarchar(255)")
	private String diaChi;
	@Column
	private Double heSoLuong;
	@ManyToOne
	@JoinColumn(name = "maNVQL")
	private NhanVien maNVQL;
	@Column(columnDefinition = "nvarchar(255)")
	private String trinhTrang;

	public NhanVien(String hoTenNV, ChucVu maCV, String sdt, String cccd, LocalDate ngaySinh, String diaChi,
			Double heSoLuong, NhanVien maNVQL, String trinhTrang) {
		super();
		this.hoTenNV = hoTenNV;
		this.maCV = maCV;
		this.sdt = sdt;
		this.cccd = cccd;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
		this.maNVQL = maNVQL;
		this.trinhTrang = trinhTrang;
	}
}
