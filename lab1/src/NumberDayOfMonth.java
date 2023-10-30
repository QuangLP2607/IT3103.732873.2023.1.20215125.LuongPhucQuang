import javax.swing.JOptionPane;
public class NumberDayOfMonth {
	public static void main(String[] args) {	
		int year = getInputYear();
		int month=getInputMonth();
		int day = calculateDaysInMonth(year,month);
		
		JOptionPane.showMessageDialog(null, 
				 "Số ngày trong tháng là: " + day, "Kết quả", 
				 JOptionPane.INFORMATION_MESSAGE);
		 
		System.exit(0);
	}
	//Input year
	public static int getInputYear() {
	    int year = 0;
    	boolean validInput = false;
		while (!validInput) {
			String strYear = JOptionPane.showInputDialog(null,
	                "Please input the year: ","Input the year", 
	                JOptionPane.INFORMATION_MESSAGE);
            try {
                if (strYear != null) {
                    year = Integer.parseInt(strYear);
                    validInput = true;
                } 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                		"Invalid year!", "Error", 
                		JOptionPane.ERROR_MESSAGE);
            }
	    }
	    return year;
	}
	//Input month 
    public static int getInputMonth() {
	    int month=0;
		do {
			String strMon = JOptionPane.showInputDialog(null,
	                "Please input the month: ","Input the month", 
	                JOptionPane.INFORMATION_MESSAGE);
			switch (strMon) {
		    case "January":
		    case "Jan.":
		    case "Jan":
		    case "1":
		        month = 1;
		        break;
		    case "February":
		    case "Feb.":
		    case "Feb":
		    case "2":
		        month = 2;
		        break;
		    case "March":
		    case "Mar.":
		    case "Mar":
		    case "3":
		        month = 3;
		        break;
		    case "April":
		    case "Apr.":
		    case "Apr":
		    case "4":
		        month = 4;
		        break;
		    case "May":
		    case "5":
		        month = 5;
		        break;
		    case "June":
		    case "Jun":
		    case "6":
		        month = 6;
		        break;
		    case "July":
		    case "Jul":
		    case "7":
		        month = 7;
		        break;
		    case "August":
		    case "Aug.":
		    case "Aug":
		    case "8":
		        month = 8;
		        break;
		    case "September":
		    case "Sept.":
		    case "Sep":
		    case "9":
		        month = 9;
		        break;
		    case "October":
		    case "Oct.":
		    case "Oct":
		    case "10":
		        month = 10;
		        break;
		    case "November":
		    case "Nov.":
		    case "Nov":
		    case "11":
		        month = 11;
		        break;
		    case "December":
		    case "Dec.":
		    case "Dec":
		    case "12":
		        month = 12;
		        break;
		    default:
		    	JOptionPane.showMessageDialog(null, 
		    			"Invalid month!", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }
	    } while (month>12||month<1);
	    return month;
	}
    public static int calculateDaysInMonth(int year, int month) {
        int days;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear(year))
                    days = 29;
                else
                    days = 28;
                break;
            default:
                days = 0; // Handle invalid months
                break;
        }
        return days;
    }
    // check leap year
    public static boolean isLeapYear(int year) {
    	 return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}






