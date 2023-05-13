package diegoczajka.forum.repository

import diegoczajka.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}