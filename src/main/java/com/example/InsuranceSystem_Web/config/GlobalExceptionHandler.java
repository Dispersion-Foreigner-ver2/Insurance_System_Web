package com.example.InsuranceSystem_Web.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.util.Objects.requireNonNull;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({BindException.class})
    public BaseResponse<?> errorValid(BindException ex) {
        String errorCode = requireNonNull(ex.getFieldError()).getDefaultMessage();
        log.error(errorCode);
        return new BaseResponse(500, HttpStatus.BAD_REQUEST, errorCode);
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse<?> handleBaseException(BaseException exception) {
        int errorCode = exception.getCode();
        HttpStatus httpStatus = exception.getHttpStatus();
        String message = exception.getMessage();
        return new BaseResponse(errorCode, httpStatus, message);
    }

//    @ExceptionHandler(value
//            = { MethodArgumentNotValidException.class})
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors()
//                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
//        System.out.println("Ddd    : " +errors);
//        log.info(errors.get(0));
//        return ResponseEntity.badRequest().body(errors);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<BaseResponse> handleBaseException(MethodArgumentNotValidException ex){
//        String errorCode = requireNonNull(ex.getFieldError()).getDefaultMessage();
//        ErrorMessageRes errorMessageRes = ErrorMessageRes.builder()
//                .message(errorCode)
//                .build();
//        return ResponseEntity.badRequest().body(new BaseResponse(errorMessageRes));
//    }



}
