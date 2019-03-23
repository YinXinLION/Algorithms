package com.lion.other.skeletal;

/**
 * 当接口有公用方法时可以创建抽象类，使用子类作为委派器，使用骨架实现。
 */
public class VendingManager {
    public static void main(String[] args) {
        Ivending candy = new CandyVending();
        Ivending drink = new DrinkVending();
//        可以看到其中有很多重复代码，start、stop、process
//        接口缺点：一种约定且不包含方法块，因此每个类必须按照约定去实现接口中所有方法，某些方法可能会重复。
        candy.process();
        drink.process();
        System.out.println("====================");
        //引入抽象类后，提供了通用的代码，但不能继承其他类了
        //如果引入VendingServicing类，负责清洁售货机，那么可以采用组合？会产生强耦合

        AbstractVending candy1 =  new CandyVending1();
        AbstractVending drink1 =  new DrinkVending1();
        candy1.process();
        System.out.println("*********************");
        drink1.process();

        System.out.println("===================");
        // 好处 子类可以继承其他类
        // 通过调用委托给抽象类消除代码重复
        // 子类可以根据需要实现其他的接口
        Ivending candyNew = new CandyVendingNew();
        candy.process();
        if (candy instanceof VendingService) {
            VendingService vs = (VendingService)candy;
            vs.service();
        }

    }
}
