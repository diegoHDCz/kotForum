package diegoczajka.forum.service

import diegoczajka.forum.model.Curso
import diegoczajka.forum.model.StatusTopico
import diegoczajka.forum.model.Topico
import diegoczajka.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {
    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "tenho duvidas",
            curso = Curso(
                id = 1,
                nome = "kotlin",
                categoria = "programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Diego",
                email = "diego.czajka@gmail.com"
            )
        )
        val topico2 = Topico(
            id = 2,
            titulo = " kotlin 2",
            mensagem = "tenho 2 duvidas",
            curso = Curso(
                id = 2,
                nome = "kotlin",
                categoria = "programação"
            ),
            autor = Usuario(
                id = 2,
                nome = "Diego",
                email = "diego.czajka@gmail.com"
            )
        )
        topicos = Arrays.asList(topico, topico2)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream()
            .filter({ t -> t.id == id }).findFirst().get()
    }


}