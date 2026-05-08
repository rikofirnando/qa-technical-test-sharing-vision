package runners

import org.junit.runner.RunWith
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.Test

@RunWith(Cucumber.class)
@CucumberOptions(

//Spesifik file *.feature tertentu saja untuk menjalankan Test Case-nya
//features = "Include/features/Login.feature",

// Universal dapat digunakan untuk semua script *.feature
features = "Include/features/",
glue = "steps"
)
public class MyRunner {

	// Pancingan agar tidak muncul error "No runnable methods"
	@Test
	public void dummyTest() {
	}
}