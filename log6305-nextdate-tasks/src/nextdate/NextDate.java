package nextdate;
// This is mutant program.
// Author : ysma

import java.util.*;


public class NextDate
{

    static final int ILLEGALYEAR = -3;

    static final int ILLEGALMOUNTH = -2;

    static final int ILLEGALDAY = -1;

    static int daysinmounth = 0;

    public static void main( java.lang.String[] args )
    {
    	NextDate nextDate = new NextDate();
        int day = new java.lang.Integer( args[0] );
        int month = new java.lang.Integer( args[1] );
        int year = new java.lang.Integer( args[2] );
        
        int[] date = new int[3];
        date[0] = day;
        date[1] = month;
        date[2] = year;
        
        nextDate.nexDate( date );
        System.exit( 0 );
    }

    public void nexDate( int[] date)
    {
    	int day = date[0];
    	int month = date[1];
    	int year = date [2];
    	
        int daysinmonth = 0;
        java.lang.String message = "";
        if (year < 2000 || year > 2999) {
            message = "Illigal year!!!";
        } else {
            if (month < 1 || month > 12) {
                message = "Illigal month!!!";
            } else {
                switch (month) {
                case 1 :
                case 3 :
                case 5 :
                case 7 :
                case 8 :
                case 10 :
                case 12 :
                    daysinmonth = 31;
                    break;

                case 2 :
                    {
                        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                            daysinmonth = 29;
                        } else {
                            daysinmonth = 28;
                        }
                        break;
                    }

                default  :
                    daysinmonth = 30;

                }
                if (day < 1 || day > daysinmonth) {
                    message = "Illigal day!!!";
                } else {
                    if (day == daysinmonth) {
                        day = 1;
                        if (month != 12) {
                            month++;
                        } else {
                            month = 1;
                            year++;
                        }
                    } else {
                        day++;
                    }
                    message = day + "/" + month + "/" + year;
                }
            }
        }
        System.out.println( message );
    }

}
