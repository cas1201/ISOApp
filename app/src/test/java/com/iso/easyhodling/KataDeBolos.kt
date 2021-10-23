package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()
    private var puntuacion = 0

    @Test
    fun partidaSinPuntos(){
        puntuacion = partida.turno(0, 0)
        assertEquals(0, puntuacion)
    }

    @Test
    fun partidaCuatroPuntos(){
        puntuacion = partida.turno(4, 0)
        assertEquals(4, puntuacion)
    }

    @Test
    fun partidaSietePuntos(){
        puntuacion = partida.turno(7, 0)
        assertEquals(7, puntuacion)
    }

    @Test
    fun partidaCuatroPuntosDosTiros(){
        puntuacion = partida.turno(2, 2)
        assertEquals(4, puntuacion)
    }

    @Test
    fun partidaSietePuntosDosTiros(){
        puntuacion = partida.turno(2, 5)
        assertEquals(7, puntuacion)
    }

    @Test
    fun partidaDocePuntosTresTiros(){
        partida.turno(5, 4)
        puntuacion = partida.turno(3, 0)
        assertEquals(12, puntuacion)
    }

    @Test
    fun partidaDocePuntosCuatroTiros(){
        partida.turno(4, 4)
        puntuacion = partida.turno(3, 1)
        assertEquals(12, puntuacion)
    }

    @Test
    fun partidaUnSemiplenoYPuntuarPrimeraTiradaSegundoTurno(){
        puntuacion =
            partida.turno(5, 5) + partida.turno(2, 0)
        assertEquals(14, puntuacion)
    }

    @Test
    fun partidaUnSemiplenoYPuntuarAmbasTiradasSegundoTurno(){
        puntuacion =
            partida.turno(5, 5) + partida.turno(2, 3)
        assertEquals(17, puntuacion)
    }

    @Test
    fun partidaUnPlenoYPuntuarPrimeraTiradaSegundoTurno(){
        puntuacion =
            partida.turno(10, 0) + partida.turno(2, 0)
        assertEquals(14, puntuacion)
    }

    @Test
    fun partidaUnPlenoYPuntuarAmbasTiradasSegundoTurno(){
        puntuacion =
            partida.turno(10, 0) + partida.turno(2, 3)
        assertEquals(20, puntuacion)
    }
}