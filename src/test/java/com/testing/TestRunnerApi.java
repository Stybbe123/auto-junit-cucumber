package com.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/rest",
    glue={"com.testing.stepDefinition"},
    tags = {"@api"},
    plugin = { "json:target/cucumber/api/report-composite-api.json", "pretty",
        "html:target/cucumber/api/", "rerun:target/rerun_rest.txt" }
)
public class TestRunnerApi {
}
