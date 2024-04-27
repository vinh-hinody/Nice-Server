package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CaTruc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int maCT;
	@Column
	private int vaoCa;
	@Column
	private int raCa;
	
	public int getMaCT() {
		return maCT;
	}
	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}
	public int getVaoCa() {
		return vaoCa;
	}
	public void setVaoCa(int vaoCa) {
		this.vaoCa = vaoCa;
	}
	public int getRaCa() {
		return raCa;
	}
	public void setRaCa(int raCa) {
		this.raCa = raCa;
	}
	public CaTruc(int maCT, int vaoCa, int raCa) {
		super();
		this.maCT = maCT;
		this.vaoCa = vaoCa;
		this.raCa = raCa;
	}
	public CaTruc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CaTruc [maCT=" + maCT + ", vaoCa=" + vaoCa + ", raCa=" + raCa + "]";
	}



}
