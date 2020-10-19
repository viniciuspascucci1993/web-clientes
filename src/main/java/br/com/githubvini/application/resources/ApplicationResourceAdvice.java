package br.com.githubvini.application.resources;

import br.com.githubvini.application.resources.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável que serve como uma annotation que identifica um steriotipo que vai receber requisições quando houver um erro
 * @Author: Vinicius Torres Pascucci.
 */
@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler( MethodArgumentNotValidException.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationError(MethodArgumentNotValidException e ) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map( objectError ->  objectError.getDefaultMessage() )
                .collect(Collectors.toList() );
            return new ApiErrors(messages);
    }

    @ExceptionHandler( ResponseStatusException.class )
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {

        String messageErro = ex.getMessage();
        HttpStatus statusCode = ex.getStatus();

        ApiErrors apiErrors = new ApiErrors(messageErro);
        return new ResponseEntity(apiErrors, statusCode);
    }

}
