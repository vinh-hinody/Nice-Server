package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@IdClass(ChiTietPhieuDP_ID.class)
public class ChiTietPhieuDatPhong implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private PhieuDatPhong maPDP;
	@Id
	private Phong maP;
	@Column
	private LocalDateTime tgVao;
	@Column
	private LocalDateTime tgRa;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;

}
