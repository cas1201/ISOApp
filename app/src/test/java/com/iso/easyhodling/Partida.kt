package com.iso.easyhodling

class Partida {
    private var turno = mutableListOf<Int>()
    var partida = mutableListOf<MutableList<Int>>()

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
        }

        if (ultimoTurno == 10) {
            if (partida.size == 11) {
                if (partida[ultimoTurno - 1][0] == 10) {
                    if (partida[ultimoTurno][0] == 10) {
                        puntuacion += partida[ultimoTurno][0] + partida[ultimoTurno][1]
                    } else {
                        puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0] + partida[ultimoTurno][1]
                    }
                } else {
                    puntuacion += partida[ultimoTurno].sum() + partida[ultimoTurno][0]
                }
            }
        }
        return puntuacion
    }

    fun turno(ronda: Int, tirada1: Int, tirada2: Int) {
        turno = mutableListOf(tirada1, tirada2)
        partida(ronda - 1, turno)
    }

    fun tiradaExtraSemipleno(ronda: Int, tirada1: Int) {
        turno = mutableListOf(tirada1)
        partida(ronda - 1, turno)
    }

    fun tiradasExtrasPleno(ronda: Int, tirada1: Int, tirada2: Int) {
        turno = mutableListOf(tirada1, tirada2)
        partida(ronda - 1, turno)
    }

    private fun partida(ronda: Int, turno: MutableList<Int>) {
        partida.add(ronda, turno)
    }
}
