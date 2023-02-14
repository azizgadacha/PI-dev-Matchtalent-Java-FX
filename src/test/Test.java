/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import utils.MyDB;

/**
 *
 * @author Hend
 */
public class Test {
    
    
    
    public static void main(String[] args){
        MyDB db = MyDB.getInstance();
        MyDB db2 = MyDB.getInstance();
        
        System.out.println(db);
        System.out.println(db2);
    }
}

