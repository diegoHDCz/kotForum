package diegoczajka.forum.service


import diegoczajka.forum.model.Usuario
import diegoczajka.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class UsuarioService(private val repository: UsuarioRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)

    }

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }

}