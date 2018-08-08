package com.bonc.valid;


import org.springframework.security.core.AuthenticationException;

/**
 * @author Think
 */
public class ValidCodeException extends AuthenticationException {

    public ValidCodeException(String msg) {
        super(msg);
    }
}
