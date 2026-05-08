Feature: Login Aplikasi HR SV Jakarta

  Scenario: Login berhasil dengan kredensial yang valid
    Given Saya membuka halaman login HR SV
    When Saya memasukkan username dan password
    And Saya memastikan form tidak kosong dan mengambil screenshot
    And Saya klik tombol Login
    Then Saya berhasil masuk ke dashboard HR SV
    And Saya mengambil screenshot bukti berhasil login
    Then Saya menutup browser