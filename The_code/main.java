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

public class main
{

    public Date d;
    public String d2;
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

    public main()
    {
        System.out.print("\u000c");
        Menu();

     
    }
    public static void exit(){
        System.out.print("program is end");
        System.exit(0);
    }

    public void Menu()
    {
        System.out.println("\n \n");
        System.out.println("spaceW helper system");
        System.out.println("E- exit");
        System.out.println("1- one off invoice");
        System.out.println("L- launch schedule");
        System.out.println("M- monthly invoice");
        System.out.println("D- display teddy bear");
        System.out.println("select option: \n");

        Scanner key = new Scanner(System.in);
        String x = key.nextLine();

        if (x.compareToIgnoreCase("E")==0){
            exit();
        }
        else if (x.compareToIgnoreCase("1")==0){
            dateOfLunche();
        }
        else if (x.compareToIgnoreCase("m")==0){
            TheMonthlyInvoice();
        }
        else if (x.compareToIgnoreCase("l")==0){
            TheSchedual();
        }
        else if (x.compareToIgnoreCase("D")==0){
            TheDraw();
        }
        else{
            Menu();
        }

            
            
        
        
    }
    public void dateOfLunche(){
        Scanner keyy = new Scanner(System.in);
        System.out.print("\nenter launche date:");
        String y = keyy.next();
        SimpleDateFormat z = new SimpleDateFormat("dd/MM/yy");
        try {
            d = z.parse(y);
            d2 = z.format(d);

            ClientID();

        }catch(ParseException e){
            System.out.println("\n date doesnt exist\n");
            dateOfLunche();

        }
    }
    public void ClientID(){
        System.out.print("enter client ID:");

        Scanner keyyy = new Scanner(System.in);
        String clientID = keyyy.nextLine();
        int s;
        for(s=0;s<7;s++){
            if (clientID.compareToIgnoreCase(ClientCode[s])==0){
                Client = ClientName[s];
                ContactName = Attention[s];
                TheClientCode = ClientCode[s];
                ServiceCode();
                
                break;

            }
            
        }
        if(s == 7){
                System.out.println("\nID is not correct\n");
                ClientID(); 
            }
    }

    public void ServiceCode(){
        System.out.print("enter service code:");
        Scanner input = new Scanner(System.in);
        String service = input.nextLine();
        int m;
        for(m=0;m<6;m++){
            if (service.compareToIgnoreCase(ServiceCode[m])==0){
                theService = service;
                theCost= ServiceCost[m];

                orbit();
                break;
            }
            
        }
        if (m == 6){
                System.out.println("service code is not correct");
                ServiceCode();

            }

    }

    public void orbit(){
        System.out.print("enter orbit:");
        Scanner maryam = new Scanner(System.in);
        String orbit = maryam.nextLine();
        if (orbit.compareToIgnoreCase("leo")==0){
            theOrbit = orbit;
            PayLoad();

        }
        else if (orbit.compareToIgnoreCase("gto")==0){
            theOrbit = orbit;
            PayLoad();
        }
        else{
            System.out.println("\norbit not available");
            orbit();
        }
    }

    public void PayLoad(){
        System.out.print("enter payload value:");
        Scanner p = new Scanner(System.in);
        int ammount;
        try{
            ammount = p.nextInt();
            if(ammount >= 10000 && ammount <= 900000000){
                theammount = ammount;
                PayloadRange();

            }else{
                System.out.println("\nvalue is not available, please try again");
                PayLoad();
            }
        }catch (InputMismatchException e){
            System.out.println("\npayload value is not correct");
            PayLoad();
        }

    }

    public void PayloadRange(){
        if(theammount >= 1000000){

            theLaunchSite();
            globalWarming();
            summery();
        }else{
            GloWSatllite = "No";
            theLaunchSite();
            summery();

        }

    }

    public void theLaunchSite(){
        System.out.print("\nEnter Luanch Site:  ");
        Scanner ahmed = new Scanner(System.in);
        String enterLaunchSite = ahmed.nextLine();
        if(enterLaunchSite.compareToIgnoreCase("LC40")==0){
            LuanchSite = ("LC40");
            LaunchSitecost = 0;
        }else if (enterLaunchSite.compareToIgnoreCase("KSC")==0){
            LuanchSite = ("KSC");
            LaunchSitecost = 130000;
        }else{
            System.out.println("\nlunche site code is not correct");
            theLaunchSite();
        }

    }

