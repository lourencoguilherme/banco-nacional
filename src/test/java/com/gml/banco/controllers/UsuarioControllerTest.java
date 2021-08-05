package com.gml.banco.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gml.banco.dto.UsuarioCreateDto;
import com.gml.banco.dto.UsuarioResponseDto;
import com.gml.banco.entities.Usuario;
import com.gml.banco.services.UsuarioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(SpringRunner.class)
public class UsuarioControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private UsuarioController controller;

    @Mock
    private UsuarioService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void deveTestarBuscaUsuarioPorIdComSucesso() throws Exception {
        Usuario usuario = new Usuario(1L, "Guilherme", "123", "1234", true, LocalDateTime.now(), LocalDateTime.now());

        Mockito.when(service.findUsuarioById(anyLong())).thenReturn(usuario);

        MockHttpServletResponse result =  mvc.perform(
                MockMvcRequestBuilders.get("/api/usuarios/"+"1")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(result.getStatus(), 200);

        UsuarioResponseDto responseDto = (UsuarioResponseDto) stringAsObject(result.getContentAsString(), UsuarioResponseDto.class);
        assertEquals(responseDto.getUsuarioId(), usuario.getUsuarioId());
        assertEquals(responseDto.getNome(), usuario.getNome());

    }

    @Test
    public void deveTestarCriarUsuarioComSucesso() throws Exception {
        Usuario usuario = new Usuario(1L, "Guilherme", "123", "1234", true, LocalDateTime.now(), LocalDateTime.now());
        UsuarioCreateDto usuarioCreateDto = new UsuarioCreateDto("Guilherme", "123", "1234");

        Mockito.when(service.saveUsuario(any(Usuario.class))).thenReturn(usuario);

        MockHttpServletResponse result =  mvc.perform(
                MockMvcRequestBuilders.post("/api/usuarios")
                        .content(objectAsString(usuarioCreateDto))
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(result.getStatus(), 200);

        UsuarioResponseDto responseDto = (UsuarioResponseDto) stringAsObject(result.getContentAsString(), UsuarioResponseDto.class);
        assertEquals(responseDto.getUsuarioId(), usuario.getUsuarioId());
        assertEquals(responseDto.getNome(), usuario.getNome());
    }


    public Object stringAsObject(String result, Class clazz) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(result, clazz);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public String objectAsString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }



}
