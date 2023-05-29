const slide_Wrapper = $('.slide_Content > .slide_Wrapper');

slide_Wrapper.on('click', (e) => {
    e.preventDefault();

    const slideDownItems = $(e.currentTarget).next('.slide_Down_items');
    const isActive = slideDownItems.is(':visible');

    $('.slide_Down_items').slideUp();
    slide_Wrapper.removeClass('active');

    if (!isActive) {
        slideDownItems.slideDown();
        $(e.currentTarget).addClass('active');
    }
});

const top_items = $('.top_Click_area > .top_items');

top_items.on('click', (e) => {
    e.preventDefault();

    const top_Click_area = $(e.currentTarget).next('.top_Click_area');
    const isActive = top_Click_area.is('.active');


    // top_items.addClass('active')
    top_items.removeClass('active')

    if (!isActive) {
        // $(e.currentTarget).removeClass('active')
        $(e.currentTarget).addClass('active')
    }
});


// CKEditor 5 세팅

const watchdog = new CKSource.EditorWatchdog();

window.watchdog = watchdog;

watchdog.setCreator((element, config) => {
    return CKSource.Editor
        .create(element, config)
        .then(editor => {




            return editor;
        })
});

watchdog.setDestructor(editor => {



    return editor.destroy();
});

watchdog.on('error', handleError);

watchdog
    .create(document.querySelector('.editor'), {

        licenseKey: '',




    })
    .catch(handleError);

function handleError(error) {
    console.error('Oops, something went wrong!');
    console.error('Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:');
    console.warn('Build id: 478n3xxyx1yj-tb95nupm70ge');
    console.error(error);
}

ClassicEditor
    .create(document.querySelector('.editor'), {
        toolbar: {
            items: [
                'fontSize',
                'bold',
                'italic',
                'link',
                'bulletedList',
                'numberedList',
                'indent',
                'outdent',
                'imageUpload',
                'blockQuote',
                'insertTable',
                'mediaEmbed',
                'undo',
                'redo',
                'exportPdf',
                'fontBackgroundColor',
                'fontColor',
                'fontSize',
                'fontFamily',
                'highlight',
                'horizontalLine',
                'underline',

            ]
        },
        language: 'ko',
        image: {
            toolbar: [
                'imageTextAlternative',
                'imageStyle:full',
                'imageStyle:side'
            ]
        },
        table: {
            contentToolbar: [
                'tableColumn',
                'tableRow',
                'mergeTableCells',
                'tableCellProperties',
                'tableProperties'
            ]
        }
    })
    .then(editor => {
        console.log(editor);
    })
    .catch(error => {
        console.error(error);
    });



