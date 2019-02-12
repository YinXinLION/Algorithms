package com.lion.DesignPattern.ConstrctorBuilder.Demo2;

/**
 * 这种多参数构造器是不好的，如果需要1个 2个 3个 要写很多构造器
 */
public class Computer {
    private String mainBoard ;     // 主板
    private String cpu ;           // cpu
    private String hd ;            // 硬盘
    private String powerSupplier ; // 电源
    private String graphicsCard;   // 显卡

    // 其它一些可选配置
    private String mouse ; // 鼠标
    private String computerCase ; //机箱
    private String mousePad ;   //鼠标垫
    private String other ;  //其它配件


    public Computer(String mainBoard,String cpu,String hd,String powerSupplier,
                    String graphicsCard,String mouse,String computerCase,String mousePad,String other){
        this.mainBoard = mainBoard ;
        this.cpu = cpu ;
        this.hd = hd ;
        this.powerSupplier = powerSupplier ;
        this.graphicsCard = graphicsCard ;
        this.mouse = mouse ;
        this.computerCase = computerCase ;
        this.mousePad = mousePad ;
        this.other = other ;
    }

    public Computer(String mainBoard,String cpu,String hd,String powerSupplier,
                    String graphicsCard,String mouse,String computerCase,String mousePad){
        this.mainBoard = mainBoard ;
        this.cpu = cpu ;
        this.hd = hd ;
        this.powerSupplier = powerSupplier ;
        this.graphicsCard = graphicsCard ;
        this.mouse = mouse ;
        this.computerCase = computerCase ;
        this.mousePad = mousePad ;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getPowerSupplier() {
        return powerSupplier;
    }

    public void setPowerSupplier(String powerSupplier) {
        this.powerSupplier = powerSupplier;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(String computerCase) {
        this.computerCase = computerCase;
    }

    public String getMousePad() {
        return mousePad;
    }

    public void setMousePad(String mousePad) {
        this.mousePad = mousePad;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
