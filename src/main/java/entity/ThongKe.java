package entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class ThongKe implements Serializable{
	private double tongThu;
	private double tongChi;
	private double loiNhuan;
	private int ngay;
	private int thang;
	private int nam;
	
}
