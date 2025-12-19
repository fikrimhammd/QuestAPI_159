package com.example.mysql.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mysql.modeldata.DetailSiswa
import com.example.mysql.modeldata.UIStateSiswa
import com.example.mysql.modeldata.toDataSiswa
import com.example.mysql.modeldata.toDetailSiswa
import com.example.mysql.repository.RepositoryDataSiswa
import retrofit2.Response

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa) :
    ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    //Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(
                detailSiswa = detailSiswa,
                isEntryValid = validasiInput(detailSiswa)
            )
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun addSiswa() {
        if (!validasiInput()) return

        try {
            val response = repositoryDataSiswa.postDataSiswa(
                uiStateSiswa.detailSiswa.toDataSiswa()
            )

            if (response.isSuccessful) {
                println("✅ Sukses Tambah Data")
            } else {
                println("❌ Gagal tambah data: ${response.code()}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            println("🔥 ERROR addSiswa: ${e.message}")
        }
    }


}