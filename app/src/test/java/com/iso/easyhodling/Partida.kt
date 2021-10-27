package com.iso.easyhodling

class Partida {
    companion object Ronda {
        var ronda = 1
    }
    private var puntuacion = 0
    private var ultimoTurno = 0
    private var turno = mutableListOf<Int>()
    private var partida = mutableListOf<MutableList<Int>>()

    fun puntuacion(): Int {
        while (ultimoTurno != partida.size) {
            if (ultimoTurno != 0) {
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
            } else {
                puntuacion += partida[ultimoTurno].sum()
                ultimoTurno++
            }
        }
        return puntuacion
    }

    fun turno(tirada1: Int, tirada2: Int) {
        turno = mutableListOf(tirada1, tirada2)
        partida(turno)
    }

    private fun partida(turno: MutableList<Int>) {
        partida.add(ronda - 1, turno)
        ronda++
    }
}
