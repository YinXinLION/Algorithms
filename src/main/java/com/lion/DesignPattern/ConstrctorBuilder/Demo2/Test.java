package com.lion.DesignPattern.ConstrctorBuilder.Demo2;

/**
 * 替代多参数构造函数的建造者模式
 */
public class Test {
    public static void main(String[] args) {
        // 不使用建造者模式
        Computer computer = new Computer("主板","cpu","hd","电源","显卡"
                ,"鼠标","机箱","鼠标垫") ;
        System.out.println("使用普通的构造方法组装电脑："+computer.toString());

        // 使用建造者模式
        ComputerB computerB = new ComputerB.ComputerBuilder("主板","cpu","hd","电源","显卡")
                .setMouse("鼠标").setMousePad("垫子").build() ;
        System.out.println("使用建造者模式组装电脑："+computerB.toString());
    }
}
