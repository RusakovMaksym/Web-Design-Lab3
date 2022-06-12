function short(element) {

    const request = fetch('https://cutt.ly/api/api.php?key=cb6e9014af99c1735937297960ef782850bd3&short=' + $('#typeEmailX').val(), {
        method: 'POST',
    }).then(response => {
        if (response.ok) {
            return response.json();
        }
        throw alert("Помилка! " + response.statusText);
    })
        .then(data => {
            if (data.url["status"] !== 7) {
                alert("Помилка вводу! Спробуйте ще!")
            } else {
                shortLink = data.url["shortLink"]
                navigator.clipboard.writeText(data.url["shortLink"])
                saveLink($('#typeEmailX').val() , data.url["shortLink"])
                alert("Скорочене посилання успішно скопійовано!")
            }
        })
    /*{
        method: 'POST',
        //mode: 'no-cors',
    })
        .then(response => response.json())
        .then(response => {
        alert(JSON.stringify(response))
        if (response.ok) {
            return response.json();
        }
        throw alert("Помилка! " + response.statusText);
    })
    .then(data => {
        if (data.url["status"] !== 7) {
            alert("Помилка вводу! Спробуйте ще!")
        } else {
            shortLink = data.url["shortLink"]
            navigator.clipboard.writeText(data.url["shortLink"])
            saveLink($('#typeEmailX').val() , data.url["shortLink"])
            alert("Скорочене посилання успішно скопійовано!")
        }
    })

     */
    //saveLink($('#typeEmailX').val() , 'Тут має бути результат від апі')
}

function saveLink(longLink , shortLink) {
    $.ajax(
        {
            url: '/api/user/link',
            type: 'POST',
            data: {
                link: longLink,
                short: shortLink
            },
            success:
                function (response) {

                },
            error:
                function (response) {

                }
        }
    )
}