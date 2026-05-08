Feature: Logout Aplikasi HR SV Jakarta

  Scenario: Pengguna berhasil login kemudian melakukan logout
    # --- Bagian ini akan otomatis memakai LoginSteps.groovy yang lama ---
    Given Saya membuka halaman login HR SV
    When Saya memasukkan username dan password
    And Saya memastikan form tidak kosong dan mengambil screenshot
    And Saya klik tombol Login
    Then Saya berhasil masuk ke dashboard HR SV
    And Saya mengambil screenshot bukti berhasil login
    
    # --- Bagian ini adalah langkah baru untuk Logout ---
    When Saya klik avatar profile
    And Saya klik tombol Sign Out
    Then Saya berhasil logout dan kembali ke halaman utama
    And Saya mengambil screenshot bukti berhasil logout