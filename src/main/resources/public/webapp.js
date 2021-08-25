const webapp = (function () {

    const send = () => {

        postMethod();
    }

    const postMethod = () => {
        /*const promise = $.post({
            url: "/inputdata",
            data: JSON.stringify(""),
            contentType: "application/json"
        });
        promise.then((data) => {
            alert("A");
        }, (error) => {
            alert("B");
        });*/
        window.location.href = "http://localhost:4567/inputdata";
    }

    return {
        send: function () {
            send();
        }
    }
})();