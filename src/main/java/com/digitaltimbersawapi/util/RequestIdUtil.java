package com.digitaltimbersawapi.util;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.MDC;


public class RequestIdUtil {

    private static final String REQUEST_ID = "requestId";

    private static final String DEFAULT_REQUEST_ID = "0";

    public static void setRequestId(String requestId) {

        requestId = Strings.isBlank(requestId) ? DEFAULT_REQUEST_ID : requestId;

        MDC.put(REQUEST_ID, requestId);
    }

    public static String getRequestId() {

        String requestId = MDC.get(REQUEST_ID);

        return Strings.isBlank(requestId) ? DEFAULT_REQUEST_ID : requestId;
    }

}
