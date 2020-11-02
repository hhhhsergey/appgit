package com.hhhh.app.service;

public class Mathcontainer {
	
	int one;
	int two;
	int result;
	double userresult; //double потому что считывается с формы double
	
	/*если прокатит, то надо добавить temprank
	 * счет будет динамический
	 * цикл фор, потом по номеру переменной сделать выражение 
	 * и складывание результата в темпранк
	 */

	public Mathcontainer() {
		
	}
	
	public Mathcontainer(int one, int two, int result, double userresult) {
		this.one = one;
		this.two = two;
		this.result = result;
		this.userresult = userresult;
	}


	public double getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public double getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public double getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public double getUserresult() {
		return userresult;
	}

	public void setUserresult(double userresult) {
		this.userresult = userresult;
	}
	
	public String toString() {
		return "mc toString ["+one+"]["+two+"]["+result+"]["+userresult+"]";
		
	}

	
	
	
	

}
