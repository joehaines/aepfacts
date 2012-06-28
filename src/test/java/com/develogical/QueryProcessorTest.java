package com.develogical;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    @Test
    public void returnsEmptyStringForUnknownQueries() {
        String result = new QueryProcessor().process("unknown");
        assertNotNull(result);
        assertThat(result, is(""));
    }

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
}



