let lastNote = {};
const radioSelector = "input[name ='formType']:checked";
const advancedElementSelector = ".formTypeAdvanced";
const simpleElementSelector = ".formTypeSimple";
const disabledAttribute = "hidden";
let isAdvanced = false;
let delayTime;
const maxRandomDelaySeconds = 30;
const millisecondsToSeconds = 1000;

//TODO maybe add field level error messages

function onLoadScript() {
    showHideComplex();
    updateDelayTime();
}

function showHideComplex() {
    lastNote = {};
    isAdvanced = document.querySelector(radioSelector).value === "advanced";
    hideFields()
}

function hideFields() {
    if (isAdvanced) {
        addHiddenAttribute(simpleElementSelector);
        removeHiddenAttribute(advancedElementSelector)
    } else {
        addHiddenAttribute(advancedElementSelector);
        removeHiddenAttribute(simpleElementSelector)
    }
}

function updateDelayTime() {
    let value = document.getElementById("delayTimeSelect").value;
    if (value === "Random") {
        value = (Math.floor(Math.random() * maxRandomDelaySeconds));
    }
    console.log("delay is " + value);
    delayTime = value;
}

function addHiddenAttribute(selector) {
    document.querySelectorAll(selector).forEach((field) => {
        field.setAttribute(disabledAttribute, "true");
    });
}

function removeHiddenAttribute(selector) {
    document.querySelectorAll(selector).forEach((field) => {
        field.removeAttribute(disabledAttribute);
    });
}

function submitNote() {
    readNote();
    outputNoteAndMessage("submitted note")
}

function resubmitNote() {
    outputNoteAndMessage("Resubmitted note");
}

function outputNoteAndMessage(reason) {
    addMessage(reason);
    outputNote();
}

function readNote() {
    lastNote["Priority:"] = document.getElementById("priority").value;
    lastNote["Name:"] = document.getElementById("name").value;
    if (isAdvanced) {
        lastNote["Categories:"] = Array.from(document.getElementById("multiCategory").selectedOptions).map(option => option.innerText);
        lastNote["Text:"] = document.getElementById("noteText").value;
    } else {
        lastNote["Category:"] = document.getElementById("singleCategory").value;
    }
}

function outputNote() {
    let key, divHtml, spanKey, spanValue;
    //Clear existing note
    let output = document.getElementById("lastNoteOutput");
    removeChildrenBySelector(output, "div");

    //Output note details
    lastNote["Timestamp:"] = timestamp();
    for (key in lastNote) {
        if (lastNote[key] !== "") {
            divHtml = document.createElement("DIV");
            divHtml.setAttribute("class", "flexContainerRow");
            spanKey = document.createElement("SPAN");
            spanKey.setAttribute("class", "flexStart");
            spanKey.innerText = key;
            divHtml.appendChild(spanKey);
            spanValue = document.createElement("SPAN");
            spanValue.setAttribute("class", "flexEnd");
            spanValue.innerText = lastNote[key];
            divHtml.appendChild(spanValue);
            output.appendChild(divHtml)
        }
    }
}

function addMessage(reason) {
    let messagesList = document.getElementById("messages");
    let message = document.createElement("LI");
    message.class = "message";
    message.style.opacity = "0";
    message.innerText = timestamp() + " - " + reason;
    messagesList.appendChild(message);
    setTimeout(function () {
        message.style.opacity = "1";
    }, delayTime * millisecondsToSeconds);
}

function timestamp() {
    const date = new Date();
    return date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear() + " " +
        date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
}


function removeChildrenBySelector(output, childSelector) {
    let i;
    let children = output.querySelectorAll(childSelector);
    for (i = 0; i < children.length; i++) {
        output.removeChild(children[i]);
    }
}