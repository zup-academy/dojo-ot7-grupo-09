package br.com.zup.edu.nossositedeviagens.Common.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerValidation {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorRequest> handler(MethodArgumentNotValidException exception){
        List<ErrorRequest> requests = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach( e->{
            String mensagem = getErrorMessage(e);
            requests.add(new ErrorRequest(e.getField(), mensagem));
        });
        return requests;
    }

    private String getErrorMessage(FieldError e){
        return messageSource.getMessage(e, LocaleContextHolder.getLocale());
    }

}
