@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@import exercise.dto.posts.PostPage
@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Все публикации</h1>
                <table class="table table-striped">
                    @for(var post : page.getPosts())
                    <tr>
                        <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                        <p>${post.getBody()}</p>
                    </tr>
                    @endfor
                </table>
                <br>
                <div>
                    @if(page.getPage() > 1)
                        <a href="${NamedRoutes.postsPath(page.getPage() - 1)}">Назад</a>
                    @endif

                    @if(page.getPosts().size() == 5)
                        <a href="${NamedRoutes.postsPath(page.getPage() + 1)}">Вперед</a>
                    @endif
                </div>
            </main>
        </div>
    `
)
