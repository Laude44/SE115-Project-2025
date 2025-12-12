// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static final int ERROR = -99999;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};
    public static int[][][] dataMemory = new int[MONTHS][DAYS][COMMS];

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        if(month<0 || month > 11) return "INVALID_MONTH";
        int mostProfComIndex=0;
        int mostProfComProfit=0;

        for(int i =0;i<COMMS;i++){
            int comsTotalProfit=0;
            for(int j =0;j<DAYS;j++){
            comsTotalProfit += dataMemory[month][j][i];
            }
            if(comsTotalProfit > mostProfComProfit){
                mostProfComIndex=i;
                mostProfComProfit=comsTotalProfit;}
        }
        return commodities[mostProfComIndex] + mostProfComProfit;
    }

    public static int totalProfitOnDay(int month, int day) {
        if(month<0 || month > 11 || day < 0 || day >28){return ERROR;}
        int total=0;
        for(int i=0;i<COMMS;i++){
            total += dataMemory[month][day][i];
        }
        return total;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
    if(from > to || from < 1 || to > 28 ){return ERROR;}
    int commodityIndex =-1;
        for(int i=0;i<commodities.length;i++){
            if(commodity.equals(commodities[i])){commodityIndex=i;}
        }
        if(commodityIndex==-1){return ERROR;}
        int total =0;
        for(int i=0;i<MONTHS;i++){
            for(int j=from -1 ;j<to -1 ;j++){
            total += dataMemory[i][j][commodityIndex];
        }
    }
        return total;
    }

    public static int bestDayOfMonth(int month) { 
        if(month > 11 || month < 0) {return -1;}
        int bestDayIndex=-1;
        int bestDayTotal=0;

        for(int i=0;i<28;i++){
            int dayTotal=0;
            for(int j=0;i<5;i++){
                dayTotal+=dataMemory[month][i][j];
            }
            if(dayTotal>bestDayTotal){
                bestDayTotal=dayTotal;
                bestDayIndex=i;}
        }
        return bestDayIndex;
    }
    
    public static String bestMonthForCommodity(String comm) {
        int commodityIndex =-1;
        for(int i=0;i<commodities.length;i++){
            if(comm.equals(commodities[i])){commodityIndex=i;}
        }
        if(commodityIndex==-1){return "INVALID_COMMODITY";}
        int bestMonthIndex=-1;
        int bestMonthTotal=0;
        for(int i=0;i<12;i++){
            int monthTotal=0;
            for(int j=0;j<28;j++){
                monthTotal += dataMemory[i][j][commodityIndex];
            }
            if(monthTotal>bestMonthTotal) {
                bestMonthIndex=i;
                bestMonthTotal=monthTotal;
            }
        }
        return commodities[bestMonthIndex];
    }

    public static int consecutiveLossDays(String comm) {
        int commodityIndex =-1;
        for(int i=0;i<commodities.length;i++){
            if(comm.equals(commodities[i])){commodityIndex=i;}
        }
        if(commodityIndex==-1){return -1;}
        int loseStreak =0;
        for(int i=0;i<12;i++){
            for(int j=0;j<28;j++){
                if(dataMemory[i][j][commodityIndex]<0){
                    loseStreak++;
                }
                else{loseStreak=0;
                }
            }
        }
        return loseStreak;
    }
    
    public static int daysAboveThreshold(String comm, int threshold) {
        int commodityIndex =-1;
        for(int i=0;i<commodities.length;i++){
            if(comm.equals(commodities[i])){commodityIndex=i;}
        }
        if(commodityIndex==-1){return -1;}
        int thresholdCounter=0;
        for(int i=0;i<12;i++){
            for(int j=0;j<28;j++){
                if(dataMemory[i][j][commodityIndex]>threshold){
                    thresholdCounter++;
                }
            }
        }
        return thresholdCounter;
    }

    public static int biggestDailySwing(int month) {
        if (month < 0 || month > 11) return ERROR;

        int previousDayTotal = 0;
        int biggestSwing = 0;

        for (int j=0;j<5;j++) {
            previousDayTotal += dataMemory[month][0][j];
        }

        for (int i=1;i<28;i++) {
            int daysTotal = 0;
            for (int j=0;j<5;j++) {
                daysTotal += dataMemory[month][i][j];
            }
            int swing = Math.abs(daysTotal - previousDayTotal);
            if (swing > biggestSwing) biggestSwing = swing;
            previousDayTotal = daysTotal;
        }

        return biggestSwing;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        int commodityIndexc1 =-1;
        int commodityIndexc2 =-1;
        for(int i=0;i<commodities.length;i++){
            if(c1.equals(commodities[i])){commodityIndexc1=i;}
        }
        for(int i=0;i<commodities.length;i++){
            if(c2.equals(commodities[i])){commodityIndexc2=i;}
        }
        if(commodityIndexc1==-1 || commodityIndexc2==-1){return "INVALID_COMMODITY";}
        int c1Total =0;
        int c2Total =0;
        for(int i=0;i<12;i++){
            for(int j=0;j<28;j++){
                c1Total += dataMemory[i][j][commodityIndexc1];
                c2Total += dataMemory[i][j][commodityIndexc2];
            }
        }
        if(c1Total>c2Total){return c1+" is better than "+c2;}
        else if(c1Total<c2Total){return c2+" is better than "+c1;}
        else {return c1+" is equal to "+c2;}
    }
    
    public static String bestWeekOfMonth(int month) {
        if(month > 11 || month < 0) {return "INVALID_MONTH";}
        for(int i =0;i<4;i++){
            int bestWeek=0;
            for(int j=0;j<7;j++){

            }
        }


        return "DUMMY"; 
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}