/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dipta
 */
public class BNMmethod {
    private String EngName;
    private String BanName;
    public int nameindex;
    public int containindex;
    public int endindex;
    
    public String SFpath(String Gender, String Religion, String nameStart) {
        String R = "";
        String G = "";
        String g = "";
        String ch = "";
        
        G = Gender.equalsIgnoreCase("male") ? "male" : "female";
        g = Gender.equalsIgnoreCase("male") ? "Boys.txt" : "Girls.txt";
        ch = nameStart.toLowerCase();
        if (Religion.equalsIgnoreCase("christian")) {
            R = "christian";
        } else if (Religion.equalsIgnoreCase("hindu")) {
            R = "hindu";
        } else {
            R = "muslim";
        }
        
        return "E:/EDU/Study/FinalProject/BanglaNameMaker/src/DB/" + R + "/" + G + "/" + ch + g;
        // "E:\EDU\Study\FinalProject\BanglaNameMaker\src\DB"
    }
    
    public String[][] EBnames(String sourcePath) throws FileNotFoundException {
        File readSrc   = new File(sourcePath);
        Scanner read = new Scanner(readSrc);
        
        String name[][] = new String[500][2];
        String Ename = "";
        String Bname = "";
        
       nameindex = 0;
        while(read.hasNextLine()) {
            String RL = read.nextLine();
            
            nameFunction(RL);
            name[nameindex][0] = getEName();
            name[nameindex][1] = getBName();
            nameindex++;
        }
        
        return name;
    }
    
    public boolean CONnames(String name, String ch) {
        String subName = name.substring(1,  (name.length()-1));
        if (subName.indexOf(ch.toLowerCase()) == -1)
            return false;
        return true;
    }
    public boolean ENDnames(String name, String ch) {
        String end = name.substring(name.length() - 1);
        if (!end.equalsIgnoreCase(ch))
            return false;
        return true;
    }
    
    public void setName(String Ename, String Bname) {
        EngName = Ename;
        BanName = Bname;
    }
    public String getEName() {
        return EngName;
    }
    public String getBName() {
        return BanName;
    }
    public void nameFunction(String name) {
        String Ename = "";
        String Bname = "";
        
        int i = 0;
        for ( ; i<name.length(); i++) {
            if (name.charAt(i) == ' ' || name.charAt(i) == '\t')
                break;
            Ename += name.charAt(i);
        }
        
        for ( ; i<name.length(); i++) {
            if (name.charAt(i) == ' ' || name.charAt(i) == '\t') {
                continue;
            }
            else break;
        } 
        for ( ; i<name.length(); i++) {
            Bname += name.charAt(i);
        }
        setName(Ename, Bname);
    }
    
}
