package com.iso.easyhodling

import com.iso.easyhodling.Partida.Ronda.ronda
import org.junit.Assert.*
import org.junit.Test

class KataDeBolos {

    private val partida = Partida()

    fun añadirRestoRondas(){
        val rondasTotales = 10
        while (ronda - 1 != rondasTotales){
            partida.turno(0, 0)
        }
    }

    @Test
    fun partidaSinPuntos(){
        partida.turno(0, 0)
        añadirRestoRondas()
        assertEquals(0, partida.puntuacion())
    }

    @Test
    fun partidaCuatroPuntos(){
        partida.turno(4, 0)
        añadirRestoRondas()
        assertEquals(4, partida.puntuacion())
    }

    @Test
    fun partidaSietePuntos(){
        partida.turno(7, 0)
        añadirRestoRondas()
        assertEquals(7, partida.puntuacion())
    }

    @Test
    fun partidaCuatroPuntosDosTiros(){
        partida.turno(2, 2)
        añadirRestoRondas()
        assertEquals(4, partida.puntuacion())
    }

    @Test
    fun partidaSietePuntosDosTiros(){
        partida.turno(2, 5)
        añadirRestoRondas()
        assertEquals(7, partida.puntuacion())
    }

    @Test
    fun partidaDocePuntosTresTiros(){
        partida.turno(5, 4)
        partida.turno(3, 0)
        añadirRestoRondas()
        assertEquals(12, partida.puntuacion())
    }

    @Test
    fun partidaDocePuntosCuatroTiros(){
        partida.turno(4, 4)
        partida.turno(3, 1)
        añadirRestoRondas()
        assertEquals(12, partida.puntuacion())
    }

    @Test
    fun partidaUnSemiplenoYPuntuarPrimeraTiradaSegundoTurno(){
        partida.turno(5, 5)
        partida.turno(2, 0)
        añadirRestoRondas()
        assertEquals(14, partida.puntuacion())
    }

    @Test
    fun partidaUnSemiplenoYPuntuarAmbasTiradasSegundoTurno(){
        partida.turno(5, 5)
        partida.turno(2, 3)
        añadirRestoRondas()
        assertEquals(17, partida.puntuacion())
    }

    @Test
    fun partidaUnPlenoYPuntuarPrimeraTiradaSegundoTurno(){
        partida.turno(10, 0)
        partida.turno(2, 0)
        añadirRestoRondas()
        assertEquals(14, partida.puntuacion())
    }

    @Test
    fun partidaUnPlenoYPuntuarAmbasTiradasSegundoTurno(){
        partida.turno(10, 0)
        partida.turno(2, 3)
        añadirRestoRondas()
        assertEquals(20, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenos(){
        partida.turno(6, 4)
        partida.turno(2, 8)
        añadirRestoRondas()
        assertEquals(22, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenosYPuntuarPrimeraTiradaSiguienteTurno(){
        partida.turno(6, 4)
        partida.turno(2, 8)
        partida.turno(3, 0)
        añadirRestoRondas()
        assertEquals(28, partida.puntuacion())
    }

    @Test
    fun partidaDosSemiplenosYPuntuarAmbasTiradasSiguienteTurno(){
        partida.turno(6, 4)
        partida.turno(2, 8)
        partida.turno(3, 4)
        añadirRestoRondas()
        assertEquals(32, partida.puntuacion())
    }

    @Test
    fun partidaDosPlenos(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        añadirRestoRondas()
        assertEquals(30, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenos(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        añadirRestoRondas()
        assertEquals(60, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenosYPuntuarAmbasTiradasSiguienteTurno(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(2, 1)
        añadirRestoRondas()
        assertEquals(68, partida.puntuacion())
    }

    @Test
    fun partidaTresPlenosYPuntuarAmbasTiradasSiguienteTurno2(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(1, 1)
        añadirRestoRondas()
        assertEquals(65, partida.puntuacion())
    }

    @Test
    fun partidaRandom1(){
        partida.turno(5, 3)
        partida.turno(6, 3)
        partida.turno(3, 7)
        partida.turno(2, 4)
        añadirRestoRondas()
        assertEquals(35, partida.puntuacion())
    }

    @Test
    fun partidaRandom2(){
        partida.turno(5, 3)
        partida.turno(10, 0)
        partida.turno(3, 7)
        partida.turno(2, 4)
        añadirRestoRondas()
        assertEquals(46, partida.puntuacion())
    }

    @Test
    fun partidaRandom3(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.tiradasExtrasPleno(0, 0)
        assertEquals(270, partida.puntuacion())
    }

    @Test
    fun partidaRandom4(){
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.turno(10, 0)
        partida.tiradasExtrasPleno(2, 3)
        assertEquals(282, partida.puntuacion())
    }
}