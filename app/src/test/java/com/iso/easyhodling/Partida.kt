package com.iso.easyhodling

class Partida {
    private var puntuacion = 0

    fun puntuacion(bolosTirados: Int): Int {
        puntuacion += bolosTirados
        return puntuacion
    }
}
