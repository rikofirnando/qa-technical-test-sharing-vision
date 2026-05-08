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

CSWeb.click("[class='c-header-toggler-icon']")

CSWeb.click("//*[text()='Cuti dan Lembur']")

CSWeb.click("//*[text()='Pengajuan Lembur']")

CSWeb.click("[class='c-sidebar-backdrop c-show']")

CSWeb.click("//*[text()='Ajukan Lembur']")

CSWeb.selectOption("[name='jenis_lembur']", "Hari Kerja")

CSWeb.click("[class='react-datepicker__input-container']")

CSWeb.click("//div[contains(@aria-label,'May 11th, 2026')]")

CSWeb.setText("(//*[@class='form-control'])[3]", "10:00 PM")

CSWeb.pressEnter()

CSWeb.setText("(//*[@class='form-control'])[4]", "11:45 PM")

CSWeb.pressEnter()

CSWeb.selectOption("//select[@name='id_pic']", "Tris Retno Aryani")

