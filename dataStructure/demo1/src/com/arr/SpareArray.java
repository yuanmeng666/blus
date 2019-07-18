package com.arr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SpareArray {
    public static void main(String[] args) {
        int arr[][]=new int[11][11];
        arr[1][3]=1;
        arr[2][3]=2;
        arr[3][4]=1;
        arr[5][4]=2;

//棋盘数组为
        System.out.println("棋盘数组为:");
        for ( int[] row : arr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int sumcout=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    sumcout++;
                }
            }
        }
        System.out.println("棋子的总数为："+sumcout);

        //创建稀疏数组：第一列：行 第二列 列 第三列 下的棋子总数
        int spareArr[][] =new int[sumcout+1][3];
        spareArr[0][0]=11;
        spareArr[0][1]=11;
        spareArr[0][2]=sumcout;

        //遍历数组
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){

                if(arr[i][j]!=0){
                    count++;
                    spareArr[count][0]=i;
                    spareArr[count][1]=j;
                    spareArr[count][2]=arr[i][j];
                }
            }
        }

        System.out.println("稀疏数组为:");
        for ( int[] row : spareArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//将稀疏数组保存到磁盘
        System.out.println("将稀疏数组保存到磁盘");
        try {
            File datafile =new File("D:\\data.map");
            FileWriter writer =new FileWriter(datafile);

            for ( int[] row : spareArr){
                for (int data : row){
                    writer.write(data+"\t");
                }
                writer.write("\r\n");
            }
            writer.close();
            System.out.println("从磁盘读取文件转化为二维数组");
            int arrfile[][]=new int[5][5];
            FileReader in=new FileReader("D:\\data.map");
            BufferedReader reader=new BufferedReader(in);
            String line ="";
            int begin=0;
            while ((line =reader.readLine() )!=null){
                String[] temp=line.split("\t");
                for (int i=0;i<temp.length;i++){
                    arrfile[begin][i]=Integer.parseInt(temp[i]);
                }
                begin++;
            }
            in.close();
            System.out.println("解析数组");
            for ( int[] row : arrfile){
                for (int data : row){
                    System.out.printf("%d\t",data);
                }
                System.out.println();
            }

           // DataInputStream dataInputStream=new DataInputStream( new FileInputStream(spareArr));
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*//稀疏数组转为 原始二维数组
        int arr2[][] =new int[ spareArr[0][0]][ spareArr[0][1]];
        for (int i=1 ;i<spareArr.length;i++){
            arr2[spareArr[i][0]][spareArr[i][1]]=spareArr[i][2];
        }

        System.out.println("还原后的二维数组为:");
        for ( int[] row : arr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }*/
    }
}
