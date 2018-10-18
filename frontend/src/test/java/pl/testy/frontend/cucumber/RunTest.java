package pl.testy.frontend.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        // glue laczy nam z metoda w stepie; dziwne, bo musi miec
        //CucumberStepConfig,RunTest,WindowSteps -> musimy odniesc sie do pakietu matki
        glue = "classpath:pl.testy.frontend.cucumber",
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        // ta sa taki w scenario.feature, te kore maja wlasnie ten tag
        //to beda wywołane. takie suity testów
        tags = {"@window"}
)
public class RunTest {
}
