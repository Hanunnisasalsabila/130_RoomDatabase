package com.example.praktikum8.viewmodel.provider

import com.example.praktikum8.repositori.AplikasiSiswa
import com.example.praktikum8.viewmodel.EntryViewModel
import com.example.praktikum8.viewmodel.HomeViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
    }
}