# mail-server-java

### 메일 전송 방법
- method : POST
- URL : /mailserver
- body : JSON
```
// email : String
// content : String

{
    "email" : "전송할 이메일",
    "content" : "전송할 내용"
}
```

- Response
    - 정상 동작 시 1
    - 오류 발생 등 비정상 동작 시 0
