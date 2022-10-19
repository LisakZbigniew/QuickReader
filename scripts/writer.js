
var readingInterval = 1000.0;
var index = 0;
var interval = -1;

function startReading(){
    console.log("Starting display");
    resumeDisplayingAt(0);
}

function resumeDisplayingAt(index){

    if(interval != -1){
        stopReading()
    }
    var text = document.getElementById("textInput").value;
    text = text.split(/\s/);
    readInterval();
    var display = document.getElementById("display");
    index = 0;
    interval = setInterval(() => {
        display.textContent = text[index];
        index += 1;
        if(index == text.length) stopReading();
    },readingInterval);
}

function stopReading(){
    if(interval != -1){
        clearInterval(interval);
        interval = -1;
    }
}

function readInterval(){
    var wps = document.getElementById("wps").value;
    readingInterval = 1000/wps;
    if(interval != -1){
        resumeDisplayingAt(index);   
    }
}

