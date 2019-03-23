package com.lion.other.skeletal;

public abstract class AbstractVendingNew implements Ivending{
    public void start()
    {
        System.out.println("Start Vending machine");
    }
    public void stop()
    {
        System.out.println("Stop Vending machine");
    }
    public void process()
    {
        start();
        chooseProduct();
        stop();
    }
}
