package bitcoin;	

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;




public class Trade extends UserData {			//Trade�� �ٲ� ����
	
	/*�ſ� ���� �ѵ� ���*/
	public long Check_limit(int fin) {			//������ �Է� -> ���� �� �ִ� �ſ� ���� �ѵ� ���
		
		/*	// �ſ� ���� ���� �ʿ� ������
		float Inter1 = 3;  //1����		
		float Inter2 = 5;  //2����
		float Inter3 = 7;  //3����
		*/
		
		if(super.Get_borrow()!= null &&super.Get_borrow().length >=3)			//���� ������ 3�� �̻��� ��쿡�� ����
			return -1;
		if(super.Get_credit() >=700)		//1���
		{
			if(fin == 1) {				//1����
				return 1000000000;	//10��
			}
			else if(fin ==2) {			//2����
				return 1500000000;	//15��
			}
			else if (fin ==3) {			//3����
				return 3000000000L;	//30��
			}
			else {
				//����
			}
		}
		else if (super.Get_credit() >=400)	//2���
		{
			if(fin == 1) {				//1����
				return 1000000000;	//10��
			}
			else if(fin ==2) {			//2����
				return 1500000000;	//15��
			}
			else if (fin ==3) {			//3����
				return 3000000000L;	//30��
			}
			else {
				//����
			}
		}
		else								//3���
		{
			if(fin == 1) {				//1����
				return 1000000000;	//10��
			}
			else if(fin ==2) {			//2����
				return 1500000000;	//15��
			}
			else if (fin ==3) {			//3����
				return 3000000000L;	//30��
			}
			else {
				//����
			}
			
		}
		
		
		
		
		return 0;
	}
	
	
	/*��ȯ�� �̱��� ���� ����*/
	//�ſ� ���� ���� �Լ�
	public void Loan_Edit(int fin,long m)					//�Է� �����ǰ� ���� �� �Է�
	{		//�ٽ��ѹ� üũ�ϱ�
		/*üũ �ϴ� ��Ʈ*/
		
		long[] borrow	= super.Get_borrow();			//����
		long[] Due_Date;				//��ȯ��
		float[] inter;				//����
		int[] loan;					//���� ���� �Է�
		/*���� ���� ��� ����*/
		if(super.Get_borrow() == null) {			//������ ������ ���°�쿡��
			 borrow = new long[1];
			 Due_Date = new long[1];
			 inter = new float[1];
			 loan = new int [1];
			 
		}
		else {/*������ �غ����� �ִٸ� ��ĭ �� ũ�� ����� �ش�.*/
			borrow = new long[super.Get_borrow().length+1];
			 Due_Date = new long[super.Get_borrow().length+1];
			 inter = new float[super.Get_borrow().length+1];
			 loan = new int [super.Get_borrow().length+1];
			 
			 /*���� ������ �ޱ�*/
			 for(int i = 0;super.Get_borrow().length< i;i++) {
				 borrow[i] = super.Get_borrow()[i];
				 Due_Date[i] =super.Get_Due_Date()[i];  
				 inter[i] = super.Get_inter()[i];
				 loan[i] = super.Get_Loan()[i];
			 }
		}
		
			//�Է� ������ ������ -> �ſ� ��� ���� ->  �� �߰� - > ���ڸ� �ڵ� ���� -> ��ȯ�� �Է�
		super.Put_credit(super.Get_credit() - (fin * 50));	//������ ���� ��ĥ��
		super.Put_own(super.Get_own() + m);
		
		//�ڵ� ù�ڸ� 1 ��°�ڸ� ������
		loan[loan.length] = 100+fin;
		
		
	}
	
	
	
	//�㺸 ���� ���� �Լ�
	public void Loan_Edit(int fin, int index, long m) {				//�ŷ�����, �ǹ� ��ȣ, ��	
		long[] borrow	= super.Get_borrow();			//����
		long[] Due_Date;				//��ȯ��
		float[] inter;				//����
		int[] loan;					//���� ���� �Է�
		/*���� ���� ��� ����*/
		if(super.Get_borrow() == null) {			//������ ������ ���°�쿡��
			 borrow = new long[1];
			 Due_Date = new long[1];
			 inter = new float[1];
			 loan = new int [1];
			 
		}
		else {/*������ �غ����� �ִٸ� ��ĭ �� ũ�� ����� �ش�.*/
			borrow = new long[super.Get_borrow().length+1];
			 Due_Date = new long[super.Get_borrow().length+1];
			 inter = new float[super.Get_borrow().length+1];
			 loan = new int [super.Get_borrow().length+1];
			 /*���� ������ �ޱ�*/
			 for(int i = 0;super.Get_borrow().length< i;i++) {
				 borrow[i] = super.Get_borrow()[i];
				 Due_Date[i] =0;  //Get Due_Date �����ϱ�
				 inter[i] = super.Get_inter()[i];
				 loan[i] = 0;	//Get_loan �����ϱ�
			 }
		}
		

		
		
		
		//�Է� ������ ������ ->	�ſ� ��� ���� ->  �� �߰� - > ���ڸ� �ڵ� ���� -> ��ȯ�� �Է�
		
	
		
		super.Put_credit(super.Get_credit() - (fin * 50));	//������ ���� ��ĥ��
		
		super.Put_own(super.Get_own() + m);
		
		//���ڸ� ���� ù° �ڸ� 2, + ��° �ڸ� �ǹ� �ε��� + ��°�ڸ� �ŷ� ����
		loan[loan.length] = 200+(index*10)+fin;
		
		
		//��ȯ�� �Է� �߰��Ұ�!!
		
	}
	
	
	
