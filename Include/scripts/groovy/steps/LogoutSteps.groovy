package steps

import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import cucumber.api.java.en.And
import myApp.CSWeb

class LogoutSteps {

    @When("Saya klik avatar profile")
    def clickAvatar() {
        // Selector persis sesuai script aslimu
        CSWeb.click("(//*[@class='c-avatar-img'])[2]")
    }

    @And("Saya klik tombol Sign Out")
    def clickSignOut() {
        CSWeb.click("//*[text()='Sign Out']")
    }

    @Then("Saya berhasil logout dan kembali ke halaman utama")
    def verifyLogout() {
        // Verifikasi teks sesuai script aslimu
        CSWeb.verifyTextPresent("Aplikasi HR SV Jakarta Test", false)
        CSWeb.verifyTextPresent("Log In", false)
    }

    @And("Saya mengambil screenshot bukti berhasil logout")
    def screenshotLogout() {
        CSWeb.takeScreenshot()
    }
}