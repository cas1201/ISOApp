package com.iso.easyhodling

class Partida {
    private var puntuacion = 0

    fun puntuacion(bolosTiradosPrimeraTirada: Int, bolosTiradosSegundaTirada: Int): Int {
        puntuacion += bolosTiradosPrimeraTirada + bolosTiradosSegundaTirada
        return puntuacion
    }
}
