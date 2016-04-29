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
 * From <a href="http://jsonrpc.org/spec.html">http://jsonrpc.org/spec.html</a>.<br /><br />
 * When a rpc call is made, the Server MUST reply with a Response, except for in 
 * the case of Notifications. The Response is expressed as a single JSON Object, 
 * with the following members:<br />
 * <dl>
 * <dt>jsonrpc</dt>
 * <dd>A String specifying the version of the JSON-RPC protocol. MUST be exactly "2.0".</dd>
 * </dl>
 * <dl>
 * <dt>result</dt>
 * <dd>This member is REQUIRED on success.<br>
 * This member MUST NOT exist if there was an error invoking the method.<br>
 * The value of this member is determined by the method invoked on the Server.</dd>
 * </dl>
 * <dl>
 * <dt>error</dt>
 * <dd>This member is REQUIRED on error.<br>
 * This member MUST NOT exist if there was no error triggered during invocation.<br>
 * The value for this member MUST be an Object as defined in section 5.1.</dd>
 * </dl>
 * <dl>
 * <dt>id</dt>
 * <dd>This member is REQUIRED.<br>
 * It MUST be the same as the value of the id member in the Request Object.<br>
 * If there was an error in detecting the id in the Request object (e.g. Parse error/Invalid Request), it MUST be Null.</dd>
 * </dl>
 * <p>Either the result member or error member MUST be included, but both members MUST NOT be included.</p>
 */
public class JsonRpcResponse {

    private String jsonrpc = "2.0";
    private Object id, result;
    private JsonRpcError error;
    private String warning;

    public JsonRpcResponse() {
    }

    public JsonRpcResponse(Object id) {
        jsonrpc = "2.0";
        this.id = id;
    }

    public JsonRpcError getError() {
        return error;
    }

    public JsonRpcResponse setError(JsonRpcError error) {
        this.error = error;
        return this;
    }

    public JsonRpcResponse setResult(Object result) {
        this.result = result;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}
