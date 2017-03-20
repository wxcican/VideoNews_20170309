package com.fuicuiedu.xc.videonew_20170309.bombapi.result;

//{
//        "createdAt": YYYY-mm-dd HH:ii:ss,    // 用户注册时间
//        "objectId": objectId,                // 用户唯一Id
//        "sessionToken": sessionToken         // 用来认证更新或删除用户的请求
//        }

public class UserResult {

    private String createdAt;
    private String objectId;
    private String sessionToken;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
