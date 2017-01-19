package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 16.1.17..
 */
public class Zadatak4BrisanjeVrednosti {

    static Dao<Knjiga, Integer> knjigaDao;
    static Dao<Oblast, Integer> oblastDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);

            List<Oblast> oblasti = oblastDao.queryForAll();
            for (Oblast o : oblasti)
                System.out.println("o = " + o);

            oblasti = oblastDao.queryForEq(Oblast.POLJE_NAZIV, "Aritmeticki operatori");
            Oblast zaBrisanje = oblasti.get(0);
            oblastDao.delete(zaBrisanje);

            oblasti = oblastDao.queryForAll();
            for (Oblast o : oblasti)
                System.out.println("o = " + o);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
