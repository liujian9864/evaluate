function Tabs(tabs_name, contents_name, tabs_checked_style, contents_checked_style) {
    var tabs = document.querySelectorAll(tabs_name),
        contents = document.querySelectorAll(contents_name),
        e_mark = 0;
    for (var i = 0, len = tabs.length; i < len; i++) {
        tabs[i].num = i;
        tabs[i].onclick = function () {
            tabs[e_mark].classList.toggle(tabs_checked_style);
            tabs[this.num].classList.toggle(tabs_checked_style);
            contents[e_mark].classList.toggle(contents_checked_style);
            contents[this.num].classList.toggle(contents_checked_style);
            e_mark = this.num;
        };
    }
}

 $(function() {
        showAllByPage(1);
        function showAllByPage(currentPage) {

            var courseName=$("#courseName").val();
            $.ajax({
                type: "post",
                url: "/loginUser",
                dataType: "json",
                success:function (result){
                    var user=result.userName+"("+result.userType+")"
                    $('#loginuser').html(user);
                    $('#userId').val(result.userId);
                    $('#student').html(result.userName);

                }
            });
            var stuId=$('#userId').val();
            $.ajax({
                type: "post",
                url: "/student/allEva",
                data: {currentPage:currentPage,stuId:stuId,courseName:courseName},
                dataType: "json",
                success: function (result) {
                    var totalPage = result.totalPage;
                    var currentPage = result.currentPage;

                    var tbody = "";
                    for (i = 0; i <  result.evas.length; i++) {
                        var tr = "";
                        tr += "<tr>";
                        tr += "<td>" + result.evas[i].courseNumberId + "</td>";
                        tr += "<td>" + result.evas[i].courseName + "</td>";
                        tr += "<td>" + result.evas[i].courseTeacher + "</td>";
                        if (result.evas[i].evaGradeCount!="" && result.evas[i].evaGradeCount!=null){
                            tr += "<td>" + result.evas[i].evaGradeCount + "</td>";
                            tr += "<td>" + result.evas[i].message + "</td>";
                            tr += "<td><button value='" + result.evas[i].courseId + "' type='button' class='btn btn-warning modButton stopEva' id'" + result.evas[i].courseId + "'>评价完成</button> </td>";
                        }else{
                            tr += "<td><select  class='coursegrade' id='coursegrade"+result.evas[i].courseId+"'><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select></td>";
                            tr += "<td><input class='courseMessage' type='text' id='courseMessage"+result.evas[i].courseId+"'></td>";
                            tr += "<td><button value='" + result.evas[i].courseId + "' type='button' class='btn btn-primary modButton saveEva' id'" + result.evas[i].courseId + "'>评价</button> </td>"
                        }
                        tr += "</tr>";
                        tbody += tr;
                    }
                    $("tbody").html(tbody);

                    var ul = "";
                    for(i=1;i<=totalPage;i++){
                        var li = "";
                        li += "<li class='fenli fenli1'><a class='fenye fenye1' id='numberPage1'>"+i+"</a></li>";
                        ul += li;
                    }
                    var uli =""
                    uli += "<li><a class='fenye fenye1' id='previousPage1'>«</a></li>";
                    uli += ul;
                    uli += "<li><a class='fenye fenye1' id='nextPage1'>»</a></li>";
                        $("#showAllFenye").html(uli);

                    $(".fenye1").unbind("click");
                    $(".fenye1").click(function(){
                        var id = $(this).attr("id");
                        if(id == "previousPage1"){
                            if(currentPage == 1){
                                alert("已经第一页了");
                            }else{
                                showAllByPage(currentPage-1);
                            }
                        }else if(id == "nextPage1"){
                            if(currentPage == totalPage){
                                alert("已经是最后一页了");
                            }else{
                                showAllByPage(currentPage+1);
                            }
                        }else if(id == "numberPage1"){
                            showAllByPage($(this).text());
                        }
                    })
                    var number = currentPage-1;
                    $(".fenli1:eq("+number+")").attr("class","am-active");

                    $("#searchCourse").unbind("click");
                    $("#searchCourse").click(function(){
                        showAllByPage(1);
                    })

                    $(".saveEva").unbind("click");
                    $(".saveEva").click(function(){
                        var courseId=$(this).val();
                        var evaGrade={
                            courseId:$(this).val(),
                            stuId:$('#userId').val(),
                            evaGradeCount:$('#coursegrade'+courseId).val(),
                            Message:$('#courseMessage'+courseId).val()
                        }
                        $.ajax({
                            type: "post",
                            url: "/student/evaGrade",
                            data: evaGrade,
                            dataType: "json",
                            success:function (result) {
                                alert("评教成功")
                                showAllByPage(1);
                            }
                        });
                    })

                }
            })
        }

     $(document).on("click", "#edit-pwd", function () {
         var user={
             userName:$('#student').text(),
             oldPassword:$('#oldPassword').val(),
             newPassword:$('#newPassword').val()
         };
         $.ajax({
             type: "post",
             url: "/student/editStudentPwd",
             data: user,
             dataType: "json",
             success:function (result) {
                 if (result){
                     alert("密码修改成功！请重新登陆");
                     window.location.href="/index";
                 }else{
                     alert("旧密码输入错误");
                 }
             }
         });

     })

     $(document).on("click", "#mes", function () {
         var stuId=$('#userId').val();
         $.ajax({
             type: "post",
             url: "/admin/selectStudentById",
             data:{stuId:stuId},
             dataType: "json",
             success:function (result){
                 $('#stuNumberId').val(result.stuNumberId);
                 $('#stuName').val(result.stuName);
                 $('#stuSex').val(result.stuSex);
                 $('#stuInstitution').val(result.stuInstitution);
                 $('#stuClass').val(result.stuClass);
             }
         })
     })
     $(document).on("click", "#showEva", function () {
         $.ajax({
             type: "post",
             url: "/loginUser",
             dataType: "json",
             success:function (result){
                 var user=result.userName+"("+result.userType+")"
                 $('#loginuser').html(user);
                 $('#userId').val(result.userId);
                 $('#student').html(result.userName);
                showAllByPage(1);
             }
         });
     })

     $(document).on("click", "#exit", function () {
         window.location.href="/index";
     })
 })



			