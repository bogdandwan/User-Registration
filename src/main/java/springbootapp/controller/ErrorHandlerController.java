package springbootapp.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springbootapp.dto.ApiError;
import springbootapp.exception.NotFoundException;

@RestControllerAdvice
public class ErrorHandlerController {



    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ApiError handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        final String message = ex.getMostSpecificCause().getMessage();
        if (message != null){
            if(message.contains("UK_user_email")) return new ApiError("User with this email already exist");
            if(message.contains("UK_user_username")) return new ApiError("User with this username already exist");
        }
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        return new ApiError("Some of method arguments are not valid");
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError handleNotFoundException(NotFoundException ex){

        return new ApiError(ex.getMessage());
    }

}
