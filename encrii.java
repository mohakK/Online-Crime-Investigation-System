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
public class encrii {
    public static void main(String []args) 
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message ");
      String msg = sc.nextLine();
      char ar[] = msg.toCharArray();
      int i,j,n;
      if(ar.length%2==0)
      n=ar.length;
      else
          n=ar.length-1;
      for(i=0;i<n;i=i+2)
      {
       for(j=1;j<n;j=j+2) 
       {
           char c = ar[i];
           ar[i]=ar[j];
           ar[j]=c;
       }
      }
      for(i=0;i<ar.length;i++)
      {
          System.out.print(ar[i]);
      }
      String ems = String.valueOf(ar);
      String ms="";
      int key = (int)(Math.random()*50)%10;
      for(i=0;i<ems.length();i++)
      {
           char ch = ems.charAt(i);
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
       ar=msg.toCharArray();
       for(i=0;i<n;i=i+2)
      {
       for(j=1;j<n;j=j+2) 
       {
           char c = ar[i];
           ar[i]=ar[j];
           ar[j]=c;
       }
      }
       msg=String.valueOf(ar);
       System.out.println("Decrypted "+msg);
    }
}
