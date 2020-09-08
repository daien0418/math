package com.dai.en.questions;

import java.util.Random;

public class SkipList {

    int size = 0;
    int currentLevel = 0;
    final int maxLevel = 2 << 3;
    public SkipListNode header = new SkipListNode(-1, "head Node", maxLevel);

    public SkipListNode find(int score) {
        SkipListNode temp = header;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].score < score) {
                temp = temp.next[i];
            }

            if (temp.next[i] != null && temp.next[i].score == score) {
                return temp.next[i];
            }

        }

        return temp.next[0];
    }

    public void insert(int score, String value) {
        int level = getLevel(score);
        SkipListNode newNode = new SkipListNode(score, value, level);

        SkipListNode temp = header;
        // SkipListNode[] preNodes = new SkipListNode[level];

        for (int i = level - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].score < score) {
                temp = temp.next[i];
            }
            newNode.next[i] = temp.next[i];
            temp.next[i] = newNode;
        }

        currentLevel = Math.max(currentLevel, level);
        size++;
    }

    public void delete(int score) {
        SkipListNode temp = header;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].score < score) {
                temp = temp.next[i];
            }

            if (temp.next[i] != null && temp.next[i].score == score) {
                temp.next[i] = temp.next[i].next[i];
            }
        }
    }

    private int getLevel(int score) {
        Random random = new Random();
        return random.nextInt(maxLevel) + 1;
    }

    public int getLevel() {
        return this.currentLevel;
    }

    public static void main(String args[]) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 20; i++) {
            skipList.insert(i, "i am " + i + " so");
        }

        int level = skipList.getLevel();
        System.out.println("²ãÊý:" + level);
        for (int i = level - 1; i >= 0; i--) {
            SkipListNode temp = skipList.header;
            while(temp!=null){
                System.out.print(temp.score+"-->");
                temp = temp.next[i];
            }
            System.out.println();
        }

        System.out.println(skipList.find(5).value);
    }
}

class SkipListNode {
    int score;
    String value;
    SkipListNode[] next;
    int level;

    public SkipListNode(int score, String value, int level) {
        this.score = score;
        this.value = value;
        this.level = level;
        this.next = new SkipListNode[level];
    }
}
