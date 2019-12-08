package bitcoin;	

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;




public class Trade extends UserData {			//Trade로 바꿀 예정
	
	/*신용 대출 한도 계산*/
	public long Check_limit(int fin) {			//금융권 입력 -> 빌릴 수 있는 신용 대출 한도 출력
		
		/*	// 신용 대출 이자 필요 없을듯
		float Inter1 = 3;  //1금융		
		float Inter2 = 5;  //2금융
		float Inter3 = 7;  //3금융
		*/
		
		if(super.Get_borrow()!= null &&super.Get_borrow().length >=3)			//현재 대출이 3개 이상일 경우에는 금지
			return -1;
		if(super.Get_credit() >=700)		//1등급
		{
			if(fin == 1) {				//1금융
				return 1000000000;	//10억
			}
			else if(fin ==2) {			//2금융
				return 1500000000;	//15억
			}
			else if (fin ==3) {			//3금융
				return 3000000000L;	//30억
			}
			else {
				//오류
			}
		}
		else if (super.Get_credit() >=400)	//2등급
		{
			if(fin == 1) {				//1금융
				return 1000000000;	//10억
			}
			else if(fin ==2) {			//2금융
				return 1500000000;	//15억
			}
			else if (fin ==3) {			//3금융
				return 3000000000L;	//30억
			}
			else {
				//오류
			}
		}
		else								//3등급
		{
			if(fin == 1) {				//1금융
				return 1000000000;	//10억
			}
			else if(fin ==2) {			//2금융
				return 1500000000;	//15억
			}
			else if (fin ==3) {			//3금융
				return 3000000000L;	//30억
			}
			else {
				//오류
			}
			
		}
		
		
		
		
		return 0;
	}
	
	
	/*상환일 미구현 차후 구현*/
	//신용 대출 내부 함수
	public void Loan_Edit(int fin,long m)					//입력 금융권과 빌릴 돈 입력
	{		//다시한번 체크하기
		/*체크 하는 파트*/
		
		long[] borrow	= super.Get_borrow();			//대출
		long[] Due_Date;				//상환일
		float[] inter;				//이자
		int[] loan;					//대출 종류 입력
		/*이전 대출 기록 대조*/
		if(super.Get_borrow() == null) {			//이전에 대출이 없는경우에는
			 borrow = new long[1];
			 Due_Date = new long[1];
			 inter = new float[1];
			 loan = new int [1];
			 
		}
		else {/*대출을 해본적이 있다면 한칸 더 크게 만들어 준다.*/
			borrow = new long[super.Get_borrow().length+1];
			 Due_Date = new long[super.Get_borrow().length+1];
			 inter = new float[super.Get_borrow().length+1];
			 loan = new int [super.Get_borrow().length+1];
			 
			 /*원래 데이터 받기*/
			 for(int i = 0;super.Get_borrow().length< i;i++) {
				 borrow[i] = super.Get_borrow()[i];
				 Due_Date[i] =super.Get_Due_Date()[i];  
				 inter[i] = super.Get_inter()[i];
				 loan[i] = super.Get_Loan()[i];
			 }
		}
		
			//입력 받은돈 빌리기 -> 신용 등급 차감 ->  돈 추가 - > 세자리 코드 생성 -> 상환일 입력
		super.Put_credit(super.Get_credit() - (fin * 50));	//예시임 이후 고칠것
		super.Put_own(super.Get_own() + m);
		
		//코드 첫자리 1 셋째자리 금융권
		loan[loan.length] = 100+fin;
		
		
	}
	
	
	
