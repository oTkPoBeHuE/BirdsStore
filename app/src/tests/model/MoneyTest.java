package model;

import model.abstractstore.Money;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {
    private static String NUMBER1 = "99.11";
    private static String NUMBER2 = "3.11";
    private static String NUMBER3 = "-3.11";

    private static String NUMBER1_ADD_NUMBER2 = "102.22";
    private static String NUMBER1_SUB_NUMBER2 = "96.00";
    private static String NUMBER2_SUB_NUMBER1 = "-96.00";
    private static String NUMBER1_SUB_NUMBER1 = "0.00";

    private static String NUMBER1_SUB_NUMBER3 = "102.22";
    private static String NUMBER1_ADD_NUMBER3 = "96.00";

    @Test
    public void add() throws Exception {
        assertEquals(NUMBER1_ADD_NUMBER2,  new Money(NUMBER1).add(NUMBER2).toString());
        assertEquals(NUMBER1_ADD_NUMBER3,  new Money(NUMBER1).add(NUMBER3).toString());
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(NUMBER1_SUB_NUMBER2,  new Money(NUMBER1).subtract(NUMBER2).toString());
        assertEquals(NUMBER2_SUB_NUMBER1,  new Money(NUMBER2).subtract(NUMBER1).toString());
        assertEquals(NUMBER1_SUB_NUMBER1,  new Money(NUMBER1).subtract(NUMBER1).toString());
        assertEquals(NUMBER1_SUB_NUMBER3,  new Money(NUMBER1).subtract(NUMBER3).toString());
    }

    @Test
    public void compareTo() throws Exception {
        assertTrue(new Money(NUMBER1).compareTo(new Money(NUMBER2)) > 0);
        assertTrue(new Money(NUMBER2).compareTo(new Money(NUMBER1)) < 0);
        assertTrue(new Money(NUMBER1).compareTo(new Money(NUMBER1)) == 0);
    }

}