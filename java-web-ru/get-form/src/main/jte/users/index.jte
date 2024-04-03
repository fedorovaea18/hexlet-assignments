@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Искать">
        </form>

        @if(page != null)
            <div>
                @for(var user : page.getUsers())
                    ${user.getFirstName()} ${user.getLastName()}
                @endfor
            </div>
        @endif
    `
)
