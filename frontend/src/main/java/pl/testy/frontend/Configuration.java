package pl.testy.frontend;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(CONFIG.getString("environment"));

    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");
    public static final String URL = ENV.getString("baseUrl");
    public static final String URL_REMOTE = ENV.getString("remoteUrl");
}
