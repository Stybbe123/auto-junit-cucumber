package com.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/web",
	glue={"com.testing.stepDefinition", "com.testing.webHooks"},
	tags = {"@web"},
	plugin = { "json:target/cucumber/web/report-composite-web.json", "pretty",
		"html:target/cucumber/web/", "rerun:target/rerun_web.txt" }
)
public class TestRunnerWeb {
}