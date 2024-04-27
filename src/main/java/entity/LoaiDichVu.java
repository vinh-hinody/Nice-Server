package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoaiDichVu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(255)")
	private String ma;
	@Column(columnDefinition = "nvarchar(255)")
	private String ten;
	
	public LoaiDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiDichVu(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	@Override
	public String toString() {
		return "LoaiDichVu [ma=" + ma + ", ten=" + ten + "]";
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
}
