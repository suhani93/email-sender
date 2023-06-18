const templateParametersElement = document.getElementById("templateParametersDiv");
const mailSendButton = document.getElementById("mailSendButton");
const templateIdList = document.getElementById("templateIdList");

const createTemplateParameterInputField = (parameterName, parameterValue) => {
	let inputCount = 0;

	const createInputTag = (inputId, parameterName, inputValue) => {
		const div = document.createElement("div");

		const label = document.createElement("label");
		label.setAttribute("for", inputId);
		label.textContent = parameterName;
		div.appendChild(label);

		const input = document.createElement("input");
		input.type = "text";
		input.id = inputId;
		input.name = inputId;
		input.value = inputValue;
		input.dataset.parameterName = parameterName;
		div.appendChild(input);

		const lineRipple = document.createElement("div");
		div.appendChild(lineRipple);

		return div;
	};

	const addInputFields = () => {
		const templateParameterInput = createInputTag(`key_${inputCount}`,`${parameterName}`,`${parameterValue}`);
		templateParametersElement.appendChild(templateParameterInput);
		inputCount++;
	};

	addInputFields();

};

const removeAllTemplateParameterInputFields = () => {
	while (templateParametersElement.firstChild) templateParametersElement.removeChild(templateParametersElement.firstChild);
}

const generateJSON = () => {
	const jsonOutput = {};

	const inputs = document.querySelectorAll("[name^='key_']");
	inputs.forEach((input) => {
		const key = input.dataset.parameterName;
		const value = input.value;

		if (key && value) {
			jsonOutput[key] = value;
		}
	});

	return jsonOutput;
};

const makeMailSendFormData = () => {
	return {
		mailRecipient: document.getElementById("mailRecipient").value,
		mailSender: document.getElementById("mailSender").value,
		subject: document.getElementById("subject").value,
		templateId: document.getElementById("templateIdList").value,
		parameters: generateJSON(),
	};
};

const sendMail = () => {
	const xhr = new XMLHttpRequest();
	xhr.open("POST", "/send", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = () => {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log("메일이 성공적으로 전송되었습니다.");
		}
	};
	xhr.send(JSON.stringify(makeMailSendFormData()));
};


mailSendButton.addEventListener("click", sendMail);


document.addEventListener("DOMContentLoaded", () => {
	getAllMailTemplates().then(value => {
		let changeTemplateId = (templateParameters) => {
			removeAllTemplateParameterInputFields();
			if(templateParameters == undefined || templateParameters == null){
				return ;
			}
			templateParameters.forEach((parameter) => {
				createTemplateParameterInputField(parameter.name, parameter.defaultValue);
			})
		}

		value.item.content.forEach((template) => {
			const option = document.createElement("option");
			option.value = template.id;
			option.textContent = template.name;
			option.dataset.templateParameters =  JSON.stringify(template.templateParameters || []) ;
			templateIdList.appendChild(option);
		});

		templateIdList.addEventListener("change", (event)=>{
			let templateParameters = JSON.parse(event.target[event.target.selectedIndex].dataset.templateParameters) ;
			changeTemplateId(templateParameters);
		});

		if(value.item.content[0].templateParameters != undefined){
			changeTemplateId(value.item.content[0].templateParameters);
		}


	}).catch(error => {
		console.error(error);
	});
});

