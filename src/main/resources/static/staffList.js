function fPageLoader(url, obj) {
    $('#mainContainer').remove();
    $('#side-container').remove();
    $("html, body").animate({ scrollTop: 0 }, "fast");
    $('#main-container').after('<div id="side-container"></div>');
    $('#side-container').after('<div id="mainContainer"></div>');
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

// $(document).ready(function() {
//     $('#fetchData').on('click', function (ev) {
//         fPageLoader("./fetchStaffDetails")
//     });
// });

$('#fetchData').on('click', function (ev) {
    // var data = table.row($(this).parents('tr')).data();
    // var confirm = window.confirm("Are you sure to delete ?");
    // if (confirm == true) {
        $.ajax({
            type : "GET",
            url : "fetchStaffDetails",
            success : function(obj) {
                table.ajax.reload();
            },
        });
    // } else {
    //     return false;
    // }
});