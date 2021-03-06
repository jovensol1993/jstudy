package day13;

/*
	문제 2]
		Figure 클래스를 만들고
			
			class Figure {
				double getArea(){
					return 0.0;
				}
				public String toString(){
					return "이것은 도형입니다.";
				}
			}
		
		
		이 클래스를 상속받아서 Sagak(사각형), Semo(삼각형), Dongle(원) 클래스를 만들어서
		각 도형의 내용을 출력하세요.
 */

import static java.lang.Math.*; // static 의 멤버를 임포트 하는 방법

public class Ex02 {
	
	
	public Ex02() {
		int[] cnt = new int[10];
		for(int i = 0 ; i < 10 ; i++ ) {
			cnt[i] = (int)(Math.random() * 11);
		}
		
		// Figure 배열 만든다.
		Figure[] fg = new Figure[10];
		for(int i = 0 ; i < fg.length ; i++ ) {
			int no1 = (int)(random() * 13 + 3);
			if(cnt[i] % 3 == 0) {
				fg[i] = new Dongle(no1);
			} else if( cnt[i] % 3 == 1) {
				int no2 = (int)(random()*13 + 3);
				fg[i] = new Semo(no1, no2);
			} else {
				int no2 = (int) (random()* 13 + 3);
				fg[i] = new Sagak(no1, no2);
			}
		} // 배열이 완성이 됬다.
		
		// 출력하기
		for(int i = 0 ; i < fg.length ; i++ ) {
			System.out.println(fg[i]);
		}
	}
	public static void main(String[] args) {
		new Ex02();
	}

}

class Figure {
	double getArea(){
		return 0.0;
	}
	public String toString(){
		return "이것은 도형입니다.";
	}
}

class Sagak extends Figure {
	int width, height;
	double area;
	
	// 새성자 함수를 만들어둔다.
	public Sagak() {
		this(1, 1);
		// 원칙은 this.Sagak(1, 1) 호출해야하지만 생성자 함수는 일반함수처럼 호출할 수 없다.
	}
	
	public Sagak(int width, int height) {
		this.width = width;
		this.height = height;
		area = getArea();
	}
	
	public double getArea() { 
		/*
		 	getArea() 오버라이딩
		 	
		 	방법 ]
		 		
		 		1. 함수의 원형은 유지한다. 함수의 원형 = 반환값타입 + 함수이름 + 매개변수리스트
		 		2. 접근지정자는 같거나 넓은 방향으로 한다.
		 */
		return width * height;
	}
	
	public String toString() {
		return "이 도형은 가로가 " + width + 
				" 이고 세로가 " + height + 
				" 이고 넓이가 " + area + 
				" 인 사각형입니다.";
	}
}

class Semo extends Figure {
	int width, height;
	double area;
	
	public Semo() {
		this(1, 1);
	}
	
	public Semo(int width, int height) {
		this.width = width;
		this.height = height;
		area = getArea();
	}
	
	public double getArea() {
		return width * height / 2.0;
	}
	
	public String toString() {
		return "이 도형은 밑변이 " + width + 
				" 이고 높이가 " + height + 
				" 이고 넓이가 " + area + 
				" 인 삼각형입니다.";
	}
}

class Dongle extends Figure {
	int rad;
	double arround, area;
	
	// 생성자 함수
	public Dongle() {
		this(1);
	}
	
	public Dongle(int rad) {
		this.rad = rad;
		area = getArea();
		setArround();
	}
	
	public double getArea() {
		return rad * rad * 3.14;
	}
	
	// 둘레 변수 초기화 해주는 함수
	public void setArround() {
		arround = ((int)(2 * rad * 3.14 * 100 + 0.5)) / 100.0;
	}
	
	public String toString() {
		return "이 도형은 반지름이 " + rad + 
				" 이고  둘레가 " + arround + 
				" 이고 넓이가 " + area + 
				" 인 원입니다.";
	}
}
