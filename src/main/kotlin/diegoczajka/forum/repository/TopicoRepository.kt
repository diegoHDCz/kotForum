package diegoczajka.forum.repository

import diegoczajka.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}