window.onload = function (ev) {
    var element = document.querySelector(".main");
    element.innerText = "this is a big change";
    var btn = document.createElement("button");
    btn.innerText = "hello";
    element.appendChild(btn);
}
