/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import java.util.*;

public class RandNumGen {
    public static void main(String ar[])    {
        Random random = new Random();
        Scanner s = new Scanner(System.in);
        int OTP;
        
        boolean generateAgain = true;
        do  {
            System.out.print("Generate OTP??(y/n): ");
            if(s.next().equalsIgnoreCase("y"))  {
                System.out.println("OTP generated is: "+random.nextInt(10000));
            }
            else    {
                generateAgain = false;
            }
        }while(generateAgain);
    }
}
