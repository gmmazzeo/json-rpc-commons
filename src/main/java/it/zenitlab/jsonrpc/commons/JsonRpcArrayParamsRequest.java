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

public class JsonRpcArrayParamsRequest extends JsonRpcRequest {

    private Object[] params;

    public JsonRpcArrayParamsRequest() {
        super();
    }

    @Override
    public Object[] getParams() {
        return params;
    }

    @Override
    public void setParams(Object params) {
        this.params=(Object[])params;
    }
    
    @Override
    public String toString() {
        return "id=" + id + "; jsonrpc=" + jsonrpc + "; method=" + method + "; params=" + params + "; sessionKey=" + sessionkey;
    }    

}
