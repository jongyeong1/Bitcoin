package bitcoin;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.jfree.ui.RefineryUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import java.awt.SystemColor;

/*
 * �ʿ��Ѱ�
 * ���ο� �ڷᱸ�� - userdata�� �ѵ� �迭 �ʿ� loan�̶� ���� ����
 * ���� �ڷᱸ�� ���� - userdata�� �ִ� �迭�� ���� ���� ���� ������pop
 * �� �������°� ���� �ֱ���
 */

public class StartPage {

	private JFrame frame;
	private JFrame f;
	
	private int level;			//����
	
	private boolean homeset;
	private  String buy_label;
	private boolean buy_set;
	private String money_label;
	private String bit_label;
	private String loan_label; 
	private String home_set1;  // ������ ���� - �� �������̴� ǥ���ϴ� ��Ʈ����
	private String home_set2;  // ������ ����
	private String home_set3;  // ������ ����
	private String home_set4;  // ������ ����
	private String home_set5;  // ������ ����
	private String home_set6;  // ������ ����
	private boolean home_set11;
	private boolean home_set12;
	private boolean home_set13;
	private boolean home_set14;
	private boolean home_set15;
	private boolean home_set16; 
	private long price;
	
	
	// ���� ���� 
	private String text1; 
	private String loanb_label;
	private String loan_text1;
	private String loan_text2; 
	private String loan_text3; 
	private String loan_text4; 
	private String loan_text5; 
	private String loan_text6; 
	private String loan_text7; 
	private String loan_text8; 
	private String loan_text11;
	private String loan_text12; 
	private String loan_text13; 
	private String loan_text14; 
	private String loan_text15; 
	private String loan_text16; 
	private String loan_text17; 
	private String loan_text18; 
	private String loan_text111;
	private String loan_text21; 
	private String loan_text31; 
	private String loan_text41; 
	private String loan_text51; 
	private String loan_text61; 
	private String loan_text71; 
	private String loan_text81; 
	static public long loan_ex; // ������ ���� - �Ѿ��� ��		���� �ٲ�
	private long loan_ex1[]= {0,0,0}; // ������ ���� - ����
	private long loan_ex2[]= {0,0,0}; // ������ ����- �Ѿ�
	private long loan_ex3[]= {0,0,0}; // ������ ����- ����
	private int su_loan[]= {0,0,0}; // ������ ���� - �ٰ������� Ȯ��
	static public int d_day;// ������ ���� - ��ȯ��
	private long day;
	private static int ending;
	private int is;
	private long Value_of_building[] = {6000,32000,105000,809000,91302000,328000000000L};		//�ǹ� �� ����
	private Ending end_c;
	private int low_level;
	
	private String id;			//id����
	private String passwd;		//�н����� ����
	//public Time1 tttt;
	
	
	//
	public int building[] = {0,0,0,0,0,0};//������ ����
	
	public final static String newline = "\n";
	 static  public JTextArea textArealeft;               //��Ʈ���� �ü�â
	    protected JTextArea textArearight;            //��Ʈ���� �ŷ� �� ����â
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private String text_name;
    
    private JTextField BuyText;
    private JTextField SellText;
    static  public JTextArea textAreaForLeft;
    private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.frame.setVisible(true);
				
			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	

		
		frame = new JFrame();
		frame.setTitle("��Ʈ���� ����");  
		frame.setBounds(100, 100, 780, 480);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		f = new JFrame();
		f.setLocation(100,100);
		f.setSize(780,480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(false);
		
		final Chart chart = new Chart("Dynamic Line And TimeSeries Chart");    //��Ʈ �����ϱ�-
		
	      chart.pack();
	      RefineryUtilities.centerFrameOnScreen(chart);//-��Ʈ �����ϱ�
	      JButton ShowChart = new JButton("��Ʈ ����");   //��Ʈ ���� ��ư
	      ShowChart.setBounds(32, 21, 258, 67);

		Trade userdata = new Trade();
		Save save = new Save();					//����
		//tttt=new Time1(userdata);
		//timer1 = new Time(userdata);
		//��ư �� �� ����κ� ����2
		DecimalFormat momo = new DecimalFormat("###,###,###,###,###,###");
		day=0;
		JButton btnNewButton_15 = new JButton(home_set1);
		JButton btnNewButton_5 = new JButton(home_set2);
		JButton btnNewButton_115 = new JButton(home_set3);
		JButton btnNewButton_1115 = new JButton(home_set4);
		JButton btnNewButton_11115 = new JButton(home_set5);
		JButton btnNewButton_111115 = new JButton(home_set6);
		JPanel GamePage_state = new JPanel();
		JPanel GamePage_loan = new JPanel();
		JPanel GamePage_change = new JPanel();
		JPanel ToolBar = new JPanel();
		JButton btnNewButton_2 = new JButton(loan_text1);
		JLabel lblNewLabel_3 = new JLabel(loan_text2);
		JLabel label_12 = new JLabel(loan_text3);
		JLabel label_13 = new JLabel(loan_text4);
		JLabel label_14 = new JLabel(loan_text5);
		JLabel lblNewLabel_5 = new JLabel(loan_text6);
		JLabel lblNewLabel_7 = new JLabel(loan_text7);
		JLabel label_16 = new JLabel(momo.format(loan_ex1[0]));
		JLabel label_18 = new JLabel(momo.format(loan_ex2[0]));
		JLabel label_20 = new JLabel(loan_text8);
		JButton button_2 = new JButton(loan_text11);
		JLabel label_2 = new JLabel(loan_text12);
			JLabel label_3 = new JLabel(loan_text13);
		JLabel label_4 = new JLabel(loan_text14);
		JLabel label_5 = new JLabel(loan_text15);
		JLabel label_7 = new JLabel(loan_text16);
		JLabel label_23 = new JLabel(loan_text17);
		JLabel label_25 = new JLabel(momo.format(loan_ex1[2]));
		JLabel label_27 = new JLabel(momo.format(loan_ex2[2]));
		JLabel label_28 = new JLabel(loan_text18);
		JButton button_3 = new JButton(loan_text111);
		JLabel label_30 = new JLabel(loan_text21);
		JLabel label_31 = new JLabel(loan_text31);
		JLabel label_32 = new JLabel(loan_text41);
		JLabel label_33 = new JLabel(loan_text51);
		JLabel label_35 = new JLabel(loan_text61);
		JLabel label_37 = new JLabel(loan_text71);
		JLabel label_39 = new JLabel(momo.format(loan_ex1[1]));
		JLabel label_41 = new JLabel(momo.format(loan_ex2[1]));
		JLabel label_42 = new JLabel(loan_text81);
		JButton change = new JButton("\uAC70\uB798");
		 GamePage_change.add(ShowChart);
		 JPanel levelpanel = new JPanel();
		 JLabel TextLabel = new JLabel("ü�� ���");      //����â ��
	      TextLabel.setBounds(127, 98, 98, 43);
	      GamePage_change.add(TextLabel);
	      
	      JTextArea textAreaForLeft = new JTextArea();  //ȣ��â ����
	      textAreaForLeft.setBounds(1, 1, 226, 251);
	      GamePage_change.add(textAreaForLeft);
	      
	      JTextArea textAreaForRight = new JTextArea(); //����â ����
	      textAreaForRight.setBounds(1, 1, 354, 251);
	      GamePage_change.add(textAreaForRight);
	      
	      JScrollPane scrollBarForLeft = new JScrollPane(textAreaForLeft);        //�ؽ�Ʈ�ʵ� ��ũ��
	      scrollBarForLeft.setBounds(50, 131, 228, 253);
	      scrollBarForLeft.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      
	      JScrollPane scrollBarForRight = new JScrollPane(textAreaForRight);
	      scrollBarForRight.setBounds(420, 20, 245, 68);
	      scrollBarForRight.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	      scrollBarForLeft.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	      textAreaForLeft.setLineWrap(true);  
	      GamePage_change.add(scrollBarForLeft);
	      
	      scrollBarForRight.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	      textAreaForRight.setLineWrap(true);  
	      GamePage_change.add(scrollBarForRight);                       //�ؽ�Ʈ�ʵ� ��ũ��
	      
	      JPanel SellPanel = new JPanel();              //�ŵ�â
	      SellPanel.setBackground(Color.LIGHT_GRAY);
	      SellPanel.setBounds(400, 157, 290, 199);
	      GamePage_change.add(SellPanel);
	      SellPanel.setLayout(null);
	      
	      JPanel BuyPanel = new JPanel();               //�ż�â
	      BuyPanel.setBounds(400, 157, 290, 199);
	      GamePage_change.add(BuyPanel);
	      BuyPanel.setBackground(Color.LIGHT_GRAY);
	      BuyPanel.setLayout(null);
	      
	      JButton SellButton = new JButton("�ŵ��ϱ�");   //�ŵ��ϱ� ��ư �׼�
	      SellButton.setBounds(573, 118, 91, 23);
	      GamePage_change.add(SellButton);           
	      
	      JButton BuyButton = new JButton("�ż��ϱ�"); //�ż��ϱ� ��ư �׼�
	      BuyButton.setBounds(426, 118, 91, 23);
	        GamePage_change.add(BuyButton);
	         
	      JButton BitSellBut = new JButton("�ŵ�");      
	      BitSellBut.setBounds(168, 64, 91, 23);
	      SellPanel.add(BitSellBut);
	         
	      JButton SellAllBut = new JButton("���� �ŵ��ϱ�");
	      SellAllBut.setBounds(87, 131, 129, 30);
	      SellPanel.add(SellAllBut);
	      
	      JLabel BitSellLabel = new JLabel("Bit");
	      BitSellLabel.setBounds(137, 68, 96, 15);
	      SellPanel.add(BitSellLabel);
	      
	      SellText = new JTextField();         //�ŵ� â�� �ŵ����� �ؽ�Ʈâ(�ŵ� �Է�â)
	      SellText.setBounds(29, 65, 96, 21);
	      SellPanel.add(SellText);
	      SellText.setText("1");
	      SellText.setColumns(10);
	            
	      JLabel righttextlabel = new JLabel("�ֱ� �ŷ�");  //�ֱ� �ŷ�â �� ��
	      righttextlabel.setBounds(420, 5, 67, 15);
	      GamePage_change.add(righttextlabel);            
	                  
	      BuyText = new JTextField();  //�ż� â�� �ż� ���� �ؽ�Ʈâ(�ż� �Է�â)
	      BuyText.setText("1");
	      BuyText.setBounds(29, 65, 96, 21);
	      BuyPanel.add(BuyText);
	      BuyText.setColumns(10);
	                  
	      JButton BuyAllBut = new JButton("���� �ż��ϱ�");
	      BuyAllBut.setBounds(87, 131, 129, 30);
	      BuyPanel.add(BuyAllBut);
	            
	      JButton BitBuyBut = new JButton("�ż�");
	      BitBuyBut.setBounds(168, 64, 91, 23);
	      BuyPanel.add(BitBuyBut);
	                  
	      JLabel BitBuyLabel = new JLabel("Bit");
	      BitBuyLabel.setBounds(137, 68, 96, 15);
	      BuyPanel.add(BitBuyLabel);
	      
	      SellPanel.setVisible(false);
	      GamePage_change.setVisible(false);
	      BuyButton.addActionListener(new ActionListener() {        //�ż� �ϱ� â �̵� �׼�
	          public void actionPerformed(ActionEvent e) {
	             SellPanel.setVisible(false);
	             BuyPanel.setVisible(true);

	          }
	       });
	       SellButton.addActionListener(new ActionListener() {       //�ŵ� �ϱ� â �̵� �׼�
	          public void actionPerformed(ActionEvent e) {
	             SellPanel.setVisible(true);
	             BuyPanel.setVisible(false);

	          }
	       });
	       ShowChart.addActionListener(new ActionListener() {        //��Ʈ ���� ��ư �׼�
	          public void actionPerformed(ActionEvent e) {      
	             chart.setVisible(true);            
	          }
	       });
	       BitSellBut.addActionListener(new ActionListener() {       //�ؽ�Ʈ �޾ƿ� ��ŭ �ż��ϱ� ��ư �׼�
	          public void actionPerformed(ActionEvent e) {
	             
	             
	             
	             
	             if(SellText.getText()!=null)
	             {
	                if(Double.parseDouble(SellText.getText())>0){
	                String BitSell= "";
	                double BitSellLo=0;
	                BitSell=BuyText.getText();
	                BitSellLo=Double.parseDouble(BitSell);
	                System.out.println(chart.lastValue);

	                //demo.lastValue
	                
	                if(userdata.Get_bit()>=Double.parseDouble(SellText.getText()))
	                {


	                   userdata.Put_bit(-Double.parseDouble(SellText.getText()));
	                   userdata.Put_own(Long.parseLong(SellText.getText())*(long)chart.lastValue*10000);
	                   

	                   textAreaForRight.append("�ŵ�"+Double.parseDouble(SellText.getText())+"�� ����" + newline);
	                   textAreaForRight.append("�ŵ� �� �ں�"+userdata.Get_own() +"��"+ newline);
	                   textAreaForRight.append("�ŵ� �� ��Ʈ����"+userdata.Get_bit() + newline);

	                }
	                else
	                {
	                   textAreaForRight.append("�ŵ� ����-��Ʈ���� ����"+ newline+ newline+ newline);


	                }
	                }
	             
	             
	             
	             

	          }}
	       });
	       SellAllBut.addActionListener(new ActionListener() {      //�ؽ�Ʈ �޾ƿ� ��ŭ �ŵ��ϱ� ��ư �׼�
	          public void actionPerformed(ActionEvent e) {
	             
	             
	             
	             
	          
	                

	                
	                
	                if(userdata.Get_bit()>0)
	                {

	                   
	                   userdata.Put_own((long)(userdata.Get_bit()*chart.lastValue)*10000);

	                   userdata.Put_bit(-userdata.Get_bit());
	                   
	                   
	                   textAreaForRight.append("�ŵ�"+Double.parseDouble(SellText.getText())+"�� ����" + newline);
	                   textAreaForRight.append("�ŵ� �� �ں�"+userdata.Get_own() +"��"+ newline);
	                   textAreaForRight.append("�ŵ� �� ��Ʈ����"+userdata.Get_bit() + newline);
	                }
	                else
	                {
	                   textAreaForRight.append("�ŵ� ����-��Ʈ���� ����"+ newline+ newline+ newline);

	                }
	                
	             
	             
	             
	             

	          }
	       });

	       ////////////////////Ÿ�̸� �ż��ŵ�/////////////////////////////   �ǽð����� �ؽ�Ʈ ����� ���� ��Ʈ���ΰ� ����

	       Timer timer = new Timer(1000, new ActionListener()

	       {   

	       public void actionPerformed (ActionEvent e)

	       {  	
	    	   day++;
	    	   if(day%10==0)				//////////Time �Լ� �ű�
	    	   {
	    		   d_day--;
	    		   if(d_day==0)
	    		   {
	    			   frame.remove(ToolBar);
						frame.remove(GamePage_change);
						frame.remove(GamePage_state);
						frame.remove(GamePage_loan);
						frame.remove(levelpanel);
						ending=2;
						f.setVisible(true);
						Canvas c = new Canvas();  
						c.setBackground(Color.black);
						JPanel p = new JPanel();
						p.setLayout(new BorderLayout());
						p.add(c);
						f.getContentPane().add(p);
						NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
						Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
						MediaPlayerFactory mpf = new MediaPlayerFactory();
						EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new DefaultFullScreenStrategy(f));
						emp.setVideoSurface(mpf.newVideoSurface(c));
						//emp.toggleFullScreen();
						emp.setEnableMouseInputHandling(false);
						emp.setEnableKeyInputHandling(true);
						p.setVisible(true);
						String file="fail.mp4";
						emp.prepareMedia(file);
						frame.dispose();
						emp.play();
	    		   }
	    		   for(int i =0; i<building.length;i++) {
	    			   if(building[i]==1) {
	    				   userdata.Put_own(Value_of_building[i]*(i*3)+1);
	    			   }
	    		   }
	    		   //�� ����
	    		   
	    		   for(int i=0; i<loan_ex1.length;i++) {
	    			   if(loan_ex2[i]==0)
	    				   i++;
	    			   if(i == loan_ex1.length)
	   					break;
	    			   loan_ex1[i] = (loan_ex2[i] + loan_ex1[i])*loan_ex3[i] /10000;
	    			   loan_ex2[i] += loan_ex1[i];
	    		   }
	    		   
	    	   }
	    	   Date date = new Date();
			      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		     
	    	   String formattedDate = sdf.format(date);
	          String tmp = Double.toString(chart.lastValue);
	          textAreaForLeft.append(tmp +"       "+formattedDate + newline);
	         
	            textAreaForLeft.setCaretPosition(textAreaForLeft.getDocument().getLength());
	               
	       }

	       });
	       ////////////////////Ÿ�̸� �ż��ŵ�/////////////////////////////

