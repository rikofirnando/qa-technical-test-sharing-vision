import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import myApp.CSWeb

// 1. SETUP & NAVIGASI
CSWeb.openBrowser("")
CSWeb.navigateToUrl(GlobalVariable.base_url)
CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)
CSWeb.click("//button[text()='Sign Up']")

// 2. INPUT DATA (Variabel dari Data Binding)
CSWeb.setText("[name='nama']", fullName)
CSWeb.setText("[name='tempat_lahir']", placeOfBirth)
CSWeb.setText("[name='tanggal_lahir']", dateOfBirth)
CSWeb.setText("[name='nomor_ktp']", noKTP)
CSWeb.setText("[name='nomor_hp']", phoneNumber)
CSWeb.setText("[name='email']", email)
CSWeb.setText("[name='tanggal_join']", dateJoined)
CSWeb.setText("[name='alamat']", address)
CSWeb.setText("[name='domisili']", domicileAddress)

// Handle file upload
if (ktpPath != "") { CSWeb.uploadFile("[name='img_ktp']", ktpPath) }
if (selfiePath != "") { CSWeb.uploadFile("[name='img_selfie']", selfiePath) }

CSWeb.takeScreenshot()

// 3. LOGIKA STRATEGIS BERDASARKAN SCENARIO TYPE
if (scenarioType == "Positive") {
    // Verifikasi field sebelum submit (Best Practice)
    CSWeb.verifyFieldNotEmpty("[name='nama']")
    CSWeb.verifyEmailFormat("[name='email']", email)
    
    CSWeb.click("[type='submit']")
    
    // Cek pesan sukses
    boolean isSuccess = WebUI.verifyTextPresent(expectedMessage, false, FailureHandling.OPTIONAL)
    if (isSuccess) {
        KeywordUtil.markPassed("PASSED: Skenario Positif Berhasil")
        CSWeb.click("[class='swal-button swal-button--confirm']")
    } else {
        KeywordUtil.markFailed("FAILED: Pesan sukses '" + expectedMessage + "' tidak muncul")
    }

} else if (scenarioType == "Negative_EmptyForm") {
    // Sesuai diskusi kita: Skenario form kosong = Tombol harusnya disabled
    // Kita cek atributnya, bukan klik tombolnya
    String isBtnDisabled = WebUI.getAttribute(WebUI.convertWebElementToTestObject("[type='submit']"), 'disabled')
    
    if (isBtnDisabled != null) {
        KeywordUtil.markPassed("PASSED: Tombol Submit ter-disable (Sesuai Logic)")
    } else {
        KeywordUtil.markFailed("FAILED: Tombol Submit tetap aktif padahal form kosong")
    }

} else {
    // Skenario Negatif Lainnya (Misal: Format Salah)
    CSWeb.click("[type='submit']")
    
    boolean isErrorVisible = WebUI.verifyTextPresent(expectedMessage, false, FailureHandling.OPTIONAL)
    if (isErrorVisible) {
        KeywordUtil.markPassed("PASSED: Error tervalidasi: " + expectedMessage)
    } else {
        KeywordUtil.markFailed("FAILED: Pesan error '" + expectedMessage + "' tidak muncul")
    }
}

CSWeb.closeBrowser()

