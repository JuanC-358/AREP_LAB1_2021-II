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
        window.location.href = "https://arepl1.herokuapp.com/inputdata";
    }

    return {
        send: function () {
            send();
        }
    }
})();