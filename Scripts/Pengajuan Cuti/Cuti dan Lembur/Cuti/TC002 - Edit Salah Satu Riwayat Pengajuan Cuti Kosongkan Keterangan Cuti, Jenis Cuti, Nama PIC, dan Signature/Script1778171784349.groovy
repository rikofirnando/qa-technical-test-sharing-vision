import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

// Global Variable
def username = GlobalVariable.username
def password = GlobalVariable.password

CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.verifyFieldNotEmpty("[type='text']")

CSWeb.verifyFieldNotEmpty("[type='password']")

CSWeb.takeScreenshot()

CSWeb.click("//button[text()='Login']")

CSWeb.waitVerifyForTextPresent("Aplikasi HR SV Jakarta 2023", 2)

CSWeb.waitVerifyForTextPresent("Riwayat Pengajuan Cuti", 3)

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'page 1')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'page 2')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'page 3')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'page 4')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'page 5')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'Go to previous page')]")

CSWeb.click("//a[contains(@aria-label,'Go to next page')]")

CSWeb.click("//a[contains(@aria-label,'Go to first page')]")

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(@aria-label,'Go to last page')]")

CSWeb.takeScreenshot()

//CSWeb.closeBrowser()
