import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")



CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

// Global Variable
String evidence = GlobalVariable.evidence
def username = GlobalVariable.username
def password = GlobalVariable.password

CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.verifyFieldNotEmpty("[type='text']")

CSWeb.verifyFieldNotEmpty("[type='password']")

CSWeb.takeScreenshot()

CSWeb.click("//button[text()='Login']")

CSWeb.click("[class='c-header-toggler-icon']")

CSWeb.verifyTextPresent("Aplikasi HR SV Jakarta 2023", false)

CSWeb.verifyTextPresent("Riwayat Pengajuan Cuti", false)

CSWeb.takeScreenshot()

CSWeb.click("//a[contains(text(),'Cuti Bersama')]")

CSWeb.click("//a[contains(text(),'Pengajuan Masuk')]")

CSWeb.click("[class='c-sidebar-backdrop c-show']")

CSWeb.click("//*[contains(text(),'Ajukan Masuk')]")

CSWeb.click("[placeholder='Pilih tanggal...']")

CSWeb.click("(//button[.//div[text()='11']])[1]")

CSWeb.pressSpace()

CSWeb.click("(//button[.//div[text()='15']])[1]")

CSWeb.pressSpace()

CSWeb.click("[name='id_pic']")

CSWeb.click("//*[contains(text(),'Test UAT')]")

CSWeb.click("[class='justify-content-center row']")

CSWeb.setText("[name='keterangan_cuti']", "Liburan jalan-jalan")

CSWeb.drawRandomSignature("//canvas[contains(@class,'sigPadRef')]")

CSWeb.uploadFile("//input[@type='file']", evidence)

CSWeb.enhancedClick("(//*[@type='button'])[9]")

CSWeb.enhancedClick("(//button[@type='button'])[8]")

CSWeb.verifyFieldNotEmpty("//*[contains(text(),'Test UAT')]")

CSWeb.verifyFieldNotEmpty("[name='keterangan_cuti']")

CSWeb.verifyTextPresent("Preview Evidence:", false)

CSWeb.closeBrowser()
