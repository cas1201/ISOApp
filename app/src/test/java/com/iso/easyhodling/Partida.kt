package com.iso.easyhodling

import java.lang.IndexOutOfBoundsException

class Partida {
    companion object Ronda {
        var ronda = 1
    }

    private var turno = mutableListOf<Int>()
    private var partida = mutableListOf<MutableList<Int>>()

    fun puntuacion(): Int {
        var ultimoTurno = 0
        var puntuacion = 0

        while (ultimoTurno != partida.size && ultimoTurno != 10) {
            if (ultimoTurno == 0) {
                puntuacion += partida[ultimoTurno].sum()
                ultimoTurno++
            } else {
                if (partida[ultimoTurno - 1].sum() == 10) {
                    if (partida[ultimoTurno - 1][0] == 10) {
                        if (partida[ultimoTurno][0] == 10) {
                            puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0] + partida[ultimoTurno + 1][0]
                            ultimoTurno++
                        } else {
                            puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0] + partida[ultimoTurno][1]
                            ultimoTurno++
                        }
                    } else {
                        puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0]
                        ultimoTurno++
                    }
                } else {
                    puntuacion += partida[ultimoTurno].sum()
                    ultimoTurno++
                }
            }
            println(partida)
            println(ultimoTurno)
        }

        if (ultimoTurno == 10) {
            if (partida[ultimoTurno - 1][0] == 10) {
                if (partida[ultimoTurno][0] == 10) {
                    puntuacion += partida[ultimoTurno][0] + partida[ultimoTurno][1]
                    ultimoTurno++
                } else {
                    puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0] + partida[ultimoTurno][1]
                    ultimoTurno++
                }
            } else {
                puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0]
                ultimoTurno++
            }
            println(partida)
            println(ultimoTurno)
        }
        return puntuacion
    }

    fun turno(tirada1: Int, tirada2: Int) {
        turno = mutableListOf(tirada1, tirada2)
        partida(turno)
    }

    fun tiradaExtraSemipleno(tirada1: Int) {
        turno = mutableListOf(tirada1)
        partida(turno)
    }

    fun tiradasExtrasPleno(tirada1: Int, tirada2: Int) {
        turno = mutableListOf(tirada1, tirada2)
        partida(turno)
    }

    private fun partida(turno: MutableList<Int>) {
        partida.add(ronda - 1, turno)
        ronda++
    }
}
