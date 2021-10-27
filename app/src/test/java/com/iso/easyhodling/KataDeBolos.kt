package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()

    private fun restoRondas() {
        val rondasTotales = 10
        var rondaActual = partida.partida.size
        while (rondaActual != rondasTotales) {
            partida.turno(rondaActual + 1, 0, 0)
            rondaActual++
        }
    }

    @Test
    fun partidaSinPuntos() {
        partida.turno(1, 0, 0)
        restoRondas()
        assertEquals(0, partida.puntuacion())
    }

    @Test
    fun partidaCuatroPuntos() {
        partida.turno(1, 4, 0)
        restoRondas()
        assertEquals(4, partida.puntuacion())
    }

    @Test
    fun partidaSietePuntos() {
        partida.turno(1, 7, 0)
        restoRondas()
        assertEquals(7, partida.puntuacion())
    }

    @Test
    fun partidaCuatroPuntosDosTiros() {
        partida.turno(1, 2, 2)
        restoRondas()
        assertEquals(4, partida.puntuacion())
    }

    @Test
    fun partidaSietePuntosDosTiros() {
        partida.turno(1, 2, 5)
        restoRondas()
        assertEquals(7, partida.puntuacion())
    }

    @Test
    fun partidaDocePuntosTresTiros() {
        partida.turno(1, 5, 4)
        partida.turno(2, 3, 0)
        restoRondas()
        assertEquals(12, partida.puntuacion())
    }

    @Test
    fun partidaDocePuntosCuatroTiros() {
        partida.turno(1, 4, 4)
        partida.turno(2, 3, 1)
        restoRondas()
        assertEquals(12, partida.puntuacion())
    }

    @Test
    fun partidaUnSemiplenoYPuntuarPrimeraTiradaSegundoTurno() {
        partida.turno(1, 5, 5)
        partida.turno(2, 2, 0)
        restoRondas()
        assertEquals(14, partida.puntuacion())
    }

    @Test
    fun partidaUnSemiplenoYPuntuarAmbasTiradasSegundoTurno() {
        partida.turno(1, 5, 5)
        partida.turno(2, 2, 3)
        restoRondas()
        assertEquals(17, partida.puntuacion())
    }

    @Test
    fun partidaUnPlenoYPuntuarPrimeraTiradaSegundoTurno() {
        partida.turno(1, 10, 0)
        partida.turno(2, 2, 0)
        restoRondas()
        assertEquals(14, partida.puntuacion())
    }

    @Test
    fun partidaUnPlenoYPuntuarAmbasTiradasSegundoTurno() {
        partida.turno(1, 10, 0)
        partida.turno(2, 2, 3)
        restoRondas()
        assertEquals(20, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenos() {
        partida.turno(1, 6, 4)
        partida.turno(2, 2, 8)
        restoRondas()
        assertEquals(22, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenosYPuntuarPrimeraTiradaSiguienteTurno() {
        partida.turno(1, 6, 4)
        partida.turno(2, 2, 8)
        partida.turno(3, 3, 0)
        restoRondas()
        assertEquals(28, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenosYPuntuarAmbasTiradasSiguienteTurno() {
        partida.turno(1, 6, 4)
        partida.turno(2, 2, 8)
        partida.turno(3, 3, 4)
        restoRondas()
        assertEquals(32, partida.puntuacion())
    }

    @Test
    fun partidaDosPlenos() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        restoRondas()
        assertEquals(30, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenos() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        restoRondas()
        assertEquals(60, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenosYPuntuarAmbasTiradasSiguienteTurno() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        partida.turno(4, 2, 1)
        restoRondas()
        assertEquals(68, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenosYPuntuarAmbasTiradasSiguienteTurno2() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        partida.turno(4, 1, 1)
        restoRondas()
        assertEquals(65, partida.puntuacion())
    }

    @Test
    fun partidaRandom1() {
        partida.turno(1, 5, 3)
        partida.turno(2, 6, 3)
        partida.turno(3, 3, 7)
        partida.turno(4, 2, 4)
        restoRondas()
        assertEquals(35, partida.puntuacion())
    }

    @Test
    fun partidaRandom2() {
        partida.turno(1, 5, 3)
        partida.turno(2, 10, 0)
        partida.turno(3, 3, 7)
        partida.turno(4, 2, 4)
        restoRondas()
        assertEquals(46, partida.puntuacion())
    }

    @Test
    fun partidaRandom3() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        partida.turno(4, 10, 0)
        partida.turno(5, 10, 0)
        partida.turno(6, 10, 0)
        partida.turno(7, 10, 0)
        partida.turno(8, 10, 0)
        partida.turno(9, 10, 0)
        partida.turno(10, 10, 0)
        partida.tiradasExtrasPleno(11, 0, 0)
        assertEquals(270, partida.puntuacion())
    }

    @Test
    fun partidaRandom4() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        partida.turno(4, 10, 0)
        partida.turno(5, 10, 0)
        partida.turno(6, 10, 0)
        partida.turno(7, 10, 0)
        partida.turno(8, 10, 0)
        partida.turno(9, 10, 0)
        partida.turno(10, 10, 0)
        partida.tiradasExtrasPleno(11, 2, 3)
        assertEquals(282, partida.puntuacion())
    }

    @Test
    fun partidaPerfecta() {
        partida.turno(1, 10, 0)
        partida.turno(2, 10, 0)
        partida.turno(3, 10, 0)
        partida.turno(4, 10, 0)
        partida.turno(5, 10, 0)
        partida.turno(6, 10, 0)
        partida.turno(7, 10, 0)
        partida.turno(8, 10, 0)
        partida.turno(9, 10, 0)
        partida.turno(10, 10, 0)
        partida.tiradasExtrasPleno(11, 10, 10)
        assertEquals(300, partida.puntuacion())
    }

    @Test
    fun partidaRandomSemiplenoRondaExtra() {
        partida.turno(1, 5, 3)
        partida.turno(2, 4, 4)
        partida.turno(3, 1, 0)
        partida.turno(4, 6, 0)
        partida.turno(5, 7, 0)
        partida.turno(6, 0, 6)
        partida.turno(7, 8, 1)
        partida.turno(8, 5, 1)
        partida.turno(9, 3, 5)
        partida.turno(10, 5, 5)
        partida.tiradaExtraSemipleno(11, 3)
        assertEquals(75, partida.puntuacion())
    }

    @Test
    fun partidaRandomSemiplenoRondaExtraPleno() {
        partida.turno(1, 5, 3)
        partida.turno(2, 4, 4)
        partida.turno(3, 1, 0)
        partida.turno(4, 6, 0)
        partida.turno(5, 7, 0)
        partida.turno(6, 0, 6)
        partida.turno(7, 8, 1)
        partida.turno(8, 5, 1)
        partida.turno(9, 3, 5)
        partida.turno(10, 5, 5)
        partida.tiradaExtraSemipleno(11, 10)
        assertEquals(89, partida.puntuacion())
    }

    @Test
    fun excepcionSumaMayor10() {
        try {
            partida.turno(1, 7, 8)
        } catch (e: Excepciones) {
            println(e.message)
        }
    }

    @Test
    fun excepcionTiradaMayor10() {
        try {
            partida.turno(1, 11, 0)
        } catch (e: Excepciones) {
            println(e.message)
        }
    }

    @Test
    fun excepcionTRondasMaximas() {
        try {
            partida.turno(1, 5, 3)
            partida.turno(2, 4, 4)
            partida.turno(3, 1, 0)
            partida.turno(4, 6, 0)
            partida.turno(5, 7, 0)
            partida.turno(6, 0, 6)
            partida.turno(7, 8, 1)
            partida.turno(8, 5, 1)
            partida.turno(9, 3, 5)
            partida.turno(10, 5, 2)
            partida.turno(11, 0, 0)
            partida.turno(12, 0, 0)
        } catch (e: Excepciones) {
            println(e.message)
        }
    }
}