    public void globalWarming(){
        System.out.print("\nIs it a Global Worming Satllite Y/N:");
        Scanner f = new Scanner(System.in);
        String globalWarmingSatllite = f.nextLine();
        if(globalWarmingSatllite.compareToIgnoreCase("y")==0){
            GloWSat = true;
            GloWSatllite = "Yes";
        }else if(globalWarmingSatllite.compareToIgnoreCase("n")==0){
            GloWSat = false;
            GloWSatllite = "No";
        }else if(globalWarmingSatllite.equals("exit")){
            exit(); 
        }else{
            System.out.println("invaild amount, pleas try again");
            globalWarming();
        }
    }
    public void taxammount(){
        if(theammount >= 1000000 && GloWSat == true){
            taxammount = (int)(theammount * 0.13) ; 
        }
    }

    public void OrbitCoast(){
        if(theOrbit.compareToIgnoreCase("gto")==0){
            OrbitCoast = 120000;
        }
    }

    public void Total(){
        Total = theCost +   taxammount  +  +OrbitCoast + LaunchSitecost; 
    }

    public void summery(){
        System.out.println("Data               :"+d2);
        System.out.println("Client Code        :"+TheClientCode.toUpperCase());
        System.out.println("Service Code       :"+theService.toUpperCase());
        System.out.println("Orbit              :"+theOrbit.toUpperCase());
        System.out.println("Launch Site        :"+LuanchSite);
        System.out.printf("Value of Payload    :%-,10d\n",theammount);
        System.out.println("Global Warm Sat    :"+GloWSatllite);

        receipt();
    }

    public void receipt(){
        taxammount();
        OrbitCoast();
        Total();

        System.out.print("\n \n ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("To         :"+Client);
        System.out.println("Attention  :"+ContactName);
        System.out.println("Client Code:"+TheClientCode);
        System.out.println(" \n ");
        System.out.println("SpaceW Service Invoice");
        System.out.print("\n");

        System.out.println("|Launch        |Orbit         |Site          |Warming       |Service       |Service       |Total         |");
        System.out.println("|Date          ||Fees         |Fees          |Tax           |              |Cost          |              |"); 
        System.out.println("|--------------|--------------|--------------|--------------|--------------|--------------|--------------|");
        System.out.printf("|%14s|%,14d|%,14d|%,14d|%14s|%,14d|%,14d|",d2,OrbitCoast,LaunchSitecost,taxammount,theService,theCost,Total);
        System.out.println("                                                                                          |--------------|");
        System.out.printf("                                                                                           %,14d|",Total);

        ClearData();
        Menu();

    }

    public void ClearData(){

        d2 = null;
        theService = "";
        theCost = 0;
        LaunchSitecost = 0;
        theammount = 0;

        GloWSat = false;

        GloWSatllite = "";
        OrbitCoast = 0;
        taxammount = 0;

        Total = 0;
    }

    
    
    public void TheMonthlyInvoice(){
        MonthlyInvoice TheInvoice = new MonthlyInvoice();
        TheInvoice.Monthly();
        Menu();
    
    }
    
    public void TheSchedual(){
        LaunchScheduale Schesuale = new LaunchScheduale();
        Schesuale.Schedual();
        Menu();
        
    }
    
    public void TheDraw(){
    
        System.out.print("enter Service Code or enter (m) to go back to Menu) :  ");
        Scanner service1 = new Scanner(System.in);
        String service = service1.nextLine();
        if (service.compareToIgnoreCase("ORBC1U")==0 || service.compareToIgnoreCase("ORBC2U")==0 ||  service.compareToIgnoreCase("ORBC3U")==0 || service.compareToIgnoreCase("ORBC6U")==0){
            draw TheDraw1 = new draw();
        
            Menu();
                
            }
        else if (service.compareToIgnoreCase("m")==0){
            Menu();
        }
        else{
            System.out.print("\n\n");
            System.out.println("\n value is not available, please try again");
            TheDraw();
        }
    
    }

    
}
    
