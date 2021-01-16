package com.hhhh.app.controller;

import com.hhhh.app.entity.Lesson;
import com.hhhh.app.service.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
		Date date = new Date();
		System.out.println(format.format(date));
		System.out.println(date);
		Date date2 = new Date(1604920910);
		date2 = new Date();
		System.out.println(format.format(date2));
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(1);
		int[] a= {1,2,3,4,5,6,7,8};
		a.toString();
		System.out.println(a.toString());
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		List<Lesson> testlist=new ArrayList<Lesson>();
		if(testlist.isEmpty())System.out.println("empty");
		

//		List<Mathcontainer> list = new ArrayList<Mathcontainer>();
//		Mathcontainer aaa = new Mathcontainer();
//		Mathcontainer bbb = new Mathcontainer();
//		Mathcontainer ccc = new Mathcontainer();
//		aaa.setOne(5);
//		aaa.setTwo(7);
//		bbb.setOne(3);
//		bbb.setTwo(4);
//		ccc.setOne(10);
//		ccc.setTwo(6);
//		list.add(aaa);
//		list.add(bbb);
//		list.add(ccc);
//		//сложили все в лист.
////		for(Mathcontainer mc:list) {
////			System.out.println(mc.getOne()+" "+mc.getTwo());
////			System.out.println();
////		}
////		for(int i=0;i<8;i++) {
////			Mathcontainer mc.getOne();
////		}
////		
//
//		String test ="math";
//		System.out.println(test.equals("math")+ "equals");
//		
//		int a;
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
//		a=(int)(Math.random()*(100-1)+1);System.out.println("a= "+a);
	}
	
}
