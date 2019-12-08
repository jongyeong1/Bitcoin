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
	private File file = new File("./save.txt");				//save 데이터 위치
	private FileWriter file_writer;
	
	/////////저장할 변수들////////
	private Trade userdata;
	long loan_ex;
	long loan_ex1[];
	long loan_ex2[];
	int su_loan[];
	int d_day;
	int building[];
	
	int ex =0;
	//초액 이자 총액 이율 갚았는지 확인 디데이 빌딩
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
	
	public int Check_id(String id) {				//id를 입력 받으면 id 존재하는지 확인
		if(id == null)
			return -1;
		if(spaceCheck(id))
			return -1;								//공백
		String ex ="./";
		ex +=id;
		ex +=".txt";
		File ID = new File(ex);
		if(!ID.exists())		//존재 하지 않는다면 0
			return 0;
		
		
		return 1;				//존재하면 1
	}
	
	
	public int register_id(String id, String passwd) {			//입력 받은 id로 생성
		if(id==null || passwd ==null)
			return -2;
		

		///////check id해서 중복 체크		중복 되는 경우에는 -1 리턴
		if(Check_id(id)==1)
			return -1;
		if(spaceCheck(passwd))
			return -1;
		if(Check_id(id)==-1)
			return -2;
		
		///////없으면 파일 생성
		String ex ="./";
		ex +=id;
		ex +=".txt";
		File register = new File(ex);
		
		try {
			register.createNewFile();		//생성
			file_writer = new FileWriter(register,false);
			file_writer.write(passwd+" 0");				//0을 넣어서 뒤에 값이 없음을 나타냄
			file_writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int login_check(String id, String passwd) {
		if(id ==null || passwd == null)
			return -2;
		
		///////check id 해서 존재하는지 확인	존재하지 않으면 -1 리턴
		if(Check_id(id)==0)
			return -1;
		if(Check_id(id)==-1)		//공백 -2 리턴
			return -2;
		
		///////존재하면 파일을 읽어서 passwd 확인
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
			
			if(passwd.compareTo(tokens.nextToken(" "))!=0 )							//비밀 번호가 일치 하지 않는다면 -2 리턴
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
	
	public int login_id(String id, String passwd,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//레벨 출력
		
		if(id ==null || passwd == null)
			return -2;
		
		///////check id 해서 존재하는지 확인	존재하지 않으면 -1 리턴
		if(Check_id(id)==0)
			return -1;
		if(Check_id(id)==-1)		//공백 -2 리턴
			return -2;
		
		///////존재하면 파일을 읽어서 passwd 확인
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
			
			if(passwd.compareTo(tokens.nextToken(" "))!=0 )							//비밀 번호가 일치 하지 않는다면 -2 리턴
				return -2;
			System.out.print("cc");
		
			level = Integer.parseInt(tokens.nextToken(" "));				// level
			if(level == 0) {												// level =0 즉 로드할 데이터가 없으면 9를 내보냄
				return 9;
			}
			userdata.Set_own(Long.parseLong(tokens.nextToken(" ")));			//돈
			userdata.Set_bit(Double.parseDouble(tokens.nextToken(" ")));			//비트코인
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
		/////// 불일치시 -2 리턴
		/////// 일치할경우에는 레벨 리턴                                                                                                                                                                                                                                                                                       
		
		return level;
	}
	
	
	
	
	
	
	public void Save_Data(String id, String passwd,int level,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//save 함수
		String buffer  = "";
		String ex ="./";
		try {
				ex +=id;
				ex +=".txt";
				File log = new File(ex);
				file_writer = new FileWriter(log,false);		//기존 내용을 제거 하고 다시씀
				buffer += passwd;
				buffer += " "; 
				buffer += Integer.toString(level);			//레벨
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
				System.out.print("Save success");			//세이브 성공
		}
		catch (Exception e) {
            e.getStackTrace();
	}
		

	}
		
	public void Save_Data(int level,Trade userdata, long loan_ex,long loan_ex1[],long loan_ex2[], int su_loan[], int d_day, int building[]) {				//save 함수
			String buffer;
			try {
						
					file_writer = new FileWriter(file,false);		//기존 내용을 제거 하고 다시씀
					buffer = Integer.toString(level);			//레벨
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
					System.out.print("Save success");			//세이브 성공
			}
			catch (Exception e) {
	            e.getStackTrace();
		}
			
	
		}
	
	
	
	
	
		//레벨 출력
		public int Load(Trade userdata, long loan_ex1[],long loan_ex2[], int su_loan[], int building[]) {		//load 함수 static data는따로 (loan_ex , d_day
			
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

				///////토큰 분리/////
				StringTokenizer tokens = new StringTokenizer(ex);
				level = Integer.parseInt(tokens.nextToken(" "));				// level
				userdata.Set_own(Long.parseLong(tokens.nextToken(" ")));			//돈
				userdata.Set_bit(Double.parseDouble(tokens.nextToken(" ")));			//비트코인
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
