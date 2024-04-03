@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    welcome = null,
    users = @`
        @for(var user : page.getUsers())
            <div>${user.getFirstName()} ${user.getLastName()} </div>
            <p>
                <a href="/users/${user.getId()}"></a>
            </p>
        @endfor
    `
)
