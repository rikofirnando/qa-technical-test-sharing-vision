import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

def username = GlobalVariable.username
def password = GlobalVariable.password

// Hardcode
// CSWeb.setText("[type='text']", "TestAccountKaryawan1")
// CSWeb.setEncryptedText("[type='password']", "P@sswordK1")

// Global Variable
CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.takeScreenshot()

CSWeb.click("//button[text()='Login']")

CSWeb.verifyTextPresent("Aplikasi HR SV Jakarta 2023", false)

CSWeb.verifyTextPresent("Riwayat Pengajuan Cuti", false)

CSWeb.takeScreenshot()

CSWeb.click("(//*[@class='c-avatar-img'])[2]")

CSWeb.click("//*[text()='Sign Out']")

CSWeb.verifyTextPresent("Aplikasi HR SV Jakarta Test", false)

CSWeb.verifyTextPresent("Log In", false)

CSWeb.takeScreenshot()

