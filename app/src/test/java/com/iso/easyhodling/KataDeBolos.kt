package com.iso.easyhodling

import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()

    @Test
    fun partidaSinPuntos(){
        val puntuacion = partida.puntuacion()
        assertEquals(0, puntuacion)
    }
}