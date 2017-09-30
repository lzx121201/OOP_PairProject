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
public class sortByRating implements Comparator<Person> {
    
    @Override
    public int compare(Person o1, Person o2) {
        double r1 = o1.getMyRating();
        double r2 = o2.getMyRating();
        
        if(r1>r2)
            return 1;
        else if(r1<r2)
            return -1;
        else
            return 0;

    }
    
}
