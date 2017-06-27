package com.github.yl.bloomfilter;

import java.util.BitSet;

/**
 * Created by lei.yang on 17/4/16.
 */
public class WhichChars {

    private BitSet used = new BitSet();
    public WhichChars(String str){
        for(int i=0;i< str.length();i++)
            used.set(str.charAt(i));  // set bit for char
    }
    public String toString(){
        String desc="[ ";
        int size=used.size();
        for(int i=0;i< size;i++){
            if(used.get(i))
                desc+=(char)i;
        }
        return desc+" ]";
    }
    public static void main(String args[]){
        WhichChars w=new WhichChars("How do you do,shiyuanyuan");
        System.out.println(w);
    }
}
