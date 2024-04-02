@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>USERS</title>
</head>
<body>
<table class="table table-primary table-striped table-bordered table-sm">

    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>

    </tr>
    </thead>

    @for(var user : page.getUsers())
    <tbody>
    <tr>


        <th scope="row">  <a href="/users/${user.getId()}">${user.getId()}</a> </th>
        <td>${user.getFirstName()} </td>
        <td>${user.getLastName()} </td>
    </tr>
    </tbody>
    @endfor
</table>
</body>
</html>
