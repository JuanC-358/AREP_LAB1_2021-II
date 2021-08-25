const webapp = (function () {

    const send = () => {

        postMethod("", numbers);
    }

    const postMethod = (listNum, numbers) => {
        const promise = $.post({
            url: "/inputdata",
            data: JSON.stringify(""),
            contentType: "application/json"
        });
        promise.then((data) => {
            alert("A");
            return;
        }, (error) => {
            alert("B");
            return;
        });
    }

    return {
        send: function () {
            send();
        }
    }
})();