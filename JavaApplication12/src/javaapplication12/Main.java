/*
 * . Making sense out of HTTP log file 
 * 
 */

package javaapplication12;

import java.util.*;

import java.io.*;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import java.lang.*;

public class Main extends JFrame{

static        int  ffcnt=0,msiecnt=0,safacnt=0,chrocnt=0,opercnt=0,tokencnt=0;
static        int browcnt=0,kitcnt=0,botcnt=0;
static        int googlebotcnt=0,yahoobotcnt=0,msnbotcnt=0,twicelercnt=0,netscapecnt=0,exabotcnt=0;
static        int lincnt=0,wincnt=0,maccnt=0;
static        int twicnt=0,kincnt=0,reccnt=0;
static        int errcnt=0,succnt=0;


    public static void main(String[] args) throws Exception {


        FileReader fr1=new FileReader("C:\\weblog.txt");
        FileReader fr2=new FileReader("C:\\weblog.txt");
        Scanner sr1=new Scanner(fr1);
        Scanner sr2=new Scanner(fr2);


        StringTokenizer stk1;
        StringTokenizer stk2;

        Vector tokens=new Vector();
        Vector tokens2=new Vector();

        Vector IP=new Vector();
        Vector DATE=new Vector();
        Vector TIMEZONE=new Vector();
        Vector METHOD=new Vector();
        Vector URL=new Vector();
        Vector PROTOCOL=new Vector();
        Vector STATUS=new Vector();
        Vector BYTES=new Vector();
        Vector REFERRAL=new Vector();
        Vector UA=new Vector();
        

        do
        {


            stk1=new StringTokenizer(sr1.nextLine());
            stk2=new StringTokenizer(sr2.nextLine(),"\"");
            do
            {
              tokens.addElement(stk1.nextToken());
            }
            while(stk1.hasMoreTokens());
            
            do
            {
                tokens2.addElement(stk2.nextToken());
                
            }
            while(stk2.hasMoreTokens());
            

            //IP
            String tmp="";
            IP.addElement(tokens.elementAt(0));


            //Date
            tmp=(String)tokens.elementAt(3);
            tmp=tmp.substring(1,tmp.length());
            DATE.addElement(tmp);
            

            //Timezone
            tmp=(String)tokens.elementAt(4);
            tmp=tmp.substring(0,tmp.length() - 1 );
            TIMEZONE.addElement(tmp);
            

            //method
            tmp=(String)tokens.elementAt(5);
            tmp=tmp.substring(1,tmp.length());
            METHOD.addElement(tmp);

            //url
            tmp=(String)tokens.elementAt(6);
            tmp=tmp.substring(0,tmp.length()-1);
            URL.addElement(tmp);

            //protocol
            tmp=(String)tokens.elementAt(7);
            tmp=tmp.substring(0,tmp.length()-1);
            PROTOCOL.addElement(tmp);

            //STATUS
            tmp=(String)tokens.elementAt(8);
            STATUS.addElement(tmp);

            //BYTES
            tmp=(String)tokens.elementAt(9);
            BYTES.addElement(tmp);

            //REFERRAL
            tmp=(String)tokens.elementAt(10);
            tmp=tmp.substring(1,tmp.length()-1);
            REFERRAL.addElement(tmp);

            //UA
            tmp=(String)tokens2.elementAt(5);
            UA.addElement(tmp);

            tokens.clear();
            tokens2.clear();

        
        }while(sr1.hasNextLine());
  

        Enumeration URLenum=URL.elements();
        Enumeration STATUSenum=STATUS.elements();
        Enumeration UAenum=UA.elements();
        

        do
        {
          String temp = UAenum.nextElement().toString();

          //Browsers
          if(temp.contains("Firefox") && temp.contains("Mozilla/"))
                    ffcnt++;
          if(temp.contains("MSIE") )
                   msiecnt++;
          if(temp.contains("Opera/"))
                   opercnt++;
          if(temp.contains("Version/"))
                   safacnt++;

          if(temp.contains("Chrome/"))
                   chrocnt++;
          if(temp.contains("Mozilla/4.79"))
                   netscapecnt++;

          //Bots
          if(temp.contains("Googlebot"))
                   googlebotcnt++;
          if(temp.contains("Yahoo! Slurp"))
                   yahoobotcnt++;
          if(temp.contains("msnbot/"))
                    msnbotcnt++;
          if(temp.contains("Twiceler-"))
                    twicelercnt++;
          if(temp.contains("Exabot"))
                    exabotcnt++;

          //OS
          if(temp.contains("Macintosh"))
                   maccnt++;
          if(temp.contains("Windows NT"))
                   wincnt++;
          if(temp.contains("Linux"))
                   lincnt++;

        }while(UAenum.hasMoreElements());

        //POPULAR WEBSITE COUNT
        while(URLenum.hasMoreElements())
        {
            String tmp=(String)URLenum.nextElement();
            if(tmp.contains("twibuzz.com"))
                twicnt++;
            if(tmp.contains("kinneryandrajan.com"))
                kincnt++;
            if(tmp.contains("recipewithme.com"))
                reccnt++;
        }
     

        //STATUS  COUNT
        while(STATUSenum.hasMoreElements())
        {
            String tmp=((String)STATUSenum.nextElement());
            if(tmp.contains("404"))
                errcnt++;
            else
                succnt++;
        }
   
         DataInputStream dis=new DataInputStream(System.in);
         DataInputStream dis1=new DataInputStream(System.in);
         int ch,ch1;
        do
        {
            System.out.println("[1]-BROWSER STATS");
            System.out.println("[2]-BOT STATS");
            System.out.println("[3]-OS STATS");
            System.out.println("[4]-WEBSITE STATS");
            
            System.out.println("[5]-SUCCESS STATS");
            System.out.println("[6]-LOG VIEW");
            System.out.println("[7]-EXIT");
            System.out.println("ENTER YOUR CHOICE: ");
            ch=Integer.parseInt(dis.readLine());

            switch(ch)
            {

                case  1:           Main demo1 =  new Main("STATS", "BROWSER STATS",1);
                                   demo1.pack();
                                   demo1.setVisible(true);
                                   break;

                case 2:            Main demo2 =  new Main("STATS", "BOT STATS",2);
                                   demo2.pack();
                                   demo2.setVisible(true);
                                   break;

                case 3:            
                                   Main demo3 =  new Main("STATS", "OS STATS",3);
                                   demo3.pack();
                                   demo3.setVisible(true);
                                   break;

                case 4:
                                   Main demo4 =  new Main("STATS", "WEBSITE STATS",4);
                                   demo4.pack();
                                   demo4.setVisible(true);
                                   break;

                case 5:            Main demo6 =  new Main("STATS", "HIT RATIO STATS",6);
                                   demo6.pack();
                                   demo6.setVisible(true);
                                   break;

                case 6:              do{
                                     System.out.println("[1]-USER ACTIVITY LOG");
                                     System.out.println("[2]-ACESSED URL LOG");
                                     System.out.println("[3]-USER AGENT LOG");
                                     System.out.println("[4]-EXIT");
                                     System.out.println("ENTER YOUR CHOICE: ");
                                     ch1=Integer.parseInt(dis1.readLine());
                                     switch(ch1)
                                     {
                                         case 1:
                                                int log0=0;
                                                Enumeration IPenum1=IP.elements();
                                                Enumeration DATEenum1=DATE.elements();
                                                Enumeration URLenum1=URL.elements();
                                                Enumeration BYTESenum1=BYTES.elements();
                                                System.out.print("\nSno____IP ADDRESS______DATE_______________URL_____________BYTES" );
                                                while(IPenum1.hasMoreElements())
                                                {
                                                System.out.print("\n"+log0+ "______" + IPenum1.nextElement());
                                                System.out.print("_____" + DATEenum1.nextElement());
                                                System.out.print("_____" + URLenum1.nextElement());
                                                System.out.print("_____" + BYTESenum1.nextElement()+"\n");
                                                log0++;
                                                }
                                                break;
                                         case 2:
                                                int log=0;
                                                Enumeration URLenum2=URL.elements();
                                                while(URLenum2.hasMoreElements())
                                                 {
                                                    System.out.print("\n"+ log+ "______" + URLenum2.nextElement());
                                                    log++;
                                                 }
                                                 break;
                                         case 3:
                                                int log1=0;
                                                Enumeration UAenum1=UA.elements();
                                                while(UAenum1.hasMoreElements())
                                                 {
                                                    System.out.print("\n"+ log1+ "______" + UAenum1.nextElement());
                                                    log1++;
                                                 }
                                                 break;
                                       
                                         case 4:System.exit(0);
                                               break;

                                         default:System.out.println("\nWRONG CHOICE");
                                     }
                                     } while(ch!=4);
                       break;
                        
                case 7:System.exit(0);
                        break;

                default: System.out.println("WRONG CHOICE");
            }
        }
        while(ch!=7);

    }//main()


public Main(String applicationTitle, String chartTitle, int flag ) {

super(applicationTitle);

PieDataset dataset;
if(flag==1)
 dataset = createDataset1();
 else if(flag==2)
     dataset = createDataset2();
 else if(flag==3)
     dataset = createDataset3();

else if(flag==4)
     dataset = createDataset4();

else if(flag==6)
     dataset = createDataset6();


 else
     dataset = createDataset1();
        JFreeChart chart = createChart(dataset, chartTitle);
   
        ChartPanel chartPanel = new ChartPanel(chart);
   
        chartPanel.setPreferredSize(new java.awt.Dimension(1100,700));
   
        setContentPane(chartPanel);

}

private  PieDataset createDataset1() {

        DefaultPieDataset result = new DefaultPieDataset();
        float fper = ((float)ffcnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;
        float cper = ((float)chrocnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;
        float oper = ((float)opercnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;
        float sper = ((float)safacnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;
        float mper = ((float)msiecnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;
        float nper = ((float)netscapecnt /(float) (ffcnt+chrocnt+opercnt+safacnt+msiecnt))*100;


        result.setValue("FIREFOX "+String.format("%.2f", fper)+ "%", ffcnt);
        result.setValue("CHROME "+String.format("%.2f", cper)+ "%", chrocnt);
        result.setValue("OPERA "+String.format("%.2f", oper)+ "%", opercnt);
        result.setValue("SAFARI "+String.format("%.2f", sper)+ "%", safacnt);
        result.setValue("IE "+String.format("%.2f", mper)+ "%", msiecnt);
        result.setValue("NETSCAPE "+ String.format("%.2f", nper)+ "%", netscapecnt);
        return result;

    }

private  PieDataset createDataset2() {

        DefaultPieDataset result = new DefaultPieDataset();
        float gper = ((float)googlebotcnt /(float) (googlebotcnt+yahoobotcnt+msnbotcnt+twicnt+exabotcnt))*100;
        float yper = ((float)googlebotcnt /(float) (googlebotcnt+yahoobotcnt+msnbotcnt+twicnt+exabotcnt))*100;
        float mper = ((float)googlebotcnt /(float) (googlebotcnt+yahoobotcnt+msnbotcnt+twicnt+exabotcnt))*100;
        float tper = ((float)googlebotcnt /(float) (googlebotcnt+yahoobotcnt+msnbotcnt+twicnt+exabotcnt))*100;
        float eper = ((float)googlebotcnt /(float) (googlebotcnt+yahoobotcnt+msnbotcnt+twicnt+exabotcnt))*100;

        result.setValue("GOOGLE BOTS " + String.format("%.2f", gper)+ "%", googlebotcnt);
        result.setValue("YAHOO SLURP " + String.format("%.2f", yper)+ "%", yahoobotcnt);
        result.setValue("MSN BOT " + String.format("%.2f", mper)+ "%", msnbotcnt);
        result.setValue("TWICELER " +String.format("%.2f", tper)+ "%", twicnt);
        result.setValue("EXABOT " +String.format("%.2f", eper)+ "%", exabotcnt);

        return result;

    }

private  PieDataset createDataset3() {


        float winper = ((float)wincnt /(float) (lincnt+maccnt+wincnt))*100;
        float linper = ((float)lincnt /(float) (lincnt+maccnt+wincnt))*100;
        float macper = ((float)maccnt /(float) (lincnt+maccnt+wincnt))*100;
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("WINDOWS "+String.format("%.2f", winper)+ "%", wincnt);
        result.setValue("LINUX "+String.format("%.2f", linper)+ "%", lincnt);
        result.setValue("MACINTOSH "+String.format("%.2f", macper)+ "%" , maccnt);


        return result;

    }

private  PieDataset createDataset4() {



        DefaultPieDataset result = new DefaultPieDataset();
        float kper = ((float)kincnt /(float) (twicnt+reccnt+kincnt))*100;
        float tper = ((float)twicnt /(float) (twicnt+reccnt+kincnt))*100;
        float rper = ((float)reccnt /(float) (twicnt+reccnt+kincnt))*100;
        result.setValue("KINNERYANDRAJAN(www.kinneryandrajan.com)" + String.format("%.2f", kper)+ "%" , kincnt);
        result.setValue("TWIBUZZ (www.twibuzz.com)" + String.format("%.2f", tper)+ "%", twicnt);
        result.setValue("RECIPEWITHME (www.recipewithme.com)"+String.format("%.2f", rper)+ "%", reccnt);


        return result;

    }

private  PieDataset createDataset6() {


        DefaultPieDataset result = new DefaultPieDataset();
        float sper = ((float)succnt /(float) (errcnt+succnt))*100;
        float eper = ((float)errcnt /(float) (errcnt+succnt))*100;
        result.setValue("SUCCESSFUL HITS"+String.format("%.2f", sper)+ "%", succnt);
        result.setValue("UNSUCCESSFUL HITS"+String.format("%.2f", eper)+ "%", errcnt);
        return result;

    }



private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title,  
            dataset,                
            true,                   
            true,
            false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
}

}//classends
