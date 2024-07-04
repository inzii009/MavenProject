package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        // feature tag we use to provide the path of all feature files
        features = "src/test/resources/features/",
        // glue gives path of the step definitions for feature files. (we just provide package name)
        glue = "steps" ,
        // dry run option is used to generate code for un-implemented steps
        //if set true,it scans all the gherkin steps whether they are implemented or not.It stops actual execution.
       //to execute script,it should be false
        dryRun = false,
        // it removes all the irrelevant information from the console
        monochrome = true,
        //tags will identify the scenario based on the tag we provide to the feature file
        tags = "@sprint1",

        plugin = {"pretty","html:target/InzimamReport.html","json:target/InzimamReport.json"} //to generate report and other purposes
       // tags = "@search And not @addEmployee"
        //tags = "@search or @addEmployee"
        //tags = "@search And @addEmployee"
        //plugin = {"ugly","html:target/babarReport.html"}
        //plugin = {"beautiful","html:target/babarReport.html"}

        //this plugin print the steps in console
)
public class Smoke {
}
