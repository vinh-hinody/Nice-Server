package entity;


import java.io.Serializable;

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
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Phong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(255)")
	private String maP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenP;
	@ManyToOne
	@JoinColumn(name = "maLP")
	private LoaiPhong maLP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	@Column
	private double giaP;
	@Column
	private int sucChua;
}


