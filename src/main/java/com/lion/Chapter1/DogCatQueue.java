package com.lion.Chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */
public class DogCatQueue {
    // dog queue
    private Queue<PetEnterQueue> dogQ;
    // cat queue
    private Queue<PetEnterQueue> catQ;
    // 记录总数
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error");
        }
    }

    public Pet poll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return catQ.poll().getPet();
            } else {
                return dogQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty!");
        }
    }
}
