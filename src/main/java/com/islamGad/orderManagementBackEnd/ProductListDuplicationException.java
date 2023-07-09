package com.islamGad.orderManagementBackEnd;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductListDuplicationException extends RuntimeException {
    public ProductListDuplicationException(String msg) {
        super(msg);
    }
}
