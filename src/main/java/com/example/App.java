package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
       try {
        int random = (int) (Math.random()*100 +1); 
        System.out.println(random);
        System.out.println("Avvio Server");
        ServerSocket server = new ServerSocket(5600);
        Socket s = server.accept();
        System.out.println("Il Client si è connesso");
        BufferedReader ingresso = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream uscita = new DataOutputStream(new DataOutputStream(s.getOutputStream()));
        String num;
        int n = 0;
        int tentativi = 0;
        do {
            tentativi++;
            num = ingresso.readLine();
            n = Integer.parseInt(num);
            if(n < random && n!=0)
            {
                System.out.println("1");
                uscita.writeBytes("1" + "\n");
            }
            if(n > random && n!=0)
            {
                System.out.println("2");
                uscita.writeBytes("2" + "\n");
            }
        } while (n != random);
            System.out.println("3");
                uscita.writeBytes("3" + "\n");
                System.out.println(tentativi);
                server.close();
                s.close();

       } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Errore");
        System.exit(1);
       }
    }
}
