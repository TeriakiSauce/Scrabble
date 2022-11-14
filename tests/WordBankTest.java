import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the WordBank class methods
 * @author Jaan
 * @version 1.0
 */
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
        assertTrue(bank.isWordValid("hi"));
        assertFalse(bank.isWordValid("u"));
    }

    @Test
    public void testGetLetterValue() {
        assert(bank.getLetterValue('u') == 1);
    }

    @Test
    public void testGetWordValue() {
        assert(bank.getWordValue("hi") == 5);
    }
}