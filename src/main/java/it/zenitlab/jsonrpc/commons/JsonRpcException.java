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

public class JsonRpcException extends Exception {
    
    public static int
            INVALID_JSONRPC_VERSION=-20000,
            INVALID_RESPONSE_ID=-19999,
            IO_EXCEPTION=-19998;
    int code;
    String detailedMessage, userMessage;
    
    public JsonRpcException(JsonRpcError err) {
        this.code=err.code;
        this.userMessage=err.userMessage;
        this.detailedMessage=err.detailedMessage;
    }

    public JsonRpcException(int code, String detailedMessage, String userMessage) {
        this.code = code;
        this.detailedMessage = detailedMessage;
        this.userMessage = userMessage;        
    }   

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    @Override
    public String getMessage() {
        return detailedMessage;
    }    
}
