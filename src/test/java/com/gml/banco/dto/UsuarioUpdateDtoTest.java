package com.gml.banco.dto;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UsuarioUpdateDtoTest {

    @Test
    public void deveTestarUsuarioUpdateDtoNoArgsConstructor() {
        UsuarioUpdateDto usr = new UsuarioUpdateDto();
        assertNotNull(usr);
        assertNull(usr.getNome());
        assertNull(usr.getSenha());
    }

    @Test
    public void deveTestarUsuarioUpdateDtoAllArgsConstructor() {
        UsuarioUpdateDto usr = new UsuarioUpdateDto("Guilherme", "123");
        assertNotNull(usr);
        assertEquals(usr.getNome(), "Guilherme");
        assertEquals(usr.getSenha(), "123");
    }

    @Test
    public void deveTestarUsuarioUpdateDtoGetSet() {
        UsuarioUpdateDto usr = new UsuarioUpdateDto();
        assertNotNull(usr);
        usr.setNome("Guilherme");
        usr.setSenha("123");

        assertEquals(usr.getNome(), "Guilherme");
        assertEquals(usr.getSenha(), "123");
    }

}
