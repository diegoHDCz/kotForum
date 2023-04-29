package diegoczajka.forum.dto

import diegoczajka.forum.model.StatusTopico
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicoView(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)