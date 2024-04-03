
@import exercise.dto.users.UsersPage
@param UsersPage page



@template.layout.page(
content = @`

    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>

    @if(!page.getUsers().isEmpty())
    <table class="table table-primary table-striped table-bordered table-sm">

        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">EMAIL</th>

        </tr>
        </thead>

        @for(var user : page.getUsers())
            <tbody>
            <tr>
                <td>${user.getId()}</td>
                <td><a href="/users/${user.getId()}">${user.getFirstName() + " " +user.getLastName()}</a> </td>
                <td>${user.getEmail()}</td>
            </tr>
            </tbody>
        @endfor
    </table>
    @endif
`

)


