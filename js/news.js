const newsPage = () => {
    let page = {
        urls: {
            getAllNews: API_DOMAIN + "news",
        },
        elements: {},
        commands: {
            loadData: {},
        },
    };

    page.elements.newsContainer = $("#newsContainer");
    page.elements.newsColumn = $("#newsColumn");

    //  Load data

    page.commands.loadData.allNews = () => {
        return $.ajax({
            url: page.urls.getAllNews,
            type: "GET",
        });
    };

    page.commands.appendAllNews = () => {
        page.commands.loadData.allNews().then((data) => {
            page.elements.newsContainer.empty();
            page.elements.newsColumn.empty();
            $.each(data, (index, item) => {
                let newCard = page.commands.renderNewsCard(item);
                let newRow = page.commands.renderNewsRow(item);
                page.elements.newsContainer.prepend(newCard);
                page.elements.newsColumn.prepend(newRow);
            });
            page.commands.initCarousel();
        });
    };

    page.commands.loadData.handleLoadData = () => {
        page.commands.appendAllNews();
    };

    //  Render

    page.commands.renderNewsCard = (news) => {
        const { title, cover, previewText, id } = news;
        return `
                  <div
                     class="col-md-6 col-lg-4 col-sm-12 mb-4"
                     data-aos="fade-up"
                     data-aos-delay="100"
                        >
                     <a href="news-details.html"
                        ><img
                           src=${cover}
                           class="news-img"
                           alt="Image"
                           class="img-fluid"
                     /></a>
                     <div class="p-4 bg-white">
                        <span
                           class="d-block text-secondary small text-uppercase"
                           >Jan 20th, 2019</span
                        >
                        <h2 class="h5 text-black mb-3">
                           <a href="news/${id}"
                                 >${title}</a
                           >
                        </h2>
                        <p>
                          ${previewText}
                        </p>
                     </div>
               </div>
      `;
    };

    page.commands.renderNewsRow = (news) => {
        const { title, id } = news;
        return ` <tr>
                    <td><a href="news/${id}">${title}</a></td>
                </tr>`;
    };

    page.commands.initCarousel = () => {
        page.elements.NewsOwl = $(".news-carousel");
        page.elements.RelatedNewsOwl = $(".relate-news-carousel");

        page.elements.NewsOwl.owlCarousel({
            items: 1,
            loop: true,
            stagePadding: 0,
            autoplay: true,
            margin: 20,
            nav: false,
            dots: true,
            center: true,
            nav: true,
            navText: [
                '<span class="icon-arrow_back">',
                '<span class="icon-arrow_forward">',
            ],
        });
        page.elements.NewsOwl.trigger("play.owl.autoplay", [2000]);
        page.elements.RelatedNewsOwl.owlCarousel({
            loop: true,
            stagePadding: 0,
            itemClass: "owl-item news-owl-item",
            margin: 20,
            dots: true,
            nav: false,
            responsive:{
                0:{
                    items:1,
                },
                600:{
                    items:2,
                },
                1000:{
                    items:3,
                }
            }
        })
    };

    // page.commands.initEditor = () => {
    //     var editor = new FroalaEditor("div#froala", {}, function () {
    //         $("#editorConfirmBtn").on("click", () => {
    //             console.log(editor);
    //             console.log(editor.html.get());
    //         });
    //     });
    // };

    return () => {
        page.commands.loadData.handleLoadData();
        // page.commands.initEditor();
    };
};
$(() => {
    const newPageInit = newsPage();
    newPageInit();
});
