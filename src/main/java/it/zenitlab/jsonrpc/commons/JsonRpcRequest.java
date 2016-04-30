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
 * From <a href="http://jsonrpc.org/spec.html">http://jsonrpc.org/spec.html</a>.<br><br>
 * A rpc call is represented by sending a Request object to a Server. The Request object has the following members:
 * <dl>
 * <dt>jsonrpc</dt>
 * <dd>A String specifying the version of the JSON-RPC protocol. MUST be exactly "2.0".</dd>
 * </dl>
 * <dl>
 * <dt>method</dt>
 * <dd>A String containing the name of the method to be invoked. Method names that begin with the word rpc followed by a period character (U+002E or ASCII 46) are reserved for rpc-internal methods and extensions and MUST NOT be used for anything else.</dd>
 * </dl>
 * <dl>
 * <dt>params</dt>
 * <dd>A Structured value that holds the parameter values to be used during the invocation of the method. This member MAY be omitted.</dd>
 * </dl>
 * <dl>
 * <dt>id</dt>
 * <dd>An identifier established by the Client that MUST contain a String, Number, or NULL value if included. If it is not included it is assumed to be a notification. The value SHOULD normally not be Null <a href="#id1">[1]</a> and Numbers SHOULD NOT contain fractional parts <a href="#id2">[2]</a><br>
 * <br>
 * The Server MUST reply with the same value in the Response object if included. This member is used to correlate the context between the two objects.<br><br>
 * <div>
 * <p>[1] The use of Null as a value for the id member in a Request object is discouraged, because this specification uses a value of Null for Responses with an unknown id. Also, because JSON-RPC 1.0 uses an id value of Null for Notifications this could cause confusion in handling.</p>
 * </div>
 * <br>
 * <div>
 * <p>
 * [2] Fractional parts may be problematic, since many decimal fractions cannot be represented exactly as binary fractions.</p>
 * </div>
 * </dd>
 * </dl>
 * <div>
 * <span> Notification</span>
 * <p>A Notification is a Request object without an "id" member. A Request object that is a Notification signifies the Client's lack of interest in the corresponding Response object, and as such no Response object needs to be returned to the client. The Server MUST NOT reply to a Notification, including those that are within a batch request.</p>
 * <p>Notifications are not confirmable by definition, since they do not have a Response object to be returned. As such, the Client would not be aware of any errors (like e.g. "Invalid params.","Internal error.").</p>
 * </div>
 * <div>
 * <span>Parameter Structures</span>
 * <p>If present, parameters for the rpc call MUST be provided as a Structured value. Either by-position through an Array or by-name through an Object.</p>
 * <ul>
 * <li>by-position: params MUST be an Array, containing the values in the Server expected order.</li>
 * <li>by-name: params MUST be an Object, with member names that match the Server expected parameter names. The absence of expected names MAY result in an error being generated. The names MUST match exactly, including case, to the method's expected parameters.</li>
 * </ul>
 * </div>
 */
public abstract class JsonRpcRequest {

    protected String jsonrpc="2.0", method;
    protected Object id;
    protected String sessionkey; //not standard json-rpc    

    public JsonRpcRequest() {
    }
    
    public JsonRpcRequest(Object id) {
        this.id=id;
    }

    public abstract Object getParams();

    public abstract void setParams(Object params);

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }
}
