package bitcoin;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Time1 extends Thread {
	private Calendar cmp;			//초기 시간 저장
	private Calendar time;			//게임내 시간 저장
	private Calendar Check;	
	private long inter[];
	
	private long Value_of_building[] = {6000,32000,105000,809000,91302000,328000000000L};		// 나누기 1만을 한 값 저장
	private int building[];
	
	private long money[];
	private long rate[];
	private Trade userdata;
	
	
	public void Set_Time() {			//시간 초기화
		cmp = Calendar.getInstance();	//현재 시간 부터
		time = Calendar.getInstance();
		Check = Calendar.getInstance();
	}
	public Time1(Trade userdata) {
		
		this.userdata = userdata;
	}
	
	public void set_Inter(long inter[], long money[],long rate[],int building[]) {	//loan_ex1,loan_ex2,이율, 빌딩 순으로 입력한다.
		this.inter = inter;
		this.money = money;
		this.rate = rate;
		this.building = building;
		
	}
	

	public Calendar Get_cmp() {			//게임 시작 시간(현실 시간)
		return this.cmp;
	}
	public Calendar Get_time() {		//게임 내부 시간
		return this.time;
	}
	
	
	public void Set_inter() {			//각각 의 이자 
		long diff_day=time.getTimeInMillis() - Check.getTimeInMillis();		//날차이
		diff_day =diff_day/ (24*60*60*1000);
		System.out.println(diff_day);
		if(diff_day>=1)		//하루가 차이가 나면
		{	
			//건물 이자			차후 구현
			for(int i = 0; i<building.length;i++) {
				if(building[i]==1) {				//보유할 경우에만.
					
					userdata.Put_own(Value_of_building[i]*((i*3)+1));
				}
			}

			//빚 이자
			
			for(int i = 0; i<inter.length; i ++) {
				if(money[i] == 0)
					i++;
				if(i == inter.length)
					break;
				inter[i] = (money[i] + inter[i]) * rate[i] /10000;			//이자 적용
				money[i] += inter[i]; 			//총액 + 이자
				
			}
				
			StartPage.d_day --;
			if(	StartPage.d_day<=0)
				//엔딩시점
			
			System.out.println(userdata.Get_own()+"    "+StartPage.d_day);
			Check.add(Calendar.DATE, 1);				
			
		}
	}
	public void run() {
		while(true) {
		try {
			
			Thread.sleep(6000);			//1분 마다
			time.add(Calendar.DATE, 1);	// 하루 증가
			Set_inter();
			
		}
		catch(InterruptedException e){
			 e.printStackTrace();
		}
	}
	}
}
