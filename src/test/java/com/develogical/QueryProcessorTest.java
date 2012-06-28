package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {


    @Test
    public void testHighestNumber() {
        int result = new QueryProcessor().findHighestNumber(new String[]{"14", "7", "15"});
        assertThat(result, is(15));
    }

    @Test
    public void testHighestNumberMethod() {
        String result = new QueryProcessor().process("1383b7a0: which of the following numbers is the largest: 417, 24, 54, 196");
        assertThat(result, is("417"));
    }

    @Test
    public void testMinus() {
        String result = new QueryProcessor().process("947ed210: what is 1 minus 6");
        assertThat(result, is("-5"));
    }

    @Test
    public void testFibb() {
        String result = new QueryProcessor().process("84735d40: what is the 19th number in the Fibonacci sequence");
        assertThat(result, is("4181"));
    }

    @Test
    public void testSqRoot() {
        String result = new QueryProcessor().process("e08b4860: what is 14 to the power of 11");
        assertThat(result, is("4049565169664"));
    }

}



