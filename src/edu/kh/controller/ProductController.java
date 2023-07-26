package edu.kh.controller;

import java.util.Scanner;

import edu.kh.model.vo.Product;

public class ProductController {
	
	Scanner sc = new Scanner(System.in);
	int count = 0;
	Product pro[] = new Product[10];
	
	public void mainMenu() {
		
		int input = -99;
		
		do{
			
			System.out.println("========제품 관리 메뉴========");
			System.out.println("1. 제품 정보 추가 : ");
			System.out.println("2. 제품 전체 조회 : ");
			System.out.println("0. 프로그램 종료 : ");
			System.out.print("번호를 입력하세요. : ");
			
			input = sc.nextInt();
			
			switch(input) {
			case 1 : productInput(); break;
			case 2 : ProductPrint(); break;
			default : break;
			}
			
		}while(input !=0);
	}
	
	public void productInput() {
		
		System.out.println("\n******제품 정보 추가******");
		System.out.print("제품번호 : ");
		int input1 = sc.nextInt();
		System.out.print("제품명 : ");
		String input2 = sc.next();
		System.out.print("제품가격: ");
		int input3 = sc.nextInt();
		System.out.print("제품세금 : ");
		double input4 = sc.nextDouble();
		
		for(int i = 0; i < pro.length; i++) {
			
			if(pro[i] == null) {
				
				pro[i].setpId(input1);
				pro[i].setpName(input2);
				pro[i].setPrice(input3);
				pro[i].setTax(input4);
				count++;
			}
		}
	}
	
	public void ProductPrint() {
		
		for(int i = 0; i < pro.length; i++) {

			System.out.println(pro[i].toString());
		}
	}

}
