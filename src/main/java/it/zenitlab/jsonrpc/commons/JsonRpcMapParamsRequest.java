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
 * A JSON-RPC request with parameters of the method represented using a Map, i.e.,  (key, value) pairs
 */
import java.util.HashMap;

public class JsonRpcMapParamsRequest extends JsonRpcRequest {

    private HashMap<String, Object> params;

    public JsonRpcMapParamsRequest() {
    }

    @Override
    public HashMap<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Object params) {
        this.params=(HashMap<String, Object>) params;
    }

    @Override
    public String toString() {
        return "id=" + id + "; jsonrpc=" + jsonrpc + "; method=" + method + "; params=" + params + "; sessionKey=" + sessionkey;
    }
}
