/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
/**
 *
 * @author Sanjana13
 */
public class mesencr {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message");
        String msg=sc.nextLine();
        String ms = "";
       int i,j;
       int key = (int)(Math.random()*50)%10;
        for(i=0;i<msg.length();i++)
      {
           char ch = msg.charAt(i);
           ch=(char)(ch+key);
            ms=ms+ch;
      }
      System.out.println("Encrypted "+ms);
      msg="";
       for(i=0;i<ms.length();i++)
      {
           char ch = ms.charAt(i);
           ch=(char)(ch-key);
           msg=msg+ch;
      }
       System.out.println("Decrypted "+msg);
    }
    }

