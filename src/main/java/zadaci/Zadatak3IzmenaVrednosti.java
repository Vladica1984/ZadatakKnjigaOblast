package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by androiddevelopment on 16.1.17..
 */
public class Zadatak3IzmenaVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
