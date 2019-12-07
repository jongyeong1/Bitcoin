package bitcoin
;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

public class Chart extends ApplicationFrame implements ActionListener {

	private Calendar cmp;			//초기 시간 저장
	private Calendar time;			//게임내 시간 저장
	private Calendar Check;	
	private long inter[];
	
	private long Value_of_building[] = {6000,32000,105000,809000,91302000,328000000000L};		// 나누기 1만을 한 값 저장
	private int building[];
	
	private long money[];
	private long rate[];
	private Trade userdata;
	
    private TimeSeries series;
    public double lastValue = 1000;
    Timer timer = new Timer(250, this);
    
    public void Set_Time() {			//시간 초기화
		cmp = Calendar.getInstance();	//현재 시간 부터
		time = Calendar.getInstance();
		Check = Calendar.getInstance();
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
	public void start() {
		
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
    public Chart(final String title) {
        super(title);
        this.series = new TimeSeries("BTC", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);
        timer.setInitialDelay(0);
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        final JPanel content = new JPanel(new BorderLayout());

        final ChartPanel chartPanel = new ChartPanel(chart);

        content.add(chartPanel);

        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        chartPanel.setLayout(null);

        setContentPane(content);

        timer.start();
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Realtime BitCoin Chart",
            "24Hours",
            "One Bit Coin",
            dataset,
            true,
            true,
            false
        );

        final XYPlot plot = result.getXYPlot();

        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);

        //Domain axis would show data of 60 seconds for a time
        xaxis.setFixedAutoRange(60000.0);  // 60 seconds
        xaxis.setVerticalTickLabels(true);

        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 3000.0);

        return result;
    }
    /**
     * Generates an random entry for a particular call made by time for every 1/4th of a second.
     *
     * @param e  the action event.
     */
    public void windowClosing(WindowEvent e) {
       ApplicationFrame frame =(ApplicationFrame)e.getWindow();
       frame.dispose();
       System.out.println("windowClosing()");
       //timer.stop();

    }
    public void windowOpenning(WindowEvent e) {
        timer.start();
       System.out.println("windowaOpenning()");

    }

    public void actionPerformed(final ActionEvent e) {
       
       int RandoH=(int)(Math.random()*100)+1;  //1에서 100까지의 랜덤수
       
       
        final double factor = 0.9 + 0.2*Math.random();         //변동률 Math랜덤은 0.0보다 크고 1보다 작은 값의 랜덤 생성 따라서 기대값은 0.5



        if(RandoH==100&&lastValue>200) //추후 랜덤값에 의한 비트코인 속보 생성 예정
        {
           System.out.println("속보:비트코인 블록체인 파훼법 등장");
           this.lastValue=this.lastValue-100;
        }
        if(RandoH==99)
        {
           System.out.println("속보:비트코인 새로운 보안 강화");
           this.lastValue=this.lastValue+100;
        }
        this.lastValue = this.lastValue * factor;
        this.lastValue=Math.round(this.lastValue*100)/100.0;
        final Millisecond now = new Millisecond();
        this.series.add(new Millisecond(), this.lastValue);
    	
 //       System.out.println("Current Time in Milliseconds = " + now.toString()+", Current Value : "+this.lastValue);
    }

    /**
     * Starting point for the dynamic graph application.
     *
     * @param args  ignored.
     */
   

}  