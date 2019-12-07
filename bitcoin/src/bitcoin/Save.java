package bitcoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	public Save(Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[] ) {					//������
		this.userdata = userdata;				//���� �ڻ�� ��Ʈ��������
		this.loan_ex = loan_ex;					
		this.loan_ex1 = loan_ex1;
		this.loan_ex2 = loan_ex2;
		this.su_loan = su_loan;
		this.d_day = d_day;
		this.building = building;
	}
	
	public Save() {
		
	}
	
	public void Save_Data() {				//save �Լ�
			String buffer;
			try {
						
					file_writer = new FileWriter(file,false);		//���� ������ ���� �ϰ� �ٽþ�
					buffer = Long.toString(userdata.Get_own());
					buffer += " "; 
					buffer += Double.toString(userdata.Get_bit());
					buffer += " ";
					buffer += Long.toString(loan_ex);
					buffer += " ";
					for(int i = 0;i< loan_ex1.length;i++) {
						buffer += Long.toString(loan_ex1[i]);
					}
					buffer += " ";
					for(int i =0;i<loan_ex2.length; i++) {
						buffer += Long.toString(loan_ex2[i]);
					}
					buffer += " ";
					for(int i = 0; i<su_loan.length;i++) {
						buffer+= Integer.toString(su_loan[i]);
					}
					buffer += " ";
					buffer += Integer.toString(d_day);
					buffer += " ";
					for(int i=0; i<building.length; i++) {
						buffer += Integer.toString(building[i]);
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
