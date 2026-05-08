package steps

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import myApp.CSWeb

class LoginSteps {

	@Given("Saya membuka halaman login HR SV")
	def navigateToLogin() {
		CSWeb.openBrowser("")
		CSWeb.navigateToUrl(GlobalVariable.base_url)
		CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)
	}

	@When("Saya memasukkan username dan password")
	def enterCredentials() {
		def username = GlobalVariable.username
		def password = GlobalVariable.password

		CSWeb.setText("[type='text']", username)
		CSWeb.setEncryptedText("[type='password']", password)
	}

	@And("Saya memastikan form tidak kosong dan mengambil screenshot")
	def verifyAndScreenshotForm() {
		CSWeb.verifyFieldNotEmpty("[type='text']")
		CSWeb.verifyFieldNotEmpty("[type='password']")
		CSWeb.takeScreenshot()
	}

	@And("Saya klik tombol Login")
	def clickLogin() {
		CSWeb.click("//button[text()='Login']")
	}

	@Then("Saya berhasil masuk ke dashboard HR SV")
	def verifyDashboard() {
		CSWeb.waitVerifyForTextPresent("Aplikasi HR SV Jakarta 2023", 2)
		CSWeb.waitVerifyForTextPresent("Riwayat Pengajuan Cuti", 3)
	}

	@And("Saya mengambil screenshot bukti berhasil login")
	def screenshotDashboard() {
		CSWeb.takeScreenshot()
	}
	
	@Then("Saya menutup browser")
	def closeBrowser() {
		CSWeb.closeBrowser()
	}
	
}