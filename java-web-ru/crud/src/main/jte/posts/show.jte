@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
    <head>
        <title>Информация о публикации</title>
    </head>
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${page.getPost().getName()}</h1>
            <p>${page.getPost().getBody()}</p>
        </main>
        <button><a href="/posts">Вернуться</a></button>
    </div>
    `
)
