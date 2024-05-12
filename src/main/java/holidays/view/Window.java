
package holidays.view;

//reference: https://github.sydney.edu.au/SOFT2412-2020S2/R18C_Group6_ASM2/blob/master/src/main/java/VendingMachine/View/GameWindow.java
//This start import part is reference from my previous soft2412 team work
import holidays.model.Facade;
import holidays.model.clientserver.*;
import holidays.model.database.DataControl;
import holidays.model.singletonFacade;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;


import java.util.*;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;


public class Window extends JFrame implements ActionListener {

    public String country;
    public String systemDate;
    public String currentYear;
    public String currentMonth;
    public int year;
    public int month;
    public int day;
    Facade facade;
    String tempData;
    String conveyUrl;
    //JTextArea showText;
    //JButton temp;



    private JPanel panel;

    JButton j1 = new JButton("Continue");
    JButton previousMonth = new JButton("Previous Month");
    JButton nextMonth = new JButton("Next Month");
    JLabel lotsOfHoliday = new JLabel("");


    public Window(boolean in, boolean out) throws Exception{
        Client c;
        Output o;
        if (in == true) {
            c = new ClientImpl();
        }
        else {
            c = new offlineInput();
        }
        if (out == true) {
            o = new OutputImpl();
            System.out.println("567567567");
        }
        else {
            o = new offlineOutput();
            System.out.println("123123123123");
        }
        singletonFacade sf = new singletonFacade(c, o);
        facade = sf.getFacade();
        facade.createDatabase(new DataControl());
        init();
        setBounds(100,100,1024,780);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        //c = new ClientImpl();
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        Color co = new Color(123,57,86);
        startWindow();
        panel.setBackground(co);

    }



