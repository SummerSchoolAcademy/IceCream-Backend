package com.summerschool.icecreamshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "All the copies of the book are already borrowed.")
public class InvalidPage {
}
