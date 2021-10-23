package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()
    private var puntuacion = 0

    @Test
    fun partidaSinPuntos(){
        puntuacion = partida.puntuacion(0)
        assertEquals(0, puntuacion)
    }

    @Test
    fun partidaCuatroPuntos(){
        puntuacion = partida.puntuacion(4)
        assertEquals(4, puntuacion)
    }

    @Test
    fun partidaSietePuntos(){
        puntuacion = partida.puntuacion(7)
        assertEquals(7, puntuacion)
    }
}