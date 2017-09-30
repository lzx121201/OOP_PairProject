/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.util.Comparator;

/**
 *
 * @author lizhengxing
 */
public class sortByID implements Comparator<Person> {
    
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getId() - o2.getId();
    }
    
}
