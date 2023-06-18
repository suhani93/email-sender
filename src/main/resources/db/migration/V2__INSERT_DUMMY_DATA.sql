INSERT INTO email_db.mail_template (name, description, template, template_parameters, created_at, modified_at) VALUES('템플릿 1', '템플릿 1번입니다.', '<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <div>
        test
    </div>
    <div>
        <span th:text="${message}">테스트입니다.</span>
    </div>

</body>
</html>','[
{
"name":"message",
"description": "메세지 입니다.",
"defaultValue": "테스트입니다."
}
]' ,current_timestamp(), current_timestamp());



INSERT INTO email_db.mail_template (name, description, template, template_parameters, created_at, modified_at) VALUES('템플릿 2', '템플릿 2번입니다.', '<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <span th:text="${text}">안녕하세요 ~~</span>
    </div>
</body>
</html>', '[
{
"name":"text",
"description": "텍스트입니다.",
"defaultValue": "안녕하세요 ~~"
}
]', current_timestamp(), current_timestamp());
