package com.iso.easyhodling

import java.lang.Integer.sum

class Partida {
    private var puntuacion = 0
    private var turno = mutableListOf<Int>()
    private var partida = mutableListOf<MutableList<Int>>()
    private var ultimoTurno = 0

    fun puntuacion(): Int{
        for (i in partida.indices)
            puntuacion += partida[i].sum()
        return puntuacion
    }

    fun turno(tirada1: Int, tirada2: Int){
        turno = mutableListOf(tirada1, tirada2)
        partida(turno)
    }

    private fun partida(turno: MutableList<Int>) {
        partida.add(ultimoTurno, turno)
        ultimoTurno++
    }
}
