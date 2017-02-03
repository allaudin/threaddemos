package io.github.allaudin;

import io.github.allaudin.cbarrier.BarrierApp;
import io.github.allaudin.clatch.LatchApp;
import io.github.allaudin.sem.SemApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Qazi on 2017-02-03.
 *
 * @author M.Allaudin
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Select the demo to run\n\n1) CountDownLatch\n2) CyclicBarrier\n3) Semaphore\n");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String option = br.readLine();

            switch (option){
                case "1": {
                    System.out.println("\nStarting CountDownLatch demo...");
                    LatchApp.run();
                    break;
                }
                case "2": {
                    System.out.println("\nStarting CyclicBarrier demo...");
                    BarrierApp.run();
                    break;
                }
                case "3": {
                    System.out.println("\nStarting Semaphore demo...");
                    SemApp.run();
                    break;
                }
                default: {
                    System.out.println("Not a valid option. Quitting.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main

} // App
