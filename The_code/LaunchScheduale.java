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

public class LaunchScheduale
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
    
    public LaunchScheduale()
    {
        
       
    }
    
    public void Schedual(){
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
            PrintSchedual();
        }catch(FileNotFoundException e){
            System.out.println("Errors in This txt file");
            Schedual();
        }
    }

    public void PrintSchedual(){

        System.out.println("|Date        |Client      |Service     |Launchpad    |");
        System.out.println("+------------+------------+------------+--------------");
        for (int i=0;i<TheDate.length;i++){
            if(TheDate[i] == null){
                break;
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
                LuanchSite1[i] = ("   Error Found");
                ClientCode1[i] = ("  Error Found");

            }

            String Date = TheDate[i];
            String Client = ClientCode1[i];
            String TheServiceCode = Service[i];
            String TheLuanchSite = LuanchSite1[i];
            System.out.printf("%12s%12s%12s%12s\n",Date,Client,TheServiceCode,TheLuanchSite);
            ClearData();
        }
        System.out.println("+------------+------------+------------+--------------");

    
    }
    
    public void ClearData(){

        OrbitCoast = 0;
        LaunchSitecost = 0;

        OrbitCoast = 0;
        taxammount = 0;
        Total = 0;

    }
}
