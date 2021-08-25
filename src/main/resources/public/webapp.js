const webapp = (function () {
    const numbers = (error, data) => {
        if (error != null) {
            console.log(`Error: ${error}`);
            alert("Formato Invalido -> ej: 10.5,3.5,5");
            return;
        }
        $("#avg").text(data.media);
        $("#stdv").text(data.desviacion);
    }

    const send = () => {
        const data = $("#list").val();
        const listNum = data.split(",");

        postMethod(listNum, numbers);
    }

    const postMethod = (listNum, numbers) => {
        const promise = $.post({
            url: "/calculator",
            data: JSON.stringify(listNum),
            contentType: "application/json"
        });
        promise.then((data) => {
            numbers(null, JSON.parse(data));
        }, (error) => {
            numbers(error, null);
        });
    }

    return {
        send: function () {
            send();
        }
    }
})();