	public int Credit_Loan(int fin) {					//�������� �Է� �ް� �ſ� ���� ���� ����
		long able;
		long money;
		Scanner scanner = new Scanner(System.in);
		//�ѵ�üũ
		able = Check_limit(fin);
		if(able == -1.0) {
			// �ȳ��� ��� �����ϱ�
			scanner.close();
			return -1;						//���� ������ -1 ����
		}
		
		//��� ��¹� ���� ��� ������ �ݾ� ���
		// ���� �ݾ� �Է�
		while(true) {
		money = scanner.nextLong();		//������ �Է�
		
		if(money>=1 && money <= able) {		//�ѵ����� �� ������
			break;
		}
		else {
			//����� �� ���ٴ� ��� ��� �����Ұ�
		}
		}
		
		scanner.close();
		Loan_Edit(fin,money);					//�ſ� ���� 
		
		return 0;
	}
	
	public int Build_Loan(int fin,int index) {			//�ǹ� ��ȣ �Է� �㺸 ���� ����
		
		if(super.Get_borrow()!= null &&super.Get_borrow().length >=3) {
			return -1;						//���� ������ -1 ����
		}
		
		Scanner scanner = new Scanner(System.in);
		long money;
		
		while(true) {
			money = scanner.nextLong();		//������ �Է�
			if(money>=1 && money <= super.Get_building()[index]) {		//�ѵ����� �� ������
				break;
			}
			else {
				//����� �� ���ٴ� ��� ��� �����Ұ�
			}
			
		}
		
		
		Loan_Edit(fin,index,money);
		
		scanner.close();
		return 0;
	}
	
	
	////////////
	//���� ���� �Լ�
	////////////
	
	//���� ���߿� ������ ���� �ȵ�  ����Ʈ ��Ʈ������ �����Ұ�
	public long Inter_cmp(long Date,long Due) {				//�Է� ���� ��¥ ���� ���� ���
		//YYYYMMDD ���� ���� ������
		int tmp = (int)Due;
		Due = (long)tmp;		//�Ҽ��� �ڸ� ����
		
		String date = new String(Long.toString(Date));
		String due = new String(Long.toString(Due));
		 String strFormat = "yyyyMMdd";    //strStartDate �� strEndDate �� format
	        
	        //SimpleDateFormat �� �̿��Ͽ� startDate�� endDate�� Date ��ü�� �����Ѵ�.
	        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
	        try{
	            Date startDate = sdf.parse(date);
	            Date endDate = sdf.parse(due);
	 
	            //�γ�¥ ������ �ð� ����(ms)�� �Ϸ� ������ ms(24��*60��*60��*1000�и���) �� ������.
	            long diffDay = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
	            
	            return diffDay;					//������ ���
	            
	        }catch(ParseException e){		//���� �ϸ�
	            e.printStackTrace();		//���ܰ�� ȭ�� ���
	        }
	    
		return -1;
	
	}
	
	public int Inter(long Date) {					//���� ��¥ �Է� ����
		//���� �ڵ带 �޾Ƽ� ���� �ϸ�
		long cmp;		//���� ��¥�� ������� ����ؼ� �ӽ� �����ϴ� ����
		
		for(int i = 0;i<super.Get_borrow().length;i++) {			//����ݵ� ���δ� ����
			
			cmp =Inter_cmp(Date,(super.Get_Due_Date()[i]/100000000));
			
			if(cmp>=7&&cmp%7!=0) {						//7�� ���� �Ǹ�
				super.Put_own((long)(super.Get_own()-(super.Get_borrow()[i]*(super.Get_inter()[i]/100))));	//���� �ΰ�
				// ���̳ʽ� �����̵Ǹ� ��� ��� �� ��
			}
		}
		
		return 0;
	}
	
	
	//�ǹ� ���� �Լ�
	//�ſ��� �϶� �̱���
	public void Take_build(int index) {				//���� �ǹ� �ε��� �Է�
		long[] build;	//��ü�� ����
		
		if(super.Get_building().length-1 >=1) {			//���� ������ 2�� �̻��ϋ�
			
		build = new long[super.Get_building().length-1];	
		
		for(int i=0;i<super.Get_building().length;i++)			//�ε����� �����ϰ� ���
		{	if(index == i) {
			i++;
			if(i>=super.Get_building().length)
				break;
		}
			build[i] = super.Get_building()[i];
		}
		}
		else {
			build = null;
		}
		
	
	}
	
