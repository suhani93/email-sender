INSERT INTO email_db.mail_template (name, description, template, created_at, modified_at) VALUES('템플릿 1', '템플릿 1번입니다.', '<!DOCTYPE html>
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
</html>', current_timestamp(), current_timestamp());
