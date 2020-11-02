import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Trump
{
    public static void main(String[] args) throws Exception {
        //links excel file to apache poi, allowing access to get and set the cells of the excel spreadsheet.
        File scr = new File("C:\\Users\\matth\\Downloads\\trumptweetrework2.xlsx");
        FileInputStream fis = new FileInputStream(scr);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        //testing the abilities of the apache poi
        //String data0 = sheet1.getRow(39880).getCell(3).getStringCellValue().substring(0,10);
        //double data0 = sheet1.getRow(1).getCell(4).getNumericCellValue();
        //System.out.println(data0);
        double [] trumpretweetcount = new double [1248]; //total number of retweets per day
        double totaldayretweets = 0; //counting varible fot retweets per day
        int k = 0; // counting varrible for array index of all areas with 1248 indexies
        String [] trumptweet = new String [1248]; // store all trump tweets in a given day
        String totaldaytweet = ""; // varible that concatinates all tweets in a day to be store in trumptweet
        String [] trumpday = new String [1248]; // stores the date of the the index
        int [] tweetpd = new int [1248]; // stores the amount of tweets tweeted in a day
        int tpd = 0; // countaing variable for the amount of tweets tweeded in a day

        //traverses through the excel and stores the specified cells into the declared arrays
        for (int i = 29804; i<=40956; i++){
            if ((sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,10)).equals(sheet1.getRow(i+1).getCell(3).getStringCellValue().substring(0,10))){
                totaldayretweets += sheet1.getRow(i).getCell(4).getNumericCellValue();
                totaldaytweet += sheet1.getRow(i).getCell(2).getStringCellValue() + " || ";
                tpd++;
            }

            //if (sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,10) != sheet1.getRow(i+1).getCell(3).getStringCellValue().substring(0,10)){
            else{
                totaldayretweets += sheet1.getRow(i).getCell(4).getNumericCellValue();
                totaldaytweet += sheet1.getRow(i).getCell(2).getStringCellValue() + " || ";
                trumpday[k] = sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,10);
                tpd++;
                tweetpd [k] = tpd;
                trumptweet [k] = totaldaytweet;
                trumpretweetcount [k] = totaldayretweets;
                k++;
                totaldayretweets = 0;
                totaldaytweet = "";
                tpd = 0;
            }

        }

        // prints the day, number of tweets,retweet count, and the tweets tweeded for every day from August 1, 2016 to December 29, 2019
        for (int b = 1; b<=1247; b++){
            System.out.println(trumpday[b] + " " + tweetpd[b] + " " + trumpretweetcount[b] + " " + trumptweet[b]);

        }

        // finds the max retweet count per given day and the index of that day. Then it prints that days twitter stats.
        double max = trumpretweetcount[0];
        int maxindex = 0;
        for (int a = 1; a < trumpretweetcount.length; a++){
            if (trumpretweetcount[a] > max){
                max = trumpretweetcount[a];
                maxindex = a;
            }
        }
        System.out.println("Most retweets in a given day " + trumpday[maxindex] + " " + tweetpd[maxindex] + " " + trumpretweetcount[maxindex] + " " + trumptweet[maxindex]);

        // finds the max retweet count per tweet on a given day, and gives the index of that day. Then prints that days stats.
        double maxpt = (trumpretweetcount[0] / tweetpd[0]);
        int maxindexpt = 0;
        for(int c = 1; c < trumpretweetcount.length; c++){
            if ((trumpretweetcount[c] / tweetpd[c]) > maxpt){
                maxpt = (trumpretweetcount[c] / tweetpd[c]);
                maxindexpt = c;

            }
        }
        System.out.println("Most retweets per tweet in a given day " + trumpday[maxindexpt] + " " + tweetpd[maxindexpt] + " " + trumpretweetcount[maxindexpt] + " " + trumptweet[maxindexpt]);

        //calculates the total number of tweets tweeted from Augist 1, 2016 to December 29, 2019. Prints the number
        int sumoftweets = 0;
        for (int d: tweetpd){
            sumoftweets += d;
        }
        System.out.println("Sum of tweets from Aug 1, 2016 to Dec 29, 2019 is  " + sumoftweets);

        //calculates the total number of retweets from Augist 1, 2016 to December 29, 2019. Prints the number
        double sumofretweets = 0;
        for (double e: trumpretweetcount){
            sumofretweets += e;
        }
        System.out.println("Sum of retweets from Aug 1, 2016 to Dec 29, 2019 is  " + sumofretweets);

        // calculates the agverage number of retweets on a Trump tweet. Prints the number
        double averageretweet = 0;
        averageretweet = sumofretweets/sumoftweets;
        System.out.println("Average retweets per tweet " + averageretweet);

        //stores the same inforation as the first for-loop, but by month and not by day. 
        //I will use this data to find trends in Trumps tweets.
        double [] trumpretweetcountmonth = new double [41];
        double totaldayretweetsmonth = 0;
        int km = 0;
        String [] trumpmonth = new String [41];
        int [] tweetpm = new int [41];
        int tpm = 0;
        for (int i = 29804; i<=40956; i++){
            if ((sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,7)).equals(sheet1.getRow(i+1).getCell(3).getStringCellValue().substring(0,7))){
                totaldayretweetsmonth += sheet1.getRow(i).getCell(4).getNumericCellValue();
                tpm++;
            }

            //if (sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,10) != sheet1.getRow(i+1).getCell(3).getStringCellValue().substring(0,10)){
            else{
                totaldayretweetsmonth += sheet1.getRow(i).getCell(4).getNumericCellValue();
                trumpmonth[km] = sheet1.getRow(i).getCell(3).getStringCellValue().substring(0,7);
                tpm++;
                tweetpm [km] = tpm;
                trumpretweetcountmonth [km] = totaldayretweetsmonth;
                km++;
                totaldayretweetsmonth = 0;
                tpm = 0;
            }
        }

        double [] monthrpt = new double [41];
        for(int hh = 0; hh<41; hh++){
            monthrpt [hh] = trumpretweetcountmonth[hh]/tweetpm[hh];
            System.out.println(trumpmonth[hh] + " " + trumpretweetcountmonth[hh] + " " + tweetpm[hh] + " " + monthrpt[hh]);
        }
        // I entered the monthrpt into the program loggerpro, to find the linear line of best fit. 
        // Now I have the equation of Trumps tweet popularity.
        //g = the month from August 1,2016 of Trumps average retweet count on one of his tweets.
        int g = 99;
        double tweetpopularity = 14094 + (166.4*g);
        //when a = 40, the month will be December 2019. a = 99 when the next president after the upcoming election
        //will be elected. Thus, if trump gets reelected, then at a = 99, a new president will be elected, making 
        // trump a lame duck. This will be the peak of his twitter account in terms of retweets per tweet.
        System.out.println("Projected number of retweets per tweet in November 2024 is  " + tweetpopularity);
        //monthrpt[3] = the retweet per tweet when trump was first elected. Thus,tweetpopularity/monthrpt[3] *100 will calculate
        // the percent increase in Trumps tweets popularity from when we was first elected to when he could poteintally 
        // become a lame duck after the the 2024 election.(If he gets elected for a second term)
        double percentIncreaseTweetPopularity = (tweetpopularity / monthrpt[3]) * 100;
        System.out.println("Percent increase in Retweets per tweet from when Trump first elected and 2024 election is  " + percentIncreaseTweetPopularity);
        //This calculation came to be 159.88796094612417. Thus Trumps tweets could become 159.88796094612417% more popular by
        // the end of his influencal presidential term, compared to when he first got elected.

        
        //Now I will do the same thing but instead look at only the number of tweets tweeted by Trump.
        //First I enter tweetpm[] into logger pro and find the best fit equation.
        double numberoftweetsprojected = 144.5 + (6.071 * g);
        System.out.println("number of tweets projected in the month of November 2024 is  " + numberoftweetsprojected);
        double percentIncreaseTweet = (numberoftweetsprojected / tweetpm[3]) * 100;
        System.out.println("Percent increase in number of tweets tweeted by Trump from Nov 2016 to Nov 2024 is  " + percentIncreaseTweet);
        //This calculates to be a 409.63131868131865% increase. 

        //Now I will find how many Trump Tweets are projected from January 1, 2020 to November 30, 2024
        double tweetprojectedsum = 0;
        for (int gg = 41; gg<=98; gg++){
            tweetprojectedsum += (144.5 + (6.071 * gg));
        }
        System.out.println("Project number of tweets from Jan 2020 to Nov 2024 is  " + tweetprojectedsum);

        //number of days in this projection is 2131.
        System.out.println("On average  " + (tweetprojectedsum / 2131) + " tweets are needed per day to maintain this projecton.");
        System.out.println("It must be very difficult to be president! Very Cool Trump!");

    }
}
