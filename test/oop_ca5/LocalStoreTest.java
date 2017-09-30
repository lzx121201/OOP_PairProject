/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
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
public class LocalStoreTest {
    
    public LocalStoreTest() {
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
     * Test of loadLocalRecords method, of class LocalStore.
     */
    @Test
    public void testLoadLocalRecords() {
        System.out.println("loadLocalRecords");
        LocalStore instance = new LocalStore();
        instance.loadLocalRecords();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveLocalRecords method, of class LocalStore.
     */
    @Test
    public void testSaveLocalRecords() {
        System.out.println("saveLocalRecords");
        LocalStore instance = new LocalStore();
        instance.saveLocalRecords();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchPerson method, of class LocalStore.
     */
    @Test
    public void testSearchPerson() {
        System.out.println("searchPerson");
        String name = "";
        LocalStore instance = new LocalStore();
        ArrayList<Person> expResult = instance.searchPerson(name);
        ArrayList<Person> result = instance.searchPerson(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchLocally method, of class LocalStore.
     */
    @Test
    public void testSearchLocally() {
        System.out.println("searchLocally");
        String name = "";
        LocalStore instance = new LocalStore();
        ArrayList<Person> expResult = instance.searchLocally(name);
        ArrayList<Person> result = instance.searchLocally(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchUsingAPI method, of class LocalStore.
     */
    @Test
    public void testSearchUsingAPI() {
        System.out.println("searchUsingAPI");
        String name = "";
        LocalStore instance = new LocalStore();
        ArrayList<Person> expResult = instance.searchUsingAPI(name);
        ArrayList<Person> result = instance.searchUsingAPI(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editPerson method, of class LocalStore.
     */
    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        String name = "";
        LocalStore instance = new LocalStore();
        instance.editPerson(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchById method, of class LocalStore.
     */
    @Test
    public void testSearchById() {
        System.out.println("searchById");
        int id = 11361;
        LocalStore instance = new LocalStore();
        ArrayList<Person> expResult = instance.searchById(id);
        ArrayList<Person> result = instance.searchById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class LocalStore.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        LocalStore instance = new LocalStore();
        instance.listAll();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listByID method, of class LocalStore.
     */
    @Test
    public void testListByID() {
        System.out.println("listByID");
        LocalStore instance = new LocalStore();
        instance.listByID();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listByRating method, of class LocalStore.
     */
    @Test
    public void testListByRating() {
        System.out.println("listByRating");
        LocalStore instance = new LocalStore();
        instance.listByRating();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRecords method, of class LocalStore.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        LocalStore instance = new LocalStore();
        Map<String, ArrayList<Person>> expResult = instance.getRecords();
        Map<String, ArrayList<Person>> result = instance.getRecords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRecords method, of class LocalStore.
     */
    @Test
    public void testSetRecords() {
        System.out.println("setRecords");
        Map<String, ArrayList<Person>> records = null;
        LocalStore instance = new LocalStore();
        instance.setRecords(records);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of exportToHtml method, of class LocalStore.
     */
    @Test
    public void testExportToHtml() throws Exception {
        System.out.println("exportToHtml");
        String strPath = "c:/xampp/";
        String strName = "test.html";
        LocalStore instance = new LocalStore();
        instance.exportToHtml(strPath, strName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
