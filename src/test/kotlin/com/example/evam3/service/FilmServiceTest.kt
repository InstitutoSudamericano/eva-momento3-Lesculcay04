package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.repository.FilmRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.util.Optional

@SpringBootTest
internal class FilmServiceTest {
    @InjectMocks
    lateinit var filmService: FilmService //clae que se va a probar

    @Mock   //objeto simulado
    lateinit var filmRepository: FilmRepository

    val jsonStringFilm = File("./src/test/resources/film.json").readText(Charsets.UTF_8)
    val filmMock = Gson().fromJson(jsonStringFilm, Film::class.java)


    @Test
    fun savefilmCorrect(){
        Mockito.`when`(filmRepository.save(Mockito.any(Film::class.java))).thenReturn(filmMock)
        val response = filmService.save(filmMock)
        Assertions.assertEquals(response.id, filmMock.id)
    }


    @Test
    fun savefilmWhenTitleIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            filmMock.apply { title=" "}
            Mockito.`when`(filmRepository.save(Mockito.any(Film::class.java))).thenReturn(filmMock)
            filmService.save(filmMock)

        }
    }
    @Test
    fun deletefilmCorrect() {
        val filmId = 1L // Replace with the actual film ID you want to delete
        Mockito.`when`(filmRepository.existsById(filmId)).thenReturn(true)

        try {
            filmService.delete(filmId)
        } catch (ex: Exception) {
            // Handle exception if needed
            Assertions.fail("Exception thrown during delete operation: ${ex.message}")
        }

        // Add assertions or verifications as needed
        Mockito.verify(filmRepository, Mockito.times(1)).deleteById(filmId)
    }
    @Test
    fun updatefilmCorrect() {
        val updatedfilm = Film(/* Updated film details */) // Replace with the updated film information
        Mockito.`when`(filmRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(filmMock))
        Mockito.`when`(filmRepository.save(Mockito.any(Film::class.java))).thenReturn(updatedfilm)

        try {
            val response = filmService.update(updatedfilm)
            Assertions.assertEquals(response.id, updatedfilm.id)
            // Add more assertions based on your update logic
        } catch (ex: Exception) {
            // Handle exception if needed
            Assertions.fail("Exception thrown during update operation: ${ex.message}")
        }

        // Add verifications as needed
        Mockito.verify(filmRepository, Mockito.times(1)).findById(updatedfilm.id)
        Mockito.verify(filmRepository, Mockito.times(1)).save(Mockito.any(Film::class.java))
    }
}