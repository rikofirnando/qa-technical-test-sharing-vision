package runners

import org.junit.runner.RunWith
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.Test

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Include/features/01_Login.feature",

glue = "steps"
)
public class TC01_Login {

	// Pancingan agar tidak muncul error "No runnable methods"
	@Test
	public void dummyTest() {
	}
}