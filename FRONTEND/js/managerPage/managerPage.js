const slide_Wrapper = $('.slide_Content > .slide_Wrapper');

slide_Wrapper.on('click', (e) => {
    $(e.currentTarget).next('.slide_Down_items').slideToggle();
    $(e.currentTarget).toggleClass('active');
})