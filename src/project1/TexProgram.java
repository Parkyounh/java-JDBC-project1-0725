package project1;

import java.util.Scanner;

class Salary{
	private int salary[];
	private String names[];
	private int tex;
	private int peopleNum;
	private int total;
	private int min ;
	private int max;
	private double average;
	private int annualSalary[];
	
	
	public Salary(int peopleNum) {
		super();
		this.peopleNum = peopleNum;
		this.names = new String[peopleNum];
		this.salary = new int[peopleNum];
		this.annualSalary = new int[peopleNum];
		
	}
	
	public String[] getNames() {
		return names;
	}

	public void setNames(int i,String names) {
		this.names[i] = names;
	}

	public int[] getSalary() {
		return salary;
	}
	public void setSalary(int i,int salary) {
		this.salary[i] = salary;
	}
	public int getTex() {
		return tex;
	}
	public void setTex(int tex) {
		this.tex = tex;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	public int[] getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int i,int annualSalary ) {
		this.annualSalary[i] = annualSalary;
	}

	public int minimum(){
		min = salary[0];
		for (int i=0; i<peopleNum; i++) {
			
			if (min>salary[i]) {
				min = salary[i];
			}
		}
		return min;
	}
	public int maximum(){
		for (int i=0; i<peopleNum; i++) {
			if (max<salary[i]) {
				max = salary[i];
			}
		}
		return max;
	}
	public double average(){
		for (int i=0; i<peopleNum; i++) {
			total+=salary[i];
		}
		average = (double)total/peopleNum;
		return average;
	}
	public int total(){
		total=0;
		for (int i=0; i<peopleNum; i++) {
			total+=salary[i];
		}
		return total;
	}
	
	public int tex(int i) {  //1400만 5000만 8800만 1억5000만 3억 까지만 계산  
		
		if (annualSalary[i]<14000000) {        
			tex= (int)((double)annualSalary[i]/100*6);
			
		}else if(annualSalary[i]>=14000000 && annualSalary[i]<50000000) {
			tex = (int)((double)(annualSalary[i]-14000000)/100*15 + 840000);
			
		}else if(annualSalary[i]>=50000000 && annualSalary[i]<88000000) {
			tex = (int)((double)(annualSalary[i]-50000000)/100*24 + 6240000);
			
		}else if(annualSalary[i]>=88000000 && annualSalary[i]<150000000) {
			tex = (int)((double)(annualSalary[i]-88000000)/100*35 + 15360000);
			
		}else if(annualSalary[i]>=150000000 && annualSalary[i]<300000000) {
			tex = (int)((double)(annualSalary[i]-150000000)/100*38 + 37060000);
			
		}else {
			System.out.println("오류");
		}
		return tex;
	}
	
	
}


public class TexProgram {
	public static void main(String[] args) {
		int peopleNum =0;
		int tex;
		String nameSal;
		boolean run =false;
		double arv;
		
		int salary[];
		int annualSalary[];
		String [] splitNameSal;
		String names[];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사람 수 입력: ");
		peopleNum =Integer.parseInt(sc.nextLine());
		
		Salary sal = new Salary(peopleNum);
		
		for (int i=0; i<peopleNum; i++){
			
			System.out.print("이름(띄고)월급 입력(남은횟수:"+peopleNum+")>");
			nameSal = sc.nextLine();
			splitNameSal=nameSal.split(" ");
			try {
				sal.setNames(i, splitNameSal[0]);
				sal.setSalary(i, Integer.parseInt(splitNameSal[1]));
				sal.setAnnualSalary(i, Integer.parseInt(splitNameSal[1])*12);
			} catch (Exception e) {
				System.err.println("잘못 입력하셨습니다");
			}
		}
		
		names=sal.getNames();
		salary=sal.getSalary();
		annualSalary=sal.getAnnualSalary();
			
		while(!run) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1.이름 리스트 | 2.임금 리스트 | 3.통합 리스트 | 4.통계 | 5.세금 계산(연봉) | 6.종료");
			System.out.println("---------------------------------------------------------------------");
			
			String input = sc.nextLine();
			
			if (input.equals("1")) {
				for (int i=0; i<peopleNum;i++) {
					System.out.println(names[i]);
				}
			}else if (input.equals("2")) {
				for (int i=0; i<peopleNum;i++) {
					System.out.println(salary[i]);
				}
				
			}else if (input.equals("3")) {
				for (int i=0; i<peopleNum;i++) {
					System.out.println(names[i]+"\t"+salary[i]);
				}
				
			}else if (input.equals("4")) {
				System.out.printf("평균:%.2f\n최대:%d\n최저:%d\n총합:%d\n",sal.average(),sal.maximum(),sal.minimum(),sal.total());
	
			}else if (input.equals("5")) {
				System.out.println("-------------------");
				System.out.println("원하는 사람의 번호를 입력하시오");
				System.out.println("-------------------");
				
				for (int i=0; i<peopleNum;i++) {
					System.out.println(i+1+":"+names[i]+"\t"+annualSalary[i]);
				}
				System.out.print(">>");
				input = sc.nextLine();
				System.out.print("세금은 약"+sal.tex(Integer.parseInt(input)-1)+"원 입니다.");
				System.out.println();
				
			}else if (input.equals("6")) {
				System.out.println("종료");
				return;
			}
			
			
		}
			
		
		
	}
	

}
