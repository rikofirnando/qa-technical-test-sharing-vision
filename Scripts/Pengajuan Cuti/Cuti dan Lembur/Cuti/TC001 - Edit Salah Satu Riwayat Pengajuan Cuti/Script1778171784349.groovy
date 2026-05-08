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

CSWeb.click("(//*[@class='p-0 btn'])[1]")

CSWeb.click("[placeholder='Pilih tanggal...']")

CSWeb.click("(//button[.//div[text()='11']])[1]")

CSWeb.click("(//button[.//div[text()='15']])[1]")

CSWeb.click("//*[contains(text(),'Cuti Sakit')]")

CSWeb.click("[name='id_pic']")

CSWeb.click("//*[contains(text(),'Ramdan')]")

CSWeb.setText("[name='keterangan_cuti']", "Riko Firnando Cuti Sakit")

CSWeb.click("[class='btn-edit-ttd-layer']")

CSWeb.drawRandomSignature("//canvas[contains(@class,'sigPadRef')]")

CSWeb.verifyFieldNotEmpty("[placeholder='Pilih tanggal...']")

CSWeb.verifyFieldNotEmpty("//*[contains(text(),'Cuti Sakit')]")

CSWeb.verifyFieldNotEmpty("//*[contains(text(),'Ramdan')]")

CSWeb.verifyFieldNotEmpty("[name='keterangan_cuti']")

CSWeb.takeScreenshot()

CSWeb.click("//*[contains(text(),'Submit')]")

CSWeb.verifyTextPresent("Pengajuan cuti berhasil diperbaharui", false)

CSWeb.click("[class='swal-button swal-button--confirm']")

CSWeb.verifyTextPresent("2026/05/11 - 2026/05/15", false)

CSWeb.verifyTextPresent("Riko Firnando Cuti Sakit", false)

CSWeb.takeScreenshot()

//CSWeb.closeBrowser()
