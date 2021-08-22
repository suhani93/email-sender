#   프로젝트 설명
> 탬플릿엔진 Thymeleaf 를 사용하여 해당 html을 발송하는 API 서버

# 개발 환경

|구분|환경|
|:---:|:---:|
|JDK|OpenJDK 11 ( zulu )|
|사용 SMTP 서버 | 구글 SMTP|


# 사용 방법

> 1. application.yml 안에 있는 username 과 password 변경
> 2. 실행

# 설정 시 나올 수 있는 문제
> Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted 발생 시 
> [여기](https://www.google.com/search?q=+Authentication+failed%3B+nested+exception+is+javax.mail.AuthenticationFailedException&sxsrf=ALeKk02TCQyacaOq3Pm8V5UQ9oycPqhXBw%3A1629555613301&ei=nQshYYzuEcPM-Qanh7uoDw&oq=+Authentication+failed%3B+nested+exception+is+javax.mail.AuthenticationFailedException&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBQgAEIAEMgUIABDLATIFCAAQgAQyBQgAEMsBMgUIABCABDIECAAQHjIFCAAQgARKBAhBGABQjQxYjQxgwQ1oAHAAeACAAXOIAeIBkgEDMC4ymAEAoAEBwAEB&sclient=gws-wiz&ved=0ahUKEwjMsOPbp8LyAhVDZt4KHafDDvUQ4dUDCA4&uact=5) 참고

# 메일 보내는 API URL

### URL

> GET /send <br>
> Host: localhost:8080


### Parameter
> |Name|Type|Description|Ex|Required|
> |:----:|:----:|:----:|:------:|:------:|
> |mailRecipient|String|메일 받는 사람|suhani93@naver.com|O|
> |mailSender|String|메일 보낸 사람|suhani93|O|
> |templateId|String|Thymeleaf 탬플릿 아이디<br>(classpath:templates/ 아래 경로)|mail/test|O|
> |subject|String|메일의 제목| 이메일 발송 테스트 |X|
> |parameters|Object|Thymeleaf 탬플릿에서 사용될 값|발송했어요|X|

### Ex

> http://localhost:8080/send?mailRecipient=suhani93@naver.com&mailSender=smtp.suhani93&subject=이메일테스트&templateId=mail/test&parameters[message]=발송했어요

![image](https://user-images.githubusercontent.com/73545607/130357071-7cc2425c-3ea0-4c98-b277-36aa831bf5b8.png)


# 기타

> gmail 계정 SMTP는 일 발송 건수가 있어서 실 운영시에는 SMTP 서버를 구축해서 사용하거나 g-suite 혹은 다른 SMTP 서버를 구매해서 사용해야 한다.


