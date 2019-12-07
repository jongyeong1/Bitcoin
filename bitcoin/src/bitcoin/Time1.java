package bitcoin;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Time1 extends Thread {
	private Calendar cmp;			//�ʱ� �ð� ����
	private Calendar time;			//���ӳ� �ð� ����
	private Calendar Check;	
	private long inter[];
	
	private long Value_of_building[] = {6000,32000,105000,809000,91302000,328000000000L};		// ������ 1���� �� �� ����
	private int building[];
	
	private long money[];
	private long rate[];
	private Trade userdata;
	
	
	public void Set_Time() {			//�ð� �ʱ�ȭ
		cmp = Calendar.getInstance();	//���� �ð� ����
		time = Calendar.getInstance();
		Check = Calendar.getInstance();
	}
	public Time1(Trade userdata) {
		
		this.userdata = userdata;
	}
	
	public void set_Inter(long inter[], long money[],long rate[],int building[]) {	//loan_ex1,loan_ex2,����, ���� ������ �Է��Ѵ�.
		this.inter = inter;
		this.money = money;
		this.rate = rate;
		this.building = building;
		
	}
	

	public Calendar Get_cmp() {			//���� ���� �ð�(���� �ð�)
		return this.cmp;
	}
	public Calendar Get_time() {		//���� ���� �ð�
		return this.time;
	}
	
	
	public void Set_inter() {			//���� �� ���� 
		long diff_day=time.getTimeInMillis() - Check.getTimeInMillis();		//������
		diff_day =diff_day/ (24*60*60*1000);
		System.out.println(diff_day);
		if(diff_day>=1)		//�Ϸ簡 ���̰� ����
		{	
			//�ǹ� ����			���� ����
			for(int i = 0; i<building.length;i++) {
				if(building[i]==1) {				//������ ��쿡��.
					
					userdata.Put_own(Value_of_building[i]*((i*3)+1));
				}
			}

			//�� ����
			
			for(int i = 0; i<inter.length; i ++) {
				if(money[i] == 0)
					i++;
				if(i == inter.length)
					break;
				inter[i] = (money[i] + inter[i]) * rate[i] /10000;			//���� ����
				money[i] += inter[i]; 			//�Ѿ� + ����
				
			}
				
			StartPage.d_day --;
			if(	StartPage.d_day<=0)
				//��������
			
			System.out.println(userdata.Get_own()+"    "+StartPage.d_day);
			Check.add(Calendar.DATE, 1);				
			
		}
	}
	public void run() {
		while(true) {
		try {
			
			Thread.sleep(6000);			//1�� ����
			time.add(Calendar.DATE, 1);	// �Ϸ� ����
			Set_inter();
			
		}
		catch(InterruptedException e){
			 e.printStackTrace();
		}
	}
	}
}
