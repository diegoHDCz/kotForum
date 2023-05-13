package diegoczajka.forum.service

import diegoczajka.forum.model.Curso
import diegoczajka.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {


    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)

    }
}