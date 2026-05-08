package runners

import org.junit.runner.RunWith
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.Test

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Include/features/Login.feature",

glue = "steps"
)
public class TC02_Logout {

	// Pancingan agar tidak muncul error "No runnable methods"
	@Test
	public void dummyTest() {
	}
}