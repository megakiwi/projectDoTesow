package pl.testy.api.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(CONFIG.getString("environment"));

    public static final String URL = ENV.getString("baseUrl");
}
