package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class PhieuGoiMon implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maPGM;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien maNV;
	@Column
	private LocalDate thoiGianLap;
	@ManyToOne
	@JoinColumn(name = "maP")
	private Phong maP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	
	
}
