package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()

    @Test
    fun partidaSinPuntos(){
        val puntuacion = partida.puntuacion(0)
        assertEquals(0, puntuacion)
    }

    @Test
    fun partidaCuatroPuntos(){
        val puntuacion = partida.puntuacion(4)
        assertEquals(4, puntuacion)
    }
}