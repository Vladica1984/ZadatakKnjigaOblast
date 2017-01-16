package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.scene.control.Tab;
import model.Knjiga;
import model.Oblast;

/**
 * Created by androiddevelopment on 16.1.17..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            TableUtils.dropTable(connectionSource, Oblast.class, true);
            TableUtils.dropTable(connectionSource, Knjiga.class, true);

            TableUtils.createTable(connectionSource, Knjiga.class);
            TableUtils.createTable(connectionSource, Oblast.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

