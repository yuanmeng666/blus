package com.arr;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class LinkedList{
    private HeroNode head;
    //添加英雄节点
    public void addNode(HeroNode node){
        if (head ==null){
            System.out.println("没有头节点。加锤子");
        }
        HeroNode temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(node);
    }

    //删除英雄节点
    public void deleteHero(String data){
        if (head ==null){
            System.out.println("没有头节点。删锤子");
        }
        HeroNode temp=head;
        while (temp.getNext()!=null){
            if(data.equals(temp.getNext().getId())){
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp=temp.getNext();
        }
        System.out.println("");
    }

}
class HeroNode{
    private int id;
    private String name;
    private HeroNode next;


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HeroNode getNext() {

        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }


}
