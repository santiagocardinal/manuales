package com.example;

public class Numeros {
    private int num;
    public Numeros(int num){
        this.num = num;
    }

    //========================GETTERS=======================
    public int getNum(){
        return num;
    }
    //=======================SETTER==========================
    public void setNum(int nuevo_num){
        this.num = nuevo_num;
    }  

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
