package bitcoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Save {
	private File file = new File("./save.txt");				//save ������ ��ġ
	private FileWriter file_writer;
	
	/////////������ ������////////
	private Trade userdata;
	long loan_ex;
	long loan_ex1[];
	long loan_ex2[];
	int su_loan[];
	int d_day;
	int building[];
	
	int ex =0;
	//�ʾ� ���� �Ѿ� ���� ���Ҵ��� Ȯ�� ���� ����
	public Save() {
		
	}
	
	public boolean spaceCheck(String spaceCheck)
	{	if(spaceCheck == null)
		return false;
		if(spaceCheck.compareTo("") ==0)
			return true;
	    for(int i = 0 ; i < spaceCheck.length() ; i++)
	    {	
	        if(spaceCheck.charAt(i) == ' ')
	            return true;
	    }
	    return false;
	}
	
	public int Check_id(String id) {				//id�� �Է� ������ id �����ϴ��� Ȯ��
		if(id == null)
			return -1;
		if(spaceCheck(id))
			return -1;								//����
		String ex ="./";
		ex +=id;
		ex +=".txt";
		File ID = new File(ex);
		if(!ID.exists())		//���� ���� �ʴ´ٸ� 0
			return 0;
		
		
		return 1;				//�����ϸ� 1
	}
	
	
	public int register_id(String id, String passwd) {			//�Է� ���� id�� ����
		if(id==null || passwd ==null)
			return -2;
		

		///////check id�ؼ� �ߺ� üũ		�ߺ� �Ǵ� ��쿡�� -1 ����
		if(Check_id(id)==1)
			return -1;
		if(spaceCheck(passwd))
			return -1;
		if(Check_id(id)==-1)
			return -2;
		
		///////������ ���� ����
		String ex ="./";
		ex +=id;
		ex +=".txt";
		File register = new File(ex);
		
		try {
			register.createNewFile();		//����
			file_writer = new FileWriter(register,false);
			file_writer.write(passwd+" 0");				//0�� �־ �ڿ� ���� ������ ��Ÿ��
			file_writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int login_check(String id, String passwd) {
		if(id ==null || passwd == null)
			return -2;
		
		///////check id �ؼ� �����ϴ��� Ȯ��	�������� ������ -1 ����
		if(Check_id(id)==0)
			return -1;
		if(Check_id(id)==-1)		//���� -2 ����
			return -2;
		
		///////�����ϸ� ������ �о passwd Ȯ��
		int level =0;
		File check;
		String buffer = "";
		String buffer2 = "";
		String ex = "./";
		ex += id;
		ex += ".txt";
		check = new File(ex);
		
		try {
			BufferedReader infiles = new BufferedReader(new InputStreamReader(new FileInputStream(check.getAbsolutePath()), "UTF8"));
			
			while((buffer = infiles.readLine())!= null) {
				buffer2 += buffer;

			}
			
			infiles.close();
			StringTokenizer tokens = new StringTokenizer(buffer2);
			
			if(passwd.compareTo(tokens.nextToken(" "))!=0 )							//��� ��ȣ�� ��ġ ���� �ʴ´ٸ� -2 ����
				return -2;
			level = Integer.parseInt(tokens.nextToken(" "));				// level
			if(level == 0) {
				return 9;
			}
		}
		catch (Exception e) {
            e.getStackTrace();
            System.out.println("error");
            return -1;
            }
		return 0;
	}
	
	public int login_id(String id, String passwd,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//���� ���
		
		if(id ==null || passwd == null)
			return -2;
		
		///////check id �ؼ� �����ϴ��� Ȯ��	�������� ������ -1 ����
		if(Check_id(id)==0)
			return -1;
		if(Check_id(id)==-1)		//���� -2 ����
			return -2;
		
		///////�����ϸ� ������ �о passwd Ȯ��
		int level =0;
		File check;
		String buffer = "";
		String buffer2 = "";
		String ex = "./";
		ex += id;
		ex += ".txt";
		check = new File(ex);
		
		try {
			BufferedReader infiles = new BufferedReader(new InputStreamReader(new FileInputStream(check.getAbsolutePath()), "UTF8"));
			
			while((buffer = infiles.readLine())!= null) {
				buffer2 += buffer;

			}
			
			infiles.close();
			StringTokenizer tokens = new StringTokenizer(buffer2);
			
			if(passwd.compareTo(tokens.nextToken(" "))!=0 )							//��� ��ȣ�� ��ġ ���� �ʴ´ٸ� -2 ����
				return -2;
			System.out.print("cc");
		
			level = Integer.parseInt(tokens.nextToken(" "));				// level
			if(level == 0) {												// level =0 �� �ε��� �����Ͱ� ������ 9�� ������
				return 9;
			}
			userdata.Set_own(Long.parseLong(tokens.nextToken(" ")));			//��
			userdata.Set_bit(Double.parseDouble(tokens.nextToken(" ")));			//��Ʈ����
			StartPage.loan_ex = Long.parseLong(tokens.nextToken(" "));			
			
			for(int i =0; i< loan_ex1.length;i++) {		
				if(i!=loan_ex1.length-1) {
					
				loan_ex1[i] = Long.parseLong(tokens.nextToken(" "));
				
				}
				else
					loan_ex1[i] = Long.parseLong(tokens.nextToken(" "));
			}
		
			for(int i=0; i<loan_ex2.length; i++) {
				if(i!=loan_ex2.length-1)
				loan_ex2[i] = Long.parseLong(tokens.nextToken(" "));
				else
					loan_ex2[i] = Long.parseLong(tokens.nextToken(" "));
			}
			
			for(int i=0; i< su_loan.length; i++) {
				if(i!=su_loan.length -1)
				su_loan[i] = Integer.parseInt(tokens.nextToken(" "));
				else
					su_loan[i] = Integer.parseInt(tokens.nextToken(" "));
			}
			StartPage.d_day = Integer.parseInt(tokens.nextToken(" "));
			for(int i =0; i< building.length; i++) {
				if(i!=building.length-1)
				building[i] = Integer.parseInt(tokens.nextToken(" "));
				else
					building[i] = Integer.parseInt(tokens.nextToken(" "));
			}
			
			System.out.println("load complete");
			
		}
		catch (Exception e) {
            e.getStackTrace();
            System.out.println("error");
            return -1;
	}
		/////// ����ġ�� -2 ����
		/////// ��ġ�Ұ�쿡�� ���� ����                                                                                                                                                                                                                                                                                       
		
		return level;
	}
	
	
	
	
	
	
	public void Save_Data(String id, String passwd,int level,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//save �Լ�
		String buffer  = "";
		String ex ="./";
		try {
				ex +=id;
				ex +=".txt";
				File log = new File(ex);
				file_writer = new FileWriter(log,false);		//���� ������ ���� �ϰ� �ٽþ�
				buffer += passwd;
				buffer += " "; 
				buffer += Integer.toString(level);			//����
				buffer += " "; 
				buffer += Long.toString(userdata.Get_own());
				buffer += " "; 
				buffer += Double.toString(userdata.Get_bit());
				buffer += " ";
				buffer += Long.toString(loan_ex);
				buffer += " ";
				for(int i = 0;i< loan_ex1.length;i++) {
					buffer += Long.toString(loan_ex1[i]);
					buffer += " ";
				}
				buffer += " ";
				for(int i =0;i<loan_ex2.length; i++) {
					buffer += Long.toString(loan_ex2[i]);
					buffer += " ";
				}
				buffer += " ";
				for(int i = 0; i<su_loan.length;i++) {
					buffer+= Integer.toString(su_loan[i]);
					buffer += " ";
				}
				buffer += " ";
				buffer += Integer.toString(d_day);
				buffer += " ";
				for(int i=0; i<building.length; i++) {
					buffer += Integer.toString(building[i]);
					buffer += " ";
				}
				file_writer.write(buffer);
				
				file_writer.flush();
				System.out.print("Save success");			//���̺� ����
		}
		catch (Exception e) {
            e.getStackTrace();
	}
		

	}
		
	public void Save_Data(int level,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//save �Լ�
			String buffer;
			try {
						
					file_writer = new FileWriter(file,false);		//���� ������ ���� �ϰ� �ٽþ�
					buffer = Integer.toString(level);			//����
					buffer += " "; 
					buffer += Long.toString(userdata.Get_own());
					buffer += " "; 
					buffer += Double.toString(userdata.Get_bit());
					buffer += " ";
					buffer += Long.toString(loan_ex);
					buffer += " ";
					for(int i = 0;i< loan_ex1.length;i++) {
						buffer += Long.toString(loan_ex1[i]);
						buffer += " ";
					}
					buffer += " ";
					for(int i =0;i<loan_ex2.length; i++) {
						buffer += Long.toString(loan_ex2[i]);
						buffer += " ";
					}
					buffer += " ";
					for(int i = 0; i<su_loan.length;i++) {
						buffer+= Integer.toString(su_loan[i]);
						buffer += " ";
					}
					buffer += " ";
					buffer += Integer.toString(d_day);
					buffer += " ";
					for(int i=0; i<building.length; i++) {
						buffer += Integer.toString(building[i]);
						buffer += " ";
					}
					file_writer.write(buffer);
					
					file_writer.flush();
					System.out.print("Save success");			//���̺� ����
			}
			catch (Exception e) {
	            e.getStackTrace();
		}
			
	
		}
	
	
	
	
	
		//���� ���
		public int Load(Trade userdata, long loan_ex1[],long loan_ex2[], int su_loan[], int building[]) {		//load �Լ� static data�µ��� (loan_ex , d_day
			
			String ex = "";
			
			String buffer = "";
			int level = 0;
			try {
				BufferedReader infiles = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF8"));
			
				while((buffer = infiles.readLine())!= null) {
					ex += buffer;

				}
				
				System.out.print(ex);
				
				infiles.close();

				///////��ū �и�/////
				StringTokenizer tokens = new StringTokenizer(ex);
				level = Integer.parseInt(tokens.nextToken(" "));				// level
				userdata.Set_own(Long.parseLong(tokens.nextToken(" ")));			//��
				userdata.Set_bit(Double.parseDouble(tokens.nextToken(" ")));			//��Ʈ����
				StartPage.loan_ex = Long.parseLong(tokens.nextToken(" "));			//
				
				for(int i =0; i< loan_ex1.length;i++) {		
					if(i!=loan_ex1.length-1) {
						
					loan_ex1[i] = Long.parseLong(tokens.nextToken(" "));
					
					}
					else
						loan_ex1[i] = Long.parseLong(tokens.nextToken(" "));
				}
			
				for(int i=0; i<loan_ex2.length; i++) {
					if(i!=loan_ex2.length-1)
					loan_ex2[i] = Long.parseLong(tokens.nextToken(" "));
					else
						loan_ex2[i] = Long.parseLong(tokens.nextToken(" "));
				}
				
				for(int i=0; i< su_loan.length; i++) {
					if(i!=su_loan.length -1)
					su_loan[i] = Integer.parseInt(tokens.nextToken(" "));
					else
						su_loan[i] = Integer.parseInt(tokens.nextToken(" "));
				}
				StartPage.d_day = Integer.parseInt(tokens.nextToken(" "));
				for(int i =0; i< building.length; i++) {
					if(i!=building.length-1)
					building[i] = Integer.parseInt(tokens.nextToken(" "));
					else
						building[i] = Integer.parseInt(tokens.nextToken(" "));
				}
				
				System.out.println("load complete");
			}
			catch (Exception e) {
				e.getStackTrace();
				
				System.out.print("error");
			}

				return level;
		}
			
}
