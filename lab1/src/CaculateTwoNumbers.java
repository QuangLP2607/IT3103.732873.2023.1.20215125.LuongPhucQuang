// CaculateTwoNumbers.java
import javax.swing.JOptionPane;
public class CaculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2; 

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ","Input the first number", 
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, 
                "Please input the second number: ","Input the second number", 
                JOptionPane. INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double result;
        // add
        result = num1 + num2;
        System.out.printf("%.2f + %.2f = %.2f\n",num1,num2,result);
        // sub 
        result = num1 - num2;
        System.out.printf("%.2f - %.2f = %.2f\n",num1,num2,result);
        // mul 
        result = num1 * num2;
        System.out.printf("%.2f * %.2f = %.2f\n",num1,num2,result);
        // div
        if (num2 == 0) 
        {
            System.out.println("Cannot divide by zero");
        } else 
            {
                result = num1 / num2;
                System.out.printf("%.2f / %.2f = %.2f\n",num1,num2,result);
            }
        
        System.exit(0);
    }
}

