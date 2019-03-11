/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;

/**
 *
 * @author dipta
 */
public class Control {
    public String Gender;
    public String Religion;
    public String nameStart;
    public String nameContain;
    public String nameEnd;
    public int nameindex;
    public int containindex;
    public int endindex;
    public int commonindex;
    
    public Control(String Gender, String Religion, String nameStart, String nameContain, String nameEnd) {
        this.Gender = Gender;
        this.Religion = Religion;
        this.nameStart = nameStart;
        this.nameContain = nameContain;
        this.nameEnd = nameEnd;
    }
    
    public String SourceFilePath() {
        BNMmethod bnm = new BNMmethod();
        return bnm.SFpath(Gender, Religion, nameStart);
    }
    public void BNMnames(String sourcePath, String EBname[][], String CONname[][], String ENDname[][], String COMMname[][], String nameContain, String nameEnd) throws FileNotFoundException {
         BNMmethod bnm = new BNMmethod();
         
        EBname = bnm.EBnames(sourcePath);
        nameindex = bnm.nameindex;
        
        ConEndNames(EBname, CONname, ENDname, COMMname, nameContain, nameEnd, nameindex);
        
        
    }
    
    public void ConEndNames(String EBname[][], String CONname[][], String ENDname[][], String COMMname[][],  String nameContain, String nameEnd, int indx)  {
        BNMmethod bnm = new BNMmethod();
        
        containindex = 0; endindex = 0;
        for (int i=0; i<indx; i++) {
            boolean flag1 = bnm.CONnames(EBname[i][0], nameContain);
            if (flag1) {
                CONname[containindex][0] = EBname[i][0];
                CONname[containindex][1] = EBname[i][1];
                containindex++;
            }
            boolean flag2 = bnm.ENDnames(EBname[i][0], nameEnd);
            if (flag2) {
                ENDname[endindex][0] = EBname[i][0];
                ENDname[endindex][1] = EBname[i][1];
                endindex++;
            }
            
            // Common Name
            commonindex = 0;
            if (flag1 && flag2) {
                COMMname[commonindex][0] = EBname[i][0];
                COMMname[commonindex][1] = EBname[i][1];
                commonindex++;
            }
        }
    }
    
    
    
}
