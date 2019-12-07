package bitcoin;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/*신용등급 만점을 임시로 1000점으로 규정 
 * 1000~700점 1급
 * 699~400 2급
 * 399~100 3급
 * 99~0 4급   (신용 불량자 돈을 빌릴 수 없음)
 * */

public class UserData {
   
private int credit= 0;      //신용 등급
private long own= 0;      //보유 자산
private double bit= 0;      //비트코인 개수
private int building[] = {0,0,0,0,0,0};   //대출 건물
private long Build_Due_Date[] = {0,0,0,0,0,0};//담보 대출 상환일
private long Loan_limit[][] = {{1,2,3,0},{1,2,3,0},{1,2,3,0}};         //한도 [금융][신용 등급]
private long Due_Date[] = {0,0,0};      //상환일*100000000 + 빌린날      YYYYMMDD형식으로 저장 및 사용
private int Loan[] = {0,0,0,0};            //대출 종류      -> 3개까지 대출 가능하도록 코드를 작성 하도록 한다.
private long borrow[] = {0,0,0};      //대출 
private    float inter[] = {0,0,0};         //이자 대출과 같은 인덱스에 삽입하여야만 한다.

//////////////////시간 변수들//////////////////
private SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");      //시간 포맷
private Calendar cmp;         //초기 시간 저장
private Calendar time;         //게임내 시간 저장


public void Set_time() {            //게임내 시간 초기화
   cmp = Calendar.getInstance();
   time =cmp;
   
}
public void Timer() {
   
}


public UserData()
{
   this.credit = 2;
  }
public UserData(int credit, long own, long bit, int building[], long borrow[]) {      //생성자
   this.credit = credit;
   this.bit = bit;
   this.building = building;
   this.borrow = borrow;
}
public void Set_Data(int credit, long own, long bit) {
   this.credit = credit;
   this.bit = bit;
   this.own = own;
}

//데이터 호출 함수
public int Get_credit() {   //신용등급 호출
   return this.credit;
}
public long Get_own() {   //보유자산 호출
   return this.own;
}
public double Get_bit() {   //비트코인 개수 호출
   return this.bit;
}
public int[] Get_building(){//보유 빌딩수 호출
   return this.building;
}
public  long[] Get_borrow() {//대출 현황 호출
   return this.borrow;
}


public float[] Get_inter() {//이자 호출
   return this.inter;
}

public long[] Get_Due_Date() {//상환일 호출
   return this.Due_Date;
}
public long[][] Get_Loan_limit(){
   return this.Loan_limit;
}
public int[] Get_Loan() {
   return this.Loan;
}

// 삽입 함수
public void Put_credit(int credit) {   //신용 등급 삽입
   this.credit += credit;
}

public void Put_own(long own) {      //보유자산 삽입
   this.own += own;
}

public void Put_bit(double bit) {      //비트코인 개수 삽입
   this.bit += bit;
   
}

public int Put_building(int building) {   
   int i =0;
   while(this.building[i]!=0) {
      i++;
      if(i==6)
         return -1;
   }
   this.building[i] += building;
   return i;
}
public int Put_buid_due_date(long due_date,int index) {
   this.Build_Due_Date[index] +=due_date;
   return 0;
}

public void Put_Due_Date(long due_date,int index) {
   this.Due_Date[index] += due_date;
}

public void Put_inter(float inter, int index) {
   this.inter[index] = inter;
}

public void Put_borrow(long borrow, int index) {   //인덱스에 대출금 삽입시 사용
   this.borrow[index] += borrow;
   
}
public void Put_borrow(long borrow,int index,int[] Loan) {      //대출 현황 삽입
   this.borrow[index] += borrow;
               //이율 삽입
   this.Loan = Loan;
}
public void Put_loan(int index) {
   this.Loan[index] =1;
}



public void Set_own(long own) {
	this.own = own;
}
public void Set_bit(double bit) {
	this.bit = bit;
}



//감소 삭제 함수
public int Dec_credit(int dec_credit) {      //신용등급 감소함수
   this.credit -= dec_credit;
   return this.credit;
}
public long Dec_own(long dec_own) {         //보유 금액 감소
   this.own -=dec_own;   
   return this.own;
}
public double Dec_bit(double dec_bit) {         //비트코인 감소
   this.bit -= dec_bit;
   return this.bit;
}
public long Dec_build(long dec_build,int index) {//담보 대출액 감소 거스름돈 출력
   long change =0;
   
   this.building[index] -=dec_build;
   
   if(this.building[index]<0) {         //음수가 되면 거스름돈을 저장하고 0으로 바꾸어준다.
      change = this.building[index];
      this.building[index] = 0;
   }
   
   return change;
}
public long Dec_borrow(long dec_borrow, int index) {   //빚 감소 거스름돈 출력
   long change =0;
   this.borrow[index] -=dec_borrow;
   
   if(this.borrow[index]<0) {         //음수면 거스름돈을 저장하고 0으로 바꿈
   change = this.borrow[index];
   this.borrow[index] =0;
   }
   
   
   return change;            //거스름돈 삽입
}
public float Del_inter(int index) {         //이자 제거
   this.inter[index] = 0;
   return this.inter[index];
}
public long Del_due_date(int index) {
   this.Due_Date[index] =0;
   return this.Due_Date[index];
}

}
