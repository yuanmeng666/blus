package com.arr;

public class ArrayQueqeDemo {
    public static void main(String[] args) {
        ArrayQueqe arrayQueqe = new ArrayQueqe(5);
        arrayQueqe.addQueue(11);
        System.out.println("111111111111");
        arrayQueqe.showAllqueue();
        arrayQueqe.addQueue(12);
        System.out.println("2222222");

        arrayQueqe.showAllqueue();
        arrayQueqe.addQueue(13);
        System.out.println("33333");
        arrayQueqe.showAllqueue();

        arrayQueqe.addQueue(14);
        System.out.println("44444");
        arrayQueqe.showAllqueue();
        arrayQueqe.addQueue(15);
        System.out.println("5555");
        arrayQueqe.showAllqueue();
    }
}

class ArrayQueqe {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public ArrayQueqe(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //队列是否已经满了
    public boolean isFull() {
        // return rear==maxSize-1;
        return (rear + 1  ) % maxSize == front;
    }

    //队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加队列元素
    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列已经满了，不能加入数据");
            return;
        } else {
            arr[rear] = n;
            rear=(rear+1)%maxSize;
        }
    }

    //取出队列元素
    public int getQueue() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("ss");
        }

        int temp = arr[front];
        arr[front] = 0;
        front=(front+1)%maxSize;
        return temp;
    }

    //遍历队列数据
    public void showAllqueue() {
        if (isEmpty()) {
            System.out.println("没有数据了。");
        }
        int temp =(rear  +maxSize -front)%maxSize;
        System.out.println(temp+"---temp");
        for (int i = front ; i < front+temp; i++) {
            System.out.println("遍历数据为：" + arr[i]);
        }
    }

    //显示队列的头数据
    public int getFirstQueue() {
        if (isEmpty()) {
            System.out.println("没有数据了。");
        }
        return arr[rear + 1];
    }
}
