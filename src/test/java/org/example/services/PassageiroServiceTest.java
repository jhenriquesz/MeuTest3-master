package org.example.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a validação de CPF
 */
public class PassageiroServiceTest {

    private final PassageiroService service = new PassageiroService();

    @Test
    public void testValidarCpf_Valido() {
        // CPF válido
        String cpfValido = "123.456.789-09"; // CPF fictício válido
        assertTrue(service.ValidarCpf(cpfValido), "O CPF deveria ser válido.");
    }

    @Test
    public void testValidarCpf_Invalido() {
        // CPF inválido
        String cpfInvalido = "123.456.789-00"; // CPF fictício inválido
        assertFalse(service.ValidarCpf(cpfInvalido), "O CPF deveria ser inválido.");
    }

    @Test
    public void testValidarEmail_Valido() {
        // E-mail válido
        String emailValido = "usuario@exemplo.com";
        assertTrue(service.validarEmail(emailValido), "O e-mail deveria ser válido.");
    }

    @Test
    public void testValidarEmail_Invalido() {
        // E-mail inválido
        String emailInvalido = "usuario@exemplo";
        assertFalse(service.validarEmail(emailInvalido), "O e-mail deveria ser inválido.");
    }
}
