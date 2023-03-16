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

    //  Load data

    page.commands.loadData.allNews = () => {
        return $.ajax({
            url: page.urls.getAllNews,
            type: "GET",
        });
    };

    page.commands.appendAllNews = () => {
        page.commands.loadData.allNews()
        .then((data) => {
            page.elements.newsContainer.empty();
            $.each(data, (index,item) => {
                let newCard = page.commands.renderNewsCard(item);
                page.elements.newsContainer.prepend(newCard)
            });
        });
    };

    page.commands.loadData.handleLoadData = () => {
        page.commands.appendAllNews();
    };

    //  Render

    page.commands.renderNewsCard = (news) => {
        const { title, cover, previewText } = news;
        return `
                  <div
                     class="col-md-6 col-lg-4 mb-4"
                     data-aos="fade-up"
                     data-aos-delay="100"
               >
                     <a href="#"
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
                           <a href="#"
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

    return () => {
        page.commands.loadData.handleLoadData();
    };
};
$(() => {
    const newPageInit = newsPage();
    newPageInit();
});
