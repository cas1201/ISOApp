package com.iso.easyhodling

import java.lang.Integer.sum

class Partida {
    private var puntuacion = 0
    private var turno = mutableListOf<Int>()
    private var partida = mutableListOf<MutableList<Int>>()
    private var ultimoTurno = 0

    fun puntuacion(): Int {
        if (ultimoTurno != 1) {
            if (partida[ultimoTurno - 2].sum() == 10)
                puntuacion =
                    partida[ultimoTurno - 1].sum() + partida[ultimoTurno - 1][0]
            else
                puntuacion += partida[ultimoTurno - 1].sum()
        } else
            puntuacion += partida[ultimoTurno - 1].sum()

        return puntuacion
    }

    fun turno(tirada1: Int, tirada2: Int): Int {
        turno = mutableListOf(tirada1, tirada2)
        partida(turno)
        return puntuacion()
    }

    private fun partida(turno: MutableList<Int>) {
        partida.add(ultimoTurno, turno)
        ultimoTurno++
    }
}
