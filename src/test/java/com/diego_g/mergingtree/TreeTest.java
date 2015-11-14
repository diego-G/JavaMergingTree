package test.java.com.diego_g.mergingtree;

import java.io.File;

import main.java.com.diego_g.mergingtree.Tree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Diego Garcia
 */
public class TreeTest {

    private Tree myTree;

    public TreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    	myTree = new Tree();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void throw1() {
        try {
        	myTree.fileMerger(new File("./files/test/Test1.txt"));
        } catch (Exception exception) {
            String message = "Line 1: unproperly formatted.";
            assertEquals(message, exception.getMessage());
        }
    }
    
    @Test
    public void throw2() {
        try {
        	myTree.fileMerger(new File("./files/test/Test2.txt"));
        } catch (Exception exception) {
            String message = "Line 1: incorrect weight.";
            assertEquals(message, exception.getMessage());
        }
    }
    
    @Test
    public void throw3() {
        try {
        	myTree.fileMerger(new File("./files/test/Test3.txt"));
        } catch (Exception exception) {
            String message = "Line 1: NO path found.";
            assertEquals(message, exception.getMessage());
        }
    }
}