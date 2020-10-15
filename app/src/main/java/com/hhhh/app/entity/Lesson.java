package com.hhhh.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "math_table", schema = "mathappdemo")
public class Lesson implements Serializable{

	/**
	 *по требованию Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_math;
	private double rank;
	private double rank_total;
	
	protected Lesson() {};
	protected Lesson(int id_math,double rank,double rank_total) {
		this.id_math=id_math;
		this.rank=rank;
		this.rank_total=rank_total;
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

}
