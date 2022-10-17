

public class Main {
    public static void main(String[] args) {
        WordBank bank = new WordBank("https://www.mit.edu/~ecprice/wordlist.10000");

        System.out.println(bank.isWordValid("absolute"));
        System.out.println(bank.isWordValid("bunch of garbage"));
        System.out.println(bank.getWordValue("absolute"));
    }
}
