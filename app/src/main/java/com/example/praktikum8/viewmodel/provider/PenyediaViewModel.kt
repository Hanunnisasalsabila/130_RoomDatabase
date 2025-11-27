package com.example.praktikum8.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum8.repositori.AplikasiSiswa
import com.example.praktikum8.viewmodel.EntryViewModel
import com.example.praktikum8.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa
            HomeViewModel(application.container.repositoriSiswa)
        }
        initializer {
            val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa
            EntryViewModel(application.container.repositoriSiswa)
        }
    }
}