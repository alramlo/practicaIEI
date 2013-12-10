
/**
 * SQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package org.web.clientesdb;

public class SQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1386675037350L;
    
    private org.web.clientesdb.Consulta1Stub.SQLExceptionE faultMessage;

    
        public SQLExceptionException() {
            super("SQLExceptionException");
        }

        public SQLExceptionException(java.lang.String s) {
           super(s);
        }

        public SQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.web.clientesdb.Consulta1Stub.SQLExceptionE msg){
       faultMessage = msg;
    }
    
    public org.web.clientesdb.Consulta1Stub.SQLExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    