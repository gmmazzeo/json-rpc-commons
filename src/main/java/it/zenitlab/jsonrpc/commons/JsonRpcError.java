/*
Copyright 2016 Zenit Srl

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package it.zenitlab.jsonrpc.commons;

/**
 * From
 * <a href="http://jsonrpc.org/spec.html">http://jsonrpc.org/spec.html</a>.<br /><br />
 * When a rpc call encounters an error, the Response Object MUST contain the
 * error member with a value that is a Object with the following members:
 * <dl>
 * <dt>code</dt>
 * <dd>A Number that indicates the error type that occurred. This MUST be an
 * integer. </dd>
 * </dl>
 * <dl>
 * <dt>detailedMessage</dt>
 * <dd>A String providing a short description of the error. The detailedMessage
 * SHOULD be limited to a concise single sentence.</dd>
 * </dl>
 * <dl>
 * <dt>data</dt>
 * <dd>A Primitive or Structured value that contains additional information
 * about the error. This may be omitted. The value of this member is defined by
 * the Server (e.g. detailed error information, nested errors etc.).</dd>
 * </dl>
 * The error codes from and including -32768 to -32000 are reserved for
 * pre-defined errors. Any code within this range, but not defined explicitly
 * below is reserved for future use. The error codes are nearly the same as
 * those suggested for XML-RPC at the following url:
 * <a href="http://xmlrpc-epi.sourceforge.net/specs/rfc.fault_codes.php">http://xmlrpc-epi.sourceforge.net/specs/rfc.fault_codes.php</a>
 * <table>
 * <tr><td>code</td><td>detailedMessage</td><td>meaning</td></tr>
 * <tr><td>-32700</td><td>Parse error</td><td>Invalid JSON was received by the
 * server. An error occurred on the server while parsing the JSON
 * text.</td></tr>
 * <tr><td>-32600</td>              <td>Invalid Request</td>      <td>The JSON sent is not a valid
 * Request object.</td></tr>
 * <tr><td>-32601</td>              <td>Method not found</td>     <td>The method does not exist /
 * is not available.</td></tr>
 * <tr><td>-32602</td>              <td>Invalid params</td>	  <td>Invalid method
 * parameter(s).</td></tr>
 * <tr><td>-32603</td>              <td>Internal error</td>	  <td>Internal JSON-RPC
 * error.</td></tr>
 * <tr><td>-32099 to -32000</td>    <td>Server error</td>         <td>Reserved for
 * implementation-defined server-errors.</td></tr>
 * </table>
 * The remainder of the space is available for application defined errors.
 *
 */
public class JsonRpcError {

    public final static int 
            SYNTHAX_ERROR = -32700,
            INVALID_REQUEST = -32600,
            METHOD_NOT_FOUND = -32601,
            INVALID_PARAMS = -32602,
            INTERNAL_ERROR = -1000,
            UTENTE_NON_AUTORIZZATO = 100,
            VALORE_PARAMETRO_NON_VALIDO = 101,
            OGGETTO_INESITENTE = 102,
            HTTP_ERROR = 103,
            ERRORE_GENERICO = 0;
    int code;
    String detailedMessage, userMessage;
    Object data;

    public JsonRpcError() {
    }

    public JsonRpcError(JsonRpcException ex) {
        this.code = ex.code;
        this.detailedMessage = ex.getMessage();
    }

    public JsonRpcError(JsonRpcException ex, String userMessage) {
        this.code = ex.code;
        this.detailedMessage = ex.getMessage();
        this.userMessage = userMessage;
    }

    public JsonRpcError(int code, String userMessage, Object data) {
        this.code = code;
        this.userMessage = userMessage;
        this.data = data;
    }

    /**
     * Returns a JsonRpcResponse enclosing this JsonRpcError.
     *
     * @param responseId
     * @return A JsonRpcResponse enclosing this JsonRpcError.
     */
    public JsonRpcResponse toJsonRpcResponse(Object responseId) {
        JsonRpcResponse res = new JsonRpcResponse();
        res.setError(this);
        res.setId(responseId);
        res.setResult(null);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String message) {
        this.detailedMessage = message;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String finalMessage) {
        this.userMessage = finalMessage;
    }
}
