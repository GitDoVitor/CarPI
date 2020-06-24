package com.timeot4.carpi.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.timeot4.carpi.dto.PerfilDTO;
import com.timeot4.carpi.dto.UsuarioDTO;
import com.timeot4.carpi.dto.UsuarioRespostaDTO;
import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.repository.UsuarioRepository;
import com.timeot4.carpi.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

		public final UsuarioService usuarioService;
		public final UsuarioRepository usuarioRepository;

		@Autowired
		public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
				this.usuarioService = usuarioService;
				this.usuarioRepository = usuarioRepository;
		}

		@ApiOperation(value = "Adiciona um novo usuário.")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Usuário adicionado com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@PostMapping
		public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO dto) {
				Usuario usuario = dto.transformaObjeto();
				String uniqueID = UUID.randomUUID().toString();
				String senha = usuario.getSenha();
				usuario.setId(uniqueID);
				String bcryptHashString = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
				usuario.setSenha(bcryptHashString);
				usuario = usuarioService.salvar(usuario);
				return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
		}

		@ApiOperation(value = "Lista todos os usuários.")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Usuários listados com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@GetMapping
		public ResponseEntity<List<PerfilDTO>> listarTodos() {
				List<Usuario> usuariosList = usuarioService.listar();
				List<PerfilDTO> usuariosDTOList = new ArrayList();
				usuariosList.forEach(usuario -> {
						usuariosDTOList.add(PerfilDTO.transformaPerfil(usuario));
				});
				return new ResponseEntity<>(usuariosDTOList, HttpStatus.OK);
		}

		@ApiOperation(value = "Lista um usuário para mostrar o perfil.")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Usuário listado com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@GetMapping(value = "/{id}")
		public ResponseEntity<PerfilDTO> mostraPerfil(@PathVariable(value = "id") String id) {
				Usuario usuario = usuarioService.listaUm(id);
				return new ResponseEntity<>(PerfilDTO.transformaPerfil(usuario), HttpStatus.OK);
		}

		@ApiOperation(value = "Desativa um usuário pelo id.")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Usuário desativado com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@PutMapping(value = "/{id}")
		public void voceFoiCanceladah(@PathVariable(value = "id") String id) {
				Usuario usuario = usuarioRepository.findById(id);
				usuario.setAtivo(false);
				usuarioService.salvar(usuario);
		}

		//todo
//		@ApiOperation(value = "Edita os dados do usuário pelo id.")
//		@ApiResponses(value = {
//						@ApiResponse(code = 200, message = "Usuário editado com sucesso"),
//						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
//		})
//		@PutMapping(value = "edit/{id}")
//		public void editaUsuario(@PathVariable(value = "id") String id, @RequestBody UsuarioDTO newDto) {
//				Usuario usuario = usuarioRepository.findById(id);
//				if (usuario.getCpf().equals(newDto.getCpf())) {
//						usuarioService.salvar(newDto.transformaObjeto());
//				}
//		}
}
