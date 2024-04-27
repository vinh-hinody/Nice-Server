package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@ToString
@IdClass(ChiTietPhieuGM_ID.class)
public class ChiTietPhieuGoiMon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private PhieuGoiMon maPGM;
	@Id
	private SanPham maSP;
	@Column
	private int soLuong;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	
}
