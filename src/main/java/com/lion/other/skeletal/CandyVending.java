package com.lion.other.skeletal;

public class CandyVending implements Ivending {
    @Override
    public void start() {
        System.out.println("Start Vending machine");
    }

    @Override
    public void chooseProduct() {
        System.out.println("Produce different candies");
        System.out.println("Choose a type of candy");
        System.out.println("Pay for candy");
        System.out.println("Collect candy");
    }

    @Override
    public void stop() {
        System.out.println("Stop Vending machine");
    }

    /**
     * this is a process
     */
    @Override
    public void process() {
        start();
        chooseProduct();
        stop();
    }
}
