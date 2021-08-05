package com.gml.banco.services;

import com.gml.banco.entities.Usuario;
import com.gml.banco.repositories.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService service;

    @Mock
    private UsuarioRepository repository;

    @Test
    public void deveTestarFindUsuarioByIdComResultado(){
        Usuario usuario = new Usuario(1L, "Guilherme", "123", "1234", true, LocalDateTime.now(), LocalDateTime.now());
        Optional<Usuario> optionalUsuario = Optional.of(usuario);

        Mockito.when(repository.findById(anyLong())).thenReturn(optionalUsuario);

        Usuario usuResponse = service.findUsuarioById(1L);
        assertNotNull(usuResponse);
        assertEquals(usuResponse.getUsuarioId(), usuario.getUsuarioId());
        assertEquals(usuResponse.getNome(), usuario.getNome());
    }

    @Test
    public void deveTestarFindUsuarioByIdComRetornoDeExcecao(){

        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            service.findUsuarioById(1L);
        });
    }

    @Test
    public void deveTestarUpdateUsuario() {
        Usuario usuario = new Usuario(1L, "Guilherme", "123", "1234", true, LocalDateTime.now(), LocalDateTime.now());
        Optional<Usuario> optionalUsuario = Optional.of(usuario);

        Mockito.when(repository.findById(anyLong())).thenReturn(optionalUsuario);
        Mockito.when(repository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuResponse = service.updateUsuario(usuario);

        assertNotNull(usuResponse);
    }


}
