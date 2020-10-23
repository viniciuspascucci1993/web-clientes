package br.com.githubvini.application.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Classe utilitária para converter String em BigDecimal.
 * @author Vinicius Torres Pascucci.
 */
@Component
public class BigDecimalConverter {

    public BigDecimal convert(String value) {

        if (value == null) {
            return null;
        }

        value = value.replace(".", "").replace(",", ".");

        return new BigDecimal(value);
    }
}
