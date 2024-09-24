package com.hcl.hackathon.devlopment.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    
    public List<String> data = new ArrayList<>(5);
    
    public void produce() throws InterruptedException {
        while(true) {
            System.out.println(
                " wait Producing data " + data + " " + Thread.currentThread().getName() + " " + Thread.currentThread()
                    .getState());
            synchronized(this) {
                System.out.println(
                    "Producing data " + data + " " + Thread.currentThread().getName() + " " + Thread.currentThread()
                        .getState());
                if (data.size() >= 5) {
                    wait();
                }
                data.add("data");
                notify();
                Thread.sleep(1000);
            }
        }
    }
    
    public void consume() throws InterruptedException {
        while(true) {
            System.out.println(
                "wait consume data " + data + " " + Thread.currentThread().getName() + " " + Thread.currentThread()
                    .getState());
            synchronized(this) {
                System.out.println(
                    "Consuming data " + data + " " + Thread.currentThread().getName() + " " + Thread.currentThread()
                        .getState());
                if (data.size() <= 0) {
                    wait();
                }
                data.remove(0);
                notify();
                Thread.sleep(1000);
            }
        }
    }

}
