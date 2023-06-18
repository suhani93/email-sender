// /mail-templates/{id}에 GET 요청을 보내는 함수
const getMailTemplateById = async id => {
	const response = await fetch(`/mail-templates/${id}`);
	if (!response.ok) {
		throw new Error(`Error: ${response.status} ${response.statusText}`);
	}
	const data = await response.json();
	return data;
};

// /mail-templates에 GET 요청을 보내는 함수
const getAllMailTemplates = async (page = 0, size = 10) => {
	const response = await fetch(`/mail-templates?page=${page}&size=${size}`);
	if (!response.ok) {
		throw new Error(`Error: ${response.status} ${response.statusText}`);
	}
	const data = await response.json();
	return data;
};

// /mail-templates에 POST 요청을 보내는 함수
const createMailTemplate = async request => {
	const response = await fetch('/mail-templates', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(request)
	});
	if (!response.ok) {
		throw new Error(`Error: ${response.status} ${response.statusText}`);
	}
	const data = await response.json();
	return data;
};

// /mail-templates/{id}에 DELETE 요청을 보내는 함수
const deleteMailTemplate = async id => {
	const response = await fetch(`/mail-templates/${id}`, {
		method: 'DELETE'
	});
	if (!response.ok) {
		throw new Error(`Error: ${response.status} ${response.statusText}`);
	}
	const data = await response.json();
	return data;
};
