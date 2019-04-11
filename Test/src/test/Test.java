/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.*;
/**
 *
 * @author User
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SomeReader R = new UrlSimpleReader();
        LinkedList L = R.Read("https://simbirsoft.com");
        for (int i = 0; i < L.size(); i++) {
            System.out.println(String.valueOf(i)+"  " +L.get(i));
        }
    }
    
}
