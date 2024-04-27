package entity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Embeddable;
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
@ToString
@EqualsAndHashCode
@Embeddable
public class BangChamCong_ID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "maCT")
	private CaTruc maCT;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien maNV;
	private LocalDate ngay;
}