	//담보 대출 내부 함수
	public void Loan_Edit(int fin, int index, long m) {				//거래은행, 건물 번호, 돈	
		long[] borrow	= super.Get_borrow();			//대출
		long[] Due_Date;				//상환일
		float[] inter;				//이자
		int[] loan;					//대출 종류 입력
		/*이전 대출 기록 대조*/
		if(super.Get_borrow() == null) {			//이전에 대출이 없는경우에는
			 borrow = new long[1];
			 Due_Date = new long[1];
			 inter = new float[1];
			 loan = new int [1];
			 
		}
		else {/*대출을 해본적이 있다면 한칸 더 크게 만들어 준다.*/
			borrow = new long[super.Get_borrow().length+1];
			 Due_Date = new long[super.Get_borrow().length+1];
			 inter = new float[super.Get_borrow().length+1];
			 loan = new int [super.Get_borrow().length+1];
			 /*원래 데이터 받기*/
			 for(int i = 0;super.Get_borrow().length< i;i++) {
				 borrow[i] = super.Get_borrow()[i];
				 Due_Date[i] =0;  //Get Due_Date 구현하기
				 inter[i] = super.Get_inter()[i];
				 loan[i] = 0;	//Get_loan 구현하기
			 }
		}
		

		
		
		
		//입력 받은돈 빌리기 ->	신용 등급 차감 ->  돈 추가 - > 세자리 코드 생성 -> 상환일 입력
		
	
		
		super.Put_credit(super.Get_credit() - (fin * 50));	//예시임 이후 고칠것
		
		super.Put_own(super.Get_own() + m);
		
		//세자리 숫자 첫째 자리 2, + 둘째 자리 건물 인덱스 + 셋째자리 거래 은행
		loan[loan.length] = 200+(index*10)+fin;
		
		
		//상환일 입력 추가할것!!
		
	}
	
	
	
	public int Credit_Loan(int fin) {					//금융권을 입력 받고 신용 대출 가능 리턴
		long able;
		long money;
		Scanner scanner = new Scanner(System.in);
		//한도체크
		able = Check_limit(fin);
		if(able == -1.0) {
			// 안내문 출력 구현하기
			scanner.close();
			return -1;						//대출 금지시 -1 리턴
		}
		
		//등급 출력및 현재 사용 가능한 금액 출력
		// 빌릴 금액 입력
		while(true) {
		money = scanner.nextLong();		//빌릴돈 입력
		
		if(money>=1 && money <= able) {		//한도내의 돈 빌리기
			break;
		}
		else {
			//사용할 수 없다는 경고문 출력 구현할것
		}
		}
		
		scanner.close();
		Loan_Edit(fin,money);					//신용 대출 
		
		return 0;
	}
	
	public int Build_Loan(int fin,int index) {			//건물 번호 입력 담보 대출 리턴
		
		if(super.Get_borrow()!= null &&super.Get_borrow().length >=3) {
			return -1;						//대출 금지시 -1 리턴
		}
		
		Scanner scanner = new Scanner(System.in);
		long money;
		
		while(true) {
			money = scanner.nextLong();		//빌릴돈 입력
			if(money>=1 && money <= super.Get_building()[index]) {		//한도내의 돈 빌리기
				break;
			}
			else {
				//사용할 수 없다는 경고문 출력 구현할것
			}
			
		}
		
		
		Loan_Edit(fin,index,money);
		
		scanner.close();
		return 0;
	}
	
	
	////////////
	//이자 적용 함수
	////////////
	
	//이자 나중에 구현이 아직 안됨  데이트 스트링으로 변경할것
	public long Inter_cmp(long Date,long Due) {				//입력 받은 날짜 차이 계산및 출력
		//YYYYMMDD 형식 윤년 계산안함
		int tmp = (int)Due;
		Due = (long)tmp;		//소숫점 자리 날림
		
		String date = new String(Long.toString(Date));
		String due = new String(Long.toString(Due));
		 String strFormat = "yyyyMMdd";    //strStartDate 와 strEndDate 의 format
	        
	        //SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
	        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
	        try{
	            Date startDate = sdf.parse(date);
	            Date endDate = sdf.parse(due);
	 
	            //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
	            long diffDay = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
	            
	            return diffDay;					//지난날 출력
	            
	        }catch(ParseException e){		//실패 하면
	            e.printStackTrace();		//예외결과 화면 출력
	        }
	    
		return -1;
	
	}
	
