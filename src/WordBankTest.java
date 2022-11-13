import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordBankTest {

    private WordBank bank;

    @Before
    public void setUp() throws Exception {
        bank = new WordBank(Config.WORD_BANK_PATH);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsWordValid() {
        assertTrue(bank.isWordValid("god"));
        assertFalse(bank.isWordValid("gama"));
    }

    @Test
    public void testGetLetterValue() {
        assert(bank.getLetterValue('u') == 1);
    }

    @Test
    public void testGetWordValue() {
        assertEquals(5,(int) bank.getWordValue("goat"));
    }
}