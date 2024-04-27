package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String sdt;
	@Column(columnDefinition = "nvarchar(255)")
	private String hoTenKH;
	@Column
	private Date ngaySinh;
	@Column(columnDefinition = "nvarchar(255)")
	private String diaChi;
	@Column
	private String email;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String sdt, String hoTenKH, Date ngaySinh, String diaChi, String email, String tinhTrang) {
		super();
		this.sdt = sdt;
		this.hoTenKH = hoTenKH;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.tinhTrang = tinhTrang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "KhachHang [sdt=" + sdt + ", hoTenKH=" + hoTenKH + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi
				+ ", email=" + email + ", tinhTrang=" + tinhTrang + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, hoTenKH, ngaySinh, sdt, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(hoTenKH, other.hoTenKH) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(sdt, other.sdt) && Objects.equals(tinhTrang, other.tinhTrang);
	}

}
