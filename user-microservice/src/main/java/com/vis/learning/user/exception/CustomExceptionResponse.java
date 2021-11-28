package com.vis.learning.user.exception;

import java.util.Date;

public record CustomExceptionResponse(Date timeStamp, String message, String details) {

}
