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