    public void startWindow(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
        String currentDate =   dateFormat.format( new Date() );
        systemDate = currentDate;
        System.out.println(systemDate);
        int i = 0;
        for (String retval: systemDate.split("-")){
            if (i == 0) {
                currentYear = retval;
            }
            if (i == 1) {
                currentMonth = retval;
            }
            i++;
        }
        currentYear = currentYear.replace(" ", "");
        month = Integer.parseInt(currentMonth);
        year = Integer.parseInt(currentYear);

        j1.setBounds(390, 520, 200, 40);
        JLabel welcome = new JLabel("Welcome to this Holiday Calendar!");
        welcome.setBounds(255, 108, 600,40);
        welcome.setFont(new Font("Times New Roman",Font.BOLD, 32));
        panel.add(welcome);
        JLabel welcome2 = new JLabel("Please choose the country you want to search!");
        welcome2.setBounds(200, 200, 700,40);
        welcome2.setFont(new Font("Times New Roman",Font.BOLD, 32));
        panel.add(welcome2);
        JLabel welcome3 = new JLabel("Please select the threshold holiday count!");
        welcome3.setBounds(200, 350, 700,40);
        welcome3.setFont(new Font("Times New Roman",Font.BOLD, 32));
        panel.add(welcome3);
        country = "AF";
        JComboBox box = new JComboBox();
        box.addItem("Afghanistan - AF");
        box.addItem("Albania - AL");
        box.addItem("Algeria - DZ");
        box.addItem("American Samoa - AS");
        box.addItem("Andorra - AD");
        box.addItem("Angola - AO");
        box.addItem("Anguilla - AI");
        box.addItem("Antigua and Barbuda - AG");
        box.addItem("Argentina - AR");
        box.addItem("Armenia - AM");
        box.addItem("Aruba - AW");
        box.addItem("Australia - AU");
        box.addItem("Austria - AT");
        box.addItem("Azerbaijan - AZ");
        box.addItem("Bahrain - BH");
        box.addItem("Bangladesh - BD");
        box.addItem("Barbados - BB");
        box.addItem("Belarus - BY");
        box.addItem("Belgium - BE");
        box.addItem("Belize - BZ");
        box.addItem("Benin - BJ");
        box.addItem("Bermuda - BM");
        box.addItem("Bhutan - BT");
        box.addItem("Bolivia - BO");
        box.addItem("Bosnia and Herzegovina - BA");
        box.addItem("Botswana - BW");
        box.addItem("Brazil - BR");
        box.addItem("British Virgin Islands - VG");
        box.addItem("Brunei - BN");
        box.addItem("Bulgaria - BG");
        box.addItem("Burkina Faso - BF");
        box.addItem("Burundi - BI");
        box.addItem("Cabo Verde - CV");
        box.addItem("Cambodia - KH");
        box.addItem("Cameroon - CM");
        box.addItem("Canada - CA");
        box.addItem("Cayman Islands - KY");
        box.addItem("Central African Republic - CF");
        box.addItem("Chad - TD");
        box.addItem("Chile - CL");
        box.addItem("China - CN");
        box.addItem("Colombia - CO");
        box.addItem("Comoros - KM");
        box.addItem("Congo - CG");
        box.addItem("Congo Democratic Republic - CD");
        box.addItem("Cook Islands - CK");
        box.addItem("Costa Rica - CR");
        box.addItem("Cote d'Ivoire - CI");
        box.addItem("Croatia - HR");
        box.addItem("Cuba - CU");
        box.addItem("Curaçao - CW");
        box.addItem("Cyprus - CY");
        box.addItem("Czechia - CZ");
        box.addItem("Denmark - DK");
        box.addItem("Djibouti - DJ");
        box.addItem("Dominica - DM");
        box.addItem("Dominican Republic - DO");
        box.addItem("East Timor - TL");
        box.addItem("Ecuador - EC");
        box.addItem("Egypt - EG");
        box.addItem("El Salvador - SV");
        box.addItem("Equatorial Guinea - GQ");
        box.addItem("Eritrea - ER");
        box.addItem("Estonia - EE");
        box.addItem("eSwatini - SZ");
        box.addItem("Ethiopia - ET");
        box.addItem("Falkland Islands - FK");
        box.addItem("Faroe Islands - FO");
        box.addItem("Fiji - FJ");
        box.addItem("Finland - FI");
        box.addItem("France - FR");
        box.addItem("French Guiana - GF");
        box.addItem("French Polynesia - PF");
        box.addItem("Gabon - GA");
        box.addItem("Gambia - GM");
        box.addItem("Georgia - GE");
        box.addItem("Germany - DE");
        box.addItem("Ghana - GH");
        box.addItem("Gibraltar - GI");
        box.addItem("Greece - GR");
        box.addItem("Greenland - GL");
        box.addItem("Grenada - GD");
        box.addItem("Guadeloupe - GP");
        box.addItem("Guam - GU");
        box.addItem("Guatemala - GT");
        box.addItem("Guernsey - GG");
        box.addItem("Guinea - GN");
        box.addItem("Guinea-Bissau - GW");
        box.addItem("Guyana - GY");
        box.addItem("Haiti - HT");
        box.addItem("Honduras - HN");
        box.addItem("Hong Kong - HK");
        box.addItem("Hungary - HU");
        box.addItem("Iceland - IS");
        box.addItem("India - IN");
        box.addItem("Indonesia - ID");
        box.addItem("Iran - IR");
        box.addItem("Iraq - IQ");
        box.addItem("Ireland - IE");
        box.addItem("Isle of Man - IM");
        box.addItem("Israel - IL");
        box.addItem("Italy - IT");
        box.addItem("Jamaica - JM");
        box.addItem("Japan - JP");
        box.addItem("Jersey - JE");
        box.addItem("Jordan - JO");
        box.addItem("Kazakhstan - KZ");
        box.addItem("Kenya - KE");
        box.addItem("Kiribati - KI");
        box.addItem("Kosovo - XK");
        box.addItem("Kuwait - KW");
        box.addItem("Kyrgyzstan - KG");
        box.addItem("Laos - LA");
        box.addItem("Latvia - LV");
        box.addItem("Lebanon - LB");
        box.addItem("Lesotho - LS");
        box.addItem("Liberia - LR");
        box.addItem("Libya - LY");
        box.addItem("Liechtenstein - LI");
        box.addItem("Lithuania - LT");
        box.addItem("Luxembourg - LU");
        box.addItem("Macau - MO");
        box.addItem("Madagascar - MG");
        box.addItem("Malawi - MW");
        box.addItem("Malaysia - MY");
        box.addItem("Maldives - MV");
        box.addItem("Mali - ML");
        box.addItem("Malta - MT");
        box.addItem("Marshall Islands - MH");
        box.addItem("Martinique - MQ");
        box.addItem("Mauritania - MR");
        box.addItem("Mauritius - MU");
        box.addItem("Mayotte - YT");
        box.addItem("Mexico - MX");
        box.addItem("Micronesia - FM");
        box.addItem("Moldova - MD");
        box.addItem("Monaco - MC");
        box.addItem("Mongolia - MN");
        box.addItem("Montenegro - ME");
        box.addItem("Montserrat - MS");
        box.addItem("Morocco - MA");
        box.addItem("Mozambique - MZ");
        box.addItem("Myanmar - MM");
        box.addItem("Namibia - NA");
        box.addItem("Nauru - NR");
        box.addItem("Nepal - NP");
        box.addItem("Netherlands - NL");
        box.addItem("New Caledonia - NC");
        box.addItem("New Zealand - NZ");
        box.addItem("Nicaragua - NI");
        box.addItem("Niger - NE");
        box.addItem("Nigeria - NG");
        box.addItem("North Korea - KP");
        box.addItem("North Macedonia - MK");
        box.addItem("Northern Mariana Islands - MP");
        box.addItem("Norway - NO");
        box.addItem("Oman - OM");
        box.addItem("Pakistan - PK");
        box.addItem("Palau - PW");
        box.addItem("Panama - PA");
        box.addItem("Papua New Guinea - PG");
        box.addItem("Paraguay - PY");
        box.addItem("Peru - PE");
        box.addItem("Philippines - PH");
        box.addItem("Poland - PL");
        box.addItem("Portugal - PT");
        box.addItem("Puerto Rico - PR");
        box.addItem("Qatar - QA");
        box.addItem("Reunion - RE");
        box.addItem("Romania - RO");
        box.addItem("Russia - RE");
        box.addItem("Rwanda - RW");
        box.addItem("Saint Helena - SH");
        box.addItem("Saint Kitts and Nevis - KN");
        box.addItem("Saint Lucia - LC");
        box.addItem("Saint Martin - MF");
        box.addItem("Saint Pierre and Miquelon - PM");
        box.addItem("Saint Vincent and the Grenadines - VC");
        box.addItem("Samoa - WS");
        box.addItem("San Marino - SM");
        box.addItem("Sao Tome and Principe - ST");
        box.addItem("Saudi Arabia - SA");
        box.addItem("Senegal - SN");
        box.addItem("Serbia - RS");
        box.addItem("Seychelles - SC");
        box.addItem("Sierra Leone - SL");
        box.addItem("Singapore - SG");
        box.addItem("Sint Maarten - SX");
        box.addItem("Slovakia - SK");
        box.addItem("Slovenia - SI");
        box.addItem("Solomon Islands - SB");
        box.addItem("Somalia - SO");
        box.addItem("South Africa - ZA");
        box.addItem("South Korea - KR");
        box.addItem("South Sudan - SS");
        box.addItem("Spain - ES");
        box.addItem("Sri Lanka - LK");
        box.addItem("St. Barts - BL");
        box.addItem("Sudan - SD");
        box.addItem("Suriname - SR");
        box.addItem("Sweden - SE");
        box.addItem("Switzerland - CH");
        box.addItem("Syria - SY");
        box.addItem("Taiwan - TW");
        box.addItem("Tajikistan - TJ");
        box.addItem("Tanzania - TZ");
        box.addItem("Thailand - TH");
        box.addItem("The Bahamas - BH");
        box.addItem("Togo - TG");
        box.addItem("Tonga - TO");
        box.addItem("Trinidad and Tobago - TT");
        box.addItem("Tunisia - TN");
        box.addItem("Turkey - TR");
        box.addItem("Turkmenistan - TM");
        box.addItem("Turks and Caicos Islands - TC");
        box.addItem("Tuvalu - TV");
        box.addItem("Uganda - UG");
        box.addItem("Ukraine - UA");
        box.addItem("United Arab Emirates - AE");
        box.addItem("United Kingdom - GB");
        box.addItem("United States - US");
        box.addItem("Uruguay - UY");
        box.addItem("US Virgin Islands - VI");
        box.addItem("Uzbekistan - UZ");
        box.addItem("Vanuatu - VU");
        box.addItem("Vatican City (Holy See) - VA");
        box.addItem("Venezuela - VE");
        box.addItem("Vietnam - VN");
        box.addItem("Wallis and Futuna - WF");
        box.addItem("Yemen - YE");
        box.addItem("Zambia - ZM");
        box.addItem("Zimbabwe – ZW");
        box.setBounds(320,260,380,50);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                country = box.getSelectedItem()+"";
                country = country.substring(country.length() - 2);
            }
        });
        panel.add(box);

        JComboBox countBox = new JComboBox();
        for (int t = 1; t < 6; t++) {
            countBox.addItem(t + "");
        }
        countBox.setBounds(320,425,380,50);
        countBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facade.setThresholdHolidayCount(Integer.parseInt(countBox.getSelectedItem()+""));
            }
        });

        panel.add(countBox);

        j1.addActionListener(this);
        panel.add(j1);

    }


    public void getInputThread(int method, String str2, JButton temp, JTextArea showText) throws ExecutionException, InterruptedException {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                if (method == 0) {
                    tempData = facade.getInput(country, year, month, Integer.parseInt(str2));
                }
                if (method == 1) {
                    tempData = facade.readFromDatabase(year+""+month+str2+country);
                }

                String tempDay = str2;
                return null;
            }
            @Override
            protected void done() {
                //add to the JTextArea
                String tempp = tempData;
                if (tempp != null) {
                    tempp = tempp.replace("[", "");
                    tempp = tempp.replace("{", "");
                    tempp = tempp.replace("]", "");
                    tempp = tempp.replace("}", "");
                    tempp = tempp.replace("\"", "");
                    showText.setText("");
                    String[] sourceArray = tempp.split(",");
                    if (sourceArray.length == 1) {
                        showText.append("This is not a holiday"+ "\r\n");
                        temp.setLabel(str2+"Not");

                        if (method == 0) {
                            //insert into database
                            facade.writeIntoDatabase(year+""+month+str2+country, tempData);
                            facade.createEntity(year+""+month+str2+country, tempData);
                        }

                    }
                    else {
                        showText.append("This is a holiday"+ "\r\n");
                        for (int i = 0; i < sourceArray.length; i++) {
                            showText.append(sourceArray[i] + "\r\n");
                        }
                        temp.setLabel(str2+"Yes");
                        boolean qqq = facade.checkLotsOfHoliday(year, month, country);
                        if (qqq) {
                            lotsOfHoliday.setText("Lots of holidays!");
                        }
                        if (method == 0) {
                            //update data
                            facade.writeIntoDatabase(year+""+month+str2+country, tempData);
                            facade.createEntity(year+""+month+str2+country, tempData);
                        }

                    }
                }

            }
        };
        swingWorker.execute();
    }

    public void sendOutputThread(JTextArea showText) throws ExecutionException, InterruptedException {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                String sendData = "";
                if (facade.checkLotsOfHoliday(year, month, country)) {
                    sendData = sendData + "*";
                }
                for (int i = 0; i < day; i++) {
                    String tempKey = year+""+month+""+i+country;
                    sendData = sendData + tempKey;
                    sendData = sendData + facade.readFromDatabase(tempKey);
                }
                String urlString = facade.sendOutput(sendData);
                conveyUrl = urlString;
                return null;
            }
            @Override
            protected void done() {
                showText.setText("");
                showText.append(conveyUrl);
            }
        };
        swingWorker.execute();
    }

    public void calendarWindow(int t) {

        lotsOfHoliday.setBounds(400,50,600,10);
        panel.add(lotsOfHoliday);
        if (t == -1) {
            if (month == 1) {
                month = 12;
                year--;
            }
            else {
                month--;
            }
        }
        if (t == 1) {
            if (month == 12) {
                month = 1;
                year++;
            }
            else {
                month++;
            }
        }

        //find number of days
        int days = 0;
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            days = 31;
        }else if (month==4||month==6||month==9||month==11){
            days = 30;
        }else if (month==2){
            if( year%4==0&&year%100!=0||year%400==0){
                days = 29;
            }else {
                days = 28;
            }
        }
        day = days;






        boolean qqq = facade.checkLotsOfHoliday(year, month, country);
        if (qqq) {
            lotsOfHoliday.setText("Lots of holidays!");
        }
        else {
            lotsOfHoliday.setText("");
        }

        //Instruction
        JLabel monthShown = new JLabel("Month: " + month);
        monthShown.setBounds(200, 100, 600,40);
        monthShown.setFont(new Font("Times New Roman",Font.BOLD, 32));
        panel.add(monthShown);
        JLabel yearShown = new JLabel("Year: " + year);
        yearShown.setBounds(200, 50, 600,40);
        yearShown.setFont(new Font("Times New Roman",Font.BOLD, 32));
        panel.add(yearShown);

        //add textArea
        JTextArea showText = new JTextArea();
        showText.setBounds(710,70,275,550);
        showText.setEnabled(false);
        panel.add(showText);


        //Create day objects
        List<JButton> dateList = new ArrayList<JButton>();
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (count == days) {
                    break;
                }
                JButton temp = new JButton((j+6*i+1)+"");
                temp.setBounds(50+j*110, 150+i*80, 80, 70);
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str = temp.getLabel();
                        str=str.trim();
                        String str2="";
                        if(str != null && !"".equals(str)){
                            for(int i=0;i<str.length();i++){
                                if(str.charAt(i)>=48 && str.charAt(i)<=57){
                                    str2+=str.charAt(i);
                                }
                            }
                        }

                        //search holiday
                        String[] option  =  {"From Internet","From Database"};
                        int response=JOptionPane.showOptionDialog ( Window.this, "Where to search?",
                                "Search Method",
                                JOptionPane.YES_OPTION ,JOptionPane.PLAIN_MESSAGE,
                                null, option, option[0] );
                        if (response == 0) {
                            //Search from internet
                            try {
                                getInputThread(0, str2, temp, showText);
                            } catch (ExecutionException executionException) {
                                executionException.printStackTrace();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }

                        }
                        if (response == 1) {
                            //Search from database
                            try {
                                getInputThread(1, str2, temp, showText);
                            } catch (ExecutionException executionException) {
                                executionException.printStackTrace();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }

                        }
                    }
                });

                panel.add(temp);
                dateList.add(temp);
                count++;
            }
        }

        //add button
        previousMonth.setBounds(50, 630, 200, 40);
        nextMonth.setBounds(450, 630,200,40);
        if (t==0) {
            previousMonth.addActionListener(this);
            nextMonth.addActionListener(this);
        }

        panel.add(previousMonth);
        panel.add(nextMonth);
        JButton sendReport = new JButton("Send Month Holidays to Pastebin");



        sendReport.setBounds(700, 650, 300, 40);
        sendReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendOutputThread(showText);
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
        });

        panel.add(sendReport);






    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == j1) {
            this.panel.removeAll();
            calendarWindow(0);
            panel.validate();
            repaint();
        }
        if (e.getSource() == previousMonth) {
            this.panel.removeAll();
            calendarWindow(-1);
            panel.validate();
            repaint();
        }
        if (e.getSource() == nextMonth) {
            this.panel.removeAll();
            calendarWindow(1);
            panel.validate();
            repaint();
        }


    }







}