	       change.addActionListener(new ActionListener() {               //�ŷ�â �̵� ��ư

	          @Override
	             // TODO Auto-generated method stub
	             public void actionPerformed(ActionEvent e) {

	        	  
	             GamePage_state.setVisible(false);
	             GamePage_loan.setVisible(false);
	             GamePage_change.setVisible(true);
	             ToolBar.setVisible(true);
	              chart.timer.start();                    //�ŷ� â�� �̵� ���� ���, ��Ʈ Ÿ�̸Ӱ� ���۵�
	              timer.start();
	         
	               
	               
	          }
	             
	              

	          
	          
	       
	       });
	       BitBuyBut.addActionListener(new ActionListener() {                 //�ؽ�Ʈâ�� �����ִ� ��ŭ ����
	           @Override
	     public void actionPerformed(ActionEvent e) {          //���� �ŵ�
	     if(BuyText.getText()!=null)
	     {
	        if(Double.parseDouble(BuyText.getText())>0){
	        String BitBuy= "";
	        double BitBuyLo=0;
	        BitBuy=BuyText.getText();
	        BitBuyLo=Double.parseDouble(BitBuy);
	        System.out.println(chart.lastValue);

	        //demo.lastValue
	        if(userdata.Get_own()>=chart.lastValue*BitBuyLo*10000)
	        {

	           userdata.Put_own((long)(-chart.lastValue*BitBuyLo)*10000);
	           userdata.Put_bit(Double.parseDouble(BuyText.getText()));
	           textAreaForRight.append("�ż�"+Double.parseDouble(BuyText.getText())+"�� ����" + newline);
	           textAreaForRight.append("�ż� �� �ں�"+userdata.Get_own() +"��"+ newline);
	           textAreaForRight.append("�ż� �� ��Ʈ����"+userdata.Get_bit() + newline);

	        }
	        else
	        {
	           textAreaForRight.append("�ż� ����-�ݾ� ����"+ newline+ newline+ newline);

	        }
	        }
	     }
	     }


	           
	  }
	  );
	        
	        BuyAllBut.addActionListener(new ActionListener() {    //���� �ż�
	           @Override
	           public void actionPerformed(ActionEvent e) {
	              if(userdata.Get_own()>=(long)(chart.lastValue*10000))
	              {
	                       
	                  int numofbit = (int)(userdata.Get_own()/chart.lastValue/10000);
	                           userdata.Put_own((long)(-chart.lastValue*numofbit)*10000);
	                           userdata.Put_bit(numofbit);
	                           textAreaForRight.append("�ż�"+Double.parseDouble(BuyText.getText())+"�� ����" + newline);
	                       textAreaForRight.append("�ż� �� �ں�"+userdata.Get_own() +"��"+ newline);
	                       textAreaForRight.append("�ż� �� ��Ʈ����"+userdata.Get_bit() + newline);
	                    }
	                    else
	                    {
	                      textAreaForRight.append("�ż� ����-�ݾ� ����"+ newline+ newline+ newline);
	        
	                    }
	                 
	              }}
	           );
	        //////////////////////////////////////////////////////////////
	        
	        
	        
	        
	        
	     
	  

		
        //��ư �� �� ����κ� ��2
		ButtonGroup group=new ButtonGroup();
		//��ư �� �� ����κ� ����1
		
		levelpanel.setBounds(0, 39, 776, 413);           //�ʱ� ���� ���� �г�
		frame.getContentPane().add(levelpanel);
		levelpanel.setLayout(null);
		
		JPanel register_fail = new JPanel();
		register_fail.setBackground(SystemColor.controlHighlight);
		register_fail.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		register_fail.setBounds(260, 8, 281, 162);
		levelpanel.add(register_fail);
		register_fail.setLayout(null);
		
		register_fail.setVisible(false);
		
