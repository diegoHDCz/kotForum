package diegoczajka.forum.service

import diegoczajka.forum.dto.AtualizacaoTopicoForm
import diegoczajka.forum.dto.NovoTopicoForm
import diegoczajka.forum.dto.TopicoPorCategoriaDto
import diegoczajka.forum.dto.TopicoView
import diegoczajka.forum.exceptions.NotFoundException
import diegoczajka.forum.mapper.TopicoFormMapper
import diegoczajka.forum.mapper.TopicoViewMapper
import diegoczajka.forum.model.Topico
import diegoczajka.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import javax.persistence.EntityManager

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Elemento não encontrado",
    private val em: EntityManager
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos
            .map { t -> topicoViewMapper.map(t) }

    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)

    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }


}