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

# 메일 보내는 API URL

### URL

> GET /send <br>
> Host: localhost:8080


### Parameter
> |Name|Type|Description|Ex|Required|
> |:----:|:----:|:----:|:------:|:------:|
> |mailRecipient|String|메일 받는 사람|suhani93@naver.com|O|
> |mailSender|String|메일 보낸 사람|suhani93|O|
> |templateId|String|Thymeleaf 탬플릿 아이디|mail/test|O|
> |subject|String|메일의 제목| 이메일 발송 테스트 |X|
> |parameters|Object|Thymeleaf 탬플릿에서 사용될 값|발송했어요|X|



### Ex

> http://localhost:8080/send?mailRecipient=sh931216@naver.com&mailSender=suhani93&subject=이메일테스트&templateId=mail/test&parameters[message]=발송했어요





# 기타

> gmail 계정 SMTP는 일 발송 건수가 있어서 실 운영시에는 SMTP 서버를 구축해서 사용하거나 g-suite 혹은 다른 SMTP 서버를 구매해서 사용해야 한다.
