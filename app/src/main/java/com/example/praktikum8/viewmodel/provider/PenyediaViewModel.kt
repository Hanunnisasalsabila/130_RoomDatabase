package com.example.praktikum8.viewmodel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum8.repositori.AplikasiSiswa
import com.example.praktikum8.viewmodel.EntryViewModel
import com.example.praktikum8.viewmodel.HomeViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.praktikum8.viewmodel.DetailViewModel
import com.example.praktikum8.viewmodel.EditViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }
        initializer {
            EntryViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)