package com.lion.DesignPattern.ConstrctorBuilder.Demo1;

/**
 * Created by TigerChain
 * 具体的建造者，这里是商场的一个装机人员
 */
public class AssemblerBuilder implements Builder {

    private Computer computer = new Computer() ;
    @Override
    public void createCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void createhardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
    }

    @Override
    public void createMainBoard(String mainBoard) {
        computer.setMainBoard(mainBoard);
    }

    @Override
    public void createMemory(String memory) {
        computer.setMemory(memory);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
