package com.hhhh.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "math_table", schema = "mathapp")
public class Lesson implements Serializable{

	/**
	 *по требованию Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_math")
	private int id_math;
	@Column(name="[rank]")
	private double rank;
	@Column(name="[rank_total]")
	private double rank_total;
	private Date date;
	private int id_user;
	
	
	public Lesson() {};
	
	public Lesson(double rank,double rank_total, Date date, int id_user) {
		this.rank=rank;
		this.rank_total=rank_total;
		this.date=date;
		this.id_user=id_user;
	}

	public int getId_math() {
		return id_math;
	}

	public void setId_math(int id_math) {
		this.id_math = id_math;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public double getRank_total() {
		return rank_total;
	}

	public void setRank_total(double rank_total) {
		this.rank_total = rank_total;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate() {
		date=new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public int getId_user() {
		return id_user;
	}
	
	 public void setId_user(int id_user) {
		 this.id_user=id_user;
	 }
	
	

	@Override
	public String toString() {
		return "lesson toString [id_math"+getId_math()
		+"][rank"+getRank()
		+"][rank_total"+getRank_total()
		+"][date"+getDate()
		+"][id_user"+getId_user()
		+"]";
		}

}
