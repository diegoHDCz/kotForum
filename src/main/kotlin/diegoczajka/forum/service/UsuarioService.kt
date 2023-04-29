package diegoczajka.forum.service

import diegoczajka.forum.model.Curso
import diegoczajka.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var users: List<Usuario>) {

    init {
        val user = Usuario(
            id = 1,
            nome = "Diego",
            email = "emailfake@fake.com"
        )
        users = Arrays.asList(user)
    }

    fun buscarPorId(id: Long): Usuario {
        return users.stream().filter({ c ->
            c.id == id
        }).findFirst().get()
    }
}