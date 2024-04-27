package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
public class LoaiPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maLP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLP;
	
	public String getMaLP() {
		return maLP;
	}
	public void setMaLP(String maLP) {
		this.maLP = maLP;
	}
	public String getTenLP() {
		return tenLP;
	}
	public void setTenLP(String tenLP) {
		this.tenLP = tenLP;
	}
	public LoaiPhong(String maLP, String tenLP) {
		super();
		this.maLP = maLP;
		this.tenLP = tenLP;
	}
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLP=" + maLP + ", tenLP=" + tenLP + "]";
	}
	
	
}
