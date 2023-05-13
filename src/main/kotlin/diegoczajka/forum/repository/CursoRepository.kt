package diegoczajka.forum.repository

import diegoczajka.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}