	//��ȯ�� üũ �Լ� ���� ���� ����!!
	public int Check_Date(long Date) {			//���� ��¥ �Է� ����
		
		for(int i =0;i<super.Get_Due_Date().length;i++) {		//��ȯ���� �Ǹ� ->�ſ뵵 ���� -> �з�
			if(Date >= super.Get_Due_Date()[i]/100000000) {
				
				if(super.Get_Loan()[i]/100==2) {				//�ǹ��̸�
					Take_build(super.Get_Loan()[i]-200);		//�ǹ� �ε��� �ѱ��
					
					//�̺κп� �ſ뵵 �϶� 
				}
				else {
					super.Put_own(super.Get_own()-super.Get_borrow()[i]);//�� ����
					super.Put_credit(super.Get_credit() - 10); 	//�ſ뵵 ���� �ӽ÷� 10������
					
					//�� ���� + �ſ뵵 ����		-�� �ɰ�� �׿� �����ϴ� �ǹ� �з�
				}
			}
		}
		
		return 0;
	}
	
	
	//�� ���� �Լ�
	public int Pay_back(int index, long money) {	// ���° ���� �������� ���� ����, ������ �Է�
		
		if(super.Get_own()<money|| money<=0) {				//�Է¹��� ���� ������ �ִµ� ���� Ŭ ���� �������� ���� 0 ������ ���
			//���� ����
			return -1;
		}
		
		long[] borrow = super.Get_borrow();
		float[] inter = super.Get_inter();
		int[] Loan = super.Get_Loan();
		long[] Due_Date = super.Get_Due_Date();		
			
//if((super.Get_Loan()[index]/100)==1) {			//�ſ�����̸�
	
	if(super.Get_borrow()[index] <= money) {	//�� ����!!!
			money = super.Get_borrow()[index];				//�������� �ϴ� �ݾ��� �� Ŭ ��쿡�� �� �ݾ����� �ٲپ��� �Ž����� �����ϸ��
			
		if(super.Get_borrow().length-1 !=0) {			//���� ���� �������� �ƴϸ�	
				
			borrow = new long[super.Get_borrow().length-1];
			inter = new float[super.Get_borrow().length-1];
			Loan = new int[super.Get_borrow().length-1];
			Due_Date = new long[super.Get_borrow().length-1];
			
			for(int i =0;i<super.Get_borrow().length ;i++) {
				if(i == index) {		//�̹� ���� �κ��� �ǳʶ�
					i++;
					if(super.Get_borrow().length<=i) {
						break;						
					}
				}
				
				borrow[i] = super.Get_borrow()[i];		//������ �ִ� �� �������� �Ű� ��´�.
				inter[i] = super.Get_inter()[i];
				Loan[i] = super.Get_Loan()[i];
				Due_Date[i] = super.Get_Due_Date()[i];
			}
			
			}
		else {//���� ���� ������ ��
			
			borrow =null;
			inter = null;
			Loan = null;
			Due_Date = null;
		}
		
			
		}
		
		else {			//�� ���� �Ф�
			borrow[index] = super.Get_borrow()[index] - money;
			
			
		}
	//}
	
		return 0;
	}
	
	
	
	
	///////////////
	/*��Ʈ���� �ŷ� �Լ�*/
	///////////////
	
	public int Buy_bit(long Cost, long Count) //��Ʈ���� ���� ���ݰ� ���� �Է�
	{
		
		if(Cost*Count > super.Get_own()) {
			
			//�ŷ��� �� ����
			
			return -1;
		}
		
		
		super.Put_own(super.Get_own() - Cost*Count);			//�����ڻ꿡�� ���� ��ŭ ����
		super.Put_bit(super.Get_bit() + Count);					//��Ʈ���� �߰�
		
		
		
		
		return 0;
	}
	
	
	public int Sell_bit(long Cost, long Count)	//��Ʈ���� ���� ���ݰ� ���� �Է�
	{
		if(Count > super.Get_bit()) {
			//�� �� ����.
			return -1;
		}
		
		super.Put_own(super.Get_own() + Cost*Count);
		super.Put_bit(super.Get_bit() - Count);
		
		
		return 0;
	}
	
	
	

}
