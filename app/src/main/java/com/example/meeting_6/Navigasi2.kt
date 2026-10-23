package com.example.meeting_6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meeting_6.view.FormIsian2
import com.example.meeting_6.view.TampilData2

@Composable
fun DataApp2(
    navController: NavHostController = rememberNavController()
) {
    //Variabel lokal untuk menyimpan data sementara
    var namaSiswa by rememberSaveable { mutableStateOf("") }
    var jkSiswa by rememberSaveable { mutableStateOf("") }
    var alamatSiswa by rememberSaveable { mutableStateOf("") }

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.FormulirSaya.name) {
                FormIsian2(
                    OnSubmitBtnClick = { nama, jk, alamat ->
                        //Simpan data ke variabel lokal sebelum pindah halaman
                        namaSiswa = nama
                        jkSiswa = jk
                        alamatSiswa = alamat
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData2(
                    nama = namaSiswa,
                    jenisKelamin = jkSiswa,
                    alamat = alamatSiswa,
                    onBackBtnClick = {
                        cancelAndBackToFormulirSaya2(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirSaya2(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}
