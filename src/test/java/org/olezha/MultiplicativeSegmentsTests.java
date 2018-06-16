package org.olezha;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@Slf4j
public class MultiplicativeSegmentsTests {

    @Test
    public void case0() {
        testCase(0, false);
    }

    @Test
    public void case1() {
        testCase(1, false);
    }

    @Test
    public void case2() {
        testCase(2, false);
    }

    @Test
    public void caseReview2() {
        testCase(2, true);
    }

    @Test
    public void caseReview8() {
        testCase(8, true);
    }

    @Test
    public void caseReview10() {
        testCase(10, true);
    }

    @Test
    public void caseReview11() {
        testCase(11, true);
    }

    @Test
    public void caseReview12() {
        testCase(12, true);
    }

    @Test
    public void caseReview13() {
        testCase(13, true);
    }

    @Test
    public void caseReview14() {
        testCase(14, true);
    }

    @Test
    public void caseReview15() {
        testCase(15, true);
    }

    @Test
    public void caseReview17() {
        testCase(17, true);
    }

    private void testCase(int number, boolean isFromReview) {
        try {
            Input input = readInput(number, isFromReview);
            List<String> results = MultiplicativeSegments
                    .findShortestIntervals(input.k, input.n, input.nList);
            log.info("case {}: {}", number, results);
            assertThat(results, is(readOutput(number, isFromReview)));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Input readInput(int caseNumber, boolean isReview) throws FileNotFoundException {
        File file = new File(getClass()
                .getClassLoader()
                .getResource("multiplicative-segments/case-" + (isReview ? "review-" : "") + caseNumber + "-input.txt")
                .getFile());
        Input input = new Input();
        Scanner scan = new Scanner(file);
        input.k = BigInteger.valueOf(scan.nextLong());
        input.n = scan.nextLong();
        while (scan.hasNextLong())
            input.nList.add(BigInteger.valueOf(scan.nextLong()));
        scan.close();
        return input;
    }

    private List<String> readOutput(int caseNumber, boolean isReview) throws FileNotFoundException {
        File file = new File(getClass()
                .getClassLoader()
                .getResource("multiplicative-segments/case-" + (isReview ? "review-" : "") + caseNumber + "-output.txt")
                .getFile());
        List<String> output = new LinkedList<>();
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine())
            output.add(scan.nextLine());
        scan.close();
        return output;
    }

    private class Input {
        BigInteger k;
        long n;
        List<BigInteger> nList = new LinkedList<>();
    }
}
