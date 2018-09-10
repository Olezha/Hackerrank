package org.olezha;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MorganAndStringTests {

    private static Properties testcase2;
    private static Properties testcase5;
    private static Properties testcase7;

    @BeforeClass
    public static void initialize() throws IOException {
        testcase2 = new Properties();
        testcase2.load(MorganAndStringTests.class.getClassLoader()
                .getResourceAsStream("morgan-and-string/case-2.properties"));
        testcase5 = new Properties();
        testcase5.load(MorganAndStringTests.class.getClassLoader()
                .getResourceAsStream("morgan-and-string/case-5.properties"));
        testcase7 = new Properties();
        testcase7.load(MorganAndStringTests.class.getClassLoader()
                .getResourceAsStream("morgan-and-string/case-7.properties"));
    }

    @Test
    public void case2p1() {
        assertEquals(testcase2.getProperty("answer1"),
                MorganAndString.morganAndString(
                        testcase2.getProperty("a1"),
                        testcase2.getProperty("b1")));
    }

    @Test
    public void case2p2() {
        assertEquals(testcase2.getProperty("answer2"),
                MorganAndString.morganAndString(
                        testcase2.getProperty("a2"),
                        testcase2.getProperty("b2")));
    }

    @Test
    public void case2p3() {
        assertEquals(testcase2.getProperty("answer3"),
                MorganAndString.morganAndString(
                        testcase2.getProperty("a3"),
                        testcase2.getProperty("b3")));
    }

    @Test
    public void case2p4() {
        assertEquals(testcase2.getProperty("answer4"),
                MorganAndString.morganAndString(
                        testcase2.getProperty("a4"),
                        testcase2.getProperty("b4")));
    }

    @Test
    public void case2p5() {
        assertEquals(testcase2.getProperty("answer5"),
                MorganAndString.morganAndString(
                        testcase2.getProperty("a5"),
                        testcase2.getProperty("b5")));
    }

    @Test
    public void case5p1() {
        assertEquals(testcase5.getProperty("answer1"),
                MorganAndString.morganAndString(
                        testcase5.getProperty("a1"),
                        testcase5.getProperty("b1")));
    }

    @Test
    public void case5p2() {
        assertEquals(testcase5.getProperty("answer2"),
                MorganAndString.morganAndString(
                        testcase5.getProperty("a2"),
                        testcase5.getProperty("b2")));
    }

    @Test
    public void case5p3() {
        assertEquals(testcase5.getProperty("answer3"),
                MorganAndString.morganAndString(
                        testcase5.getProperty("a3"),
                        testcase5.getProperty("b3")));
    }

    @Test
    public void case5p4() {
        assertEquals(testcase5.getProperty("answer4"),
                MorganAndString.morganAndString(
                        testcase5.getProperty("a4"),
                        testcase5.getProperty("b4")));
    }

    @Test
    public void case5p5() {
        assertEquals(testcase5.getProperty("answer5"),
                MorganAndString.morganAndString(
                        testcase5.getProperty("a5"),
                        testcase5.getProperty("b5")));
    }

    @Test
    public void case7p1() {
        assertEquals(testcase7.getProperty("answer1"),
                MorganAndString.morganAndString(
                        testcase7.getProperty("a1"),
                        testcase7.getProperty("b1")));
    }

    @Test
    public void case7p2() {
        assertEquals(testcase7.getProperty("answer2"),
                MorganAndString.morganAndString(
                        testcase7.getProperty("a2"),
                        testcase7.getProperty("b2")));
    }

    @Test
    public void case7p3() {
        assertEquals(testcase7.getProperty("answer3"),
                MorganAndString.morganAndString(
                        testcase7.getProperty("a3"),
                        testcase7.getProperty("b3")));
    }

    @Test
    public void case7p4() {
        assertEquals(testcase7.getProperty("answer4"),
                MorganAndString.morganAndString(
                        testcase7.getProperty("a4"),
                        testcase7.getProperty("b4")));
    }

    @Test
    public void case7p5() {
        assertEquals(testcase7.getProperty("answer5"),
                MorganAndString.morganAndString(
                        testcase7.getProperty("a5"),
                        testcase7.getProperty("b5")));
    }
}
