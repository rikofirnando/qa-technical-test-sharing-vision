import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")



CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

String evidence = '/home/rikofirnando/Katalon Studio/QA Technical Test PT Sharing Vision - Riko Firnando/Pictures/sample.jpeg'
def username = GlobalVariable.username
def password = GlobalVariable.password

// Global Variable
CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

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

CSWeb.click("[name='id_pic']")

CSWeb.click("//*[contains(text(),'Test UAT')]")

CSWeb.click("[class='justify-content-center row']")

CSWeb.setText("[name='keterangan_cuti']", "Liburan jalan-jalan")

CSWeb.drawRandomSignature("//canvas[contains(@class,'sigPadRef')]")

CSWeb.uploadFile("//input[@type='file']", evidence)

CSWeb.verifyFieldEmpty("[placeholder='Pilih tanggal...']")

CSWeb.verifyFieldNotEmpty("//*[contains(text(),'Test UAT')]")

CSWeb.verifyFieldNotEmpty("[name='keterangan_cuti']")

CSWeb.verifyNotClickable("//*[contains(text(),'Submit')]")

CSWeb.takeScreenshot()

CSWeb.closeBrowser()


