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
        assertEquals(NUMBER1_ADD_NUMBER2,  Money.parseMoney(NUMBER1).add(NUMBER2).toString());
        assertEquals(NUMBER1_ADD_NUMBER3,  Money.parseMoney(NUMBER1).add(NUMBER3).toString());
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(NUMBER1_SUB_NUMBER2,  Money.parseMoney(NUMBER1).subtract(NUMBER2).toString());
        assertEquals(NUMBER2_SUB_NUMBER1,  Money.parseMoney(NUMBER2).subtract(NUMBER1).toString());
        assertEquals(NUMBER1_SUB_NUMBER1,  Money.parseMoney(NUMBER1).subtract(NUMBER1).toString());
        assertEquals(NUMBER1_SUB_NUMBER3,  Money.parseMoney(NUMBER1).subtract(NUMBER3).toString());
    }

    @Test
    public void compareTo() throws Exception {
        assertTrue(Money.parseMoney(NUMBER1).compareTo(Money.parseMoney(NUMBER2)) > 0);
        assertTrue(Money.parseMoney(NUMBER2).compareTo(Money.parseMoney(NUMBER1)) < 0);
        assertTrue(Money.parseMoney(NUMBER1).compareTo(Money.parseMoney(NUMBER1)) == 0);
    }

}