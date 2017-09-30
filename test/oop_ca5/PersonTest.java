/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PersonTest {
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Person instance = new Person();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRatings method, of class Person.
     */
    @Test
    public void testGetRatings() {
        System.out.println("getRatings");
        Person instance = new Person();
        ArrayList<Double> expResult = instance.getRatings();;
        ArrayList<Double> result = instance.getRatings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRatings method, of class Person.
     */
    @Test
    public void testSetRatings() {
        System.out.println("setRatings");
        ArrayList<Double> ratings = null;
        Person instance = new Person();
        instance.setRatings(ratings);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Person.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Person instance = new Person();
        double expResult = 0.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class Person.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        double score = 0.0;
        Person instance = new Person();
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQueryName method, of class Person.
     */
    @Test
    public void testGetQueryName() {
        System.out.println("getQueryName");
        Person instance = new Person();
        String expResult = instance.getQueryName();;
        String result = instance.getQueryName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQueryName method, of class Person.
     */
    @Test
    public void testSetQueryName() {
        System.out.println("setQueryName");
        String queryName = "";
        Person instance = new Person();
        instance.setQueryName(queryName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person();
        String expResult = instance.getName();;
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Person instance = new Person();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Person.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Person instance = new Person();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonLink method, of class Person.
     */
    @Test
    public void testGetPersonLink() {
        System.out.println("getPersonLink");
        Person instance = new Person();
        String expResult = instance.getPersonLink();
        String result = instance.getPersonLink();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonLink method, of class Person.
     */
    @Test
    public void testSetPersonLink() {
        System.out.println("setPersonLink");
        String personLink = "";
        Person instance = new Person();
        instance.setPersonLink(personLink);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Person.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Person instance = new Person();
        ArrayList<String> expResult = instance.getImage();;
        ArrayList<String> result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Person.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        ArrayList<String> image = null;
        Person instance = new Person();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMyRating method, of class Person.
     */
    @Test
    public void testGetMyRating() {
        System.out.println("getMyRating");
        Person instance = new Person();
        double expResult = 0.0;
        double result = instance.getMyRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMyRating method, of class Person.
     */
    @Test
    public void testSetMyRating() {
        System.out.println("setMyRating");
        double myRating = 0.0;
        Person instance = new Person();
        instance.setMyRating(myRating);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMyComments method, of class Person.
     */
    @Test
    public void testGetMyComments() {
        System.out.println("getMyComments");
        Person instance = new Person();
        ArrayList<String> expResult = instance.getMyComments();;
        ArrayList<String> result = instance.getMyComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMyComments method, of class Person.
     */
    @Test
    public void testSetMyComments() {
        System.out.println("setMyComments");
        String myComments = "";
        Person instance = new Person();
        instance.setMyComments(myComments);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Person instance = new Person();
        String expResult = instance.toString();;
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toHTML method, of class Person.
     */
    @Test
    public void testToHTML() {
        System.out.println("toHTML");
        Person instance = new Person();
        String expResult = instance.toHTML();;
        String result = instance.toHTML();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
