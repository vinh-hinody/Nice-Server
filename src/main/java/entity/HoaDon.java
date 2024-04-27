package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maHD;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien maNV;
	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang maKH;
	@Column
	private LocalDateTime thoiGianLap;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	
}
