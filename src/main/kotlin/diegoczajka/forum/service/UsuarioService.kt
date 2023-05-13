package diegoczajka.forum.service

import diegoczajka.forum.model.Curso
import diegoczajka.forum.model.Usuario
import diegoczajka.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(private val repository: UsuarioRepository) {


    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }
}