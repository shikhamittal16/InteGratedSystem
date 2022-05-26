var hot;
$(document).ready(function() {

    $('#fetchData').on('click', function (ev) {
        fetchAllMedicines();
        ev.preventDefault();
    });

    buildHandsOnTable();
});

function fetchAllMedicines(){
    var medicineName = $('#medicineName').val();
    var obj = {
        name : medicineName,
    }
    $.ajax({
        url : 'fetchMedicineDetails',
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
                data: 'medicineName',
            },
            {
                data: 'quantity',
            },
            {
                data: 'manufactureDate'
            },
            {
                data : 'expiryDate'
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
            'Medicine Name',
            'Quantity',
            'Manufacture Date',
            'Expiry Date',
        ],
        manualRowMove: true,
        manualColumnMove: true,
        filters: true,
        dropdownMenu:  ['alignment', '---------', 'filter_by_condition', 'filter_by_value', 'filter_action_bar'],
        exportFile: true,
        readOnly: true,
        columnSorting: true,
        licenseKey: 'non-commercial-and-evaluation'
    });
}
