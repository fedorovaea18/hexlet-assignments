@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    welcome = null,
    users = @`
        <div>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</div>
        <p>${page.getUser().getEmail()}</p>
    `
)
