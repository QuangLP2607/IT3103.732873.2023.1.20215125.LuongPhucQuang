import javax.swing.JOptionPane;
import java.lang.Math;
public class SolveEquation{
    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog(null,
                "Chọn phương trình:\n" +
                "1. Phương trình tuyến tính bậc nhất\n" +
                "2. Hệ phương trình tuyến tính\n" +
                "3. Phương trình bậc hai",
                "Options", JOptionPane.INFORMATION_MESSAGE);
        // 
        if (str.equals("1")) {
            FirstDegreeEquation();
        } else if (str.equals("2")) {
            LinearSystem();
        } else if (str.equals("3")) {
            SecondDegreeEquation();
        } else {
        	JOptionPane.showMessageDialog(null, 
            		"Invalid input!", "Error", 
            		JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
    
    public static void FirstDegreeEquation(){  
    	String strNum1, strNum2;
    	
    	strNum1 = JOptionPane.showInputDialog(null,
    			"a = ", "aX + b = 0",
    			JOptionPane.INFORMATION_MESSAGE);
    	
    	strNum2 = JOptionPane.showInputDialog(null,
    			"b = ","aX + b = 0",
    			JOptionPane.INFORMATION_MESSAGE);
    	
    	double a = Double.parseDouble(strNum1);
    	double b = Double.parseDouble(strNum2);
       
       if ( a == 0) {
          if (b == 0) {
        	  	JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
          }
          else {
        	  JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
          }
       }
       else{  
    	   	JOptionPane.showMessageDialog(null, "Phương trình có nghiệm: " + -b/a);
       }
    }

     public static void LinearSystem()
     {
        double[][] A = new double[2][2];
        double[] B = new double[2];

        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        strNum1 = JOptionPane.showInputDialog(null, "a11 = ", "a11*X + a12*Y = b1", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "a12 = ", "a11*X + a12*Y = b1", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null, "b1 = ", "a11*X + a12*Y = b1", JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null, "a21 = ", "a21*X + a22*Y = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null, "a22 = ", "a21*X + a22*Y = b2", JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null, "b2 = ", "a21*X + a22*Y = b2", JOptionPane.INFORMATION_MESSAGE);
      
        A[0][0] = Double.parseDouble(strNum1);
        A[0][1] = Double.parseDouble(strNum2);
        B[0] = Double.parseDouble(strNum3);
        A[1][0] = Double.parseDouble(strNum4);
        A[1][1] = Double.parseDouble(strNum5);
        B[1] = Double.parseDouble(strNum6);
        
        double detA = A[0][0] * A[1][1] - A[0][1] * A[1][0];
        // Tính det
        if (detA == 0) {
            if ((A[0][0] * B[1] - A[1][0] * B[0]) == 0 && (A[0][1] * B[1] - A[1][1] * B[0]) == 0) {
            	JOptionPane.showMessageDialog(null, "Hệ phương trình vô số nghiệm");
            } else {
            	JOptionPane.showMessageDialog(null, "Hệ phương trình vô nghiệm");
            }
        } else {
            double x = (B[0] * A[1][1] - B[1] * A[0][1]) / detA;
            double y = (A[0][0] * B[1] - A[1][0] * B[0]) / detA;
            JOptionPane.showMessageDialog(null, "Hệ phương trình có nghiệm:\nX: " + x + "\nY: " + y);
        }
    }

    public static void SecondDegreeEquation() {  
    	String strNum1, strNum2, strNum3;
    	
    	strNum1 = JOptionPane.showInputDialog(null,
    			"a = ", "aX^2 + bX + c  = 0",
    			JOptionPane.INFORMATION_MESSAGE);
    	
       strNum2 = JOptionPane.showInputDialog(null,
    		   "b = ", "aX^2 + bX + c  = 0",
    		   JOptionPane.INFORMATION_MESSAGE);
       
       strNum3 = JOptionPane.showInputDialog(null,
    		   "c = ", "aX^2 + bX + c  = 0",
    		   JOptionPane.INFORMATION_MESSAGE);
       
       double a = Double.parseDouble(strNum1);
       double b = Double.parseDouble(strNum2);
       double c = Double.parseDouble(strNum3);
       double delta;
       
       if (a == 0) { 
	       if ( b == 0) {
	    	   if (c == 0) {
	    		   JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
	    	   }
	    	   else {
	    		   JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
	    	   }
	       }
	       else {  
	    	   	JOptionPane.showMessageDialog(null, "Phương trình có nghiệm: " + -c/b);
	       }
       }
       else {
    	   	delta = b*b -4*a*c;
    	   	if (delta < 0) {
    	   		JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
    	   	}
    	   	if (delta == 0) {
    	   		JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép: " + (-b / (2 * a)));
    	   	}
            if (delta > 0) {   
            	double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            	double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            	JOptionPane.showMessageDialog(null, 
            			"Phương trình có hai nghiệm phân biệt:\nX1= " + x1 + "\nX2= " + x2 );
            }
       }
    }
}

