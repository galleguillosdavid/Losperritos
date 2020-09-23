package com.example.losperritos.modelo

class RepositoryRazas(private val razasDao: RazasDao) {
    private val serviceRetrofit = RetrofitRazas.getRetrofitRazas()
    val mLiveDataListRazas = razasDao.getAllRazasFromDB()
    val mLiveDataImagenesRazas = razasDao.getAllImagenesFromDB()
}