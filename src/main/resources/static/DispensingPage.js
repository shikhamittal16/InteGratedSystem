var hot;
$(document).ready(function() {

    $('#fetchData').on('click', function (ev) {
        fetchAllDetails();
        ev.preventDefault();
    });

    buildHandsOnTable();
});

function fetchAllDetails(){
    var name = $('#name').val();
    var quantity = $('#quantity').val();
    var obj = {
        name : name,
        quantity : quantity,
    }
    $.ajax({
        url : 'fetchSurgicalDetails',
        type : 'GET',
        data : obj,
        success : function(data){
            console.log(data);
            if(data.objectList.length == 0){
                fDisplayMessage("No Record Found",FailFlag);
                hot.loadData([]);

            }
            else{
                hot.loadData(data.objectList);
            }
        }
    })
}

function buildHandsOnTable(){
    hot = new Handsontable($('#hot')[0], {
        columns: [
            {
                width: '35'
            },
            {
                data: 'productName',
            },
            {
                data: 'quantity',
            },
            {
                data : 'price'
            }
        ],
        stretchH: 'all',
        autoWrapRow: true,
        manualRowResize: true,
        manualColumnResize: true,
        rowHeaders: true,
        licenseKey: 'non-commercial-and-evaluation',
        colHeaders: [
            'Action',
            'Product Name',
            'Quantity',
            'Price'
        ],
        manualRowMove: true,
        manualColumnMove: true,
        filters: true,
        dropdownMenu:  ['alignment', '---------', 'filter_by_condition', 'filter_by_value', 'filter_action_bar'],
        exportFile: true,
        readOnly: true,
        columnSorting: true,
        licenseKey: 'non-commercial-and-evaluation',
    });
}
