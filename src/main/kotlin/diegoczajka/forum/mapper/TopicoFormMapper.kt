package diegoczajka.forum.mapper

import diegoczajka.forum.dto.NovoTopicoForm
import diegoczajka.forum.model.Topico
import diegoczajka.forum.service.CursoService
import diegoczajka.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }


}
