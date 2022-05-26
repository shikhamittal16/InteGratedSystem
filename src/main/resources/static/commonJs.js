function fPageLoader(url, obj) {
    $('#mainContainer').remove();
    $('#side-container').remove();
    $("html, body").animate({ scrollTop: 0 }, "fast");
    $('#main-container').after('<div id="side-container"></div>');
    $('#side-container').after('<div id="mainContainer"></div>');
    urlHistoryStack.push(url);
    var urlToVarify = urlHistoryStack[urlHistoryStack.length-2];
    if(urlToVarify == undefined || urlToVarify == null || urlToVarify == ""){
        urlToVarify = urlHistoryStack[urlHistoryStack.length-1];
    }
    mainURLFlag = true;
    $.ajax({
        url : url ,
        type : 'GET',
        success : function (data) {
            if( data.includes('<var>loginPage</var>') ){
                window.location.reload();
            }
            else{
                $('#mainContainer').append(data);
            }

        }
    });
}