		JButton Close = new JButton("\uB2EB\uAE30");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_fail.setVisible(false);
			}
		});
		Close.setBounds(98, 129, 72, 23);
		register_fail.add(Close);
		
		JLabel lblNewLabel_9 = new JLabel("          \uD68C\uC6D0 \uAC00\uC785\uC5D0 \uC2E4\uD328 \uD558\uC168\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_9.setBounds(25, 10, 230, 28);
		register_fail.add(lblNewLabel_9);
		
		JLabel lblNewLabel_13 = new JLabel("\uB3D9\uC77C\uD55C id\uAC00 \uC788\uAC70\uB098 \uACF5\uBC31\uC774 \uD3EC\uD568\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_13.setBounds(25, 45, 244, 40);
		register_fail.add(lblNewLabel_13);
		
		JPanel load_fail = new JPanel();
		load_fail.setBackground(SystemColor.controlHighlight);
		load_fail.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		load_fail.setBounds(260, 8, 281, 161);
		levelpanel.add(load_fail);
		load_fail.setLayout(null);
		load_fail.setVisible(false);
		
		JButton btnNewButton_12 = new JButton("\uB2EB\uAE30");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load_fail.setVisible(false);
			}
		});
		btnNewButton_12.setBounds(98, 129, 72, 23);
		load_fail.add(btnNewButton_12);
		
		JLabel lblNewLabel_14 = new JLabel("\uB85C\uB4DC\uD560 \uB370\uC774\uD130\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_14.setBounds(64, 55, 155, 15);
		load_fail.add(lblNewLabel_14);
		
		JPanel login_fail = new JPanel();
		login_fail.setBackground(SystemColor.controlHighlight);
		login_fail.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		login_fail.setBounds(260, 8, 281, 162);
		levelpanel.add(login_fail);
		login_fail.setLayout(null);
		login_fail.setVisible(false);
		
		JButton btnNewButton_11 = new JButton("\uB2EB\uAE30");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_fail.setVisible(false);
			}
		});
		btnNewButton_11.setBounds(98, 129, 72, 23);
		login_fail.add(btnNewButton_11);
		
		JLabel lblNewLabel_10 = new JLabel("            \uB85C\uADF8\uC778 \uC2E4\uD328!");
		lblNewLabel_10.setBounds(56, 53, 164, 66);
		login_fail.add(lblNewLabel_10);
		
		JPanel register_success = new JPanel();
		register_success.setBackground(SystemColor.controlHighlight);
		register_success.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		register_success.setBounds(260, 8, 281, 162);
		levelpanel.add(register_success);
		register_success.setLayout(null);
		register_success.setVisible(false);
		
		JButton btnNewButton_10 = new JButton("\uB2EB\uAE30");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_success.setVisible(false);
			}
		});
		btnNewButton_10.setBounds(98, 129, 72, 23);
		register_success.add(btnNewButton_10);
		
		JLabel lblNewLabel_8 = new JLabel("                \uD68C\uC6D0\uAC00\uC785 \uC131\uACF5");
		lblNewLabel_8.setBounds(32, 39, 198, 66);
		register_success.add(lblNewLabel_8);
		JLabel NameLabel = new JLabel("\uC544\uC774\uB514:");
		NameLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		NameLabel.setBounds(208, 12, 125, 85);
		levelpanel.add(NameLabel);
		JRadioButton GoldSpoon = new JRadioButton("Extreme");
		GoldSpoon.setForeground(Color.YELLOW);
		GoldSpoon.setFont(new Font("����", Font.BOLD, 20));
		GoldSpoon.setBounds(414, 170, 113, 23);
		levelpanel.add(GoldSpoon);
		
		JRadioButton BronzeSpoon = new JRadioButton("Hard");
		BronzeSpoon.setForeground(new Color(184, 134, 11));
		BronzeSpoon.setFont(new Font("����", Font.BOLD, 20));
		BronzeSpoon.setBounds(414, 211, 113, 23);
		levelpanel.add(BronzeSpoon);
		
		JRadioButton SandSpoon = new JRadioButton("Nomal");
		SandSpoon.setForeground(new Color(51, 0, 0));
		SandSpoon.setFont(new Font("����", Font.BOLD, 20));
		SandSpoon.setBounds(414, 255, 113, 23);
		levelpanel.add(SandSpoon);
		
		  JRadioButton Load = new JRadioButton("Load");								///////�ε� ���� ��ư
			      Load.setFont(new Font("����", Font.BOLD, 20));
			      Load.setBounds(543, 211, 113, 23);
			      levelpanel.add(Load);
		
		
		
		
		GoldSpoon.setActionCommand("Gold");
		BronzeSpoon.setActionCommand("Bronze");
		SandSpoon.setActionCommand("Sand");
		Load.setActionCommand("Load");
		
			      GoldSpoon.setSelected(true);
			      
			      
			      levelpanel.setVisible(true);
			      
			      textField_3 = new JTextField(10);
			      textField_3.setBounds(311, 41, 226, 33);
			      levelpanel.add(textField_3);
			      textField_3.setColumns(10);
			      
			      passwordField = new JPasswordField();
			      passwordField.setBounds(311, 105, 226, 33);
			      levelpanel.add(passwordField);
			      
			    
			      

			      
			      JLabel label0 = new JLabel("\uB09C\uC774\uB3C4 \uC124\uC815");
			      label0.setFont(new Font("���� ���", Font.PLAIN, 33));
			      label0.setBounds(194, 170, 181, 85);
			      levelpanel.add(label0);
			      
			      
			      JButton StartGameGo = new JButton("\uAC8C\uC784 \uC2DC\uC791");
			     /* StartGameGo.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent e) {
			      	    levelpanel.setVisible(false);
			      	    GamePage_state.setVisible(true);
			      	    GamePage_loan.setVisible(false);
			      	    GamePage_.setVisible(false);
			      	  ToolBar.setVisible(true);
			      	}
			      });*/
			      
			      StartGameGo.setFont(new Font("����", Font.BOLD, 33));//
			      StartGameGo.setBounds(286, 317, 195, 61);//
			      levelpanel.add(StartGameGo);
			      
			      
			      System.out.println(text1);
			      JLabel label_47 = new JLabel("\uBE44\uBC00\uBC88\uD638:");
			      label_47.setFont(new Font("���� ���", Font.PLAIN, 20));
			      label_47.setBounds(208, 77, 91, 85);
			      levelpanel.add(label_47);
			      
			      group.add(BronzeSpoon);
			      group.add(GoldSpoon);
			      group.add(SandSpoon);
			      group.add(Load);
			      
			      JButton Register = new JButton("\uD68C\uC6D0\uAC00\uC785");
			      Register.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent e) {
			      		 id = textField_3.getText();
			             passwd = passwordField.getText();
			             System.out.println(passwd);
			            
			      		if(save.register_id(id, passwd)==-1||save.register_id(id, passwd)==-2) {
			      			register_fail.setVisible(true);
			      		}
			      		else {
			      			register_success.setVisible(true);
			      		}
			      		
			      	}
			      });
			      Register.setFont(new Font("����", Font.BOLD, 15));
			      Register.setBounds(543, 105, 113, 33);
			      levelpanel.add(Register);
			      
			      StartGameGo.addActionListener(new ActionListener() {                          //���� ��ư�� ����������,

				
					public void actionPerformed(ActionEvent e) {					///�α��� Ȯ�ι�ư��
						 id = textField_3.getText();
			             passwd = passwordField.getText();
			             
						if(save.login_check(id, passwd)<0) {							//�α��� ���н�
							login_fail.setVisible(true);
						}
						else if(save.login_check(id, passwd)==9&&group.getSelection().getActionCommand()=="Load") {
							load_fail.setVisible(true);
						}
						else {
						
						 text_name=textField_3.getText();
						 frame.setTitle("��Ʈ���� ���� -�����: "+text_name);
			             levelpanel.setVisible(false);
			             GamePage_state.setVisible(false);
			             GamePage_change.setVisible(false);
			             GamePage_loan.setVisible(false);
			             ToolBar.setVisible(true);
			             
			            
			          
			             
			            // tttt.start();
			          //   tttt.Set_Time();
			             
			            
			             if(group.getSelection().getActionCommand()=="Gold")                 //Gold�� ����� ���� ��ư�� ��Ʈ�� ���� ��ġ�� ����
			             {	userdata.Set_bit(0);
			             	userdata.Set_own(0);
			                userdata.Put_own(500000000000L);
			                level=3;
	
			                if(level==1)
			        		{
			        			is=0;
			        			
			        			d_day=365;
			        			
			        			loan_text1="�θ���� ������ ��� ��";
			        			btnNewButton_2.setText(loan_text1);
			        			loan_text2="������ �θ���� ������ ��� ���̴�.";
			        			lblNewLabel_3.setText(loan_text2);
			        			loan_text3="�θ�Կ� ���� ������� ������ �Ѵ�.";
			        			label_12.setText(loan_text3);
			        			loan_text4="�δ�Ǳ� ������ ������ ���ƺ���!";
			        			label_13.setText(loan_text4);
			        			loan_text5="(���ӿ����� ȿ���� �� �� �ִ�.)";
			        			label_14.setText(loan_text5);
			        			loan_text6="100,000,000";
			        			lblNewLabel_5.setText(loan_text6);
			        			loan_text7="5%";
			        			lblNewLabel_7.setText(loan_text7);
			        			loan_ex3[0]=500;
			        			label_16.setText(momo.format(loan_ex1[0]));
			        			loan_ex2[0]=100000000;
			        			label_18.setText(momo.format(loan_ex2[0]));
			        			loan_text8="D-"+Integer.toString(d_day);
			        			label_20.setText(loan_text8);
			        			
			        			loan_text11="C���� ���ڱ� ����";
			        			button_2.setText(loan_text11);
			        			loan_text12="C�� ������ �ٴϴ� ���� ���� ���̴�.";
			        			label_2.setText(loan_text12);
			        			loan_text13="�б��� ������ ���ذ� ����!�� ����������";
			        			label_3.setText(loan_text13);
			        			loan_text14="�ѱ���������� �� ������ ������ �ʴ´�.";
			        			label_4.setText(loan_text14);
			        			loan_text15="���б��� Ÿ������ ������ ſ����.";
			        			label_5.setText(loan_text15);
			        			loan_text16="20,000,000";
			        			label_7.setText(loan_text16);
			        			loan_text17="0.05%";
			        			label_23.setText(loan_text17);
			        			label_25.setText(momo.format(loan_ex1[2]));
			        			loan_ex3[2]=5;
			        			loan_ex2[2]=20000000;
			        			label_27.setText(momo.format(loan_ex2[2]));
			        			loan_text18="D-"+Integer.toString(d_day);
			        			label_28.setText(loan_text18);
			        			
			        			loan_text111="���ε鿡�� ������";
			        			button_3.setText(loan_text111);
			        			loan_text21="�������⼭ �����ؿ� ���̴�.";
			        			label_30.setText(loan_text21);
			        			loan_text31="ģ��ģ��,ģô,����ģ���� ���� ���ȴ�.";
			        			label_31.setText(loan_text31);
			        			loan_text41="��������� ��Ծ ������ ����� ����Ѵ�.";
			        			label_32.setText(loan_text41);
			        			loan_text51="�ֺ� ���ε��� �ұ����� ���ƾ��Ѵ�.";
			        			label_33.setText(loan_text51);
			        			loan_text61="8,000,000";
			        			label_35.setText(loan_text61);
			        			loan_text71="0.1%";
			        			label_37.setText(loan_text71);
			        			loan_ex3[1]=10;
			        			loan_ex2[1]=8000000;
			        			label_39.setText(momo.format(loan_ex1[1]));
			        			label_41.setText(momo.format(loan_ex2[1]));
			        			loan_text81="D-"+Integer.toString(d_day);
			        			label_42.setText(loan_text81);
			        			
			        			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
			        			
			        		}
			              
			        		else if(level == 2)
			        		{
			        			
			        			d_day=365;
			        			
			        			loan_text1="�ֽ����� �����Ϸ��� �� ��";
			        			btnNewButton_2.setText(loan_text1);
			        			loan_text2="�ֽ����� �λ������Ϸ��� ���ߴ�.";
			        			lblNewLabel_3.setText(loan_text2);
			        			loan_text3="������ �������μ� �� ���ƾ� �Ѵ�.";
			        			label_12.setText(loan_text3);
			        			loan_text4="��Ʈ�������� ������ ����� ���̴�.";
			        			label_13.setText(loan_text4);
			        			loan_text5="���н� ������ ���� ������ �� ����.";
			        			label_14.setText(loan_text5);
			        			loan_text6="500,000,000";
			        			lblNewLabel_5.setText(loan_text6);
			        			loan_text7="15%";
			        			lblNewLabel_7.setText(loan_text7);
			        			loan_ex3[0]=100;
			        			label_16.setText(momo.format(loan_ex1[0]));
			        			loan_ex2[0]=500000000;
			        			label_18.setText(momo.format(loan_ex2[0]));
			        			loan_text8="D-"+Integer.toString(d_day);
			        			label_20.setText(loan_text8);
			        			
			        			loan_text11="������ �����";
			        			button_2.setText(loan_text11);
			        			loan_text12="���� ���忡 �ٴϰ� ������ ���ȴ� ���̴�.";
			        			label_2.setText(loan_text12);
			        			loan_text13="1�������� ���� ���ڴ� ���� �ʴ�.";
			        			label_3.setText(loan_text13);
			        			loan_text14="�ſ��� �Ҿ����� ��Ʈ�������� ���� ����.";
			        			label_4.setText(loan_text14);
			        			loan_text15="�������� ������ ��ٴ����� ���ɴ´�.";
			        			label_5.setText(loan_text15);
			        			loan_text16="1,000,000,000";
			        			label_7.setText(loan_text16);
			        			loan_text17="5%";
			        			label_23.setText(loan_text17);
			        			label_25.setText(momo.format(loan_ex1[2]));
			        			loan_ex3[2]=25;
			        			loan_ex2[2]=1000000000;
			        			label_27.setText(momo.format(loan_ex2[2]));
			        			loan_text18="D-"+Integer.toString(d_day);
			        			label_28.setText(loan_text18);
			        			
			        			loan_text111="����ݾ�ü�� ���� ��";
			        			button_3.setText(loan_text111);
			        			loan_text21="�� ���������� ���� ������ ���� �������.";
			        			label_30.setText(loan_text21);
			        			loan_text31="����� �系�� �� Į�� ��ﳭ��.";
			        			label_31.setText(loan_text31);
			        			loan_text41="������ �ǽŽ�Ű�� ������";
			        			label_32.setText(loan_text41);
			        			loan_text51="�̹� �Ż������� �з����ȴ�.";
			        			label_33.setText(loan_text51);
			        			loan_text61="300,000,000";
			        			label_35.setText(loan_text61);
			        			loan_text71="50%";
			        			label_37.setText(loan_text71);
			        			loan_ex3[1]=250;
			        			loan_ex2[1]=300000000;
			        			label_39.setText(momo.format(loan_ex1[1]));
			        			label_41.setText(momo.format(loan_ex2[1]));
			        			loan_text81="D-"+Integer.toString(d_day);
			        			label_42.setText(loan_text81);
			        			
			        			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
			        		}
			        		else 
			        		{
			        			d_day=50;
			        			
			        			loan_text1="���� ���ǿ��� �� ��";
			        			btnNewButton_2.setText(loan_text1);
			        			loan_text2="���� ������ ����迡�� ����ϴ� �̸�.";
			        			lblNewLabel_3.setText(loan_text2);
			        			loan_text3="�ϴ� ����� ���ƸԾ� ��Ű�� ���� ���ƾ��Ѵ�.";
			        			label_12.setText(loan_text3);
			        			loan_text4="�ִ��� ���� ���� ������ ����� ������ �� ��.";
			        			label_13.setText(loan_text4);
			        			loan_text5="�ð��� �˹��ϴ� ���θ���.";
			        			label_14.setText(loan_text5);
			        			loan_text6="50,000,000,000,000";
			        			lblNewLabel_5.setText(loan_text6);
			        			loan_text7="15%";
			        			lblNewLabel_7.setText(loan_text7);
			        			loan_ex3[0]=150;
			        			label_16.setText(momo.format(loan_ex1[0]));
			        			loan_ex2[0]=50000000000000L;
			        			label_18.setText(momo.format(loan_ex2[0]));
			        			loan_text8="D-"+Integer.toString(d_day);
			        			label_20.setText(loan_text8);
			        			
			        			loan_text11="�Ϸ�̳�Ƽ�� �����ؾ��� ��";
			        			button_2.setText(loan_text11);
			        			loan_text12="��Ȯ�� ��ü �Ϸ�̳�Ƽ�� �����ؾ� �� ��";
			        			label_2.setText(loan_text12);
			        			loan_text13="�������� �̾�� ���� û���� ���� �����̴�.";
			        			label_3.setText(loan_text13);
			        			loan_text14="�Ⱓ ���� ������ ���ϸ� ������ ���� ���̴�.";
			        			label_4.setText(loan_text14);
			        			loan_text15="�Ϲ������� ������� ����غ���.";
			        			label_5.setText(loan_text15);
			        			loan_text16="100,000,000,000";
			        			label_7.setText(loan_text16);
			        			loan_text17="100%";
			        			label_23.setText(loan_text17);
			        			label_25.setText(momo.format(loan_ex1[2]));
			        			loan_ex3[2]=500;
			        			loan_ex2[2]=100000000000L;
			        			label_27.setText(momo.format(loan_ex2[2]));
			        			loan_text18="D-"+Integer.toString(d_day+200);
			        			label_28.setText(loan_text18);
			        			
			        			loan_text111="��ƿ���𿡰� ���� ��";
			        			button_3.setText(loan_text111);
			        			loan_text21="������ ������ �ִ� ��ƿ���𿡰� ���� ��";
			        			label_30.setText(loan_text21);
			        			loan_text31="������ �˰Ե� ��ƿ���𿡰� ������ ��";
			        			label_31.setText(loan_text31);
			        			loan_text41="�������� �����Ҷ����� ������ ������ ����.";
			        			label_32.setText(loan_text41);
			        			loan_text51="��� ���� �ּ��� ���� ���̴�.";
			        			label_33.setText(loan_text51);
			        			loan_text61="1,000,000,000,000";
			        			label_35.setText(loan_text61);
			        			loan_text71="500%";
			        			label_37.setText(loan_text71);
			        			loan_ex3[1]=1000;
			        			loan_ex2[1]=1000000000000L;
			        			label_39.setText(momo.format(loan_ex1[1]));
			        			label_41.setText(momo.format(loan_ex2[1]));
			        			loan_text81="D-"+Integer.toString(d_day+300);
			        			label_42.setText(loan_text81);
			        			
			        			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
			        		
			        			
			        		//	tttt.set_Inter(loan_ex1, loan_ex2, loan_ex3, building);
			        		}
			                
			             }
			             else if(group.getSelection().getActionCommand()=="Bronze")
			             {	userdata.Set_bit(0);
			             	userdata.Set_own(0);
			            	 userdata.Put_own(50000000);
				              level=2;
				              System.out.println(level);
				              if(level==1)
				      		{
				      			is=0;
				      			
				      			d_day=365;
				      			
				      			loan_text1="�θ���� ������ ��� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="������ �θ���� ������ ��� ���̴�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="�θ�Կ� ���� ������� ������ �Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="�δ�Ǳ� ������ ������ ���ƺ���!";
				      			label_13.setText(loan_text4);
				      			loan_text5="(���ӿ����� ȿ���� �� �� �ִ�.)";
				      			label_14.setText(loan_text5);
				      			loan_text6="100,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="5%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=500;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=100000000;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="C���� ���ڱ� ����";
				      			button_2.setText(loan_text11);
				      			loan_text12="C�� ������ �ٴϴ� ���� ���� ���̴�.";
				      			label_2.setText(loan_text12);
				      			loan_text13="�б��� ������ ���ذ� ����!�� ����������";
				      			label_3.setText(loan_text13);
				      			loan_text14="�ѱ���������� �� ������ ������ �ʴ´�.";
				      			label_4.setText(loan_text14);
				      			loan_text15="���б��� Ÿ������ ������ ſ����.";
				      			label_5.setText(loan_text15);
				      			loan_text16="20,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="0.05%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=5;
				      			loan_ex2[2]=20000000;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="���ε鿡�� ������";
				      			button_3.setText(loan_text111);
				      			loan_text21="�������⼭ �����ؿ� ���̴�.";
				      			label_30.setText(loan_text21);
				      			loan_text31="ģ��ģ��,ģô,����ģ���� ���� ���ȴ�.";
				      			label_31.setText(loan_text31);
				      			loan_text41="��������� ��Ծ ������ ����� ����Ѵ�.";
				      			label_32.setText(loan_text41);
				      			loan_text51="�ֺ� ���ε��� �ұ����� ���ƾ��Ѵ�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="8,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="0.1%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=10;
				      			loan_ex2[1]=8000000;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      			
				      		}
				      		else if(level == 2)
				      		{
				      			
				      			d_day=365;
				      			
				      			loan_text1="�ֽ����� �����Ϸ��� �� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="�ֽ����� �λ������Ϸ��� ���ߴ�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="������ �������μ� �� ���ƾ� �Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="��Ʈ�������� ������ ����� ���̴�.";
				      			label_13.setText(loan_text4);
				      			loan_text5="���н� ������ ���� ������ �� ����.";
				      			label_14.setText(loan_text5);
				      			loan_text6="500,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="15%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=100;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=500000000;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="������ �����";
				      			button_2.setText(loan_text11);
				      			loan_text12="���� ���忡 �ٴϰ� ������ ���ȴ� ���̴�.";
				      			label_2.setText(loan_text12);
				      			loan_text13="1�������� ���� ���ڴ� ���� �ʴ�.";
				      			label_3.setText(loan_text13);
				      			loan_text14="�ſ��� �Ҿ����� ��Ʈ�������� ���� ����.";
				      			label_4.setText(loan_text14);
				      			loan_text15="�������� ������ ��ٴ����� ���ɴ´�.";
				      			label_5.setText(loan_text15);
				      			loan_text16="1,000,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="5%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=50;
				      			loan_ex2[2]=1000000000;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="����ݾ�ü�� ���� ��";
				      			button_3.setText(loan_text111);
				      			loan_text21="�� ���������� ���� ������ ���� �������.";
				      			label_30.setText(loan_text21);
				      			loan_text31="����� �系�� �� Į�� ��ﳭ��.";
				      			label_31.setText(loan_text31);
				      			loan_text41="������ �ǽŽ�Ű�� ������";
				      			label_32.setText(loan_text41);
				      			loan_text51="�̹� �Ż������� �з����ȴ�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="300,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="50%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=250;
				      			loan_ex2[1]=300000000;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      		//	tttt.set_Inter(loan_ex1, loan_ex2, loan_ex3, building);
				      		}
				      		else 
				      		{
				      			d_day=50;
				      			
				      			loan_text1="���� ���ǿ��� �� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="���� ������ ����迡�� ����ϴ� �̸�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="�ϴ� ����� ���ƸԾ� ��Ű�� ���� ���ƾ��Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="�ִ��� ���� ���� ������ ����� ������ �� ��.";
				      			label_13.setText(loan_text4);
				      			loan_text5="�ð��� �˹��ϴ� ���θ���.";
				      			label_14.setText(loan_text5);
				      			loan_text6="50,000,000,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="15%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=1500;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=50000000000000L;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="�Ϸ�̳�Ƽ�� �����ؾ��� ��";
				      			button_2.setText(loan_text11);
				      			loan_text12="��Ȯ�� ��ü �Ϸ�̳�Ƽ�� �����ؾ� �� ��";
				      			label_2.setText(loan_text12);
				      			loan_text13="�������� �̾�� ���� û���� ���� �����̴�.";
				      			label_3.setText(loan_text13);
				      			loan_text14="�Ⱓ ���� ������ ���ϸ� ������ ���� ���̴�.";
				      			label_4.setText(loan_text14);
				      			loan_text15="�Ϲ������� ������� ����غ���.";
				      			label_5.setText(loan_text15);
				      			loan_text16="100,000,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="100%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=10000;
				      			loan_ex2[2]=100000000000L;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="��ƿ���𿡰� ���� ��";
				      			button_3.setText(loan_text111);
				      			loan_text21="������ ������ �ִ� ��ƿ���𿡰� ���� ��";
				      			label_30.setText(loan_text21);
				      			loan_text31="������ �˰Ե� ��ƿ���𿡰� ������ ��";
				      			label_31.setText(loan_text31);
				      			loan_text41="�������� �����Ҷ����� ������ ������ ����.";
				      			label_32.setText(loan_text41);
				      			loan_text51="��� ���� �ּ��� ���� ���̴�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="1,000,000,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="500%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=50000;
				      			loan_ex2[1]=1000000000000L;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      		}
			             }
			             else if(group.getSelection().getActionCommand()=="Sand")
			             {	userdata.Set_bit(0);
			             	userdata.Set_own(0);
			            	 userdata.Put_own(1000000000L);
				              level=1;
				              System.out.println(level);
				              if(level==1)
				      		{
				      			is=0;
				      			
				      			d_day=365;
				      			
				      			loan_text1="�θ���� ������ ��� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="������ �θ���� ������ ��� ���̴�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="�θ�Կ� ���� ������� ������ �Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="�δ�Ǳ� ������ ������ ���ƺ���!";
				      			label_13.setText(loan_text4);
				      			loan_text5="(���ӿ����� ȿ���� �� �� �ִ�.)";
				      			label_14.setText(loan_text5);
				      			loan_text6="100,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="5%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=50;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=100000000;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="C���� ���ڱ� ����";
				      			button_2.setText(loan_text11);
				      			loan_text12="C�� ������ �ٴϴ� ���� ���� ���̴�.";
				      			label_2.setText(loan_text12);
				      			loan_text13="�б��� ������ ���ذ� ����!�� ����������";
				      			label_3.setText(loan_text13);
				      			loan_text14="�ѱ���������� �� ������ ������ �ʴ´�.";
				      			label_4.setText(loan_text14);
				      			loan_text15="���б��� Ÿ������ ������ ſ����.";
				      			label_5.setText(loan_text15);
				      			loan_text16="20,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="0.05%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=5;
				      			loan_ex2[2]=20000000;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="���ε鿡�� ������";
				      			button_3.setText(loan_text111);
				      			loan_text21="�������⼭ �����ؿ� ���̴�.";
				      			label_30.setText(loan_text21);
				      			loan_text31="ģ��ģ��,ģô,����ģ���� ���� ���ȴ�.";
				      			label_31.setText(loan_text31);
				      			loan_text41="��������� ��Ծ ������ ����� ����Ѵ�.";
				      			label_32.setText(loan_text41);
				      			loan_text51="�ֺ� ���ε��� �ұ����� ���ƾ��Ѵ�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="8,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="0.1%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=10;
				      			loan_ex2[1]=8000000;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      		//	tttt.set_Inter(loan_ex1, loan_ex2, loan_ex3, building);
				      			
				      		}
				      		else if(level == 2)
				      		{
				      			
				      			d_day=365;
				      			
				      			loan_text1="�ֽ����� �����Ϸ��� �� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="�ֽ����� �λ������Ϸ��� ���ߴ�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="������ �������μ� �� ���ƾ� �Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="��Ʈ�������� ������ ����� ���̴�.";
				      			label_13.setText(loan_text4);
				      			loan_text5="���н� ������ ���� ������ �� ����.";
				      			label_14.setText(loan_text5);
				      			loan_text6="500,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="15%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=1500;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=500000000;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="������ �����";
				      			button_2.setText(loan_text11);
				      			loan_text12="���� ���忡 �ٴϰ� ������ ���ȴ� ���̴�.";
				      			label_2.setText(loan_text12);
				      			loan_text13="1�������� ���� ���ڴ� ���� �ʴ�.";
				      			label_3.setText(loan_text13);
				      			loan_text14="�ſ��� �Ҿ����� ��Ʈ�������� ���� ����.";
				      			label_4.setText(loan_text14);
				      			loan_text15="�������� ������ ��ٴ����� ���ɴ´�.";
				      			label_5.setText(loan_text15);
				      			loan_text16="1,000,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="5%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=500;
				      			loan_ex2[2]=1000000000;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="����ݾ�ü�� ���� ��";
				      			button_3.setText(loan_text111);
				      			loan_text21="�� ���������� ���� ������ ���� �������.";
				      			label_30.setText(loan_text21);
				      			loan_text31="����� �系�� �� Į�� ��ﳭ��.";
				      			label_31.setText(loan_text31);
				      			loan_text41="������ �ǽŽ�Ű�� ������";
				      			label_32.setText(loan_text41);
				      			loan_text51="�̹� �Ż������� �з����ȴ�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="300,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="50%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=5000;
				      			loan_ex2[1]=300000000;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      		}
				      		else 
				      		{
				      			d_day=50;
				      			
				      			loan_text1="���� ���ǿ��� �� ��";
				      			btnNewButton_2.setText(loan_text1);
				      			loan_text2="���� ������ ����迡�� ����ϴ� �̸�.";
				      			lblNewLabel_3.setText(loan_text2);
				      			loan_text3="�ϴ� ����� ���ƸԾ� ��Ű�� ���� ���ƾ��Ѵ�.";
				      			label_12.setText(loan_text3);
				      			loan_text4="�ִ��� ���� ���� ������ ����� ������ �� ��.";
				      			label_13.setText(loan_text4);
				      			loan_text5="�ð��� �˹��ϴ� ���θ���.";
				      			label_14.setText(loan_text5);
				      			loan_text6="50,000,000,000,000";
				      			lblNewLabel_5.setText(loan_text6);
				      			loan_text7="15%";
				      			lblNewLabel_7.setText(loan_text7);
				      			loan_ex3[0]=1500;
				      			label_16.setText(momo.format(loan_ex1[0]));
				      			loan_ex2[0]=50000000000000L;
				      			label_18.setText(momo.format(loan_ex2[0]));
				      			loan_text8="D-"+Integer.toString(d_day);
				      			label_20.setText(loan_text8);
				      			
				      			loan_text11="�Ϸ�̳�Ƽ�� �����ؾ��� ��";
				      			button_2.setText(loan_text11);
				      			loan_text12="��Ȯ�� ��ü �Ϸ�̳�Ƽ�� �����ؾ� �� ��";
				      			label_2.setText(loan_text12);
				      			loan_text13="�������� �̾�� ���� û���� ���� �����̴�.";
				      			label_3.setText(loan_text13);
				      			loan_text14="�Ⱓ ���� ������ ���ϸ� ������ ���� ���̴�.";
				      			label_4.setText(loan_text14);
				      			loan_text15="�Ϲ������� ������� ����غ���.";
				      			label_5.setText(loan_text15);
				      			loan_text16="100,000,000,000";
				      			label_7.setText(loan_text16);
				      			loan_text17="100%";
				      			label_23.setText(loan_text17);
				      			label_25.setText(momo.format(loan_ex1[2]));
				      			loan_ex3[2]=10000;
				      			loan_ex2[2]=100000000000L;
				      			label_27.setText(momo.format(loan_ex2[2]));
				      			loan_text18="D-"+Integer.toString(d_day);
				      			label_28.setText(loan_text18);
				      			
				      			loan_text111="��ƿ���𿡰� ���� ��";
				      			button_3.setText(loan_text111);
				      			loan_text21="������ ������ �ִ� ��ƿ���𿡰� ���� ��";
				      			label_30.setText(loan_text21);
				      			loan_text31="������ �˰Ե� ��ƿ���𿡰� ������ ��";
				      			label_31.setText(loan_text31);
				      			loan_text41="�������� �����Ҷ����� ������ ������ ����.";
				      			label_32.setText(loan_text41);
				      			loan_text51="��� ���� �ּ��� ���� ���̴�.";
				      			label_33.setText(loan_text51);
				      			loan_text61="1,000,000,000,000";
				      			label_35.setText(loan_text61);
				      			loan_text71="500%";
				      			label_37.setText(loan_text71);
				      			loan_ex3[1]=50000;
				      			loan_ex2[1]=1000000000000L;
				      			label_39.setText(momo.format(loan_ex1[1]));
				      			label_41.setText(momo.format(loan_ex2[1]));
				      			loan_text81="D-"+Integer.toString(d_day);
				      			label_42.setText(loan_text81);
				      			
				      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
				      		}
				              
			             }
			             ///////////�ε�///////////
			             else if(group.getSelection().getActionCommand()=="Load") {
			            	 ////////////////�α��� ������ ������//////////////////////
			            		 level= save.login_id(id, passwd, userdata, loan_ex, loan_ex1, loan_ex2, su_loan, d_day, building);	
			        			///////////////���� �ε�//////////////////////
			            
			        			System.out.println("hello" + building[0]);
			        			if(building[0]==1)
			        				home_set1 = "������";
			        			if(building[1]==1)
			        				home_set2 = "������";
			        			if(building[2]==1)
			        				home_set3 = "������";
			        			if(building[3]==1)
			        				home_set4 = "������";
			        			if(building[4]==1)
			        				home_set5 = "������";
			        			if(building[5]==1)
			        				home_set6 = "������";
			        			
			        		
			        			if(level==1)
					      		{
					      			is=0;			//??
					  
					      			
					      			loan_text1="�θ���� ������ ��� ��";
					      			btnNewButton_2.setText(loan_text1);
					      			loan_text2="������ �θ���� ������ ��� ���̴�.";
					      			lblNewLabel_3.setText(loan_text2);
					      			loan_text3="�θ�Կ� ���� ������� ������ �Ѵ�.";
					      			label_12.setText(loan_text3);
					      			loan_text4="�δ�Ǳ� ������ ������ ���ƺ���!";
					      			label_13.setText(loan_text4);
					      			loan_text5="(���ӿ����� ȿ���� �� �� �ִ�.)";
					      			label_14.setText(loan_text5);
					      			loan_text6="100,000,000";
					      			lblNewLabel_5.setText(loan_text6);
					      			loan_text7="5%";
					      			lblNewLabel_7.setText(loan_text7);
					      			
					      			label_16.setText(momo.format(loan_ex1[0]));
					      			
					      			label_18.setText(momo.format(loan_ex2[0]));
					      			loan_text8="D-"+Integer.toString(d_day);
					      			label_20.setText(loan_text8);
					      			
					      			loan_text11="C���� ���ڱ� ����";
					      			button_2.setText(loan_text11);
					      			loan_text12="C�� ������ �ٴϴ� ���� ���� ���̴�.";
					      			label_2.setText(loan_text12);
					      			loan_text13="�б��� ������ ���ذ� ����!�� ����������";
					      			label_3.setText(loan_text13);
					      			loan_text14="�ѱ���������� �� ������ ������ �ʴ´�.";
					      			label_4.setText(loan_text14);
					      			loan_text15="���б��� Ÿ������ ������ ſ����.";
					      			label_5.setText(loan_text15);
					      			loan_text16="20,000,000";
					      			label_7.setText(loan_text16);
					      			loan_text17="0.05%";
					      			label_23.setText(loan_text17);
					      			label_25.setText(momo.format(loan_ex1[2]));
					      			
					      			label_27.setText(momo.format(loan_ex2[2]));
					      			loan_text18="D-"+Integer.toString(d_day);
					      			label_28.setText(loan_text18);
					      			
					      			loan_text111="���ε鿡�� ������";
					      			button_3.setText(loan_text111);
					      			loan_text21="�������⼭ �����ؿ� ���̴�.";
					      			label_30.setText(loan_text21);
					      			loan_text31="ģ��ģ��,ģô,����ģ���� ���� ���ȴ�.";
					      			label_31.setText(loan_text31);
					      			loan_text41="��������� ��Ծ ������ ����� ����Ѵ�.";
					      			label_32.setText(loan_text41);
					      			loan_text51="�ֺ� ���ε��� �ұ����� ���ƾ��Ѵ�.";
					      			label_33.setText(loan_text51);
					      			loan_text61="8,000,000";
					      			label_35.setText(loan_text61);
					      			loan_text71="0.1%";
					      			label_37.setText(loan_text71);
					      			
					      			label_39.setText(momo.format(loan_ex1[1]));
					      			label_41.setText(momo.format(loan_ex2[1]));
					      			loan_text81="D-"+Integer.toString(d_day);
					      			label_42.setText(loan_text81);
					      			
					      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
					      			
					      		}
					      		else if(level == 2)
					      		{
					      			
					      		
					      			
					      			loan_text1="�ֽ����� �����Ϸ��� �� ��";
					      			btnNewButton_2.setText(loan_text1);
					      			loan_text2="�ֽ����� �λ������Ϸ��� ���ߴ�.";
					      			lblNewLabel_3.setText(loan_text2);
					      			loan_text3="������ �������μ� �� ���ƾ� �Ѵ�.";
					      			label_12.setText(loan_text3);
					      			loan_text4="��Ʈ�������� ������ ����� ���̴�.";
					      			label_13.setText(loan_text4);
					      			loan_text5="���н� ������ ���� ������ �� ����.";
					      			label_14.setText(loan_text5);
					      			loan_text6="500,000,000";
					      			lblNewLabel_5.setText(loan_text6);
					      			loan_text7="15%";
					      			lblNewLabel_7.setText(loan_text7);
					      			
					      			label_16.setText(momo.format(loan_ex1[0]));
					      			
					      			label_18.setText(momo.format(loan_ex2[0]));
					      			loan_text8="D-"+Integer.toString(d_day);
					      			label_20.setText(loan_text8);
					      			
					      			loan_text11="������ �����";
					      			button_2.setText(loan_text11);
					      			loan_text12="���� ���忡 �ٴϰ� ������ ���ȴ� ���̴�.";
					      			label_2.setText(loan_text12);
					      			loan_text13="1�������� ���� ���ڴ� ���� �ʴ�.";
					      			label_3.setText(loan_text13);
					      			loan_text14="�ſ��� �Ҿ����� ��Ʈ�������� ���� ����.";
					      			label_4.setText(loan_text14);
					      			loan_text15="�������� ������ ��ٴ����� ���ɴ´�.";
					      			label_5.setText(loan_text15);
					      			loan_text16="1,000,000,000";
					      			label_7.setText(loan_text16);
					      			loan_text17="5%";
					      			label_23.setText(loan_text17);
					      			label_25.setText(momo.format(loan_ex1[2]));
					      			
					      			label_27.setText(momo.format(loan_ex2[2]));
					      			loan_text18="D-"+Integer.toString(d_day);
					      			label_28.setText(loan_text18);
					      			
					      			loan_text111="����ݾ�ü�� ���� ��";
					      			button_3.setText(loan_text111);
					      			loan_text21="�� ���������� ���� ������ ���� �������.";
					      			label_30.setText(loan_text21);
					      			loan_text31="����� �系�� �� Į�� ��ﳭ��.";
					      			label_31.setText(loan_text31);
					      			loan_text41="������ �ǽŽ�Ű�� ������";
					      			label_32.setText(loan_text41);
					      			loan_text51="�̹� �Ż������� �з����ȴ�.";
					      			label_33.setText(loan_text51);
					      			loan_text61="300,000,000";
					      			label_35.setText(loan_text61);
					      			loan_text71="50%";
					      			label_37.setText(loan_text71);
					      			
					      			label_39.setText(momo.format(loan_ex1[1]));
					      			label_41.setText(momo.format(loan_ex2[1]));
					      			loan_text81="D-"+Integer.toString(d_day);
					      			label_42.setText(loan_text81);
					      			
					      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
					      		//	tttt.set_Inter(loan_ex1, loan_ex2, loan_ex3, building);
					      		}
					      		else if(level==3)
					      		{
					   
					      			loan_text1="���� ���ǿ��� �� ��";
					      			btnNewButton_2.setText(loan_text1);
					      			loan_text2="���� ������ ����迡�� ����ϴ� �̸�.";
					      			lblNewLabel_3.setText(loan_text2);
					      			loan_text3="�ϴ� ����� ���ƸԾ� ��Ű�� ���� ���ƾ��Ѵ�.";
					      			label_12.setText(loan_text3);
					      			loan_text4="�ִ��� ���� ���� ������ ����� ������ �� ��.";
					      			label_13.setText(loan_text4);
					      			loan_text5="�ð��� �˹��ϴ� ���θ���.";
					      			label_14.setText(loan_text5);
					      			loan_text6="50,000,000,000,000";
					      			lblNewLabel_5.setText(loan_text6);
					      			loan_text7="15%";
					      			lblNewLabel_7.setText(loan_text7);
					      			loan_ex3[0]=1500;
					      			label_16.setText(momo.format(loan_ex1[0]));
					      		
					      			label_18.setText(momo.format(loan_ex2[0]));
					      			loan_text8="D-"+Integer.toString(d_day);
					      			label_20.setText(loan_text8);
					      			
					      			loan_text11="�Ϸ�̳�Ƽ�� �����ؾ��� ��";
					      			button_2.setText(loan_text11);
					      			loan_text12="��Ȯ�� ��ü �Ϸ�̳�Ƽ�� �����ؾ� �� ��";
					      			label_2.setText(loan_text12);
					      			loan_text13="�������� �̾�� ���� û���� ���� �����̴�.";
					      			label_3.setText(loan_text13);
					      			loan_text14="�Ⱓ ���� ������ ���ϸ� ������ ���� ���̴�.";
					      			label_4.setText(loan_text14);
					      			loan_text15="�Ϲ������� ������� ����غ���.";
					      			label_5.setText(loan_text15);
					      			loan_text16="100,000,000,000";
					      			label_7.setText(loan_text16);
					      			loan_text17="100%";
					      			label_23.setText(loan_text17);
					      			label_25.setText(momo.format(loan_ex1[2]));
					      		
					      			label_27.setText(momo.format(loan_ex2[2]));
					      			loan_text18="D-"+Integer.toString(d_day);
					      			label_28.setText(loan_text18);
					      			
					      			loan_text111="��ƿ���𿡰� ���� ��";
					      			button_3.setText(loan_text111);
					      			loan_text21="������ ������ �ִ� ��ƿ���𿡰� ���� ��";
					      			label_30.setText(loan_text21);
					      			loan_text31="������ �˰Ե� ��ƿ���𿡰� ������ ��";
					      			label_31.setText(loan_text31);
					      			loan_text41="�������� �����Ҷ����� ������ ������ ����.";
					      			label_32.setText(loan_text41);
					      			loan_text51="��� ���� �ּ��� ���� ���̴�.";
					      			label_33.setText(loan_text51);
					      			loan_text61="1,000,000,000,000";
					      			label_35.setText(loan_text61);
					      			loan_text71="500%";
					      			label_37.setText(loan_text71);
					      
					      			label_39.setText(momo.format(loan_ex1[1]));
					      			label_41.setText(momo.format(loan_ex2[1]));
					      			loan_text81="D-"+Integer.toString(d_day);
					      			label_42.setText(loan_text81);
					      			
					      			loan_ex=loan_ex2[0]+loan_ex2[1]+loan_ex2[2];
					      		}
			        			
					      		
			        			
			             }
			             
			          }
					}
			       });
				
				 
		//��ư �� �� ����κ� ��1
				
		//��ư �� �� ����κ� ����2
			      
		
		
		money_label=momo.format(userdata.Get_own());
		JLabel lblNewLabel = new JLabel(":"+money_label+"��");
		bit_label=String.valueOf(userdata.Get_bit());
		JLabel label = new JLabel(":"+bit_label+"��");
		loan_label=momo.format(loan_ex);
		JLabel label_1 = new JLabel(":"+loan_label+"��");
		
		
		
		GamePage_loan.setBounds(0, 39, 776, 413);
		frame.getContentPane().add(GamePage_loan);
		GamePage_loan.setLayout(null);
		
		//���� �Ϸ� ����
				JPanel su_panel = new JPanel();
				su_panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				su_panel.setBounds(0, 0, 258, 413);
				GamePage_loan.add(su_panel);
				su_panel.setLayout(null);
				su_panel.setVisible(false);
				
				JButton su_btnNewButton_2 = new JButton("Complete!!");
				su_btnNewButton_2.setFont(new Font("����", Font.PLAIN, 30));
				su_btnNewButton_2.setBounds(0, 0, 258, 413);
				su_panel.add(su_btnNewButton_2);
				
				JPanel su_panel_1 = new JPanel();
				su_panel_1.setLayout(null);
				su_panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				su_panel_1.setBounds(258, 0, 259, 413);
				GamePage_loan.add(su_panel_1);
				su_panel_1.setVisible(false);
				
				JButton su_btnNewButton_12 = new JButton("Complete!!");
				su_btnNewButton_12.setFont(new Font("����", Font.PLAIN, 30));
				su_btnNewButton_12.setBounds(0, 0, 258, 413);
				su_panel_1.add(su_btnNewButton_12);
				
				JPanel su_panel_2 = new JPanel();
				su_panel_2.setLayout(null);
				su_panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				su_panel_2.setBounds(516, 0, 259, 413);
				GamePage_loan.add(su_panel_2);
				su_panel_2.setVisible(false);
				
				JButton su_btnNewButton_21 = new JButton("Complete!!");
				su_btnNewButton_21.setFont(new Font("����", Font.PLAIN, 30));
				su_btnNewButton_21.setBounds(0, 0, 258, 413);
				su_panel_2.add(su_btnNewButton_21);
				
				
				
				GamePage_loan.setVisible(false);
				
				//���� �Ϸ� ��
		
		//���� ��ȯ ����â ����
		loanb_label="��ȯ �ϼ̽��ϴ�.";
		JPanel loan_back = new JPanel();
		loan_back.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		loan_back.setBounds(268, 59, 229, 200);
		GamePage_loan.add(loan_back);
		loan_back.setLayout(null);
		Color coco11=new Color(234,234,234);
		loan_back.setBackground(coco11);
		JLabel llblNewLabel_112 = new JLabel(loanb_label);
		llblNewLabel_112.setBounds(12, 53, 205, 23);
		loan_back.add(llblNewLabel_112);
		
		JButton lbtnNewButton_117 = new JButton("�ݱ�");
		lbtnNewButton_117.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loan_back.setVisible(false);
			}
		});
		lbtnNewButton_117.setBounds(67, 129, 91, 23);
		loan_back.add(lbtnNewButton_117);
		loan_back.setVisible(false);
		//���� ��ȯ ����â ��
		
		//���� ��ȯ ����â ����
		
		
		
		loanb_label="�ܾ��� �����մϴ�.";
				JPanel loan_back1 = new JPanel();
				loan_back1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				loan_back1.setBounds(268, 59, 229, 200);
				GamePage_loan.add(loan_back1);
				loan_back1.setLayout(null);
				Color coco111=new Color(234,234,234);
				loan_back1.setBackground(coco111);
				JLabel llblNewLabel_1112 = new JLabel(loanb_label);
				llblNewLabel_1112.setBounds(12, 53, 205, 23);
				loan_back1.add(llblNewLabel_1112);
				
				JButton lbtnNewButton_1117 = new JButton("�ݱ�");
				lbtnNewButton_1117.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loan_back1.setVisible(false);
					}
				});
				lbtnNewButton_1117.setBounds(67, 129, 91, 23);
				loan_back1.add(lbtnNewButton_1117);
				loan_back1.setVisible(false);
		//���� ��ȯ ����â ��
		
		//1-1 ���� ����
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 258, 413);
		GamePage_loan.add(panel);
		panel.setLayout(null);
		
		
		btnNewButton_2.setBounds(12, 10, 230, 23);
		panel.add(btnNewButton_2);
		
		
		lblNewLabel_3.setBounds(10, 210, 240, 15);
		panel.add(lblNewLabel_3);
		
		
		label_12.setBounds(10, 228, 287, 15);
		panel.add(label_12);
		
		
		label_13.setBounds(10, 246, 240, 15);
		panel.add(label_13);
		
		
		label_14.setBounds(10, 264, 240, 15);
		panel.add(label_14);
		
		JLabel lblNewLabel_4 = new JLabel("����: ");
		lblNewLabel_4.setBounds(10, 43, 70, 15);
		panel.add(lblNewLabel_4);
		
	
		lblNewLabel_5.setBounds(92, 43, 150, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("�ݸ�: ");
		lblNewLabel_6.setBounds(10, 66, 50, 15);
		panel.add(lblNewLabel_6);
		
		
		lblNewLabel_7.setBounds(92, 66, 50, 15);
		panel.add(lblNewLabel_7);
		
		JLabel label_15 = new JLabel("����: ");
		label_15.setBounds(10, 91, 50, 15);
		panel.add(label_15);
		
	
		label_16.setBounds(92, 91, 150, 15);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("�Ѿ�: ");
		label_17.setBounds(10, 116, 50, 15);
		panel.add(label_17);
		
		
		label_18.setBounds(92, 116, 150, 15);
		panel.add(label_18);
		
		
		label_20.setBounds(92, 140, 150, 15);
		panel.add(label_20);
		
		JLabel label_21 = new JLabel("������: ");
		label_21.setBounds(10, 141, 50, 15);
		panel.add(label_21);
		
		textField = new JTextField(16);
		textField.setBounds(12, 359, 169, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("\uD655\uC778");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=textField.getText();
				loan_back.setBounds(18, 59, 229, 200);
				loan_back1.setBounds(18, 59, 229, 200);
				if(Long.valueOf(text1)<userdata.Get_own())
				{
					
					if(loan_ex2[0]<=Long.valueOf(text1))
					{
						loan_ex-=loan_ex2[0];
						userdata.Put_own(-loan_ex2[0]);
						loan_ex2[0]=0;
						su_loan[0]=1;
						panel.setVisible(false);
						su_panel.setVisible(true);
						if(level==3&&su_loan[1]==0&&su_loan[2]==0)
						{
							low_level=2;
							d_day+=200;
						}
						else if(level==3&&su_loan[1]==1&&su_loan[2]==0)
							d_day+=300;
						if(su_loan[2]==1&&su_loan[1]==1)
							{
							frame.remove(ToolBar);
							frame.remove(GamePage_change);
							frame.remove(GamePage_state);
							frame.remove(GamePage_loan);
							frame.remove(levelpanel);
							ending=2;
							f.setVisible(true);
							Canvas c = new Canvas();  
							c.setBackground(Color.black);
							JPanel p = new JPanel();
							p.setLayout(new BorderLayout());
							p.add(c);
							f.getContentPane().add(p);
							NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
							Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
							MediaPlayerFactory mpf = new MediaPlayerFactory();
							EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new DefaultFullScreenStrategy(f));
							emp.setVideoSurface(mpf.newVideoSurface(c));
							//emp.toggleFullScreen();
							emp.setEnableMouseInputHandling(false);
							emp.setEnableKeyInputHandling(true);
							p.setVisible(true);
							String file="imrich.mp4";
							emp.prepareMedia(file);
							frame.dispose();
							emp.play();
							}
						
					}
					else
					{
						loan_ex-=Long.valueOf(text1);
						userdata.Put_own(-Long.valueOf(text1));
						loan_ex2[0]=loan_ex2[0]-Long.valueOf(text1);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
						label_18.setText(momo.format(loan_ex2[0]));
						loan_back.setVisible(true);
					}
				}
				else
				{
					loan_back1.setVisible(true);
				}
			}
		});
		btnNewButton_9.setBounds(185, 359, 61, 23);
		panel.add(btnNewButton_9);
		
		JLabel label_44 = new JLabel("\uC0C1\uD658 \uAE08\uC561 \uC785\uB825");
		label_44.setBounds(12, 334, 91, 15);
		panel.add(label_44);
		// 1-1 ���� ��
		
		// 1-2 ���� ����
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(516, 0, 259, 413);
		GamePage_loan.add(panel_2);
		
	
		button_2.setBounds(12, 10, 230, 23);
		panel_2.add(button_2);
		
	
		label_2.setBounds(10, 210, 240, 15);
		panel_2.add(label_2);
		
		
		label_3.setBounds(10, 228, 287, 15);
		panel_2.add(label_3);
		
		
		label_4.setBounds(10, 246, 240, 15);
		panel_2.add(label_4);
		
		
		label_5.setBounds(10, 264, 240, 15);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("\uC6D0\uAE08: ");
		label_6.setBounds(10, 43, 70, 15);
		panel_2.add(label_6);
		
	
		label_7.setBounds(92, 43, 150, 15);
		panel_2.add(label_7);
		
		JLabel label_22 = new JLabel("\uAE08\uB9AC: ");
		label_22.setBounds(10, 66, 50, 15);
		panel_2.add(label_22);
		
	
		label_23.setBounds(92, 66, 50, 15);
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("\uC774\uC790: ");
		label_24.setBounds(10, 91, 50, 15);
		panel_2.add(label_24);
		
	
		label_25.setBounds(92, 91, 150, 15);
		panel_2.add(label_25);
		
		JLabel label_26 = new JLabel("\uCD1D\uC561: ");
		label_26.setBounds(10, 116, 50, 15);
		panel_2.add(label_26);
		
		
		label_27.setBounds(92, 116, 150, 15);
		panel_2.add(label_27);
		
		
		label_28.setBounds(92, 140, 150, 15);
		panel_2.add(label_28);
		
		JLabel label_29 = new JLabel("\uB9CC\uAE30\uC77C: ");
		label_29.setBounds(10, 141, 50, 15);
		panel_2.add(label_29);
		
		JLabel label_46 = new JLabel("\uC0C1\uD658 \uAE08\uC561 \uC785\uB825");
		label_46.setBounds(12, 340, 91, 15);
		panel_2.add(label_46);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 357, 169, 21);
		panel_2.add(textField_2);
		
		JButton button_5 = new JButton("\uD655\uC778");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=textField_2.getText();
				loan_back.setBounds(530, 59, 229, 200);
				loan_back1.setBounds(530, 59, 229, 200);
				if(Long.valueOf(text1)<userdata.Get_own())
				{
					
					if(loan_ex2[2]<=Long.valueOf(text1))
					{
						loan_ex-=loan_ex2[2];
						userdata.Put_own(-loan_ex2[2]);
						loan_ex2[2]=0;
						su_loan[2]=1;
						panel_2.setVisible(false);
						su_panel_2.setVisible(true);
						if(level==3&&su_loan[0]==1&&su_loan[2]==0)
							d_day+=100;
						if(su_loan[1]==1&&su_loan[0]==1)
							{
							frame.remove(ToolBar);
							frame.remove(GamePage_change);
							frame.remove(GamePage_state);
							frame.remove(GamePage_loan);
							frame.remove(levelpanel);
							ending=2;
							f.setVisible(true);
							Canvas c = new Canvas();  
							c.setBackground(Color.black);
							JPanel p = new JPanel();
							p.setLayout(new BorderLayout());
							p.add(c);
							f.getContentPane().add(p);
							NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
							Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
							MediaPlayerFactory mpf = new MediaPlayerFactory();
							EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new DefaultFullScreenStrategy(f));
							emp.setVideoSurface(mpf.newVideoSurface(c));
						//	emp.toggleFullScreen();
							emp.setEnableMouseInputHandling(false);
							emp.setEnableKeyInputHandling(true);
							p.setVisible(true);
							String file="imrich.mp4";
							emp.prepareMedia(file);
							frame.dispose();
							emp.play();
							}
						
					}
					else
					{
						loan_ex-=Long.valueOf(text1);
						
					userdata.Put_own(-Long.valueOf(text1));
					loan_ex2[2]=loan_ex2[2]-Long.valueOf(text1);
					money_label=momo.format(userdata.Get_own());
					lblNewLabel.setText(":"+money_label+"��");
					label_27.setText(momo.format(loan_ex2[2]));
					loan_back.setVisible(true);
					}
				}
				else
				{
					loan_back1.setVisible(true);
				}
			}
		});
		button_5.setBounds(185, 356, 61, 23);
		panel_2.add(button_5);
		//1-2 ���� ��
		
		//1-3 ���� ����
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(258, 0, 259, 413);
		GamePage_loan.add(panel_1);
		
		
		button_3.setBounds(12, 10, 230, 23);
		panel_1.add(button_3);
		
	
		label_30.setBounds(10, 210, 240, 15);
		panel_1.add(label_30);
		
		
		label_31.setBounds(10, 228, 287, 15);
		panel_1.add(label_31);
		
		
		label_32.setBounds(10, 246, 240, 15);
		panel_1.add(label_32);
		
		
		label_33.setBounds(10, 264, 240, 15);
		panel_1.add(label_33);
		
		JLabel label_34 = new JLabel("\uC6D0\uAE08: ");
		label_34.setBounds(10, 43, 70, 15);
		panel_1.add(label_34);
		
		
		label_35.setBounds(92, 43, 150, 15);
		panel_1.add(label_35);
		
		JLabel label_36 = new JLabel("\uAE08\uB9AC: ");
		label_36.setBounds(10, 66, 50, 15);
		panel_1.add(label_36);
		
		
		label_37.setBounds(92, 66, 50, 15);
		panel_1.add(label_37);
		
		JLabel label_38 = new JLabel("\uC774\uC790: ");
		label_38.setBounds(10, 91, 50, 15);
		panel_1.add(label_38);
		
		
		label_39.setBounds(92, 91, 150, 15);
		panel_1.add(label_39);
		
		JLabel label_40 = new JLabel("\uCD1D\uC561: ");
		label_40.setBounds(10, 116, 50, 15);
		panel_1.add(label_40);
		
		
		label_41.setBounds(92, 116, 150, 15);
		panel_1.add(label_41);
		
	
		label_42.setBounds(92, 140, 91, 15);
		panel_1.add(label_42);
		
		JLabel label_43 = new JLabel("\uB9CC\uAE30\uC77C: ");
		label_43.setBounds(10, 141, 50, 15);
		panel_1.add(label_43);
		
		JLabel label_45 = new JLabel("\uC0C1\uD658 \uAE08\uC561 \uC785\uB825");
		label_45.setBounds(12, 334, 91, 15);
		panel_1.add(label_45);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 359, 169, 21);
		panel_1.add(textField_1);
		
		JButton button_4 = new JButton("\uD655\uC778");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1=textField_1.getText();
				loan_back.setBounds(268, 59, 229, 200);
				loan_back1.setBounds(268, 59, 229, 200);
				if(Long.valueOf(text1)<userdata.Get_own())
				{
					if(loan_ex2[1]<=Long.valueOf(text1))
					{
						loan_ex-=loan_ex2[1];
						userdata.Put_own(-loan_ex2[1]);
						loan_ex2[1]=0;
						su_loan[1]=1;
						panel_1.setVisible(false);
						su_panel_1.setVisible(true);
						if(su_loan[2]==1&&su_loan[0]==1)
						{
							frame.remove(ToolBar);
							frame.remove(GamePage_change);
							frame.remove(GamePage_state);
							frame.remove(GamePage_loan);
							frame.remove(levelpanel);
							ending=2;
							f.setVisible(true);
							Canvas c = new Canvas();  
							c.setBackground(Color.black);
							JPanel p = new JPanel();
							p.setLayout(new BorderLayout());
							p.add(c);
							f.getContentPane().add(p);
							NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
							Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
							MediaPlayerFactory mpf = new MediaPlayerFactory();
							EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new DefaultFullScreenStrategy(f));
							emp.setVideoSurface(mpf.newVideoSurface(c));
						//	emp.toggleFullScreen();
							emp.setEnableMouseInputHandling(false);
							emp.setEnableKeyInputHandling(true);
							p.setVisible(true);
							String file="imrich.mp4";
							emp.prepareMedia(file);
							frame.dispose();
							emp.play();
						}
						
					}
					else
					{
						loan_ex-=Long.valueOf(text1);
						
						userdata.Put_own(-Long.valueOf(text1));
						loan_ex2[1]=loan_ex2[1]-Long.valueOf(text1);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
						label_41.setText(momo.format(loan_ex2[1]));
						loan_back.setVisible(true);
					}
				}
				else
				{
					loan_back1.setVisible(true);
				}
			}
		});
		button_4.setBounds(185, 359, 61, 23);
		panel_1.add(button_4);
	    
	      
	    //�ʱ�ȭ�� ���� ��
		


		//��Ȳ ���� ����
		
		GamePage_state.setBounds(0, 39, 776, 413);
		frame.getContentPane().add(GamePage_state);
		
		GamePage_state.setLayout(null);
		home_set1="�̺���";
		home_set2="�̺���";
		home_set3="�̺���";
		home_set4="�̺���";
		home_set5="�̺���";
		home_set6="�̺���";
		home_set11=false;
		home_set12=false;
		home_set13=false;
		home_set14=false;
		home_set15=false;
		home_set16=false;
		
		//��Ȳ ���� ��
	
	
		//���ż���â ����
				JPanel buy_home11 = new JPanel();
				buy_home11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buy_home11.setBounds(268, 59, 229, 200);
				GamePage_state.add(buy_home11);
				buy_home11.setLayout(null);
				Color lcoco11=new Color(234,234,234);
				buy_home11.setBackground(lcoco11);
				
				buy_label="���� �����ϼ̽��ϴ�.";
				JLabel lblNewLabel_112 = new JLabel(buy_label);
				lblNewLabel_112.setBounds(12, 53, 205, 23);
				buy_home11.add(lblNewLabel_112);
				
				JButton btnNewButton_117 = new JButton("�ݱ�");
				btnNewButton_117.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buy_home11.setVisible(false);
					}
				});
				btnNewButton_117.setBounds(67, 129, 91, 23);
				buy_home11.add(btnNewButton_117);
				buy_home11.setVisible(false);
				//���ż���â ��
				
				//���Ž���â ����
				JPanel buy_home111 = new JPanel();
				buy_home111.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buy_home111.setBounds(268, 59, 229, 200);
				GamePage_state.add(buy_home111);
				buy_home111.setLayout(null);
				Color Lcoco111=new Color(234,234,234);
				buy_home111.setBackground(Lcoco111);
						
				buy_label="������ �����մϴ�.";
				JLabel lblNewLabel_1112 = new JLabel(buy_label);
				lblNewLabel_1112.setBounds(12, 53, 205, 23);
				buy_home111.add(lblNewLabel_1112);
						
				JButton btnNewButton_1117 = new JButton("�ݱ�");
				btnNewButton_1117.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buy_home111.setVisible(false);
					}
				});
				btnNewButton_1117.setBounds(67, 129, 91, 23);
				buy_home111.add(btnNewButton_1117);
				buy_home111.setVisible(false);
				//���Ž���â ��
		
		//����â ����
		JPanel buy_home = new JPanel();
		buy_home.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buy_home.setBounds(268, 59, 229, 200);
		GamePage_state.add(buy_home);
		buy_home.setLayout(null);
		Color coco=new Color(234,234,234);
		buy_home.setBackground(coco);
		
		JButton btnNewButton_7 = new JButton("��");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home.setVisible(false);
				if(userdata.Get_own()<price)
				{
					buy_home111.setVisible(true);
				
				}
				else
				{
					userdata.Put_own(-price);
					money_label=momo.format(userdata.Get_own());
					lblNewLabel.setText(":"+money_label+"��");
					buy_home11.setVisible(true);
					if(home_set11)
					{
						building[0]=1;
						home_set1="������";
						btnNewButton_15.setText(home_set1);
						home_set11=false;
					}
					else if(home_set12)
					{
						building[1]=1;
						home_set2="������";
						btnNewButton_5.setText(home_set2);
						home_set12=false;
					}
					else if(home_set13)
					{
						building[2]=1;
						home_set3="������";
						btnNewButton_115.setText(home_set3);
						home_set13=false;
					}
					else if(home_set14)
					{
						building[3]=1;
						home_set4="������";
						btnNewButton_1115.setText(home_set4);
						home_set14=false;
					}
					else if(home_set15)
					{
						building[4]=1;
						home_set5="������";
						btnNewButton_11115.setText(home_set5);
						home_set15=false;
					}
					else
					{
						building[5]=1;
						home_set6="������";
						btnNewButton_111115.setText(home_set6);
						home_set16=false;
					}
					
				}
				
			}
	    });
		btnNewButton_7.setBounds(12, 129, 91, 23);
		buy_home.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("�ƴϿ�");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home.setVisible(false);
        		
			}
		});
		btnNewButton_8.setBounds(126, 129, 91, 23);
		buy_home.add(btnNewButton_8);
		buy_label="���� �Ͻðڽ��ϱ�?";
		JLabel lblNewLabel_2 = new JLabel(buy_label);
		lblNewLabel_2.setBounds(12, 53, 205, 23);
		buy_home.add(lblNewLabel_2);
		
		buy_home.setVisible(false);
		
		//����â ��
		
		
		//�Ǹż���â ����
		JPanel buy_home1111 = new JPanel();
		buy_home1111.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buy_home1111.setBounds(268, 59, 229, 200);
		GamePage_state.add(buy_home1111);
		buy_home1111.setLayout(null);
		Color coco1111=new Color(234,234,234);
		buy_home1111.setBackground(coco1111);
		
		buy_label="�Ǹ� �����ϼ̽��ϴ�.";
		JLabel lblNewLabel_11112 = new JLabel(buy_label);
		lblNewLabel_11112.setBounds(12, 53, 205, 23);
		buy_home1111.add(lblNewLabel_11112);
		
		JButton btnNewButton_11117 = new JButton("�ݱ�");
		btnNewButton_11117.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home1111.setVisible(false);
				
			}
		});
		btnNewButton_11117.setBounds(67, 129, 91, 23);
		buy_home1111.add(btnNewButton_11117);
		buy_home1111.setVisible(false);
		//�Ǹż���â ��
		
		//�ǸŽ���â ����
		JPanel buy_home11111 = new JPanel();
		buy_home11111.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buy_home11111.setBounds(268, 59, 229, 200);
		GamePage_state.add(buy_home11111);
		buy_home11111.setLayout(null);
		Color coco11111=new Color(234,234,234);
		buy_home11111.setBackground(coco11111);
				
		buy_label="�ش� ���� ���������� �ʽ��ϴ�.";
		JLabel lblNewLabel_111112 = new JLabel(buy_label);
		lblNewLabel_111112.setBounds(12, 53, 205, 23);
		buy_home11111.add(lblNewLabel_111112);
				
		JButton btnNewButton_111117 = new JButton("�ݱ�");
		btnNewButton_111117.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home11111.setVisible(false);
			}
		});
		btnNewButton_111117.setBounds(67, 129, 91, 23);
		buy_home11111.add(btnNewButton_111117);
		buy_home11111.setVisible(false);
		//�ǸŽ���â ��
		
		//�Ǹ�â ����
		JPanel buy_home1 = new JPanel();
		buy_home1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buy_home1.setBounds(268, 59, 229, 200);
		GamePage_state.add(buy_home1);
		buy_home1.setLayout(null);
		Color coco1=new Color(234,234,234);
		buy_home1.setBackground(coco1);
				
		JButton btnNewButton_17 = new JButton("��");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home1.setVisible(false);
				
				
				if(home_set11)
				{
					if(home_set1=="������")
					{
						building[0]=0;
						buy_home1111.setVisible(true);
						home_set1="�̺���";
						btnNewButton_15.setText(home_set1);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set11=false;
				}
				else if(home_set12)
				{
					if(home_set2=="������")
					{
						building[1]=0;
						buy_home1111.setVisible(true);
						home_set2="�̺���";
						btnNewButton_5.setText(home_set2);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set12=false;
				}
				else if(home_set13)
				{
					if(home_set3=="������")
					{
						building[2]=0;
						buy_home1111.setVisible(true);
						home_set3="�̺���";
						btnNewButton_115.setText(home_set3);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set13=false;
				}
				else if(home_set14)
				{
					if(home_set4=="������")
					{
						building[3]=0;
						buy_home1111.setVisible(true);
						home_set4="�̺���";
						btnNewButton_1115.setText(home_set4);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set14=false;
				}
				else if(home_set15)
				{
					if(home_set5=="������")
					{
						building[4]=0;
						buy_home1111.setVisible(true);
						home_set5="�̺���";
						btnNewButton_11115.setText(home_set5);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set15=false;
				}
				else
				{
					if(home_set6=="������")
					{
						building[5]=0;
						buy_home1111.setVisible(true);
						home_set6="�̺���";
						btnNewButton_111115.setText(home_set6);
						userdata.Put_own(price);
						money_label=momo.format(userdata.Get_own());
						lblNewLabel.setText(":"+money_label+"��");
					}
					else
					{
						buy_home11111.setVisible(true);
					}
					home_set16=false;
				}
				
			}
		});
		btnNewButton_17.setBounds(12, 129, 91, 23);
		buy_home1.add(btnNewButton_17);
				
		JButton btnNewButton_18 = new JButton("�ƴϿ�");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy_home1.setVisible(false);
		        		
			}
		});
		btnNewButton_18.setBounds(126, 129, 91, 23);
		buy_home1.add(btnNewButton_18);
		buy_label="�Ǹ� �Ͻðڽ��ϱ�?";
		JLabel lblNewLabel_12 = new JLabel(buy_label);
		lblNewLabel_12.setBounds(12, 53, 205, 23);
		buy_home1.add(lblNewLabel_12);
				
		buy_home1.setVisible(false);
				
		//�Ǹ�â ��
		
		//��Ȳ ��� ����
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.setFont(UIManager.getFont("ComboBox.font"));
		btnNewButton_1.setBounds(0, 38, 91, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GamePage_state.add(btnNewButton_1);
		
		JButton button = new JButton("��Ʈ����");
		button.setBounds(0, 74, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GamePage_state.add(button);
		
	
		
		lblNewLabel.setBounds(92, 42, 206, 15);
		GamePage_state.add(lblNewLabel);
		
		
		
		
		
		label.setBounds(92, 78, 50, 15);
		GamePage_state.add(label);
		
		JButton button_1 = new JButton("����");
		button_1.setBounds(0, 107, 91, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GamePage_state.add(button_1);
		
		
		label_1.setBounds(92, 111, 111, 15);
		GamePage_state.add(label_1);
		
		
		//��Ȳ ��� ��
		
		//��ũ�� �г� ����
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 209, 770, 197);
		GamePage_state.add(scrollPane);
	
		
        JPanel home_panel = new JPanel();
        Dimension size = new Dimension();//����� �����ϱ� ���� ��ü ����
        size.setSize(2550, 100);//��ü�� ����� ����
        home_panel.setPreferredSize(size);//������ ������ ������ �ִ� ��ü�� �̿��� �г��� ������ ����
        scrollPane.setViewportView(home_panel);
        home_panel.setLayout(null);
       
        //��ũ�� �гγ�
        
        //¯���� ����
        JLabel btnNewButton_3 = new JLabel("");
        btnNewButton_3.setIcon(new ImageIcon("./1.png"));
        btnNewButton_3.setBounds(412, 10, 144, 130);
        home_panel.add(btnNewButton_3);
        
        JLabel label_8 = new JLabel("\uD5C8\uB984\uD55C \uC8FC\uD0DD");
        label_8.setBounds(568, 10, 91, 15);
        home_panel.add(label_8);
        
        JLabel lblNewLabel_1 = new JLabel("\uC5B4\uB290 \uC791\uACE0 \uC544\uB2F4\uD55C 2\uCE35 \uC8FC\uD0DD\uC774\uB2E4.");
        lblNewLabel_1.setBounds(568, 30, 184, 20);
        home_panel.add(lblNewLabel_1);
        
        JLabel label_9 = new JLabel("4\uC778\uAC00\uC871\uC774 \uC0B4\uAE30 \uC54C\uB9DE\uC740\uAC83 \uAC19\uB2E4.");
        label_9.setBounds(568, 49, 184, 20);
        home_panel.add(label_9);
        
        JLabel label_10 = new JLabel("\uD3ED\uD30C\uB41C \uC801\uC774 \uC788\uC73C\uB2C8 \uBCF4\uD5D8\uC744 \uB4E4\uAC83.");
        label_10.setBounds(568, 68, 184, 20);
        home_panel.add(label_10);
        
        JLabel label_11 = new JLabel("$: 3\uC5B5 2\uCC9C\uB9CC\uC6D0");
        label_11.setBounds(568, 120, 85, 20);
        home_panel.add(label_11);
        
        JButton btnNewButton_4 = new JButton("\uAD6C\uB9E4");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 320000000L;
        		home_set12=true;
        	
        	}
        });
        btnNewButton_4.setBounds(412, 150, 91, 23);
        home_panel.add(btnNewButton_4);
        
        
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_5.setBounds(665, 117, 91, 23);
        home_panel.add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton("\uD310\uB9E4");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 320000000L;
        		home_set12=true;
        	}
        });
        btnNewButton_6.setBounds(515, 150, 91, 23);
        home_panel.add(btnNewButton_6);
        //¯������ ��
        
        
        //�͸������ ����
        JLabel btnNewButton_41 = new JLabel("");
        btnNewButton_41.setIcon(new ImageIcon("./2.png"));
        btnNewButton_41.setBounds(12, 10, 144, 130);
        home_panel.add(btnNewButton_41);
        
        JLabel label_81 = new JLabel("\uBB34\uB108\uC9C0\uAE30 \uC9C1\uC804\uC758 \uBA58\uC158");
        label_81.setBounds(168, 10, 120, 15);
        home_panel.add(label_81);
        
        JLabel lblNewLabel_11 = new JLabel("\uACE7 \uBB34\uB108\uC9C8\uAC83 \uAC19\uC740 \uBA58\uC158\uC774\uB2E4.");
        lblNewLabel_11.setBounds(168, 30, 184, 20);
        home_panel.add(lblNewLabel_11);
        
        JLabel label_19 = new JLabel("\uB3C8\uC774 \uC5C6\uC73C\uBA74 \uC0B4\uAE30 \uC54C\uB9DE\uC740\uAC83 \uAC19\uB2E4.");
        label_19.setBounds(168, 49, 184, 20);
        home_panel.add(label_19);
        
        JLabel label_110 = new JLabel("\uC0DD\uBA85\uBCF4\uD5D8\uC740 \uD544\uC218\uB2E4.");
        label_110.setBounds(168, 68, 184, 20);
        home_panel.add(label_110);
        
        JLabel label_111 = new JLabel("$: 6\uCC9C\uB9CC\uC6D0");
        label_111.setBounds(168, 120, 77, 20);
        home_panel.add(label_111);
        
        JButton btnNewButton_14 = new JButton("\uAD6C\uB9E4");
        btnNewButton_14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 60000000L;
        		home_set11=true;
        	}
        });
        btnNewButton_14.setBounds(12, 150, 91, 23);
        home_panel.add(btnNewButton_14);
        
      
        btnNewButton_15.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_15.setBounds(250, 117, 91, 23);
        home_panel.add(btnNewButton_15);
        
        JButton btnNewButton_16 = new JButton("\uD310\uB9E4");
        btnNewButton_16.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 60000000L;
        		home_set11=true;
        	}
        });
        btnNewButton_16.setBounds(115, 150, 91, 23);
        home_panel.add(btnNewButton_16);
		//�͸����Ǽǳ�
		
        
        //�Ϲݾ���Ʈ ����
        JLabel btnNewButton_141 = new JLabel("");
        btnNewButton_141.setIcon(new ImageIcon("./6.png"));
        btnNewButton_141.setBounds(812, 10, 144, 130);
        home_panel.add(btnNewButton_141);
        
        JLabel label_181 = new JLabel("���� ����Ʈ");
        label_181.setBounds(968, 10, 120, 15);
        home_panel.add(label_181);
        
        JLabel lblNewLabel_111 = new JLabel("�߻������ ��� ����Ʈ��.");
        lblNewLabel_111.setBounds(968, 30, 184, 20);
        home_panel.add(lblNewLabel_111);
        
        JLabel label_119 = new JLabel("'�� ���� ���~'�� �ֱ��غ���");
        label_119.setBounds(968, 49, 184, 20);
        home_panel.add(label_119);
        
        JLabel label_1110 = new JLabel("�ֺ����� �ٽ� �� ���̴�(�Ƹ���)");
        label_1110.setBounds(968, 68, 184, 20);
        home_panel.add(label_1110);
        
        JLabel label_1111 = new JLabel("$: 10�� 5õ����");
        label_1111.setBounds(968, 120, 85, 20);
        home_panel.add(label_1111);
        
        JButton btnNewButton_114 = new JButton("\uAD6C\uB9E4");
        btnNewButton_114.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 1050000000L;
        		home_set13=true;
        	}
        });
        btnNewButton_114.setBounds(812, 150, 91, 23);
        home_panel.add(btnNewButton_114);
        
        
        btnNewButton_115.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_115.setBounds(1065, 117, 91, 23);
        home_panel.add(btnNewButton_115);
        
        JButton btnNewButton_116 = new JButton("\uD310\uB9E4");
        btnNewButton_116.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 1050000000L;
        		home_set13=true;
        	}
        });
        btnNewButton_116.setBounds(915, 150, 91, 23);
        home_panel.add(btnNewButton_116);
		//�Ϲݾ���Ʈ��
        
        //��޾���Ʈ ����
        JLabel btnNewButton_1141 = new JLabel("");
        btnNewButton_1141.setIcon(new ImageIcon("./5.png"));
        btnNewButton_1141.setBounds(1212, 10, 144, 130);
        home_panel.add(btnNewButton_1141);
        
        JLabel label_1181 = new JLabel("�������� �����");
        label_1181.setBounds(1368, 10, 120, 15);
        home_panel.add(label_1181);
        
        JLabel lblNewLabel_1111 = new JLabel("������ ����� ��°��̴�.");
        lblNewLabel_1111.setBounds(1368, 30, 184, 20);
        home_panel.add(lblNewLabel_1111);
        
        JLabel label_1119 = new JLabel("���ڴ� ����ڰ� �Ѹ��� �ƴϴ�.");
        label_1119.setBounds(1368, 49, 184, 20);
        home_panel.add(label_1119);
        
        JLabel label_11110 = new JLabel("��ġ�� �������� ��������");
        label_11110.setBounds(1368, 68, 184, 20);
        home_panel.add(label_11110);
        
        JLabel label_11111 = new JLabel("$: 80�� 9õ����");
        label_11111.setBounds(1368, 120, 85, 20);
        home_panel.add(label_11111);
        
        JButton btnNewButton_1114 = new JButton("\uAD6C\uB9E4");
        btnNewButton_1114.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 8090000000L;
        		home_set14=true;
        	}
        });
        btnNewButton_1114.setBounds(1212, 150, 91, 23);
        home_panel.add(btnNewButton_1114);
        
        
        btnNewButton_1115.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1115.setBounds(1465, 117, 91, 23);
        home_panel.add(btnNewButton_1115);
        
        JButton btnNewButton_1116 = new JButton("\uD310\uB9E4");
        btnNewButton_1116.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 8090000000L;
        		home_set14=true;
        	}
        });
        btnNewButton_1116.setBounds(1315, 150, 91, 23);
        home_panel.add(btnNewButton_1116);
		//��޾���Ʈ��
        
        
        //63���� ����
        JLabel btnNewButton_11141 = new JLabel("");
        btnNewButton_11141.setIcon(new ImageIcon("./4.png"));
        btnNewButton_11141.setBounds(1612, 10, 144, 130);
        home_panel.add(btnNewButton_11141);
        
        JLabel label_11181 = new JLabel("63 ����");
        label_11181.setBounds(1768, 10, 120, 15);
        home_panel.add(label_11181);
        
        JLabel lblNewLabel_11111 = new JLabel("��� 63������ ������ �����ߴ�.");
        lblNewLabel_11111.setBounds(1768, 30, 184, 20);
        home_panel.add(lblNewLabel_11111);
        
        JLabel label_11119 = new JLabel("�������� ū���� �Ǿ� 63������ ��������");
        label_11119.setBounds(1768, 49, 224, 20);
        home_panel.add(label_11119);
        
        JLabel label_111110 = new JLabel("���̵��� �λ��� ���������Ѵ�.");
        label_111110.setBounds(1768, 68, 184, 20);
        home_panel.add(label_111110);
        
        JLabel label_111111 = new JLabel("$: 9130�� 2õ����");
        label_111111.setBounds(1768, 120, 100, 20);
        home_panel.add(label_111111);
        
        JButton btnNewButton_11114 = new JButton("\uAD6C\uB9E4");
        btnNewButton_11114.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 913020000000L;
        		home_set15=true;
        	}
        });
        btnNewButton_11114.setBounds(1612, 150, 91, 23);
        home_panel.add(btnNewButton_11114);
        
        
        btnNewButton_11115.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_11115.setBounds(1885, 117, 91, 23);
        home_panel.add(btnNewButton_11115);
        
        JButton btnNewButton_11116 = new JButton("\uD310\uB9E4");
        btnNewButton_11116.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 913020000000L;
        		home_set15=true;
        	}
        });
        btnNewButton_11116.setBounds(1715, 150, 91, 23);
        home_panel.add(btnNewButton_11116);
		//63������
        
        
       //��ǰ� ����
        JLabel btnNewButton_111141 = new JLabel("");
        btnNewButton_111141.setIcon(new ImageIcon("./3.png"));
        btnNewButton_111141.setBounds(2062, 10, 144, 130);
        home_panel.add(btnNewButton_111141);
        
        JLabel label_111181 = new JLabel("��ǰ�");
        label_111181.setBounds(2218, 10, 120, 15);
        home_panel.add(label_111181);
        
        JLabel lblNewLabel_111111 = new JLabel("�̱��� ���� ��� ���� ����.");
        lblNewLabel_111111.setBounds(2218, 30, 184, 20);
        home_panel.add(lblNewLabel_111111);
        
        JLabel label_111119 = new JLabel("�ν����ϵ�� �̹� �ѹ� �����ȴ�.");
        label_111119.setBounds(2218, 49, 284, 20);
        home_panel.add(label_111119);
        
        JLabel label_1111110 = new JLabel("����� �̹� �� �տ� �ִ�.");
        label_1111110.setBounds(2218, 68, 184, 20);
        home_panel.add(label_1111110);
        
        JLabel label_1111112 = new JLabel("��� ���� �����ϰ��� ������ ���Ҵ�.");
        label_1111112.setBounds(2218, 87, 284, 20);
        home_panel.add(label_1111112);
        
        JLabel label_1111111 = new JLabel("$: 3280����");
        label_1111111.setBounds(2218, 120, 100, 20);
        home_panel.add(label_1111111);
        
        JButton btnNewButton_111114 = new JButton("\uAD6C\uB9E4");
        btnNewButton_111114.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home1.setVisible(false);
        		buy_home.setVisible(true);
        		price = 3280000000000000L;
        		home_set16=true;
        	}
        });
        btnNewButton_111114.setBounds(2062, 150, 91, 23);
        home_panel.add(btnNewButton_111114);
        
        
        btnNewButton_111115.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_111115.setBounds(2335, 117, 91, 23);
        home_panel.add(btnNewButton_111115);
        
        JButton btnNewButton_111116 = new JButton("\uD310\uB9E4");
        btnNewButton_111116.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buy_home.setVisible(false);
        		buy_home1.setVisible(true);
        		price = 3280000000000000L;
        		home_set16=true;
        	}
        });
        btnNewButton_111116.setBounds(2165, 150, 91, 23);
        home_panel.add(btnNewButton_111116);
		//��ǰ���
        
        //�г� ����� �۾� ����
        home_panel.setVisible(false);
        scrollPane.setVisible(false);
        homeset=true; // �г� ������ ����
        //�г� ����� �۾� ��
        
        //�г� �˾� ��ư ���� ����
		JButton home = new JButton("��");
		home.setBounds(0, 187, 91, 23);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(homeset)
				{
					home_panel.setVisible(true);
					 scrollPane.setVisible(true);
					homeset=false;
					money_label=momo.format(userdata.Get_own());
					lblNewLabel.setText(":"+money_label+"��");
					loan_label=momo.format(loan_ex);
					label_1.setText(":"+loan_label+"��"); 
					bit_label=momo.format(userdata.Get_bit());
					label.setText(":"+bit_label+"��");
					btnNewButton_15.setText(home_set1);
					btnNewButton_5.setText(home_set2);
					btnNewButton_115.setText(home_set3);
					btnNewButton_1115.setText(home_set4);
					btnNewButton_11115.setText(home_set5);
					btnNewButton_111115.setText(home_set6);
				}
				else
				{
					home_panel.setVisible(false);
					 scrollPane.setVisible(false);
					homeset=true;
					
				}
			}
		});
		GamePage_state.add(home);
		
		
		 //�г� �˾� ��ư ���� ��
		
		
	
		
		
		GamePage_state.setVisible(false);
		
		
	
		GamePage_change.setBounds(0, 39, 776, 413);
		frame.getContentPane().add(GamePage_change);
		GamePage_change.setLayout(null);
		GamePage_change.setVisible(false);
		
		
		
		
		ToolBar.setBounds(0, 0, 776, 40);
		frame.getContentPane().add(ToolBar);
		ToolBar.setLayout(null);
		
		JButton state = new JButton("\uD604\uD669");
		state.setBounds(0, 0, 129, 40);
		ToolBar.add(state);
		
		
		change.setBounds(129, 0, 129, 40);
		ToolBar.add(change);
		
		JButton loan = new JButton("\uBD80\uCC44");
		loan.setBounds(258, 0, 129, 40);
		ToolBar.add(loan);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.addActionListener(new ActionListener() {				//���� SAVE
			public void actionPerformed(ActionEvent e) {
				save.Save_Data(id,passwd,level,userdata, loan_ex, loan_ex1, loan_ex2, su_loan, d_day, building);
			}
		});
		btnNewButton.setBounds(647, 0, 129, 40);
		ToolBar.add(btnNewButton);
		
			     
		//1-3 ���� ��
		
		
		
		
		
		//�ʱ�ȭ�� ���� ����
		
		
			      
			      
		ToolBar.setVisible(false);
		
		
		
		state.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GamePage_state.setVisible(true);
				GamePage_loan.setVisible(false);
				GamePage_change.setVisible(false);
				ToolBar.setVisible(true);
				home_panel.setVisible(false);
				buy_home.setVisible(false);
        		buy_home1.setVisible(false);
        		scrollPane.setVisible(false);
        		buy_home11.setVisible(false);
        		buy_home111.setVisible(false);
        		
        		money_label=momo.format(userdata.Get_own());
				lblNewLabel.setText(":"+money_label+"��");
				loan_label=momo.format(loan_ex);
				label_1.setText(":"+loan_label+"��"); 
				bit_label=momo.format(userdata.Get_bit());
				label.setText(":"+bit_label+"��");
				btnNewButton_15.setText(home_set1);
				btnNewButton_5.setText(home_set2);
				btnNewButton_115.setText(home_set3);
				btnNewButton_1115.setText(home_set4);
				btnNewButton_11115.setText(home_set5);
				btnNewButton_111115.setText(home_set6);
				
			

			}
			
		}
		);
		loan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GamePage_state.setVisible(false);
				GamePage_loan.setVisible(true);
				GamePage_change.setVisible(false);
				ToolBar.setVisible(true);
				label_16.setText(momo.format(loan_ex1[0]));
				label_18.setText(momo.format(loan_ex2[0]));
							 loan_text8="D-"+Integer.toString(d_day);
							 label_20.setText(loan_text8);
				label_25.setText(momo.format(loan_ex1[2]));
				label_27.setText(momo.format(loan_ex2[2]));
				if(level!=3)
				{
							 loan_text18="D-"+Integer.toString(d_day);
				}
				else
				{
					if(low_level==2)
					 loan_text18="D-"+Integer.toString(d_day);
					else
					 loan_text18="D-"+Integer.toString(d_day+200);
				}
							 label_28.setText(loan_text18);
				label_39.setText(momo.format(loan_ex1[1]));
				label_41.setText(momo.format(loan_ex2[1]));
				if(level!=3)
				loan_text81="D-"+Integer.toString(d_day);
				else
				{
					if(low_level==2)
					loan_text81="D-"+Integer.toString(d_day);
					else
						loan_text81="D-"+Integer.toString(d_day+300);
				}
							        			label_42.setText(loan_text81);
				
				if(su_loan[0]==1)
				{
					su_panel.setVisible(true);
					panel.setVisible(false);
				}
				else
				{
					panel.setVisible(true);
				}
				if(su_loan[1]==1)
				{
					su_panel_1.setVisible(true);
					panel_1.setVisible(false);
				}
				else
				{
					panel_1.setVisible(true);
				}
				if(su_loan[2]==1)
				{
					su_panel_2.setVisible(true);
					panel_2.setVisible(false);
				}
				else
				{
					panel_2.setVisible(true);
				}
				
				

			}
			
		}
		);
		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GamePage_state.setVisible(false);
				GamePage_loan.setVisible(false);
				GamePage_change.setVisible(true);
				ToolBar.setVisible(true);

			}
			
		}
		);
		
	}
}
