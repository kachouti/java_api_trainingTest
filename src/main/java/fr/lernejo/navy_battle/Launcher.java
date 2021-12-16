package fr.lernejo.navy_battle;

import java.io.IOException;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length < 1) {
            throw new IllegalArgumentException("vous devez spécifier un  port (serveur) en argument");
        }
        else {
            if(args.length == 1) {
                System.out.println(" port : " + args[0]);
                int portS = Integer.valueOf(args[0]);

                if(portS <= 0) {
                    throw new IllegalArgumentException("port doit etre positive ");
                }

                Server serv = new Server(portS);
                serv.Create(portS);
            }
            else if(args.length == 2) {
              
                int portC = Integer.valueOf(args[0]);

                if(portC <= 0) {
                    throw new IllegalArgumentException("port :positive");
                }

                Client cl = new Client(portC);
                cl.send(args[1]);
            }
            
        }
    }
}