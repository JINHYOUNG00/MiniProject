package co.jin.pj.main;

import java.util.Scanner;

import co.jin.pj.user.User;

public class Menu {
	
	private Scanner scn = new Scanner(System.in);
	private int menu;
	
	
	public void main() {
		
		boolean b = true;
		while(b) {
			System.out.println("======================================");
			System.out.println("1. 로그인 2. 회원가입 3. 블랙리스트 4. 종료");
			System.out.println("======================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu = scn.nextInt();
			scn.nextLine();
			if(menu == 1) {
				signIn();
			} else if(menu == 2) {
				User.userInsert();
				
			} else if(menu == 3) {
				blackList();
			} else if(menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}			
		}
	}
	
	private void signIn() {
		
	}
	private void signUp() {
		
	}
	private void blackList() {
		
	}

}
