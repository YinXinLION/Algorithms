package com.lion.other.skeletal;

public class CandyVendingNew extends VendingService implements Ivending {
    private class AbstractVendingDelegator extends AbstractVending {
        @Override
        public void chooseProduct() {
            System.out.println("Produce diiferent candies");
            System.out.println("Choose a type of candy");
            System.out.println("Pay for candy");
            System.out.println("Collect candy");
        }
    }
    AbstractVendingDelegator delegator = new AbstractVendingDelegator();

    @Override
    public void start() {
        delegator.start();
    }
    @Override
    public void chooseProduct() {
        delegator.chooseProduct();
    }
    @Override
    public void stop() {
        delegator.stop();
    }
    @Override
    public void process() {
        delegator.process();
    }
}
