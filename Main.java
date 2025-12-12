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
        if(month<0 || month > 12) return "INVALID_MONTH";
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
        if(month<0 || month > 12 || day < 0 || day >28){return ERROR;}
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
        if(month > 12 || month < 0) {return -1;}
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
                monthTotal=dataMemory[i][j][commodityIndex];
            }
            if(monthTotal>bestMonthTotal) {
                bestMonthIndex=i;
                bestMonthTotal=monthTotal;
            }
        }




        return commodities[bestMonthIndex];
    }

    public static int consecutiveLossDays(String comm) { 
        return 1234; 
    }
    
    public static int daysAboveThreshold(String comm, int threshold) { 
        return 1234; 
    }

    public static int biggestDailySwing(int month) { 
        return 1234; 
    }
    
    public static String compareTwoCommodities(String c1, String c2) { 
        return "DUMMY is better by 1234"; 
    }
    
    public static String bestWeekOfMonth(int month) { 
        return "DUMMY"; 
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}