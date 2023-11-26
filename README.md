# MailServer-Java

### 메일 전송 방법
- method : POST
- URL : http://15.164.232.10:8080/mailserver
- body : JSON
```
// email : String
// content : String

{
    "email" : "전송할 이메일",
    "content" : "전송할 내용"
}
```
