package com.dotconnectafrica.shebnks_rest_api.exception;

public interface HttpResponseCode {
    // 400	Bad Request
    // 401	Unauthorized
    // 403	Forbidden
    // 404	Not Found
    // 405	Method Not Allowed
    // 406	Not Acceptable ??? You requested a format that isn???t json
    // 429	Too Many Requests
    // 500	Internal Server Error ??? We had a problem with our server. Try again later.
    // 503	Service Unavailable ??? We???re temporarily offline for maintenance. Please try again
    // later.

    int OK = 200;
    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int METHOD_NOT_ALLOWED = 405;
    int NOT_ACCEPTABLE = 406;
    int TOO_MANY_REQUESTS = 429;
    int INTERNAL_SERVER_ERROR = 500;
    int SERVICE_UNAVAILABLE = 503;
}
