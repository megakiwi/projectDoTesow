package pl.testy.api.jdbiservice;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import pl.testy.api.configuration.Configuration;

public class DbJdbiService {

    private static Jdbi jdbi;
    private static Handle handle;

    static {
        jdbi = Jdbi.create(Configuration.DB_URL, Configuration.DB_USER, Configuration.DB_PASSWORD);
        jdbi.installPlugin(new SqlObjectPlugin());
        handle = jdbi.open();
    }

    public Handle getHandle(){
        return DbJdbiService.handle;
    }
}
