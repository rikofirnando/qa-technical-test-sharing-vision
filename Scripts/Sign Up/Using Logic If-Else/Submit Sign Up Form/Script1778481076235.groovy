import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import myApp.CSWeb

// 1. Setup Awal
CSWeb.openBrowser("")
CSWeb.navigateToUrl(GlobalVariable.base_url)
CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)
CSWeb.click("//button[text()='Sign Up']")

// 2. Input Data (Variabel ini otomatis diambil dari Data Binding/Excel)
CSWeb.setText("[name='nama']", fullName)
CSWeb.setText("[name='tempat_lahir']", placeOfBirth)
CSWeb.setText("[name='tanggal_lahir']", dateOfBirth)
CSWeb.setText("[name='nomor_ktp']", noKTP)
CSWeb.setText("[name='nomor_hp']", phoneNumber)
CSWeb.setText("[name='email']", email)
CSWeb.setText("[name='tanggal_join']", dateJoined)
CSWeb.setText("[name='alamat']", address)
CSWeb.setText("[name='domisili']", domicileAddress)

// Handle file upload jika path tidak kosong di Excel
if (ktpPath != "") { CSWeb.uploadFile("[name='img_ktp']", ktpPath) }
if (selfiePath != "") { CSWeb.uploadFile("[name='img_selfie']", selfiePath) }

CSWeb.takeScreenshot()

// 3. Eksekusi Submit
CSWeb.click("[type='submit']")


if (scenarioType == "Positive") {
    // 1. Verifikasi Field (Hanya dilakukan jika data harus valid)
    CSWeb.verifyFieldNotEmpty("[name='nama']")
    CSWeb.verifyEmailFormat("[name='email']", email)
    
    // 2. Submit & Cek Sukses
    CSWeb.click("[type='submit']")
    
    boolean isSuccess = CSWeb.verifyTextPresent(expectedMessage, false, FailureHandling.OPTIONAL)
    if (isSuccess) {
        KeywordUtil.markPassed("PASSED: Data Berhasil Tersimpan")
    } else {
        KeywordUtil.markFailed("FAILED: Harusnya sukses tapi pesan '" + expectedMessage + "' tidak muncul")
    }

} else {
    // 1. Langsung Submit (Skenario Negatif: kita sengaja masukin data salah)
    CSWeb.click("[type='submit']")
    
    // 2. Cek apakah pesan Error yang muncul sesuai dengan di Excel
    boolean isErrorVisible = CSWeb.verifyTextPresent(expectedMessage, false, FailureHandling.OPTIONAL)
    if (isErrorVisible) {
        KeywordUtil.markPassed("PASSED: Skenario Negatif Berhasil Terdeteksi: " + expectedMessage)
    } else {
        KeywordUtil.markFailed("FAILED: Sistem tidak menampilkan error yang diharapkan: " + expectedMessage)
    }
}

CSWeb.closeBrowser()