	public int Inter(long Date) {					//현재 날짜 입력 받음
		//각각 코드를 받아서 존재 하면
		long cmp;		//현재 날짜와 경과일을 계산해서 임시 저장하는 변수
		
		for(int i = 0;i<super.Get_borrow().length;i++) {			//대출금들 전부다 적용
			
			cmp =Inter_cmp(Date,(super.Get_Due_Date()[i]/100000000));
			
			if(cmp>=7&&cmp%7!=0) {						//7일 차가 되면
				super.Put_own((long)(super.Get_own()-(super.Get_borrow()[i]*(super.Get_inter()[i]/100))));	//이자 부과
				// 마이너스 통장이되면 경고문 출력 할 것
			}
		}
		
		return 0;
	}
	
	
	//건물 뺐기 함수
	//신용등급 하락 미구현
	public void Take_build(int index) {				//뺐을 건물 인덱스 입력
		long[] build;	//대체할 변수
		
		if(super.Get_building().length-1 >=1) {			//보유 빌딩이 2개 이상일떄
			
		build = new long[super.Get_building().length-1];	
		
		for(int i=0;i<super.Get_building().length;i++)			//인덱스만 제외하고 기록
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
	
	//상환일 체크 함수 아직 구현 덜함!!
	public int Check_Date(long Date) {			//오늘 날짜 입력 받음
		
		for(int i =0;i<super.Get_Due_Date().length;i++) {		//상환일이 되면 ->신용도 감소 -> 압류
			if(Date >= super.Get_Due_Date()[i]/100000000) {
				
				if(super.Get_Loan()[i]/100==2) {				//건물이면
					Take_build(super.Get_Loan()[i]-200);		//건물 인덱스 넘기기
					
					//이부분에 신용도 하락 
				}
				else {
					super.Put_own(super.Get_own()-super.Get_borrow()[i]);//돈 차감
					super.Put_credit(super.Get_credit() - 10); 	//신용도 감소 임시로 10차감임
					
					//돈 뺐기 + 신용도 감소		-가 될경우 그에 상응하는 건물 압류
				}
			}
		}
		
		return 0;
	}
	
	
	//빚 갚기 함수
	public int Pay_back(int index, long money) {	// 몇번째 빚을 갑을지에 대한 정보, 갚을돈 입력
		
		if(super.Get_own()<money|| money<=0) {				//입력받은 돈이 가지고 있는돈 보다 클 경우와 갚으려는 돈이 0 이하일 경우
			//결제 못함
			return -1;
		}
		
		long[] borrow = super.Get_borrow();
		float[] inter = super.Get_inter();
		int[] Loan = super.Get_Loan();
		long[] Due_Date = super.Get_Due_Date();		
			
//if((super.Get_Loan()[index]/100)==1) {			//신용대출이면
	
	if(super.Get_borrow()[index] <= money) {	//다 갚음!!!
			money = super.Get_borrow()[index];				//갚으려고 하는 금액이 더 클 경우에는 그 금액으로 바꾸어줌 거스름돈 생각하면됨
			
		if(super.Get_borrow().length-1 !=0) {			//빚이 전부 없어진게 아니면	
				
			borrow = new long[super.Get_borrow().length-1];
			inter = new float[super.Get_borrow().length-1];
			Loan = new int[super.Get_borrow().length-1];
			Due_Date = new long[super.Get_borrow().length-1];
			
			for(int i =0;i<super.Get_borrow().length ;i++) {
				if(i == index) {		//이미 갚은 부분은 건너뜀
					i++;
					if(super.Get_borrow().length<=i) {
						break;						
					}
				}
				
				borrow[i] = super.Get_borrow()[i];		//기존에 있던 빚 정보들을 옮겨 담는다.
				inter[i] = super.Get_inter()[i];
				Loan[i] = super.Get_Loan()[i];
				Due_Date[i] = super.Get_Due_Date()[i];
			}
			
			}
		else {//빚을 전부 갚았을 때
			
			borrow =null;
			inter = null;
			Loan = null;
			Due_Date = null;
		}
		
			
		}
		
		else {			//덜 갚음 ㅠㅠ
			borrow[index] = super.Get_borrow()[index] - money;
			
			
		}
	//}
	
		return 0;
	}
	
	
	
	
	///////////////
	/*비트코인 거래 함수*/
	///////////////
	
	public int Buy_bit(long Cost, long Count) //비트코인 현재 가격과 개수 입력
	{
		
		if(Cost*Count > super.Get_own()) {
			
			//거래할 수 없음
			
			return -1;
		}
		
		
		super.Put_own(super.Get_own() - Cost*Count);			//보유자산에서 가격 만큼 차감
		super.Put_bit(super.Get_bit() + Count);					//비트코인 추가
		
		
		
		
		return 0;
	}
	
	
	public int Sell_bit(long Cost, long Count)	//비트코인 현재 가격과 개수 입력
	{
		if(Count > super.Get_bit()) {
			//팔 수 없다.
			return -1;
		}
		
		super.Put_own(super.Get_own() + Cost*Count);
		super.Put_bit(super.Get_bit() - Count);
		
		
		return 0;
	}
	
	
	

}
