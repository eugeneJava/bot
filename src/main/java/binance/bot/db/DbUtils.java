package binance.bot.db;

public class DbUtils {
    public static String addQuotes(String stringData) {
        return "'" +stringData+ "'";
    }
}
