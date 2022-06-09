import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;
import java.io.*;
import java.util.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.font.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Locale;
import java.text.ParseException;

public class MonthlyInvoice
{

    String[] ServiceCode = {"orbl","orblh","orbc1u","orbc2u","orbc3u","orbc6u"};
    int[] ServiceCost = {62000000,90000000,500000,1000000,1400000,2000000};
    String[] ClientCode = {"ESAA","NASHA","ASA","TICK","BINC","CODE","MARZ"};
    String[] ClientName = {"Europe Systems Alternative Agency","National Air Space Hash Agency",
            "Aussie Space Agency","Tick Incorporated",
            "Byer Private Space Incorporated","Corporate Space Trust",
            "The Mars Gen Inc"};
    String[] Attention = {"Jean-Claude Junxer","Jimmy Briden","Megan Clock",
            "Mark Waston","Marilyn Hewson","Zhang Chen","Cool Dude"};

    public String Client;
    public String ContactName;
    public String TheClientCode;
    public int s;
    public String theService;
    public int theCost;
    public int m;
    public String theOrbit;
    public int theammount;
    public String LuanchSite;
    public int LaunchSitecost;
    public boolean GloWSat;
    public String GloWSatllite;
    public int Total;
    public int OrbitCoast;
    public int taxammount;

    String[] TheDate = new String[100];
    String[] ClientCode1 = new String[100];
    String[] Service = new String[100];
    String[] TheOrbit = new String[100];
    String[] ThePayLoad = new String[100];
    String[] LuanchSite1 = new String[100];
    String[] WarmingSattellite = new String[100];
    String[] TheList;

    public int g;
    int PlusTotal;

    public MonthlyInvoice()
    {

    }

    public void Monthly(){
        System.out.print("Input the name of the file to process:  ");
        Scanner TheFile = new Scanner(System.in);
        String TheFileName = TheFile.next();
        Scanner Read;
        try{

            //File Client = new File(TheFileName);
            Read = new Scanner (new FileReader(TheFileName));
            String t = "";
            int m =0;
            while (Read.hasNextLine()){
                t = Read.nextLine();
                String[] TheList= t.split(",");
                int ReadFileLength =0;
                if (TheList.length == 7){

                    TheDate[m] = TheList[0];
                    ClientCode1[m] = TheList[1];
                    Service[m] = TheList[2];
                    TheOrbit[m] = TheList[3];
                    ThePayLoad[m]= TheList[4];
                    LuanchSite1[m] = TheList[5];
                    WarmingSattellite[m] = TheList[6];

                }   else{
                    System.out.println("\nErrors in This txt file\n");
                    break;
                }
                m++;
            }
            PrintMonthlyInvoice();
        }catch(FileNotFoundException e){
            System.out.println("Errors in This txt file.");
            Monthly();
        }

    }

    public void PrintMonthlyInvoice(){

        if (ClientCode1[0].equals("ESAA")){

        }
        for (int a=0;a<7;a++){
            if(ClientCode1[0].compareToIgnoreCase(ClientCode[a])==0){

                Client = ClientName[a];
                ContactName = Attention[a];

                break;
            }

        }

        System.out.print("\n \n ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("To         :"+Client);
        System.out.println("Attention  :"+ContactName);
        System.out.println("Client Code:"+ClientCode1[0]);
        System.out.println(" \n ");
        System.out.println("SpaceW Service Invoice");
        System.out.print("\n");
        System.out.println("|Launch        |Orbit         |Site          |Warming       |Service       |Service       |Total         |");
        System.out.println("|Date          ||Fees         |Fees          |taxammount           |              |Cost          |              |"); 
        System.out.println("|--------------|--------------|--------------|--------------|--------------|--------------|--------------|");
        for (int i=0;i<TheDate.length;i++){
            if(TheDate[i] == null){
                break;
            }
            try{
            int ConvertThePayLoad = Integer.parseInt(ThePayLoad[i]);
            if (WarmingSattellite[i].compareToIgnoreCase("Y")==0 &&  (ConvertThePayLoad>= 1000000)){
                taxammount = (int)(Double.parseDouble(ThePayLoad[i]) * 0.13);
            }   else if(WarmingSattellite[i].compareToIgnoreCase("N")==0){
                taxammount = 0;
            }
            }catch(NumberFormatException e){
                System.out.println("Errors in This txt file");
                
                TheDate[i] = ("");
                taxammount = taxammount * 0;
                LaunchSitecost = 0;
                Service[i] = "";
                Total = 0;
                theCost = 0;
            }
            if (TheOrbit[i].compareToIgnoreCase("GTO")==0){
                OrbitCoast = 120000;
            }   else if (TheOrbit[i].compareToIgnoreCase("LEO")==0){
                OrbitCoast = 0;
            }   else{
                System.out.println("Errors in This txt file >> Orbit not Found");
                taxammount = taxammount * 0;
                TheDate[i] = ("");
            }

            for (int a=0;a<6;a++){
                if(Service[i].compareToIgnoreCase(ServiceCode[a])==0){

                    theCost = ServiceCost[a];

                    break;
                }

            }

            if (LuanchSite1[i].compareToIgnoreCase("KSC")==0){
                LaunchSitecost = 130000;
            }   else if(LuanchSite1[i].compareToIgnoreCase("LC40")==0){
                LaunchSitecost = 0;
            }   else{

                System.out.println("Errors in This txt file");
                TheDate[i] = ("");
                taxammount = taxammount * 0;
                LaunchSitecost = 0;
                Service[i] = "";
                Total = 0;
                theCost = 0;
            }
            try{
                Double T = Double.parseDouble(ThePayLoad[i]);

            }catch(NumberFormatException e){
                System.out.println("Errors in This txt file");
                
                TheDate[i] = ("");
                taxammount = taxammount * 0;
                LaunchSitecost = 0;
                Service[i] = "";
                Total = 0;
                theCost = 0;
            }

            Total = OrbitCoast + LaunchSitecost + theCost + taxammount; 
            System.out.printf("|%14s|%,14d|%,14d|%,14d|%14s|%,14d|%,14d|",TheDate[i],OrbitCoast,LaunchSitecost,taxammount,Service[i],theCost,Total);
            PlusTotal = PlusTotal + Total;
            System.out.print("\n");
            ClearData();
        }
        System.out.println("                                                                                          |--------------|");
        System.out.printf("                                                                                           %,14d|",PlusTotal);

    }

    public void ClearData(){

        OrbitCoast = 0;
        LaunchSitecost = 0;

        OrbitCoast = 0;
        taxammount = 0;
        Total = 0;

    }

    

  
}
