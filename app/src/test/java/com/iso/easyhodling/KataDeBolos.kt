package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()
    private var puntuacion = 0

    @Test
    fun partidaSinPuntos(){
        puntuacion = partida.puntuacion()
        assertEquals(0, puntuacion)
    }

    @Test
    fun partidaCuatroPuntos(){
        partida.turno(4, 0)
        puntuacion = partida.puntuacion()
        assertEquals(4, puntuacion)
    }

    @Test
    fun partidaSietePuntos(){
        partida.turno(7, 0)
        puntuacion = partida.puntuacion()
        assertEquals(7, puntuacion)
    }

    @Test
    fun partidaCuatroPuntosDosTiros(){
        partida.turno(2, 2)
        puntuacion = partida.puntuacion()
        assertEquals(4, puntuacion)
    }

    @Test
    fun partidaSietePuntosDosTiros(){
        partida.turno(2, 5)
        puntuacion = partida.puntuacion()
        assertEquals(7, puntuacion)
    }

    @Test
    fun partidaDocePuntosTresTiros(){
        partida.turno(5, 4)
        partida.turno(3, 0)
        puntuacion = partida.puntuacion()
        assertEquals(12, puntuacion)
    }
}