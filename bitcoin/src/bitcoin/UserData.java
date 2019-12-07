package bitcoin;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/*�ſ��� ������ �ӽ÷� 1000������ ���� 
 * 1000~700�� 1��
 * 699~400 2��
 * 399~100 3��
 * 99~0 4��   (�ſ� �ҷ��� ���� ���� �� ����)
 * */

public class UserData {
   
private int credit= 0;      //�ſ� ���
private long own= 0;      //���� �ڻ�
private double bit= 0;      //��Ʈ���� ����
private int building[] = {0,0,0,0,0,0};   //���� �ǹ�
private long Build_Due_Date[] = {0,0,0,0,0,0};//�㺸 ���� ��ȯ��
private long Loan_limit[][] = {{1,2,3,0},{1,2,3,0},{1,2,3,0}};         //�ѵ� [����][�ſ� ���]
private long Due_Date[] = {0,0,0};      //��ȯ��*100000000 + ������      YYYYMMDD�������� ���� �� ���
private int Loan[] = {0,0,0,0};            //���� ����      -> 3������ ���� �����ϵ��� �ڵ带 �ۼ� �ϵ��� �Ѵ�.
private long borrow[] = {0,0,0};      //���� 
private    float inter[] = {0,0,0};         //���� ����� ���� �ε����� �����Ͽ��߸� �Ѵ�.

//////////////////�ð� ������//////////////////
private SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");      //�ð� ����
private Calendar cmp;         //�ʱ� �ð� ����
private Calendar time;         //���ӳ� �ð� ����


public void Set_time() {            //���ӳ� �ð� �ʱ�ȭ
   cmp = Calendar.getInstance();
   time =cmp;
   
}
public void Timer() {
   
}


public UserData()
{
   this.credit = 2;
  }
public UserData(int credit, long own, long bit, int building[], long borrow[]) {      //������
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

//������ ȣ�� �Լ�
public int Get_credit() {   //�ſ��� ȣ��
   return this.credit;
}
public long Get_own() {   //�����ڻ� ȣ��
   return this.own;
}
public double Get_bit() {   //��Ʈ���� ���� ȣ��
   return this.bit;
}
public int[] Get_building(){//���� ������ ȣ��
   return this.building;
}
public  long[] Get_borrow() {//���� ��Ȳ ȣ��
   return this.borrow;
}


public float[] Get_inter() {//���� ȣ��
   return this.inter;
}

public long[] Get_Due_Date() {//��ȯ�� ȣ��
   return this.Due_Date;
}
public long[][] Get_Loan_limit(){
   return this.Loan_limit;
}
public int[] Get_Loan() {
   return this.Loan;
}

// ���� �Լ�
public void Put_credit(int credit) {   //�ſ� ��� ����
   this.credit += credit;
}

public void Put_own(long own) {      //�����ڻ� ����
   this.own += own;
}

public void Put_bit(double bit) {      //��Ʈ���� ���� ����
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

public void Put_borrow(long borrow, int index) {   //�ε����� ����� ���Խ� ���
   this.borrow[index] += borrow;
   
}
public void Put_borrow(long borrow,int index,int[] Loan) {      //���� ��Ȳ ����
   this.borrow[index] += borrow;
               //���� ����
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



//���� ���� �Լ�
public int Dec_credit(int dec_credit) {      //�ſ��� �����Լ�
   this.credit -= dec_credit;
   return this.credit;
}
public long Dec_own(long dec_own) {         //���� �ݾ� ����
   this.own -=dec_own;   
   return this.own;
}
public double Dec_bit(double dec_bit) {         //��Ʈ���� ����
   this.bit -= dec_bit;
   return this.bit;
}
public long Dec_build(long dec_build,int index) {//�㺸 ����� ���� �Ž����� ���
   long change =0;
   
   this.building[index] -=dec_build;
   
   if(this.building[index]<0) {         //������ �Ǹ� �Ž������� �����ϰ� 0���� �ٲپ��ش�.
      change = this.building[index];
      this.building[index] = 0;
   }
   
   return change;
}
public long Dec_borrow(long dec_borrow, int index) {   //�� ���� �Ž����� ���
   long change =0;
   this.borrow[index] -=dec_borrow;
   
   if(this.borrow[index]<0) {         //������ �Ž������� �����ϰ� 0���� �ٲ�
   change = this.borrow[index];
   this.borrow[index] =0;
   }
   
   
   return change;            //�Ž����� ����
}
public float Del_inter(int index) {         //���� ����
   this.inter[index] = 0;
   return this.inter[index];
}
public long Del_due_date(int index) {
   this.Due_Date[index] =0;
   return this.Due_Date[index];
}

}
