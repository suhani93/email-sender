CREATE TABLE mail_template(
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '메일 템플릿 ID',
    name VARCHAR(300) NOT NULL COMMENT '템플릿 명',
    description VARCHAR(450) NOT NULL COMMENT '템플릿 설명',
    template VARCHAR(3000) NOT NULL COMMENT '메일 템플릿',
    template_parameters JSON NOT NULL COMMENT '메일 템플릿 파라미터 JSON',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시각',
    modified_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정 시각'
)