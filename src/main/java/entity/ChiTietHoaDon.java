package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
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
@NamedNativeQueries({
	@NamedNativeQuery(name = "ChiTietHoaDon.timHoaDonCuaPhong", 
			query = "select * from [dbo].[ChiTietHoaDon] where maP = :maP and tinhTrang = :tinhTrang", 
			resultClass = ChiTietHoaDon.class)
})
public class ChiTietHoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "maHD")
	@Id
	private HoaDon maHD;
	@ManyToOne
	@JoinColumn(name = "maPDP", nullable = false)
	private PhieuDatPhong maPhieuDP;
	@ManyToOne
	@JoinColumn(name = "maPGM")
	private PhieuGoiMon maPhieuGM;
	@ManyToOne
	@JoinColumn(name = "maP")
	private Phong maPhong;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
}

