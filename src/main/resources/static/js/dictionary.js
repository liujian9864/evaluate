let defaultOption = '<option value="">----- 请选择 -----</option>';
$(document).ready(function() {
    showInstitutionList();
    showInstitution1List();
    showCourseNameList();
    showCourseName1List();
    showAddClassList();
    showAddTeacherList();
    showAddTeacher1List();
    showAddClass1List();
    showAddClass2List();
    $("#addCourseName").append(defaultOption);
    $("#addstuInstitution").append(defaultOption);
    $("#addCourseClass").append(defaultOption);
    $("#addCourseTeacher").append(defaultOption);
    $("#city-list").append(defaultOption);
    $("#stuInstitution").append(defaultOption);
    $("#stuClass").append(defaultOption);

    $("#addCourseName").change(function() {
        showCourseIdList();
    });
    $("#add-CourseName").change(function() {
        showCourseId1List();
    });
    $("#addstuInstitution").change(function() {
        showClassList();
    });
    $("#stuInstitution").change(function() {
        showClass1List();
    });

});

function showInstitutionList() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=1",
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].code + '">'
                    + list[i].name + '</option>';
                $("#addstuInstitution").append(op);
            }
        }
    });
}
function showClassList() {
    let parentCode = $("#addstuInstitution").val();
    $("#addstuClass").empty();
    $("#addstuClass").append(defaultOption);

    if (parentCode == "") {
        return;
    }

    $.ajax({
        "url":"/districts/",
        "data":"parent=" + parentCode,
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].name + '">'
                    + list[i].name + '</option>';
                $("#addstuClass").append(op);
            }
        }
    });
}
function showInstitution1List() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=1",
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].code + '">'
                    + list[i].name + '</option>';
                $("#stuInstitution").append(op);
            }
        }
    });
}
function showClass1List() {
    let parentCode = $("#stuInstitution").val();
    $("#stuClass").empty();
    $("#stuClass").append(defaultOption);

    if (parentCode == "") {
        return;
    }

    $.ajax({
        "url":"/districts/",
        "data":"parent=" + parentCode,
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].name + '">'
                    + list[i].name + '</option>';
                $("#stuClass").append(op);
            }
        }
    });
}
function showAddClassList() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=2" ,
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].name + '">'
                    + list[i].name + '</option>';
                $("#addCourseClass").append(op);
            }
        }
    });
}
function showAddClass1List() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=2" ,
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].name + '">'
                    + list[i].name + '</option>';
                $("#stuClass").append(op);
            }
        }
    });
}
function showAddClass2List() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=2" ,
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].name + '">'
                    + list[i].name + '</option>';
                $("#add-CourseClass").append(op);
            }
        }
    });
}
function showAddTeacherList() {
    $.ajax({
        "url":"/admin/findAllTeacher",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].teaName + '">'
                    + list[i].teaName + '</option>';
                $("#addCourseTeacher").append(op);
            }
        }
    });
}
function showAddTeacher1List() {
    $.ajax({
        "url":"/admin/findAllTeacher",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].teaName + '">'
                    + list[i].teaName + '</option>';
                $("#add-CourseTeacher").append(op);
            }
        }
    });
}
function showCourseNameList() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=0",
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].code + '">'
                    + list[i].name + '</option>';
                $("#addCourseName").append(op);
            }
        }
    });
}
function showCourseIdList() {
    let parentCode = $("#addCourseName").val();
    $("#addCourseNumberId").empty();
    $("#addCourseNumberId").val(parentCode);
}
function showCourseName1List() {
    $.ajax({
        "url":"/districts/type",
        "data":"type=0",
        "type":"get",
        "dataType":"json",
        "success":function(json) {
            let list = json.data;
            console.log("count=" + list.length);
            for (let i = 0; i < list.length; i++) {
                console.log("name=" + list[i].name);
                let op = '<option value="'
                    + list[i].code + '">'
                    + list[i].name + '</option>';
                $("#add-CourseName").append(op);
            }
        }
    });
}
function showCourseId1List() {
    let parentCode = $("#add-CourseName").val();
    $("#add-CourseNumberId").empty();
    $("#add-CourseNumberId").val(parentCode);
}
