package io.datajek.springmvc.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayMethodsTest {

    @Test
    public void testfindIndex_numberInArray() {
        //1. create object of the class
        ArrayMethods arrayMethods = new ArrayMethods();
        //2. call method
        int result = arrayMethods.findIndex(new int[]{8,4,5}, 4);
        //3. compare the actual results to the expected
        assertEquals(1, result);
    }

    @Test
    public void testfindIndex_numberNotInArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(-1, arrayMethods.findIndex(new int[]{8,4,5}, 1), "The findIndex method finds the index of a given number");
    }

    @Test
    public void testfindIndex_emptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertEquals(-1, arrayMethods.findIndex(new int[]{}, 1));
    }

    @Test
    public void assertTrueTest(){
        Boolean condition = true;
        assertEquals(true,condition);
    }

    @Test
    public void assertNullTest(){
        String str = null;
        assertNull(str);
    }

    @Test
    @Disabled
    public void testSortArray() {
        fail("unimplemented method");
    }

    @BeforeEach
    void init(){
        //Initialize the object here
        System.out.println("Initializing before test");
        ArrayMethods arrayMethods = new ArrayMethods();
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("Clean up after test");
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Run this code before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Run this code after all tests");
    }
}
