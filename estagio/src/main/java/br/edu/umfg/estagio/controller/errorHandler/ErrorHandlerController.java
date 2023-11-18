package br.edu.umfg.estagio.controller.errorHandler;

import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    public static final String PRIMARY_KEY_CONSTRAINT_VIOLATION = "23505";


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroDTO> handleDuplicatedCpfException(DataIntegrityViolationException ex){
        Throwable mostSpecificCause = ex.getMostSpecificCause();


        if (mostSpecificCause instanceof PSQLException psqlException){
            ServerErrorMessage serverErrorMessage = psqlException.getServerErrorMessage();
            if (psqlException.getSQLState().equals(PRIMARY_KEY_CONSTRAINT_VIOLATION)  && serverErrorMessage != null){
                HttpStatus status = HttpStatus.CONFLICT;
                return new ResponseEntity<>(
                        new ErroDTO(status.value(), serverErrorMessage.getDetail()), new HttpHeaders(), status
                );
            }
        }
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(
                new ErroDTO(status.value(), mostSpecificCause.getLocalizedMessage()), new HttpHeaders(), status
        );
    }
//
//   // @ExceptionHandler(MethodArgumentNotValidException.class)
//    public  ResponseEntity<ErroDTO> handleValidationErrors (MethodArgumentNotValidException ex){
//        List<String> erros = ex.getBindingResult().getFieldErrors()
//                .stream().map(FieldError::getDefaultMessage)
//                .toList();
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity<>(
//                new ErroDTO(status.value(), ex.getLocalizedMessage(), erros), new HttpHeaders(), status
//        );
//    }

}
