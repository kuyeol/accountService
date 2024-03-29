function refresh() {
    $.get('/users', function (users) {
        var list = '';
        (users || []).forEach(function (user) {
            list = list
                + '<tr>'
                + '<td>' + user.id + '</td>'
                + '<td>' + user.name + '</td>'
                + '<td><a href="#" onclick="deleteUser(' + user.id + ')">Delete</a></td>'
                + '</tr>'
        });
        if (list.length > 0) {
            list = ''
                + '<table><thead><th>Id</th><th>Name</th><th></th></thead>'
                + list
                + '</table>';
        } else {
            list = "No users in database"
        }
        $('#all-users').html(list);
    });
}

function deleteUser(id) {
    $.ajax('/users/' + id, {method: 'DELETE'}).then(refresh);
}


$(document).ready(function () {

    $('#create-user-button').click(function () {
        var userName = $('#user-name').val();
        var userRole = $('#user-role').val();
        $.post({
            url: '/users',
            contentType: 'application/json',



            data: JSON.stringify(
                {
                    name: userName
                }
            ),
            data: JSON.stringify({role: userRole}
            )
        }).then(refresh);
    });

    refresh();
});
