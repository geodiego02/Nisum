package com.nisuminternacional.eva.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisuminternacional.eva.backend.model.Telefono;
import com.nisuminternacional.eva.backend.model.Usuario;
import com.nisuminternacional.eva.backend.service.UsuarioService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    @WithMockUser
    public void testRegistroUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juan+test@subdomain.example.co");
        usuario.setPassword("Test1234");
        usuario.setPhones(Arrays.asList(new Telefono("1234567", "1", "57")));

        // Simulación del comportamiento del servicio
        Mockito.when(usuarioService.registrarUsuario(any(Usuario.class))).thenReturn(usuario);

        (  mockMvc.perform(post("/api/usuarios/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .header("User-Agent", "")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .content(new ObjectMapper().writeValueAsString(usuario))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("juan+test@subdomain.example.co"))
                .andExpect(jsonPath("$.name").doesNotExist())
                .andDo(print());  // Asegura que 'name' no existe en la respuesta
    }
}

